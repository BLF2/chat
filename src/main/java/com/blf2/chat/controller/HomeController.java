package com.blf2.chat.controller;

import com.blf2.chat.common.ResultBase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/health")
    public ResultBase<String> health(){
        return ResultBase.success();
    }
}
