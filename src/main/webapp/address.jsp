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
            url: "${pageContext.request.contextPath}/editProfile/address/" + principalId,
            contentType: "application/json",
            success: function (responseData) {
                console.log(responseData);
                let country = responseData.country;
                let city = responseData.city;
                let street = responseData.street;
                let house = responseData.house;
                let apartment = responseData.apartment;
                $('#country').val(country);
                $('#city').val(city);
                $('#street').val(street);
                $('#house').val(house);
                $('#apartment').val(apartment);
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
            if ($("#country").text() === "") {
                typeAddress = 'post';
            } else {
                typeAddress = 'put';
            }
            $.ajax({
                type: typeAddress,
                url: "${pageContext.request.contextPath}/editProfile/address/" + principalId,
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
                                    <label for="country"><h4>Country</h4></label>
                                    <input type="text" class="form-control" name="country" id="country"
                                           placeholder="enter your country" title="enter your country if any.">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-6">
                                    <label for="city"><h4>City</h4></label>
                                    <input type="text" class="form-control" name="city" id="city"
                                           placeholder="enter your city" title="enter your city if any.">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-6">
                                    <label for="street"><h4>Street</h4></label>
                                    <input type="text" class="form-control" name="street" id="street"
                                           placeholder="enter your street" title="enter your phone street if any.">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-6">
                                    <label for="house"><h4>House</h4></label>
                                    <input type="text" class="form-control" name="house" id="house"
                                           placeholder="house" title="enter house if any.">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-6">
                                    <label for="apartment"><h4>Apartment</h4></label>
                                    <input type="text" class="form-control" name="apartment" id="apartment"
                                           placeholder="enter your apartment" title="enter your apartment if any.">
                                </div>
                            </div>
                            <div>
                                <a hidden id="principalId">
                                    <sec:authentication property="principal.id" />
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