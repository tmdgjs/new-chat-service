package com.hansheon.chat.domain.member.application;

import com.hansheon.chat.domain.member.GivenMember
import com.hansheon.chat.domain.member.dto.MemberRegisterRequestDto
import com.hansheon.chat.domain.member.persist.repository.MemberRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.*
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@ExtendWith(MockitoExtension::class)
class MemberServiceTests {

    private val memberRepository = mockk<MemberRepository>()
    private lateinit var memberService: MemberService

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        memberService = MemberService(memberRepository)
    }

    @Test
    @DisplayName("새로운 유저를 등록한다.")
    fun register_member_success() {
        // Given
        val requestDto =
            MemberRegisterRequestDto(
                GivenMember.NAME,
                GivenMember.GENDER,
                GivenMember.BIRTH,
                GivenMember.PROFILE_IMAGE
            )

        // When

        every { memberRepository.save(any()) } returns GivenMember.toMember(1L)
        val responseDto = memberService.saveMember(requestDto)

        // Then
        verify { memberRepository.save(any()) }
        assertAll(
            { assertThat(responseDto).isNotNull() },
            { assertThat(responseDto.id).isNotNull() },
            { assertThat(responseDto.name).isEqualTo(GivenMember.NAME) },
            { assertThat(responseDto.gender).isEqualTo(GivenMember.GENDER) },
            { assertThat(responseDto.birth).isEqualTo(GivenMember.BIRTH) },
            { assertThat(responseDto.profileImage).isEqualTo(GivenMember.PROFILE_IMAGE) }
        )
    }
}
