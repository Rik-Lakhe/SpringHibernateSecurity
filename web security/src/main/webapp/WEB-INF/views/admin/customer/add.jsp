<%-- 
    Document   : add.jsp
    Created on : May 14, 2017, 9:11:52 PM
    Author     : LAKHE
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>Add Customer</h1>
        <form method="post" action="${pageContext.request.contextPath}/admin/customer/save">
            <div>
                <label>First name</label>
                <input type="text" name="firstName" required=""/>
            </div>
            <div>
                <label>Last name</label>
                <input type="text" name="lastName" required=""/>
            </div>
            <div>
                <label>email</label>
                <input type="email" name="email" required=""/>
            </div>
            <div>
                <label>Contact number</label>
                <input type="text " name="contactNo" required=""/>
            </div>
            <select name="userId" required="true">
                <option value="">Select User</option>
                <c:forEach var="u" items="${users}">
                    <option value="${u.userId}">${u.username}</option>
                </c:forEach>
            </select>
            
            
            
            <div>
                <label>Status</label>
                <label><input type="checkbox" name="status" />Active</label>
            </div>
            
            <button type="submit">Save</button>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </body>
</html>
