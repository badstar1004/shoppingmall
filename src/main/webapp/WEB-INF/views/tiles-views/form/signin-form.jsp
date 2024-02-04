
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<body>
    <div class="container py-4">
        <header class="header" role="banner">
            <div class="header_inner">
                <a class="header__logo" href="<c:url value="/"/>" >
                    <h1 class="blind">buyTogether</h1>
                </a>
            </div>
        </header>

        <div id="container" class="container py-5">
            <!-- content -->
            <div class="contentContainer" style="display: flex; flex-direction: column; align-items: center; margin-top: 30px;">
                <div class="col-sm-10" style="width: 15cm;">
                    <form:form modelAttribute="consumerLoginForm" id="newMember" name="newMember" method="post" action="/consumer/sign/sign-in">
                        <div class="mb-3 row" style="width: 100%">
                            <div class="col-md-3">
                                <label for="email" class="col-form-label">이메일</label>
                            </div>
                            <div class="col-md-9">
                                <form:input path="email" type="email" id="email" name="email" maxlength="50" cssClass="form-control" placeholder="이메일을 입력하세요" />
                            </div>
                        </div>
                        <span id="emailError" class="text-danger">
                            <form:errors path="email" cssClass="text-danger"/>
                        </span>

                        <div class="mb-3 row" style="width: 100%">
                            <div class="col-md-3">
                                <label for="password" class="col-form-label">비밀번호</label>
                            </div>
                            <div class="col-md-9">
                                <form:input path="password" type="password" id="password" name="password" maxlength="50" cssClass="form-control" placeholder="비밀번호를 입력하세요" />
                            </div>
                        </div>
                        <span id="passwordError" class="text-danger">
                            <form:errors path="password" cssClass="text-danger"/>
                        </span>

                        <c:if test="${not empty loginError}">
                            <div class="text-danger">${loginError}</div>
                        </c:if>
                        <div class="btn_login_wrap" style="display: flex; justify-content: center;">
                            <button type="submit" class="btn_login" id="consumerLog.login" style="width: 35%;">
                                <span class="btn_text">로그인</span>
                            </button>
                            <a target="_blank" href="<c:url value="/auth/sign-up"/>" class="find_text" style="margin-left: 20px">회원가입</a>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>s
</body>
<script src="../../../../resources/js/login-validation.js"></script>
