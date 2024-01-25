package org.example.shoppingmall.commons;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.example.shoppingmall.model.Category;
import org.example.shoppingmall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class CategoryInterceptor implements HandlerInterceptor {

    @Autowired
    private CategoryService categoryService;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
        ModelAndView modelAndView) throws Exception {
        if (modelAndView != null) {
            List<Category> categories = categoryService.selectCategory();
            modelAndView.addObject("categories", categories);
        }
    }
}
