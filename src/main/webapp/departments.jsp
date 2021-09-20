<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/header.jsp"/>
<div class="content">
    <div class="col-md-6">
        <div class="table flex-md-row mb-4 box-shadow h-md-250">
            <c:forEach items="${departmentList}" var="department">
                <div class="name" style="font-weight: 500; margin-bottom: 10px; font-size: large">
                <th scope="row">${department.name}</th>
                </div>
                <div class="info" style="margin-bottom: 10px">
                <th scope="row">${department.departmentInfo}</th>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
<jsp:include page="/footer.jsp"/>
