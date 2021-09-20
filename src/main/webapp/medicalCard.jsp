<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<jsp:include page="/header.jsp"/>
<div class="content">
    <sec:authorize access="hasAnyRole('PATIENT')">
        <div class="bd-example">
            <table class="table table-hover table-dark">
                <thead>
                <tr style="color: darkorange">
                    <th scope="col">Id</th>
                    <th scope="col">Data</th>
                    <th scope="col">Doctor Surname</th>
                    <th scope="col">Doctor Name</th>
                    <th scope="col">Diagnosis</th>
                    <th scope="col">Description</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${medicalCardList}" var="diagnosis">
                    <tr>
                        <th scope="row">${diagnosis.id}</th>
                        <td>${diagnosis.date}</td>
                        <td>${diagnosis.surname}</td>
                        <td>${diagnosis.name}</td>
                        <td>${diagnosis.diagnosisType}</td>
                        <td>${diagnosis.description}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            </form>
        </div>
    </sec:authorize>
    <sec:authorize access="hasAnyRole('DOCTOR')">
        <div class="bd-example">
            <table class="table table-hover table-dark">
                <thead>
                <tr style="color: darkorange">
                    <th scope="col">Id</th>
                    <th scope="col">Data</th>
                    <th scope="col">Doctor Surname</th>
                    <th scope="col">Doctor Name</th>
                    <th scope="col">Diagnosis</th>
                    <th scope="col">Description</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${medicalCardList}" var="diagnosis">
                    <tr>
                        <th scope="row">${diagnosis.id}</th>
                        <td>${diagnosis.date}</td>
                        <td>${diagnosis.surname}</td>
                        <td>${diagnosis.name}</td>
                        <td>${diagnosis.diagnosisType}</td>
                        <td>${diagnosis.description}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <button type="button" class="btn btn-outline-light me-2"
                    style="color:black; position: absolute; right: 100px"
                    onclick="location.href='${pageContext.request.contextPath}/createNewNote/${medCardId}';">Create New
                Note
            </button>
        </div>
    </sec:authorize>
</div>
<jsp:include page="/footer.jsp"/>