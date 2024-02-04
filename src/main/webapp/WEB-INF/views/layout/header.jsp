<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <title>shoppingMall</title>
</head>
    <!-- Header Section Begin -->
    <header class="header">
        <div class="container-fluid">
            <div class="row">
                <div class="col-xl-3 col-lg-5">
                    <div class="header__logo">
                        <a href="<c:url value="/"/>"><img src="<c:url value="/resources/img/logo2.png"/>" alt="홈"></a>
                    </div>
                </div>
                <div class="col-xl-6 col-lg5">
                    <nav class="header__menu">
                        <ul>
                            <li><a href="<c:url value="/"/>">홈</a></li>
                            <c:forEach var="category" items="${categories}">
                                <c:choose>
                                    <c:when test="${category.parentCategoryId == null}">
                                        <!-- 상위 카테고리의 영문 이름을 변수에 저장 -->
                                        <c:set var="parentCategoryEnName" value="${category.categoryEnName}" />
                                        <li>
                                            <a href="/${parentCategoryEnName}">${category.categoryName}</a>
                                            <!-- 하위 카테고리 드롭다운 -->
                                            <ul class="dropdown">
                                                <c:forEach var="subCategory" items="${categories}">
                                                    <c:if test="${subCategory.parentCategoryId == category.categoryId}">
                                                        <li><a href="/${parentCategoryEnName}/${subCategory.categoryId}">${subCategory.categoryName}</a></li>
                                                    </c:if>
                                                </c:forEach>
                                            </ul>
                                        </li>
                                    </c:when>
                                </c:choose>
                            </c:forEach>
                        </ul>
                    </nav>
                </div>
                <div class="col-lg-2">
                    <div class="header__right">
                        <div class="header__right__auth">
                            <c:choose>
                                <c:when test="${not empty sessionScope.consumer}">
                                    <!-- 세션에 consumer 가 있을 때 표시할 내용 -->
                                    <a href="#" style="margin-right: 10px">
                                        <c:out value="${sessionScope.consumer.consumerName}님"/>
                                    </a>
                                    <a href="<c:url value="/auth/logout"/>">로그아웃</a>
                                </c:when>
                                <c:otherwise>
                                    <!-- 세션에 consumer 가 없을 때 표시할 내용 -->
                                    <a href="<c:url value='/auth/sign-in'/>">로그인</a>
                                    <a href="<c:url value='/auth/sign-up'/>">회원가입</a>
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <ul class="header__right__widget">
                            <li><span class="icon_search search-switch"></span></li>
                            <c:choose>
                                <c:when test="${not empty sessionScope.consumer}">
                                    <li>
                                        <a href="#"><span class="icon_heart_alt"></span>
                                            <div class="tip"><c:out value="${sessionScope.consumer.wishCount}"/></div>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#"><span class="icon_bag_alt"></span>
                                            <div class="tip"><c:out value="${sessionScope.consumer.basketCount}"/></div>
                                        </a>
                                    </li>
                                </c:when>
                                <c:otherwise>
                                    <li>
                                        <a href="#"><span class="icon_heart_alt"></span>
                                            <div class="tip">0</div>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#"><span class="icon_bag_alt"></span>
                                            <div class="tip">0</div>
                                        </a>
                                    </li>
                                </c:otherwise>
                            </c:choose>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </header>
