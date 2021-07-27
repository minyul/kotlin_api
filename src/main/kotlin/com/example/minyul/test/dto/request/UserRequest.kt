package com.example.minyul.test.dto.request

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.lang.Exception
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.validation.constraints.*


// @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class) : 없어진듯.
data class UserRequest (


    // Java와 다르게 코틀린은 @field 를 써줘야한다.

    // ? 이 붙는 이유는 null 이 될 수 있음을 명시하는 것.

    @field:NotEmpty
    @field:Size(min = 2, max = 8)
    var name:String? = null,

    @field:PositiveOrZero
    var age:Int? = null,

    @field:Email
    var email:String? = null,

    @field:NotBlank
    var address:String? = null,

    // phone_number 이럴 때 어떻게 바인딩을 해야할까? @JsonProperty로 가능
    @field:Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\{4}\$")
    @JsonProperty("phone_number")
    var phoneNumber:String?= null,

    var createdAt:String?= null // yyyy-MM-dd HH:mm:ss  ex ) 2028-10-02 13:00:00
){



    // 정상일때 true, 비정상 false
    @AssertTrue // 검증하는 과정에서 실행할 수 있도록, Validation이 일어날때 이 메소드가 일어남
    private fun inValidCreatedAt(): Boolean {
        return try {
            LocalDateTime.parse(this.createdAt, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            true
        } catch (e:Exception) {
            false
        }
    }
}