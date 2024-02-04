<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<body>
    <div class="container py-4">

        <header class="header" role="banner">
            <div class="header_inner">
                <a class="header__logo" href="<c:url value="/"/>" >
                    <h1 class="title">buyTogether</h1>
                </a>
            </div>
        </header>
        <div class="p-5 mb-4 bg-body rounded-3">
            <div class="py-5">
                <h1 class="display-5 fw-bold">회원 가입</h1>
                <p class="fs-4">Membership Joining</p>
            </div>
        </div>

        <div class="row align-items-stretch text-center">

            <form:form modelAttribute="consumerRegisterForm" id="newMember" name="newMember" method="post" action="/consumer/sign/sign-up">
                <div class="mb-3 row" style="border: 1px solid #1e7e34; width: 100%">
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

                <div class="mb-3 row" style="border: 1px solid #1e7e34; width: 100%">
                    <div class="col-md-3">
                        <label for="password" class="col-form-label">비밀번호</label>
                    </div>
                    <div class="col-md-9">
                        <form:input path="password" type="password" id="password" name="password" maxlength="50" cssClass="form-control" placeholder="비밀번호를 입력하세요" />
                    </div>
                </div>
                <span id="passwordError" class="text-danger">
                    <form:errors path="password" cssClass="text-daer"/>
                </span>

                <div class="mb-3 row" style="border: 1px solid #1e7e34; width: 100%">
                    <div class="col-md-3">
                        <label for="name" class="col-form-label">이름</label>
                    </div>
                    <div class="col-md-9">
                        <form:input path="name" id="name" name="name" maxlength="10" cssClass="form-control" placeholder="이름을 입력하세요" />
                    </div>
                </div>
                <span id="nameError" class="text-danger">
                    <form:errors path="name" cssClass="text-danger"/>
                </span>

                <div class="mb-3 row" style="border: 1px solid #1e7e34; width: 100%">
                    <div class="col-md-3">
                        <label for="phoneNumber" class="col-form-label">핸드폰번호</label>
                    </div>
                    <div class="col-md-9">
                        <form:input path="phoneNumber" id="phoneNumber" name="phoneNumber" maxlength="13" cssClass="form-control"/>
                    </div>
                    <form:errors path="phoneNumber" cssClass="text-danger"/>
                </div>

                <div class="mb-3 row">
                    <div class="col-sm-offset-2 col-sm-10 ">
                        <input type="submit" id="submit" name="submit" class="btn btn-primary" value="등록"/>
                    </div>
                </div>

            </form:form>
        </div>
    </div>
</body>
<script src="../../../../resources/js/register-validation.js"></script>
