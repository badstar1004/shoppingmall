package org.example.shoppingmall.domain.consumer.controller;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.example.shoppingmall.domain.consumer.model.form.CheckEmailForm;
import org.example.shoppingmall.domain.consumer.model.form.ConsumerLoginForm;
import org.example.shoppingmall.domain.consumer.model.form.ConsumerRegisterForm;
import org.example.shoppingmall.domain.consumer.model.sessiondto.SessionDto;
import org.example.shoppingmall.domain.consumer.service.ConsumerService;
import org.example.shoppingmall.grobal.exception.business.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    /*
     * 로그인
     * */
    @PostMapping("/sign/sign-in")
    public String consumerLogin(@Valid @ModelAttribute ConsumerLoginForm consumerLoginForm,
        BindingResult result, HttpSession httpSession, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "signin-form";
        }

        try {
            SessionDto sessionDto = consumerService.consumerLogin(consumerLoginForm);
            httpSession.setAttribute("consumer", sessionDto);
            return "redirect:/";

        } catch (BusinessException ex) {
            redirectAttributes.addFlashAttribute("loginError", ex.getMessage());
            redirectAttributes.addFlashAttribute("consumerLoginForm", consumerLoginForm);
            return "redirect:/auth/sign-in";
        }
    }

    /*
     * 이메일 중복확인
     * */
    @PostMapping("/sign/check-email")
    @ResponseBody
    public ResponseEntity<Map<String, String>> checkEmail(@Valid @RequestBody CheckEmailForm checkEmailForm,
        BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errors = result.getFieldErrors().stream()
                .collect(Collectors.toMap(FieldError::getField,
                    fieldError -> Optional.ofNullable(fieldError.getDefaultMessage()).orElse("")));

            return ResponseEntity.badRequest().body(errors);
        }

        return consumerService.checkEmail(checkEmailForm) ?
            new ResponseEntity<>(HttpStatus.CONFLICT) : new ResponseEntity<>(HttpStatus.OK);
    }

    /*
     * 회원가입 저장
     * */
    @PostMapping("/sign/sign-up")
    public String membershipRegister(
        @Valid @ModelAttribute("consumerRegisterForm") ConsumerRegisterForm consumerRegisterForm,
        BindingResult result) {
        if (result.hasErrors()) {
            return "signup-form";
        }

        return consumerService.membershipRegister(consumerRegisterForm) ?
            "redirect:/" : "redirect:/auth/sign-up";
    }
}
