package org.example.shoppingmall.commons;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.example.shoppingmall.model.Category;
import org.example.shoppingmall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
@Slf4j
public class CategoryInterceptor implements HandlerInterceptor {
    @Autowired
    private CategoryService categoryService;


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
        ModelAndView modelAndView) throws Exception {
        log.info("postHandle start");

        // 로그인 페이지에 대한 요청을 처리하는 경우, 추가 로직을 실행하지 않음
        if(request.getRequestURI().equals("/sign-in") && modelAndView != null) {
            return;
        }

        if (modelAndView != null) {
            log.info("postHandle modelAndView");
            List<Category> categories = categoryService.selectCategory();
            modelAndView.addObject("categories", categories);
        }
    }
}
