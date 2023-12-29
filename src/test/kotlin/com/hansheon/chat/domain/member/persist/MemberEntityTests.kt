package com.hansheon.chat.domain.member.persist

import com.hansheon.chat.domain.member.GivenMember
import com.hansheon.chat.domain.member.persist.repository.MemberRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit.jupiter.SpringExtension


@ExtendWith(SpringExtension::class)
@DataJpaTest
class MemberEntityTests {

    @Autowired
    private lateinit var memberRepository: MemberRepository

    private lateinit var member: Member

    @BeforeEach
    fun setUp() {
        member = GivenMember.toMember()
    }

    @Test
    @DisplayName("사용자를 생성한다.")
    fun create_member_success() {

        // Given
        // setUp 의 member

        // when
        val savedMember: Member = memberRepository.save(member)

        assertAll(
            { assertThat(savedMember).isNotNull() },
            { assertThat(savedMember.id).isNotNull() },
            { assertThat(savedMember.name).isEqualTo(GivenMember.NAME) },
            { assertThat(savedMember.gender).isEqualTo(GivenMember.GENDER) },
            { assertThat(savedMember.birth).isEqualTo(GivenMember.BIRTH) },
            { assertThat(savedMember.profileImage).isEqualTo(GivenMember.PROFILE_IMAGE) }
        )
    }

}
