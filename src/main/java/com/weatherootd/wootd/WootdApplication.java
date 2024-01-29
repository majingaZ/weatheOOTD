package com.weatherootd.wootd;


import com.weatherootd.wootd.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WootdApplication implements CommandLineRunner {

    private final RegionService regionService;

    @Autowired
    public WootdApplication(RegionService regionService) {
        this.regionService = regionService;
    }

    public static void main(String[] args) {
        SpringApplication.run(WootdApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String csvFilePath = "C:/Users/heeja/intelliJ-workspace/wootd/wootdfile/regionList.csv";
        regionService.saveRegionsFromCsv(csvFilePath);
    }
}