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

</style>

<sec:authorize access="hasAnyRole('PATIENT')">
<script>
    $(document).ready(function () {
        var principalId = $('#principalId').text().trim();
        console.log(principalId);
        let noDataElement = '<span style="color:darkorange;">No data</span>'
        $.ajax({
            type: "get",
            url: "${pageContext.request.contextPath}/profile/" + principalId,
            contentType: "application/json",
            success: function (responseData) {
                console.log(responseData);
                let surname = responseData.surname ?? noDataElement;
                let name = responseData.name ?? noDataElement;
                let identification_number = responseData.identification_number ?? noDataElement;
                let passport_number = responseData.passport_number ?? noDataElement;
                let nationality = responseData.nationality ?? noDataElement;
                let dateOfBirth = responseData.date_of_birth ?? noDataElement;
                let gender = responseData.gender ?? noDataElement;
                let issueDate = responseData.issue_date ?? noDataElement;
                let expireDate = responseData.expiration_date ?? noDataElement;
                let email = responseData.email ?? noDataElement;
                let phone = responseData.phone ?? noDataElement;
                let country = responseData.country ?? noDataElement;
                let city = responseData.city ?? noDataElement;
                let street = responseData.street ?? noDataElement;
                let house = responseData.house ?? noDataElement;
                let apartment = responseData.apartment ?? noDataElement;
                let text = "<div class='profile'><h4></h4>" + "<p style='font-size: x-large; font-weight: 700'>"
                    + surname + "&nbsp;" + name + "</p></div>" +
                    "<div class='profile2'><h4></h4>" + "<p>" + "Email: &nbsp;" + email + "</p>"+
                    "<h4></h4>" + "<p>" + "Phone: &nbsp;" + phone + "</p></div>" +
                    "<div class='address'><h4></h4>" + "<p>" + "Address: &nbsp;" + country + "&nbsp;" + city +
                    "&nbsp;" + street + "&nbsp;" + house + "&nbsp;" + "&nbsp;" + apartment + "</p>"+
                    "<div class='passport'><h4>Passport:</h4>" + "<p>" + "Identification number: &nbsp;"
                    + identification_number + "</p>" +
                    "<h4></h4>" + "<p>" + "Passport number: &nbsp;" + passport_number + "</p>" +
                    "<h4></h4>" + "<p>" + "Nationality: &nbsp;" + nationality + "</p>" +
                    "<h4></h4>" + "<p>" + "Date Of Birth: &nbsp;" + dateOfBirth + "</p>" +
                    "<h4></h4>" + "<p>" + "Gender: &nbsp;" + gender + "</p>" +
                    "<h4></h4>" + "<p>" + "Issue date: &nbsp;" + issueDate + "</p>" +
                    "<h4></h4>" + "<p>" + "Expire date: &nbsp;" + expireDate + "</p></div>";
                $('#home').html(text);
            },
            error: function (responseData) {
                console.log('Error save' + responseData);
                alert('Error save' + responseData);
            }
        });
    });
</script>
</sec:authorize>
<sec:authorize access="hasAnyRole('DOCTOR')">
    <script>
        $(document).ready(function () {
            var principalId = $('#principalId').text().trim();
            console.log(principalId);
            let noDataElement = '<span style="color:darkorange;">No data</span>'
            $.ajax({
                type: "get",
                url: "${pageContext.request.contextPath}/profile/" + principalId,
                contentType: "application/json",
                success: function (responseData) {
                    console.log(responseData);
                    let surname = responseData.surname ?? noDataElement;
                    let name = responseData.name ?? noDataElement;
                    let identification_number = responseData.identification_number ?? noDataElement;
                    let passport_number = responseData.passport_number ?? noDataElement;
                    let nationality = responseData.nationality ?? noDataElement;
                    let dateOfBirth = responseData.date_of_birth ?? noDataElement;
                    let gender = responseData.gender ?? noDataElement;
                    let issueDate = responseData.issue_date ?? noDataElement;
                    let expireDate = responseData.expiration_date ?? noDataElement;
                    let email = responseData.email ?? noDataElement;
                    let phone = responseData.phone ?? noDataElement;
                    let country = responseData.country ?? noDataElement;
                    let city = responseData.city ?? noDataElement;
                    let street = responseData.street ?? noDataElement;
                    let house = responseData.house ?? noDataElement;
                    let apartment = responseData.apartment ?? noDataElement;
                    let department = responseData.department ?? noDataElement;
                    let text = "<div class='profile'><h4></h4>" + "<p style='font-size: x-large; font-weight: 700'>"
                        + surname + "&nbsp;" + name + "</p></div>" +
                        "<div class='profile2'><h4></h4>" + "<p>" + "Email: &nbsp;" + email + "</p>"+
                        "<h4></h4>" + "<p>" + "Phone: &nbsp;" + phone + "</p>"+
                        "<h4></h4>" + "<p>" + "Department: &nbsp;" + department + "</p></div>" +
                        "<div class='address'><h4></h4>" + "<p>" + "Address: &nbsp;" + country + "&nbsp;" + city +
                        "&nbsp;" + street + "&nbsp;" + house + "&nbsp;" + "&nbsp;" + apartment + "</p>"+
                        "<div class='passport'><h4>Passport:</h4>" + "<p>" + "Identification number: &nbsp;"
                        + identification_number + "</p>" +
                        "<h4></h4>" + "<p>" + "Passport number: &nbsp;" + passport_number + "</p>" +
                        "<h4></h4>" + "<p>" + "Nationality: &nbsp;" + nationality + "</p>" +
                        "<h4></h4>" + "<p>" + "Date Of Birth: &nbsp;" + dateOfBirth + "</p>" +
                        "<h4></h4>" + "<p>" + "Gender: &nbsp;" + gender + "</p>" +
                        "<h4></h4>" + "<p>" + "Issue date: &nbsp;" + issueDate + "</p>" +
                        "<h4></h4>" + "<p>" + "Expire date: &nbsp;" + expireDate + "</p></div>";
                    $('#home').html(text);
                },
                error: function (responseData) {
                    console.log('Error save' + responseData);
                    alert('Error save' + responseData);
                }
            });
        });
    </script>
</sec:authorize>
<jsp:include page="/header.jsp"/>
<sec:authentication var="user" property="principal"/>
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
                    </div>
                    <div>
                        <a hidden id="principalUsername">
                            <sec:authentication property="principal.username"/>
                        </a>
                        <a hidden id="principalId">
                            <sec:authentication property="principal.id"/>
                        </a>
                        <a hidden id="principalRole">
                            <sec:authentication property="principal.role"/>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </hr>
</div>
<jsp:include page="/footer.jsp"/>