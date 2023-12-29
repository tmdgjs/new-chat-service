package com.hansheon.chat.domain.member.controller

import com.hansheon.chat.domain.member.application.MemberService
import com.hansheon.chat.domain.member.dto.MemberRegisterRequestDto
import com.hansheon.chat.domain.member.dto.MemberRegisterResponseDto
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/members")
class MemberController(
    private val memberService: MemberService
) {

    @PostMapping
    fun registerMember(
        @RequestBody requestDto: MemberRegisterRequestDto
    ): MemberRegisterResponseDto {
        return memberService.saveMember(requestDto)
    }
}