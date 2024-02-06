package com.example.bookingplatform.user;


import com.example.bookingplatform.user.dto.UserSignInDto;
import com.example.bookingplatform.user.dto.UserSignUpDto;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @GetMapping("/register")
    public String register() {
        return "user/register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute @Valid UserSignInDto registerDto) {
        userService.register(registerDto);
            return "redirect:/auth/login";
    }

    @GetMapping("/login")
    public String login() {
        return "user/login";
    }

   @PostMapping("/login")
    public String login(@ModelAttribute @Valid UserSignUpDto dto) {

        userService.signUp(dto);
        return "redirect:/login";
    }
}
