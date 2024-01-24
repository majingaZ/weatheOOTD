package com.weatherootd.wootd.repository;

import com.weatherootd.wootd.entity.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface InuiryRepository extends JpaRepository<Inquiry, Long>, QuerydslPredicateExecutor<Inquiry> {
}
