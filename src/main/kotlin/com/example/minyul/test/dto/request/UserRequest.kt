package com.example.minyul.test.dto.request

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
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
    var phoneNumber:String?= null
)