package hello.login.web.login;


import hello.login.domain.login.LoginService;
import hello.login.domain.member.Member;
import hello.login.web.session.SessionManeger;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;
    private final SessionManeger sessionManeger;

    // 로그인 폼 연결
    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") LoginForm form) {
        return "login/loginForm";
    }

    // 로그인 (쿠키)
//    @PostMapping("/login")
    public String login(@Valid @ModelAttribute LoginForm form, BindingResult bindingResult, HttpServletResponse response) {
        if (bindingResult.hasErrors()) {
            return "login/loginForm";
        }

        Member loginMember = loginService.login(form.getLoginId(), form.getPassword());
        log.info("login? {}", loginMember);

        if (loginMember == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "login/loginForm";
        }

        //로그인 성공 처리

        // 쿠키에 시간 정보를 넣으면 시간 동안 지속되는 영속 쿠키
        // 쿠키에 시간 정보를 주지 않으면 세션 쿠키(브라우저 종료시 모두 종료)
        Cookie idCookie = new Cookie("memberId", String.valueOf(loginMember.getId()));
        response.addCookie(idCookie);
        return "redirect:/";
    }


    // 로그인 (세션)
    @PostMapping("/login")
    public String loginV2(@Valid @ModelAttribute LoginForm form, BindingResult bindingResult, HttpServletResponse response) {
        if (bindingResult.hasErrors()) {
            return "login/loginForm";
        }

        Member loginMember = loginService.login(form.getLoginId(), form.getPassword());
        log.info("login? {}", loginMember);

        if (loginMember == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "login/loginForm";
        }

        //로그인 성공 처리
        // 세션 관리자를 통해 세션을 생성하고, 회원 데이터를 보관
        sessionManeger.createSession(loginMember, response);
        return "redirect:/";
    }

//  로그아웃(쿠키)
//    @PostMapping("/logout")
    public String logout(HttpServletResponse response) {
        expireCookie(response, "memberId");
        return "redirect:/";
    }

    // 로그아웃 (세션)
    @PostMapping("/logout")
    public String logoutV2(HttpServletRequest request) {
        sessionManeger.expire(request);
        return "redirect:/";
    }

    private void expireCookie(HttpServletResponse response, String cookieName) {
        Cookie cookie = new Cookie(cookieName, null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
}



// 쿠키 로그인 문제
// 쿠키는 클라이언트가 임의로 변경할 수 있다 > 다른 사용자로 변경
// 쿠키에 보관된 정보는 훔쳐갈 수 있다. > 쿠키의 개인정보를 pc와 네트워크 전송에서 탈취
// 쿠키를 탈취하면 쿠키를 영구적으로 사용할 수 있다 > 평생 악의적 요청 보낸다