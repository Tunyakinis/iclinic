<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/header.jsp"/>
<div class="content">
<div class="p-4 p-md-5 mb-4 text-black rounded bg-white">
    <div class="container">
        <form class="form-contact" method="post" action="/iclinic-1.0/contact">
            <h2 class="form-contact-heading">Question or Comment:</h2>
            <div class="row">
                <div class="col col-md-4">
                    <label for="name" class="sr-only">Name</label>
                    <input type="name" id="name" name="name" class="form-control" placeholder="name" required
                           autofocus>
                </div>
            </div>
            <div class="row">
                <div class="col col-md-4">
                    <label for="email" class="sr-only">Email</label>
                    <input type="email" id="email" name="email" class="form-control" placeholder="email" required>
                </div>
            </div>
            <div class="row">
                <div class="col col-md-4">
                    <label for="text" class="sr-only">Text</label>
                    <textarea id="text" name="text" class="form-control" rows="5" placeholder="text" required>
                    </textarea>
                </div>
            </div>
            <button class="btn btn-lg btn-dark btn-block" style="margin-top: 5px" type="submit">Submit</button>
        </form>
    </div>
</div>
    </div>
<jsp:include page="/footer.jsp"/>
</html>
