package com.example.minyul.test.api

import com.example.minyul.test.dto.request.UserRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class PostApi {

    @PostMapping("/post-mapping")
    fun postMapping() : String {
        return "post-mapping"
    }

    @RequestMapping(method = [RequestMethod.POST], path = ["request-mapping"])
    fun requestMapping() : String {
        return "request-mapping"
    }

    // Object Mapper
    // Json -> Object
    // Object -> Json
    @PostMapping("/post-mapping/object")
    fun postMappingObject(@RequestBody request: UserRequest): UserRequest {
        println(request)
        return request
    }
}