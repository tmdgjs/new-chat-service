package com.hansheon.chat.domain.member

import com.hansheon.chat.domain.member.enums.Gender
import com.hansheon.chat.domain.member.persist.Member
import java.time.LocalDate

object GivenMember {

    const val NAME: String = "한승헌"
    val GENDER: Gender = Gender.MALE
    val BIRTH: LocalDate = LocalDate.of(2001,11,15)
    const val PROFILE_IMAGE: String = "https://url.kr/5vmngd"

    fun toMember(): Member {
        return Member.createMember(NAME, GENDER, BIRTH, PROFILE_IMAGE)
    }
}
