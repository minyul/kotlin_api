package com.example.minyul.test.api

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class DeleteApi {

    @DeleteMapping(path = ["/delete-mapping"])
    fun deleteMapping(@RequestParam _name : String, @RequestParam _age : Int) : String {
        print(_name);
        return "$_name $_age"
    }

    @DeleteMapping(path = ["/delete-mapping/{name}"])
    fun deleteMappingParam(@PathVariable name : String): String {
        return name
    }
}