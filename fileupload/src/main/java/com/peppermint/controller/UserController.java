package com.peppermint.controller;

import com.peppermint.entity.User;
import com.peppermint.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author Administrator
 */
@Controller
@RequestMapping("user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("login")
    public String login(User user,
                        HttpSession session){
        User userDB = userService.login(user);
        if(userDB != null){
            session.setAttribute("user", userDB);
            return "redirect:/file/showAll";
        } else {
            return "redirect:/index";
        }
    }
}
