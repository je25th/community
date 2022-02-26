package com.project.community.web.login;

import com.project.community.domain.login.LoginMember;
import com.project.community.domain.login.LoginService;
import com.project.community.web.SessionConst;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/login")
    public String loginForm(Model model) {

        model.addAttribute("form", new LoginForm());
        return "login/login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute LoginForm form, BindingResult bindingResult,
                        @RequestParam(defaultValue = "/") String returnURL,
                        HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "redirect:/login";
        }

        LoginMember login = loginService.login(form.getEmail(), form.getPassword());
        if (login == null) {
            bindingResult.reject("loginFila", "이메일 또는 비밀번호를 확인해주세요.");
            return "redirect:/login";
        }

        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, login);

        return "redirect:" + returnURL;
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }
}
