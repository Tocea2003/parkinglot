<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:pageTemplate pageTitle="Add car photo">
    <h1>Add Car Photo</h1>
    <form class="needs-validation" novalidate method="POST" enctype="multipart/form-data"
          action="${pageContext.request.contextPath}/AddCarPhoto">
        <div class="row">
            <div class="col-md-6 mb-3">
                License plate: ${car.licensePlate}
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="file">Photo</label>
                <input type="file" name="file" id="file" required>
                <div class="invalid-feedback">
                    Photo is required.
                </div>
            </div>
        </div>
        <input type="hidden" name="id" value="${car.id}"/>
        <hr class="mb-4">
        <button class="btn btn-primary btn-lg btn-block" type="submit">Save</button>
    </form>
    <c:if test="${not empty photoUrl}">
        <div class="row">
            <div class="col-md-6 mb-3">
                <h2>Current Photo</h2>
                <img src="${photoUrl}" alt="Car Photo" style="max-width: 100%; height: auto;">
            </div>
        </div>
    </c:if>
</t:pageTemplate>