package org.example.shoppingmall.domain.authcontroller;

import javax.servlet.http.HttpSession;
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
        if (!model.containsAttribute("consumerLoginForm")) {
            model.addAttribute("consumerLoginForm", new ConsumerLoginForm());
        }
        return "signin-form";
    }

    @GetMapping("/sign-up")
    public String signUp(Model model) {
        model.addAttribute("consumerRegisterForm", new ConsumerRegisterForm());
        return "signup-form";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {
        // 세션에서 consumer 속성 제거
        httpSession.invalidate();
        return "redirect:/";
    }
}
