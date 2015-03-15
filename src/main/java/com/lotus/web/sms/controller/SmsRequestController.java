package com.lotus.web.sms.controller;

import com.lotus.web.sms.model.SmsRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by johndoe on 3/15/2015.
 */
@Controller
public class SmsRequestController {

    @RequestMapping(name = "/sendMessage", method = RequestMethod.POST)
    @ResponseBody
    public String handleSmsMessage(HttpServletRequest request) {
        String message = "hello test\n I plan to have a & in my message, should be correct\n. If not received* (//, then something is wrong \\";
        if (StringUtils.equalsIgnoreCase(request.getParameter("message"), message)) {
            return "received";
        } else {
            System.out.println(request.getParameter("message"));
            return "fucked";
        }
    }

    @RequestMapping(name = "/sayHi", method = RequestMethod.GET)
    @ResponseBody
    public String handleSayHi() {
        return "hi";
    }
}
