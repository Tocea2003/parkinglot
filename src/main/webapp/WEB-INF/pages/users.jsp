<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Users">
    <h1>Users</h1>
    <form method="post" action="${pageContext.request.contextPath}/Users">
        <c:if test="${pageContext.request.isUserInRole('INVOICING')}">
            <button class="btn btn-primary" type="submit">Invoicing</button>
        </c:if>
        <div class="container text-center">
            <c:forEach var="user" items="${users}">
                <div class="row">
                    <div class="col">
                            ${user.name}
                    </div>
                    <c:if test="${pageContext.request.isUserInRole('INVOICING')}">
                        <div class="col">
                                ${user.invoicingData}
                        </div>
                    </c:if>
                </div>
            </c:forEach>
        </div>
    </form>
</t:pageTemplate>