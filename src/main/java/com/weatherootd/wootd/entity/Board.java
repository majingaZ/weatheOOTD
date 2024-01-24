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
public class Board extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "comm_code", referencedColumnName = "comm_code")
    private Community community;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int board_num;

    @Embedded
    private BaseEntityField baseEntityField;

    @Column(length = 4)
    private int visit_count;

    @Embeddable
    @Getter
    public static class BaseEntityField {
        @Column(name = "board_title")
        private String title;
        @Column(name = "board_content")
        private String content;
        @Column(name = "board_writer")
        private String writer;
        @Column(name = "board_file")
        private String file;
        @Column(name = "board_date")
        private LocalDateTime reg_date;
    }
}
