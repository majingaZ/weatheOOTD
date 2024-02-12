package com.weatherootd.wootd.dto;

import com.weatherootd.wootd.entity.Community;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardDTO {

    private Community community;
    private int board_num;
    private int visit_count;
    private String title;
    private String content;
    private String writer;
    private String file;
    private LocalDateTime reg_date;
}
