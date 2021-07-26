package com.example.minyul.test.dto.request

data class UserRequest (

    // ? 이 붙는 이유는 null 이 될 수 있음을 명시하는 것.
    var name:String? = null,
    var age:Int? = null,
    var email:String? = null,
    var address:String? = null
)