package com.watermelon.controller;

import com.alibaba.fastjson.JSONObject;
import com.watermelon.service.elasticsearch.SearchService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @ApiOperation(value="查询所有日志")
    @GetMapping("/searchAll")
    public JSONObject search(@ApiParam(value="起始页",example="1") @RequestParam(value="startPage",required=false) int startPage,
                             @ApiParam(value="页数据数",example="5") @RequestParam(value="pageSize",required=false) int pageSize) throws IOException {
        return searchService.searchAll(startPage,pageSize);
    }

    @ApiOperation(value="精确匹配查询")
    @GetMapping("/termSearch")
    public JSONObject searchByKey(@ApiParam(value="起始页",example="1") @RequestParam(value="startPage",required=false) int startPage,
                                  @ApiParam(value="页数据数",example="5") @RequestParam(value="pageSize",required=false) int pageSize,
                                  @ApiParam(value="关键字",example="keyword") @RequestParam(value="key",required=false)String key) throws IOException {
        return searchService.searchByKey(startPage,pageSize,key);
    }

    @ApiOperation(value="模糊匹配查询")
    @GetMapping("/fuzzySearch")
    public JSONObject searchExistByKey(@ApiParam(value="起始页",example="1") @RequestParam(value="startPage",required=false) int startPage,
                                       @ApiParam(value="页数据数",example="5") @RequestParam(value="pageSize",required=false) int pageSize,
                                       @ApiParam(value="关键字",example="keyword") @RequestParam(value="key",required=false)String key) throws IOException {
        return searchService.searchExistByKey(startPage,pageSize,key);
    }

}
