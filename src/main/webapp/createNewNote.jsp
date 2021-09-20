<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<style>
    .stl {
        background-color: orange;
        color: black;
        position: fixed;
        top: 50%;
        padding: 36px 37px;
        transform: translateY(-50%);
        left: 50%;
        opacity: 0.5;
        filter: alpha(Opacity=50);
    }
    [type="hidden"] {
        display: none;
    }
</style>

<script>
    function alertSuccess(message) {
        var alrt = document.createElement('div');
        alrt.classList.add('stl');
        alrt.innerHTML = message;
        $('body').append(alrt);
        setTimeout(function () {
            $('.stl').remove();
        }, 3000);
    }

    $(document).ready(function () {
        $("#registrationForm").on('submit', function (e) {
            e.preventDefault();
            $.ajax({
                type: "post",
                url: "${pageContext.request.contextPath}/createNewNote/${medicalCardId}",
                data: JSON.stringify($(e.target).serializeObject()),
                contentType: "application/json",
                success: function (responseData) {
                    var message = 'success save';
                    alertSuccess(message);
                },
                error: function (responseData) {
                    console.log('Error save' + responseData);
                    alert('Error save' + responseData);
                }
            });
        });
    });
</script>
<jsp:include page="/header.jsp"/>
<div class="content">
    <div class="container bootstrap snippet">
        <div class="row"></div>
        <div class="row">
            <div class="col-sm-3">
                <div class="text-center">
                    <img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png" class="avatar img-circle img-thumbnail"
                         style="    margin-top: 60px;"
                         alt="avatar">
                </div>
            </div>
            <div class="col-sm-9" style="    margin-top: 60px;">
                <div class="tab-content">
                    <div class="tab-pane active" id="home">
                        <form class="form" method="post" id="registrationForm">
                            <div class="form-group">
                                <div class="col-xs-6">
                                    <label for="date"><h4>Date</h4></label>
                                    <input type="date" class="form-control" name="date" id="date"
                                           placeholder="enter date" title="enter date if any.">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-6">
                                    <label for="description"><h4>Surname</h4></label>
                                    <input type="text" class="form-control" name="surname" id="surname"
                                           placeholder="enter surname" title="enter surname if any.">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-6">
                                    <label for="description"><h4>Name</h4></label>
                                    <input type="text" class="form-control" name="name" id="name"
                                           placeholder="enter name" title="enter name if any.">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-6">
                                    <label for="diagnosis_type"><h4>Diagnosis type</h4></label>
                                    <input type="text" class="form-control" name="diagnosis_type" id="diagnosis_type"
                                           placeholder="enter diagnosis type" title="enter diagnosis type if any.">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-6">
                                    <label for="description"><h4>Description</h4></label>
                                    <input type="text" class="form-control" name="description" id="description"
                                           placeholder="enter description" title="enter description if any.">
                                </div>
                            </div>
                            <input id="prodId" name="prodId" type="hidden" value="${medicalCardId}">
                            <button class="btn btn-lg btn-dark col-md-2" type="submit">Save</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </hr>
</div>
<jsp:include page="/footer.jsp"/>