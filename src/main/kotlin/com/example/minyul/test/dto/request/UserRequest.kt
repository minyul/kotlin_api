package com.example.minyul.test.dto.request

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming


// @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class) : 없어진듯.
data class UserRequest (

    // ? 이 붙는 이유는 null 이 될 수 있음을 명시하는 것.
    var name:String? = null,
    var age:Int? = null,
    var email:String? = null,
    var address:String? = null,

    // phone_number 이럴 때 어떻게 바인딩을 해야할까? @JsonProperty로 가능
    @JsonProperty("phone_number")
    var phoneNumber:String?= null
)