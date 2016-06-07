package com.jumore.cas.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;

public class OrderService {

	@RequiresPermissions(value=PermissionConts.Order_Update)
	public void update(){
		SecurityUtils.getSubject().checkPermission(PermissionConts.Order_Update);
	}
}
