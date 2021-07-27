package com.example.minyul.test.api

import com.example.minyul.test.dto.request.UserRequest
import com.example.minyul.test.dto.response.Result
import com.example.minyul.test.dto.response.UserResponse
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.StringBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class PutApi {

    @PutMapping("/put-mapping")
    fun putMapping() : String {
        return "put-mapping"
    }

    // Put은 내용이 없으면 생성하고 있으면 수정
    @PutMapping(path = ["/put-mapping/object"])
    fun putMappingObject(@Valid @RequestBody request : UserRequest, bindingResult: BindingResult): UserRequest {


        // 검증 후, 거기에 맞는 결과를 조작하고 싶으면 bindingResult를 쓰면 된다.
//        if(bindingResult.hasErrors()) {
//            // 500 Error
//            val msg = StringBuilder()
//            bindingResult.allErrors.forEach {
//                val field = it as FieldError
//                val message =it.defaultMessage
//                msg.append(field.toString() + " :  " + message)
//            }
//            return ResponseEntity.badRequest().body(msg.toString())
//        }


        val apply = UserResponse().apply {
            this.result = Result().apply {
                this.resultCode = "OK"
                this.resultMessage = "성공"
            }
        }.apply {
            this.description = "~~~"
        }.apply {
            val userList = mutableListOf<UserRequest>()
            userList.add(request)
            userList.add(UserRequest().apply {
                this.name = "a"
                this.age = 10
            })
            this.userRequest = userList
        }

        return request;
    }
}