package com.hansheon.chat.domain.member.dto

import com.hansheon.chat.domain.member.enums.Gender
import com.hansheon.chat.domain.member.persist.Member
import java.time.LocalDate

class MemberRegisterResponseDto private constructor(
    val id: Long,
    val name: String,
    val gender: Gender?,
    val birth: LocalDate?,
    val profileImage: String?
) {

    /* 비즈니스 로직 */
    companion object {

        fun of(member: Member): MemberRegisterResponseDto {
            return MemberRegisterResponseDto(
                id = member.id,
                name = member.name,
                gender = member.gender,
                birth = member.birth,
                profileImage = member.profileImage
            )
        }
    }
}
