package com.weatherootd.wootd.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Inquiry extends BaseEntity {

    @Embedded
    private BaseEntityField baseEntityField;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long group_num;

    @Embeddable
    @Getter
    public static class BaseEntityField {
        @Column(name = "inquiry_title")
        private String title;
        @Column(name = "inquiry_content")
        private String content;
        @Column(name = "inquiry_writer")
        private String writer;
        @Column(name = "inquiry_file")
        private String file;
        @Column(name = "inquiry_date")
        private LocalDateTime reg_date;
    }

    @Column(length = 20)
    private String password;

    @ColumnDefault("'미답변'")
    @Enumerated(EnumType.STRING)
    private AnswerStatus status;
}
