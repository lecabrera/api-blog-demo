package com.bandesal.blog.web;

import com.bandesal.blog.application.service.UserAuthDetailsService;
import com.bandesal.blog.application.web.dto.AuthenticationRequest;
import com.bandesal.blog.application.web.dto.AuthenticationResponse;
import com.bandesal.blog.application.web.security.JWTUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeleafController {

    Logger logger;
    @Autowired
    private JWTUtil jwtUtil;
    //Validación que la autenticación sea correcta
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserAuthDetailsService userAuthDetailsService;

    public ThymeleafController(){
        this.logger = LoggerFactory.getLogger(getClass());
    }

    @GetMapping({"/", "index"})
    public String getIndex(Model model){

        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }


}
