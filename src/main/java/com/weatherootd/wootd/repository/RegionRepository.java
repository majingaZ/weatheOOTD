package com.weatherootd.wootd.repository;

import com.weatherootd.wootd.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, Long> {
}
