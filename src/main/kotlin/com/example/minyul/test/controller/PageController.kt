package com.example.minyul.test.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

/*
 만약 의존성에 (gradle) 타임리프같은 것을 넣었다면
 Controller에 문자열을 반환했을 시, 리조버가 생기어 template 패키지에서 찾겠지만,
 만약 그냥 의존성 없이 html 을 반환하고자 할때는 static에서 찾는다!
 */

@Controller
class PageController {

    @GetMapping("/main")
    fun main() : String {
        return "main.html"
    }

    @ResponseBody
    @GetMapping("/test")
    fun response() : String {
        return "main.html" // 이거는 static에서 찾지않고 그냥 이 문자열이 Object로 보내짐 ( ObjectMapper로 Json이 )
    }
}