<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/header.jsp"/>
<div class="content">
    <div class="container p-4 p-md-5 mb-4">
        <form class="form-signIn" method="post" action="/iclinic-1.0/signIn">
            <h2 class="form-signIn-heading">Please sign in</h2>
            <p>
                <label for="username" class="sr-only">Username</label>
                <input type="text" id="username" name="login" class="form-control" placeholder="Username" required
                       autofocus>
            </p>
            <p>
                <label for="password" class="sr-only">Password</label>
                <input type="password" id="password" name="password" class="form-control" placeholder="Password"
                       required>
            </p>
            <button class="btn btn-lg btn-dark btn-block" type="submit">Login</button>
            <a href="/iclinic-1.0/signUp" class="btn btn-lg btn-dark btn-block">Sign up</a>
            <a href="/iclinic-1.0/signIn/google" class="google">Sign In With Google</a>
        </form>
    </div>
</div>
<jsp:include page="/footer.jsp"/>
</html>