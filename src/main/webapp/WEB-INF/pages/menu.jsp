<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="${pageContext.request.contextPath}">Parking Lot</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse"
                    aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <ul class="navbar-nav me-auto mb-2 mb-md-0">
                    <li class="nav-item">
                        <a class="nav-link active" ${pageContext.request.requestURI.substring(pageContext.request.requestURI.lastIndexOf
                                ("/")) eq '/about.jsp' ? ' active' : ''}
                           aria-current="page" href="${pageContext.request.contextPath}/about.jsp">About
                        </a>
                    </li>
                    <c:if test="${pageContext.request.remoteUser != null}">
                        <li class="nav-item">
                            <a class="nav-link ${activePage eq '/Cars' ? 'active' : ''}"
                               aria-current="page" href="${pageContext.request.contextPath}/Cars">Cars
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link ${activePage eq '/Users' ? 'active' : ''}"
                               aria-current="page" href="${pageContext.request.contextPath}/Users">Users
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link ${activePage eq '/Report' ? 'active' : ''}"
                               aria-current="page" href="${pageContext.request.contextPath}/Report">Report
                            </a>
                        </li>
                    </c:if>
                </ul>
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/Login">Login</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>