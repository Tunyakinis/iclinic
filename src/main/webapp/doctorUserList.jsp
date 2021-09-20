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
    <div class="bd-example">
        <table class="table table-hover table-dark">
            <thead>
            <tr style="color: darkorange">
                <th scope="col">Id</th>
                <th scope="col">Name</th>
                <th scope="col">Surname</th>
                <th scope="col">Email</th>
                <th scope="col">Phone</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${doctorListOfPatients}" var="user">
                <tr>
                    <th scope="row">${user.id}</th>
                    <td><a href="/iclinic-1.0/medicalCard/${user.id}" style="color: white">
                            ${user.passport.name}</a></td>
                    <td>${user.passport.surname}</td>
                    <td>${user.email}</td>
                    <td>${user.phone}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        </form>
    </div>
</div>
<jsp:include page="/footer.jsp"/>