package com.example.minyul.test.api

import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull

@Validated // <----------------------// 이걸 써주는 이유는 Validation같은 경우에는 Bean에 대한 검증인데
@RestController                      // 현재 @RequestParam에 쓴것은 Int 기에 적용이 안되서 이걸 써줘야한다.
@RequestMapping("/api")
class DeleteApi {

    @DeleteMapping(path = ["/delete-mapping"])
    fun deleteMapping(@RequestParam _name : String,

                      @NotNull(message = "age 값이 누락되었습니다.")
                      @Min(value = 20, message = "20보다 커야합니다.")
                      @RequestParam _age : Int) : String {
        print(_name);
        return "$_name $_age"
    }

    @DeleteMapping(path = ["/delete-mapping/{name}"])
    fun deleteMappingParam(@PathVariable name : String): String {
        return name
    }
}