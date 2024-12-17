<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: crist
  Date: 11/6/2024
  Time: 8:10 AM
  To change this template use File | Settings | File Templates.
--%>
<header>
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="${pageContext.request.contextPath}">Parking Lot</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <ul class="navbar-nav me-auto mb-2 mb-md-0">
                    <li class="nav-item">
                        <a class="nav-link ${pageContext.request.requestURI.substring(pageContext.request.requestURI.lastIndexOf('/')) == '/about.jsp' ? ' active' : ''}" aria-current="page" href="${pageContext.request.contextPath}/about.jsp">About</a>
                    </li>
                    <c:if test="${pageContext.request.remoteUser != null}">
                        <li class="nav-item">
                            <c:if test="${pageContext.request.isUserInRole('READ_CARS')}">
                                <a class="nav-link ${activePage == 'Cars' ? 'active' : ''}" aria-current="page" href="${pageContext.request.contextPath}/Cars">Cars</a>
                            </c:if>
                        </li>
                        <li class="nav-item">
                            <c:if test="${pageContext.request.isUserInRole('READ_USERS')}">
                                <a class="nav-link ${activePage == 'Users' ? 'active' : ''}" aria-current="page" href="${pageContext.request.contextPath}/Users">Users</a>
                            </c:if>
                        </li>
                    </c:if>
                </ul>
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <c:if test="${pageContext.request.remoteUser != null}">
                            <a class="nav-link" href="${pageContext.request.contextPath}/Logout">Logout</a>
                        </c:if>
                        <c:if test="${pageContext.request.remoteUser == null}">
                            <a class="nav-link" href="${pageContext.request.contextPath}/Login">Login</a>
                        </c:if>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>