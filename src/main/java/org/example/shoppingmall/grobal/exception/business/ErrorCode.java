package org.example.shoppingmall.grobal.exception.business;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    // 로그인
    NOT_FOUND_USER_OR_WRONG_PASSWORD("이메일 또는 비밀번호를 잘못 입력했습니다");

    private final String message;
}
