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
                    <th scope="col">Department</th>
                    <th scope="col">Role</th>
                    <th scope="col">Save</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${userList}" var="user">
                <form action="/iclinic-1.0/admin" method="post">
                    <tr>
                        <th scope="row">${user.id}</th>
                        <input id="login" name="login" type="hidden" value="${user.username}">
                        <td>${user.passport.name}</td>
                        <td>${user.passport.surname}</td>
                        <td>${user.email}</td>
                        <td>${user.phone}</td>
                        <c:if test="${not empty user.department.name}">
                            <td>${user.department.name}</td>
                        </c:if>
                        <c:if test="${empty user.department.name}">
                            <td><select name='department'>
                                <option value="${selected}" selected>${selected}</option>
                                <c:forEach items="${departmentList}" var="department">
                                    <c:if test="${department != selected}">
                                        <option value="${department}">${department}</option>
                                    </c:if>
                                </c:forEach>
                            </select></td>
                        </c:if>
                        <c:if test="${user.role == 'DOCTOR' or user.role == 'ADMIN' or user.role == 'PATIENT'}">
                            <td>${user.role}</td>
                        </c:if>
                        <c:if test="${user.role == 'USER'}">
                            <td><select name='role'>
                                <option value="${selected}" selected>${selected}</option>
                                <c:forEach items="${roleList}" var="role">
                                    <c:if test="${role != selected}">
                                        <option value="${role}">${role}</option>
                                    </c:if>
                                </c:forEach>
                            </select></td>
                        </c:if>
                        <td><button onclick="submit" class="btn btn-lg btn-dark btn-block" type="submit">Save</button></td>
                    </tr>
                </form>
                </c:forEach>
                </tbody>
            </table>
    </div>
</div>
<jsp:include page="/footer.jsp"/>

