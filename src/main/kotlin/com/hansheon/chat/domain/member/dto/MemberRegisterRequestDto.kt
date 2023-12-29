package com.hansheon.chat.domain.member.dto

import com.hansheon.chat.domain.member.enums.Gender
import com.hansheon.chat.domain.member.persist.Member
import java.time.LocalDate

data class MemberRegisterRequestDto (
    val name: String,
    val gender: Gender?,
    val birth: LocalDate?,
    val profileImage: String?
) {
    fun toEntity(): Member {
        return Member.createMember(
            name,
            gender,
            birth,
            profileImage
        )
    }
}