<%@page import="org.apache.shiro.authz.AuthorizationInfo"%>
<%@page import="com.jumore.cas.shiro.UserRealm"%>
<%@page import="org.apache.shiro.subject.PrincipalCollection"%>
<%@page import="org.apache.shiro.subject.Subject"%>
<%@page import="org.apache.shiro.SecurityUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<%
Subject subject = SecurityUtils.getSubject();
//subject.hasRole("");
//subject.checkPermission("");
AuthorizationInfo authInfo = (AuthorizationInfo)subject.getSession().getAttribute(UserRealm.AUTH_INFO_KEY);
Object principal = subject.getPrincipal();  
PrincipalCollection principals = subject.getPrincipals(); 
request.setAttribute("username",principal);
request.setAttribute("roles",authInfo.getRoles());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Site A Page1</title>
</head>
<body>
<%="Hello"%>
This is page 1 , you have logged on as : site=<%= request.getContextPath() %> username=${username } , roles=${roles }

<shiro:hasRole name="sysadmin2"> 
    <div>only have role sysadmin can see the information</div> 
</shiro:hasRole>

<shiro:hasPermission name="user.order.view2"> 
    <div>only see the information with permission user.order.view</div>
</shiro:hasPermission>
</body>
</html>