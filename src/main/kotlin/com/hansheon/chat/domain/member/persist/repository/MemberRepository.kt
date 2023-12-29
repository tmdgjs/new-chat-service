package com.hansheon.chat.domain.member.persist.repository

import com.hansheon.chat.domain.member.persist.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository: JpaRepository<Member, Long> {
}