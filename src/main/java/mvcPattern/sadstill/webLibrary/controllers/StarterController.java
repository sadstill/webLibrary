package mvcPattern.sadstill.webLibrary.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/starter")
public class StarterController {
    @GetMapping
    public String starter() {
        return "starter/starter";
    }
}
