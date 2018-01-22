package com.shaffer.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
@RequestMapping("/userdetails")
public class CustomerController {
    @RequestMapping(value = "/principal", method = RequestMethod.GET)
    @ResponseBody
    public Principal currentUserDetails(Principal principal) {
        return principal;
    }

    @RequestMapping(value = "/authentication", method = RequestMethod.GET)
    @ResponseBody
    public Authentication currentUserName(Authentication authentication) {
        return authentication;
    }
}
