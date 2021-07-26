package com.example.minyul.test.response

import com.example.minyul.test.dto.request.UserRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class ResponseApi {


    // @RequestParam(require = true) 로 하면 무조건 age값이 있어야한다.
    // 근데 deafult 가 true 이다.
    // 만약 안붙이게 할라면 Int? 이렇게 해주면된다.
    @GetMapping(path = ["/response"])
    fun getMapping(@RequestParam age : Int?): ResponseEntity<String> {
        return age?.let {
            if(it < 20) {
                return ResponseEntity.status(400).body("OK")
            }
            ResponseEntity.ok("OK")
        }.run {
            return ResponseEntity.status(400).body("OK")
        }
    }

    /*
        Any는 "Root" 타입으로, 코틀린의 모든 타입은 Any를 상속합니다.
        이는 Java에서 Object와 같은 개념이며, 실질적으로 바이트코드로 컴파일 됐을 때 자바의 Object와 일치합니다.
     */

    @PostMapping("")
    fun postMapping(@RequestBody request : UserRequest?): ResponseEntity<Any> {
        return ResponseEntity.status(200).body(request)
    }
}