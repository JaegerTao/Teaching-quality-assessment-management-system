package com.watermelon.controller;

import com.watermelon.service.elasticsearch.ExportElasticSearchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ExportController {

    @Autowired
    private ExportElasticSearchServiceImpl  exportElasticSearchService;

    @GetMapping("/exportStudent")
    public void exportStudent() throws IOException {
//        exportElasticSearchService.exportStudent();
    }

    @GetMapping("/exportTeacher")
    public void exportTeacher() throws IOException {
//        exportElasticSearchService.exportTeacher();
    }

}
