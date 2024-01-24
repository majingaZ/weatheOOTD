package com.weatherootd.wootd.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Community {

    @Id
    @Column(length = 10)
    private String comm_code;

    @Column(length = 20)
    private String comm_name;
}
