package com.example.minyul.test.api

import com.example.minyul.test.dto.request.UserRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class GetApi {

    @GetMapping("/hello") // path = ["/hello"] 도 가능 하고, ["hello"] 도 가능
    fun hello(): String {
        return "hello kotlin";
    }

    @RequestMapping(method = [RequestMethod.GET], path = ["/hello-2"])
    fun helloV2() : String {
        return "hello_2 kotelin";
    }

    @GetMapping("/get-mapping/{name}/{age}")
    fun pathVariableTestMethod(@PathVariable name: String, @PathVariable(value = "age") _age : Int) : String {
        println("${name}, ${_age}");

        return name;
    }

    @GetMapping("/get-mapping/query-param")
    fun queryParam(@RequestParam name: String) : String {
        return name;
    }

    // *******************************************
    // 만약 @RequestController에서 Object 를 반환하면*
    // ObjectMapper를 통해서 Json으로 반환이 된다.   *
    // *******************************************
    @GetMapping("/get-mapping/object")
    fun queryParamObject(request: UserRequest) : UserRequest {
            return request;
    }

    // 위에있는것처럼 age=10&name=minyul 이렇게 queryString으로 보내면돼.
    @GetMapping("/get-mapping/query-param/map")
    fun queryParamMap(@RequestParam map : Map<String,Any>): Map<String, Any> {
        val phoneNumber = map.get("phone-number");
        return map;
    }
}