package com.jn.security.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by death on 2016/8/1.
 */
@Controller
@RequestMapping("auth")
public class LoginLogoutController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(LoginLogoutController.class);

    /**
     * 指向登录页面
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage(
            @RequestParam(value = "error", required = false) boolean error,
            ModelMap model) {

        logger.debug("Received request to show login page");

        if (error == true) {
            // Assign an error message
            model.put("error",
                    "You have entered an invalid username or password!");
        } else {
            model.put("error", "");
        }
        return "loginpage";

    }

    /**
     * 指定无访问额权限页面
     *
     * @return
     */
    @RequestMapping(value = "/denied", method = RequestMethod.GET)
    public String getDeniedPage() {

        logger.debug("Received request to show denied page");

        return "deniedpage";

    }
}
