package com.watermelon.service.elasticsearch;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;

public interface SearchService {

    JSONObject searchAll(int startPage, int pageSize) throws IOException;

    JSONObject searchByKey(int startPage, int pageSize, String key) throws IOException;

    JSONObject searchExistByKey(int startPage, int pageSize, String key) throws IOException;
}
