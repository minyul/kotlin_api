package com.example.minyul.test.dto.response

import com.example.minyul.test.dto.request.UserRequest
import com.fasterxml.jackson.annotation.JsonProperty

data class UserResponse (
    var result:Result ?= null,
    var description:String ?= null,

    @JsonProperty("user")
    var userRequest : List<UserRequest> ?= null
)

data class Result (
    var resultCode:String ?= null,
    var resultMessage:String ?= null
)

/*
{
    "result" {
        "resultCode" : "OK",
        "resultMessge" : "성공"
    },

    "description" : "~~",
    "user" : [
        {
            "name" : "name_1"
            "age" : "10",
        },
         {
            "name" : "name_2"
            "age" : "10",
        }
    ]
}
 */