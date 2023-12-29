package com.hansheon.chat.domain.member.persist

import com.hansheon.chat.domain.member.enums.Gender
import jakarta.persistence.*
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import java.time.LocalDate

/**
 * @title 사용자 Entity
 */

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "member")
class Member private constructor(

    @Id
    @GeneratedValue
    val id: Long = 0L,

    @Column(name = "name")
    val name: String,

    @Column(name = "gender")
    val gender: Gender,

    @Column(name = "birth")
    val birth: LocalDate,

    @Column(name = "profile_image")
    val profileImage: String
) {

    /* 비즈니스 로직 */
    companion object {

        fun createMember(name: String,
                         gender: Gender,
                         birth: LocalDate,
                         profileImage: String,
                         id: Long = 0L): Member {
            return Member(id, name, gender, birth, profileImage)
        }
    }
}
