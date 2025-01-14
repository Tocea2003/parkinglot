<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="User Report">
    <h1>User Report</h1>
    <table class="table">
        <thead>
        <tr>
            <th>Username</th>
            <th>Email</th>
            <th>Number of Cars</th>
            <th>License Plates</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="entry" items="${userCarsMap}">
            <tr>
                <td>${entry.key.username}</td>
                <td>${entry.key.email}</td>
                <td>${entry.value.size()}</td>
                <td>
                    <c:forEach var="car" items="${entry.value}">
                        ${car.licensePlate}<br/>
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</t:pageTemplate>