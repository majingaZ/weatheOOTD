package com.weatherootd.wootd.entity;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
@Getter
@Setter
abstract class BaseEntity {

    @CreatedDate
    @Column(name="reg_date", updatable = false)
    private LocalDateTime reg_date;

    @Column(name="writer")
    @NotNull
    private String writer;

    @Column(name="title", length = 100)
    @NotNull
    private String title;

    @Column(name="content")
    @NotNull
    private String content;

    @Column(name="file")
    private String file;
}
