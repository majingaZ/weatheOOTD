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
public class Reply extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "comm_code", referencedColumnName = "comm_code")
    private Community community;

    @ManyToOne
    @JoinColumn(name = "board_num", referencedColumnName = "board_num")
    private Board board;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reply_num;
    
    @Embedded
    private BaseEntityField baseEntityField;
            
    @Embeddable
    @Getter
    public static class BaseEntityField {
        @Column(name = "reply_content", length = 300)
        private String content;

        @Column(name = "reply_writer")
        private String writer;

        @Column(name = "reply_date")
        private LocalDateTime reg_date;
    }
}
