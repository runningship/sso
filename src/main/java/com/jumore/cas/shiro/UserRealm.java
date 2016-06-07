package com.jumore.cas.shiro;

import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;

public class UserRealm extends CasRealm{

	public static final String AUTH_INFO_KEY = "AuthorizationInfo_Key";
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		AuthorizationInfo authInfo = super.doGetAuthorizationInfo(principals);
		SimpleAuthorizationInfo simpleAuthorizationInfo = (SimpleAuthorizationInfo)authInfo;
		SimplePrincipalCollection principalCollection = (SimplePrincipalCollection) principals;
        List<Object> listPrincipals = principalCollection.asList();
        Map<String, String> attributes = (Map<String, String>) listPrincipals.get(1);
        //get uid for example from attributes and get user infomation (with role and permissions) from database
        simpleAuthorizationInfo.getStringPermissions();
        
        simpleAuthorizationInfo.addStringPermission("user.order.view");
		simpleAuthorizationInfo.addRole("sysadmin");
		
        SecurityUtils.getSubject().getSession().setAttribute(AUTH_INFO_KEY, authInfo);
		return authInfo;
	}

}
