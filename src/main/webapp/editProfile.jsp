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
        var principalId = $('#principalId').text().trim();
        console.log(principalId);
        $.ajax({
            type: "get",
            url: "${pageContext.request.contextPath}/editProfile/" + principalId,
            contentType: "application/json",
            success: function (responseData) {
                console.log(responseData);
                let phone = responseData.phone;
                let email = responseData.email;
                $('#phone').val(phone);
                $('#email').val(email);
            },
            error: function (responseData) {
                console.log('Error save' + responseData);
                alert('Error save' + responseData);
            }
        });
    });

    $(document).ready(function () {
        var principalId = $('#principalId').text().trim();
        console.log(principalId);
        $("#registrationForm").on('submit', function (e) {
            e.preventDefault();
            $.ajax({
                type: "post",
                url: "${pageContext.request.contextPath}/editProfile/" + principalId,
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
<sec:authentication var="user" property="principal" />
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
                                    <label for="phone"><h4>Phone</h4></label>
                                    <input type="text" class="form-control" name="phone" id="phone"
                                           placeholder="enter your phone" title="enter your phone number if any.">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-6">
                                    <label for="email"><h4>Email</h4></label>
                                    <input type="text" class="form-control" name="email" id="email"
                                           placeholder="you@email" title="enter email if any.">
                                </div>
                            </div>
                            <div>
                                <a hidden id="principalUsername">
                                    <sec:authentication property="principal.username" />
                                </a>
                                <a hidden id="principalId">
                                    <sec:authentication property="principal.id" />
                                </a>
                                <a hidden id="principalRole">
                                    <sec:authentication property="principal.role" />
                                </a>
                            </div>
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