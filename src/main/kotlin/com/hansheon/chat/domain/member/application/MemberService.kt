package com.hansheon.chat.domain.member.application

import com.hansheon.chat.domain.member.dto.MemberRegisterRequestDto
import com.hansheon.chat.domain.member.dto.MemberRegisterResponseDto
import com.hansheon.chat.domain.member.persist.Member
import com.hansheon.chat.domain.member.persist.repository.MemberRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class MemberService(
    private val memberRepository: MemberRepository
) {

    // 회원을 저장한다.
    fun saveMember(requestDto: MemberRegisterRequestDto): MemberRegisterResponseDto {

        val savedMember: Member = memberRepository.save(requestDto.toEntity())
        return MemberRegisterResponseDto.of(savedMember)
    }
}