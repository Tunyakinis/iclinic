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
            url: "${pageContext.request.contextPath}/editProfile/passport/" + principalId,
            contentType: "application/json",
            success: function (responseData) {
                console.log(responseData);
                let surname = responseData.surname;
                let name = responseData.name;
                let identification_number = responseData.identification_number;
                let passport_number = responseData.passport_number;
                let nationality = responseData.nationality;
                let dateOfBirth = responseData.date_of_birth;
                let gender = responseData.gender;
                let issueDate = responseData.issue_date;
                let expireDate = responseData.expire_date;
                $('#surname').val(surname);
                $('#name').val(name);
                $('#identification_number').val(identification_number);
                $('#passport_number').val(passport_number);
                $('#nationality').val(nationality);
                $('#date_of_birth').val(dateOfBirth);
                $('#gender').val(gender);
                $('#issue_date').val(issueDate);
                $('#expire_date').val(expireDate);
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
            if ($("#surname").text() === "") {
                typePassport = 'post';
            } else {
                typePassport = 'put';
            }
            $.ajax({
                type: typePassport,
                url: "${pageContext.request.contextPath}/editProfile/passport/" + principalId,
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
                                    <label for="surname"><h4>Surname</h4></label>
                                    <input type="text" class="form-control" name="surname" id="surname"
                                           placeholder="enter your surname" title="enter your surname if any.">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-6">
                                    <label for="name"><h4>Name</h4></label>
                                    <input type="text" class="form-control" name="name" id="name"
                                           placeholder="enter your name" title="enter your name if any.">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-6">
                                    <label for="identification_number"><h4>Identification Number</h4></label>
                                    <input type="text" class="form-control" name="identification_number"
                                           id="identification_number"
                                           placeholder="enter your Identification Number"
                                           title="enter your identification number if any.">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-6">
                                    <label for="passport_number"><h4>Passport number</h4></label>
                                    <input type="text" class="form-control" name="passport_number" id="passport_number"
                                           placeholder="enter your passport number"
                                           title="enter your phone number if any.">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-6">
                                    <label for="nationality"><h4>Nationality</h4></label>
                                    <input type="text" class="form-control" name="nationality" id="nationality"
                                           placeholder="enter your nationality" title="enter your nationality if any.">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-6">
                                    <label for="date_of_birth"><h4>Date of birth</h4></label>
                                    <input type="date" class="form-control" name="date_of_birth" id="date_of_birth"
                                           placeholder="enter your date of birth"
                                           title="enter your date of birth if any.">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-6">
                                    <label for="gender"><h4>Gender</h4></label>
                                    <input type="text" class="form-control" name="gender" id="gender"
                                           placeholder="enter your gender" title="enter your gender if any.">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-6">
                                    <label for="issue_date"><h4>Issue Date</h4></label>
                                    <input type="date" class="form-control" name="issue_date" id="issue_date"
                                           placeholder="enter your issue date" title="enter your issue date if any">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-6">
                                    <label for="expire_date"><h4>Expire date</h4></label>
                                    <input type="date" class="form-control" name="expire_date" id="expire_date"
                                           placeholder="enter your expire date" title="enter your expire date if any">
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