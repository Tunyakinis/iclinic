<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css">
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        html {
            height: 100%;
        }

        body {
            display: flex;
            flex-direction: column;
            min-height: 100%;
        }

        .content {
            flex: 1 0 auto;
        }

        footer {
            flex: 0 0 auto;
            text-align: center;
            width: 100%;
            height: 70px;
            border-top: 1px solid rgba(0, 0, 0, .1);
            padding-top: 10px;
            margin-top: 40px;
        }

        .form-signin {
            margin-top: 13%;
        }

        .form-signin .btn {
            margin-right: 5px;
        }

        .row {
            margin-left: 0;
            margin-right: 0;
        }

        th {
            background-color: #ffc107;
            border-color: #ffc107;
        }
    </style>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script>
        $.fn.serializeObject = function () {
            var o = {};
            var a = this.serializeArray();
            $.each(a, function () {
                if (o[this.name]) {
                    if (!o[this.name].push) {
                        o[this.name] = [o[this.name]];
                    }
                    o[this.name].push(this.value || '');
                } else {
                    o[this.name] = this.value || '';
                }
            });
            return o;
        };
    </script>
</head>
<body>
<header class="p-3 bg-dark text-white">
    <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap">
                    <use xlink:href="#bootstrap"></use>
                </svg>
            </a>
            <sec:authorize access="!isAuthenticated()">
                <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                    <li><a href="/iclinic-1.0" class="nav-link px-2 text-white">Home</a></li>
                    <li><a href="departments" class="nav-link px-2 text-white">Departments</a></li>
                    <li><a href="contact" class="nav-link px-2 text-white">Contact</a></li>
                    <li><a href="aboutUs" class="nav-link px-2 text-white">About us</a></li>
                </ul>
            </sec:authorize>
            <sec:authorize access="hasAnyRole('PATIENT', 'USER')">
                <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                    <li><a href="/iclinic-1.0" class="nav-link px-2 text-white">Home</a></li>
                    <li><a href="/iclinic-1.0/editProfile" class="nav-link px-2 text-white">Edit Profile</a>
                    </li>
                    <li><a href="/iclinic-1.0/editProfile/passport" class="nav-link px-2 text-white">Edit Passport</a>
                    </li>
                    <li><a href="/iclinic-1.0/editProfile/address" class="nav-link px-2 text-white">Edit Address</a>
                    </li>
                    <li><a href="/iclinic-1.0/medicalCard/<sec:authentication property="principal.id" />" class="nav-link px-2 text-white">Medical Card</a></li>

                </ul>
            </sec:authorize>
            <sec:authorize access="hasAnyRole('DOCTOR')">
                <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                    <li><a href="/iclinic-1.0" class="nav-link px-2 text-white">Home</a></li>
                    <li><a href="/iclinic-1.0/editProfile" class="nav-link px-2 text-white">Edit Profile</a>
                    </li>
                    <li><a href="/iclinic-1.0/editProfile/passport" class="nav-link px-2 text-white">Edit Passport</a>
                    </li>
                    <li><a href="/iclinic-1.0/editProfile/address" class="nav-link px-2 text-white">Edit Address</a>
                    </li>
                    <li><a href="/iclinic-1.0/doctorUserList" class="nav-link px-2 text-white">Patients</a></li>
                </ul>
            </sec:authorize>
            <sec:authorize access="hasAnyRole('ADMIN')">
                <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                    <li><a href="/iclinic-1.0" class="nav-link px-2 text-white">Home</a></li>
                    <li><a href="/iclinic-1.0/admin" class="nav-link px-2 text-white">View Users</a>
                    </li>
                </ul>
            </sec:authorize>
            <div class="text-end">
                <sec:authorize access="!isAuthenticated()">
                    <button type="button" class="btn btn-outline-light me-2"
                            onclick="location.href='${pageContext.request.contextPath}/signIn';">Login
                    </button>
                    <button type="button" class="btn btn-warning"
                            onclick="location.href='${pageContext.request.contextPath}/signUp';">Sign-up
                    </button>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    </a>
                    <button type="button" class="btn btn-outline-light me-2"
                            onclick="location.href='${pageContext.request.contextPath}/profile';">Profile
                    </button>
                    <button type="button" class="btn btn-warning"
                            onclick="location.href='${pageContext.request.contextPath}/logout';">Logout
                    </button>
                </sec:authorize>
            </div>
        </div>
    </div>
</header>

