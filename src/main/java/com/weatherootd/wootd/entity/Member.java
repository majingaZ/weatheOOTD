package com.weatherootd.wootd.entity;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Member {

    @ColumnDefault("'USER'")
    private String role;

    @Id
    @Column(length = 30)
    private String id;

    @ColumnDefault("'web'")
    private String id_type;

    @Column(length = 130)
    @NotNull
    private String pass;

    @Column(length = 10)
    private String name;

    @Column(length = 10)
    private String nickname;

    @Column(length = 200)
    private String address;

    @Column(length = 10)
    private String birth;

    @Column(length = 40)
    private String email;

    @Column(length = 15)
    private String phone;

}
