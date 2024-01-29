package com.weatherootd.wootd.service;


import com.weatherootd.wootd.entity.Region;
import com.weatherootd.wootd.repository.RegionRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
@Transactional
public class RegionService {
    private final RegionRepository regionRepository;

    @Autowired
    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public void saveRegionsFromCsv(String csvFilePath) throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
        ) {
            for (CSVRecord csvRecord : csvParser) {
                Region region = new Region();
                region.setProvince(csvRecord.get("province"));
                region.setDistrict(csvRecord.get("district"));
                region.setTownship(csvRecord.get("township"));
                region.setNx(Integer.parseInt(csvRecord.get("nx")));
                region.setNy(Integer.parseInt(csvRecord.get("ny")));
                regionRepository.save(region);
            }
        }
    }
}