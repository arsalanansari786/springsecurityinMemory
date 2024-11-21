package com.sde.spbsecurityinmemory.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("testApi1")
public class SBSecurityAPI {

    @GetMapping("/testManager")
    public String getMethodName2() {
        return "SpringSecurity In Memory Test successin /testManager";
    }
    @GetMapping("/testSecurity")
    public String getMethodName0() {
        return "SpringSecurity In Memory Test success in login";
    }
@GetMapping("/testPresident")
    public String getMethodName1() {
        return "SpringSecurity In Memory Test success in /testPresident";
    }


    @GetMapping("/testEmployee")
    public String getMethodName3() {
        return "SpringSecurity In Memory Test success in /testEmployee";
    }

    @GetMapping("/testWorker")
    public String getMethodName4() {
        return "SpringSecurity In Memory Test success in /testWorker";
    }
}