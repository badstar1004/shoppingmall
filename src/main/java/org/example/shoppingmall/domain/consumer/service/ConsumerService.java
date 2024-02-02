package org.example.shoppingmall.domain.consumer.service;

import static org.example.shoppingmall.grobal.exception.business.ErrorCode.NOT_FOUND_USER_OR_WRONG_PASSWORD;

import lombok.extern.slf4j.Slf4j;
import org.example.shoppingmall.domain.consumer.domain.Consumer;
import org.example.shoppingmall.domain.consumer.model.form.CheckEmailForm;
import org.example.shoppingmall.domain.consumer.model.form.ConsumerLoginForm;
import org.example.shoppingmall.domain.consumer.model.form.ConsumerRegisterForm;
import org.example.shoppingmall.grobal.exception.business.BusinessException;
import org.example.shoppingmall.mapper.ConsumerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ConsumerService {

    @Autowired
    private ConsumerMapper consumerMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /*
     * 로그인
     * */
    public Consumer consumerLogin(ConsumerLoginForm consumerLoginForm) {
        try {
            // 회원 조회
            Consumer consumer = consumerMapper.findByEmail(consumerLoginForm.getEmail())
                .orElseThrow(() -> new BusinessException(NOT_FOUND_USER_OR_WRONG_PASSWORD));

            // 비밀번호 확인
            if (!passwordEncoder.matches(consumerLoginForm.getPassword(), consumer.getPassword())) {
                throw new BusinessException(NOT_FOUND_USER_OR_WRONG_PASSWORD);
            }

            return consumer;

        } catch (BusinessException ex) {
            throw ex;
        }
    }

    /*
     * 이메일 중복 확인
     * */
    public boolean checkEmail(CheckEmailForm checkEmailForm) {
        return consumerMapper.checkEmail(checkEmailForm.getEmail()) == 1;
    }

    /*
     * 회원가입 등록
     * */
    public boolean membershipRegister(ConsumerRegisterForm consumerRegisterForm) {
        consumerRegisterForm.setPassword(
            passwordEncoder.encode(consumerRegisterForm.getPassword()));
        return consumerMapper.membershipRegister(consumerRegisterForm) == 1;
    }
}
