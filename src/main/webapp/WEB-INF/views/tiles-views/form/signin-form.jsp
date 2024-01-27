
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<body>
    <div id="wrap" class="wrap">
        <div class="u_skip"><a href="https://www.naver.com">본문 바로가기</a></div>
        <header class="header" role="banner">
            <div class="header_inner">
                <a class="header__logo" href="${pageContext.request.contextPath}/" >
                    <h1 class="blind">buyTogether</h1>
                </a>
            </div>
        </header>

        <div id="container" class="container">
            <!-- content -->
            <div class="content">
                <div class="login_wrap">
                    <form id="frmNIDLogin" name="frmNIDLogin" target="_top" autocomplete="off" action="https://nid.naver.com/nidlogin.login" method="POST">
                        <ul class="panel_wrap">
                            <li class="panel_item" style="display: block;">
                                <div class="panel_inner" role="tabpanel" aria-controls="loinid">
                                    <div class="id_pw_wrap">
                                        <div class="input_row" id="id_line">
                                            <div class="icon_cell" id="id_cell">
                                                <span class="icon_id">
                                                    <span class="blind">아이디</span>
                                                </span>
                                            </div>
                                            <input type="text" id="id" name="id" placeholder="아이디" title="아이디" class="input_text" maxlength="41" value="">
                                            <span role="button" class="btn_delete" id="id_clear" style="display: block;">
                                                <span class="icon_delete">
                                                    <span class="blind">삭제</span>
                                                </span>
                                            </span>
                                        </div>
                                        <div class="input_row" id="pw_line">
                                            <div class="icon_cell" id="pw_cell">
                                                <span class="icon_pw">
                                                    <span class="blind">비밀번호</span>
                                                </span>
                                            </div>
                                            <input type="password" id="pw" name="pw" placeholder="비밀번호" title="비밀번호" class="input_text" maxlength="16">
                                            <span role="button" class="btn_delete" id="pw_clear" style="display: block;">
                                                <span class="icon_delete">
                                                    <span class="blind">삭제</span>
                                                </span>
                                            </span>
                                        </div>
                                    </div>
                                    <div class="login_keep_wrap" id="login_keep_wrap">
                                        <div class="keep_check">
                                            <input type="checkbox" id="keep" name="nvlong" class="input_keep" value="off">
                                            <label for="keep" class="keep_text">로그인 상태 유지</label>
                                        </div>
                                        <div class="ip_check">
                                            <span class="switch">
                                                <input type="checkbox" id="switch" class="switch_checkbox" value="off">
                                                <label for="switch" class="switch_btn">
                                                    <span class="blind" id="switch_blind">on</span>
                                                </label>
                                            </span>
                                        </div>
                                    </div>

                                    <div class="login_error_wrap" id="err_capslock" style="display: none;">
                                        <div class="error_message">
                                            <strong>CapsLock</strong>이 켜져 있습니다.
                                        </div>
                                    </div>

                                    <div class="login_error_wrap" id="err_empty_id" style="display: none;">
                                        <div class="error_message">
                                            <strong>아이디</strong>를 입력해 주세요.
                                        </div>
                                    </div>

                                    <div class="login_error_wrap" id="err_empty_pw" style="display: none;">
                                        <div class="error_message">
                                            <strong>비밀번호</strong>를 입력해 주세요.
                                        </div>
                                    </div>
                                    <div class="login_error_wrap" id="err_common" style="display:none;">
                                        <div class="error_message" style="width:90%">
                                        </div>
                                    </div>
                                    <div class="btn_login_wrap">

                                        <button type="submit" class="btn_login" id="log.login">
                                            <span class="btn_text">로그인</span>
                                        </button>

                                    </div>
                                </div>
                            </li>
                        </ul>
                    </form>
                </div>
                <ul class="find_wrap" id="find_wrap">

                    <li><a target="_blank" href="https://nid.naver.com/user2/api/route?m=routePwInquiry&amp;lang=ko_KR" class="find_text">비밀번호 찾기</a></li>
                    <li><a target="_blank" href="https://nid.naver.com/user2/api/route?m=routeIdInquiry&amp;lang=ko_KR" class="find_text">아이디 찾기</a></li>
                    <li><a target="_blank" href="https://nid.naver.com/user2/V2Join?m=agree&amp;lang=ko_KR&amp;domain=www.naver.com" class="find_text">회원가입</a>
                    </li>

                </ul>
            </div>
            <!-- //content -->
        </div>

    </div>
</body>
