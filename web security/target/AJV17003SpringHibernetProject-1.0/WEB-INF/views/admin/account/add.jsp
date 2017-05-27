<%-- 
    Document   : add
    Created on : May 14, 2017, 6:52:43 PM
    Author     : LAKHE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add Course</h1>
        <form method="post" action="${pageContext.request.contextPath}/admin/account/save">
            <div>
                <label>Course Name:</label>
                <input type="text" name="cname" required=""/>
            </div>
            <div>
                <label>Course Code</label>
                <input type="text" name="ccode" required=""/>
            </div>
            <div>
                <label>Course Fee</label>
                <input type="text" name="cfees" required=""/>
            </div>
            <div>
                <label>Status</label>
                <label><input type="checkbox" name="status" />Active</label>
            </div>
            
            <button type="submit">Save</button>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        
    </body>
</html>
