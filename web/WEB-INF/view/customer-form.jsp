<%--
  Created by IntelliJ IDEA.
  User: Jaeyeop
  Date: 10/4/2020
  Time: 5:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Save Customer</title>
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css">

    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
    </div>
    <div id="container">
        <form:form action="saveCustomer" modelAttribute="customer" method="post">
            <table>
                <tbody>
                <tr>
                    <td><label>First name:</label></td>
                    <td><form:input path="firstName"/></td>
                </tr>
                <tr>
                    <td><label>Last name:</label></td>
                    <td><form:input path="lastName"/></td>
                </tr>
                <tr>
                    <td><label>Email:</label></td>
                    <td><form:input path="email"/></td>
                </tr>
                <tr>
                    <td><form:hidden path="id"/></td>
                    <td><input type="submit" value="Save"></td>
                </tr>
                </tbody>
            </table>
        </form:form>

        <div style="clear: both"></div>

        <p>
            <a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
        </p>
    </div>
</div>
</body>
</html>
