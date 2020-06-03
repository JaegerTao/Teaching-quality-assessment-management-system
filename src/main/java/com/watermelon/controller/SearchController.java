package com.watermelon.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.ExistsQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private RestHighLevelClient client;

    @GetMapping("/listAll")
    public List<JSONObject> search(int startPage, int pageSize) throws IOException {
        SearchRequest request = new SearchRequest("logstash-2020.06.03");
        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.from((startPage-1)*pageSize);
        builder.size(pageSize);
        request.source(builder);
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        //获取索引，并将索引内的数据读取出来
        System.out.println("索引内doc：");
        List<JSONObject> list = new ArrayList<>();
        for (SearchHit hit : response.getHits().getHits()){
            JSONObject jo = JSONObject.parseObject(hit.getSourceAsString());
            list.add(jo);
            System.out.println(jo.get("message"));
        }
        //输出数据条数
        System.out.println(response.getHits().getHits().length);
        System.out.println("数量："+response.getHits().getTotalHits());
        return list;
    }

    @GetMapping("/listByKey")
    public List<JSONObject> searchByKey(int startPage, int pageSize, String key) throws IOException {
        SearchRequest request = new SearchRequest("logstash-2020.06.03");
        SearchSourceBuilder builder = new SearchSourceBuilder();
        //查询分页
        builder.from((startPage-1)*pageSize);
        builder.size(pageSize);
        //设置精确条件查询
        TermQueryBuilder queryBuilder = QueryBuilders.termQuery("@timestamp",key);
        builder.query(queryBuilder);
        builder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        request.source(builder);
        SearchResponse response = client.search(request,RequestOptions.DEFAULT);

        List<JSONObject> list = new ArrayList<>();
        for (SearchHit hit : response.getHits().getHits()){
            JSONObject jo = JSONObject.parseObject(hit.getSourceAsString());
            list.add(jo);
            System.out.println(jo.get("message"));
        }
        System.out.println(response.getHits().getHits().length);
        System.out.println("数量："+response.getHits().getTotalHits());
        return list;
    }

    @GetMapping("/listExistByKey")
    public List<JSONObject> searchExistByKey(int startPage, int pageSize, String key) throws IOException {
        SearchRequest request = new SearchRequest("logstash-2020.06.03");
        SearchSourceBuilder builder = new SearchSourceBuilder();
        //查询分页
        builder.from((startPage-1)*pageSize);
        builder.size(pageSize);
        //设置精确条件查询
        MatchQueryBuilder queryBuilder = QueryBuilders.matchQuery("message",key);
        builder.query(queryBuilder);
        builder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        request.source(builder);
        SearchResponse response = client.search(request,RequestOptions.DEFAULT);

        List<JSONObject> list = new ArrayList<>();
        for (SearchHit hit : response.getHits().getHits()){
            JSONObject jo = JSONObject.parseObject(hit.getSourceAsString());
            list.add(jo);
            System.out.println(jo.get("message"));
        }
        System.out.println(response.getHits().getHits().length);
        System.out.println("数量："+response.getHits().getTotalHits());
        return list;
    }

}
