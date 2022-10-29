<%-- 
    Document   : users
    Created on : 26-Oct-2022, 5:03:26 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Users</title>
    </head>
    <body>
        <h1>Manage Users</h1>
        <c:if test="${users.size() lt 1}">
            <b>No users found. Please add a user.</b>
        </c:if>

        <c:if test="${users.size() gt 0}">
            <table border="1">
                <tr>
                    <th>Email</th>
                    <th>Fist Name</th>
                    <th>last Name</th>
                    <th>Role</th>
                </tr>
                <c:forEach var="user" items="${users}">            
                    <tr>
                        <td>${user.email}</td>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>${user.role.roleName}</td>
                        <td><a href="User?action=Edit">Edit</a></td>
                        <td><a href="">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <!-- display users table here-->


        <c:if test="${message eq null}"> <h1>Add Users</h1></c:if>
        <c:if test="${message eq 'Add'}"> <h1>Add Users</h1></c:if>
        <c:if test="${message eq 'Edit'}"><h1>Edit Users</h1></c:if>



            <form action="User" method="POST">
                Email: <input type="text" name="email" required readonly = ${message eq "Edit" ? "true" : "false"}><br>            
            First name: <input type="text" name="firstname" required><br>            
            Last Name: <input type="text" name="lastname" required><br>
            Password: <input type="password" name="password" required><br>
            Role: <select name="role"><br>
                <option value="system admin">System Admin</option>
                <option value="regular user">Regular User</option>
            </select> <br>

            <c:if test="${message eq null}"> <input type="submit" value="Add">
                <input type="hidden" name="action" value="Add"></c:if>
            <c:if test="${message eq 'Add'}"> <input type="submit" value="Add">
                <input type="hidden" name="action" value="Add"></c:if>
            <c:if test="${message eq 'Edit'}"> <input type="submit" value="Edit">
                <input type="hidden" name="action" value="Edit"></c:if>
        </form>


    </body>
</html>