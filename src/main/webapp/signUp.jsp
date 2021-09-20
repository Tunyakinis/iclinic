<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/header.jsp"/>
<div class="content">
    <div class="container p-4 p-md-5 mb-4">
        <form class="form-signUp" method="post" action="/iclinic-1.0/signUp">
            <h2 class="form-signUp-heading">Please sign up</h2>
            <p>
                <label for="username" class="sr-only">Username</label>
                <input type="text" id="username" name="login" class="form-control" placeholder="Username" required
                       autofocus>
            </p>
            <p>
                <label for="password" class="sr-only">Password</label>
                <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
            </p>
            <button class="btn btn-lg btn-dark btn-block" type="submit">Sign up</button>
        </form>
    </div>
</div>
<jsp:include page="/footer.jsp"/>
</html>