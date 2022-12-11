package com.diabolocom.sergeitest

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.lang.StringBuilder
import java.util.*

@RestController
class Controller {

    @PostMapping("/solve")
    suspend fun handle(@RequestBody request: Request): Response {
        return Response(solve(request.input))
    }

    private fun solve(input: String): String {
        val s = Stack<Char>()
        for (ch in input){
            when (ch) {
                '#' -> {
                    if (!s.isEmpty()) {
                        s.pop()
                    }
                }
                else -> s.push(ch)
            }
        }
        return String(s.toCharArray())
    }
}