<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ShoppingMall</title>
    <!-- Google Font -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Single+Day&display=swap" rel="stylesheet">
    <%--  CSS Styles  --%>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>" type="text/css">
    <link rel="stylesheet" href="<c:url value="/resources/css/icons.css"/>" type="text/css">
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>" type="text/css">

</head>
<body>
    <tiles:insertAttribute name="body"/>
    <tiles:insertAttribute name="footer"/>

    <!-- Js Plugins -->
    <script src="../../../resources/js/jquery-3.3.1.min.js"></script>
    <script src="../../../resources/js/jquery-ui.min.js"></script>
    <script src="../../../resources/js/bootstrap.min.js"></script>
</body>
</html>