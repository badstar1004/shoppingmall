package org.example.shoppingmall.domain.consumer.model.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CheckEmailForm {
    @NotBlank(message = "이메일을 입력하세요")
    @Email(message = "이메일 형식이 아닙니다.")
    private String email;
}
