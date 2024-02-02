package org.example.shoppingmall.domain.authcontroller;

import org.example.shoppingmall.domain.consumer.model.form.ConsumerLoginForm;
import org.example.shoppingmall.domain.consumer.model.form.ConsumerRegisterForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/sign-in")
    public String signIn(Model model) {
        model.addAttribute("consumerLoginForm", new ConsumerLoginForm());
        return "signin-form";
    }

    @GetMapping("/sign-up")
    public String signUp(Model model) {
        // 구매자 form 설정
        model.addAttribute("consumerRegisterForm", new ConsumerRegisterForm());
        return "signup-form";
    }
}
