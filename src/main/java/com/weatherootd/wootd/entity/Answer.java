package com.weatherootd.wootd.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Answer extends BaseEntity {

    @Embedded
    private BaseEntityField baseEntityField;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "group_num", referencedColumnName = "group_num"),
            @JoinColumn(name = "password", referencedColumnName = "password")
    })
    private Inquiry inquiry;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answer_num;


    @Embeddable
    @Getter
    public static class BaseEntityField {
        @Column(name = "answer_title")
        private String title;
        @Column(name = "answer_content")
        private String content;
        @Column(name = "answer_writer")
        private String writer;
        @Column(name = "answer_file")
        private String file;
        @Column(name = "answer_date")
        private LocalDateTime reg_date;
    }
}
