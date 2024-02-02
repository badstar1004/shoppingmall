package org.example.shoppingmall.domain.consumer.model.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsumerRegisterForm {

    @NotBlank(message = "이메일을 입력하세요")
    @Email(message = "이메일 형식이 아닙니다")
    private String email;

    @NotBlank(message = "비밀번호를 입력하세요")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#]).{10,}$", message = "비밀번호는 영문, 숫자, 특수 문자(!, @, #)를 포함하여 10자리 이상이어야 합니다")
    private String password;

    @NotBlank(message = "이름을 입력하세요")
    private String name;

    @Pattern(regexp = "^\\d{11}$", message = "핸드폰번호를 확인하세요")
    private String phoneNumber;
}
