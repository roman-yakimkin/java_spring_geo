<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 08.08.2020
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    <title>View country</title>
</head>
<body>
<div class="container">
    <div class="row pt-3">
        <h4>The small geo application</h4>
    </div>
</div>
<div class="container">
    <ul class="nav">
        <li class="nav-item active"><a href="<c:url value="/" />">Home</a></li>
        <li class="nav-item"><a href="<c:url value="/country/list" />">Countries</a></li>
        <li class="nav-item"><a href="<c:url value="/city/list" />">Cities</a></li>
        <li class="nav-item"><a href="<c:url value="/country/create" />">New country</a></li>
        <li class="nav-item"><a href="<c:url value="/city/create" />">New city</a></li>
    </ul>
</div>
<div class="container">
    <div class="row pt-3">
        <a class="btn btn-primary" href="<c:url value="/country/${item.id}/edit" />">Edit country</a>
    </div>
    <div class="row pt-3 ">
        <table class="table">
            <tr>
                <td>Name</td>
                <td>${item.name}</td>
            </tr>
            <tr>
                <td>Cities</td>
                <td>
                    <ul class="table-items">
                    <c:forEach items="${item.cities}" var="city">
                        <li><a href="<c:url value="/city/${city.id}" />" >${city.name}</a></li>
                    </c:forEach>
                    </ul>
                </td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
