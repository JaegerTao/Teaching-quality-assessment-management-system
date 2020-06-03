package com.watermelon.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private RestHighLevelClient client;

    @ApiOperation(value="查询所有日志")
    @GetMapping("/searchAll")
    public JSONObject search(@ApiParam(value="起始页",example="1") @RequestParam(value="startPage",required=false) int startPage,
                             @ApiParam(value="页数据数",example="5") @RequestParam(value="pageSize",required=false) int pageSize) throws IOException {
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
        long totalNumber = response.getHits().getTotalHits();
        System.out.println(response.getHits().getHits().length);
        System.out.println("数量："+response.getHits().getTotalHits());
        Map<String,Object> result = new HashMap<>();
        result.put("resultSum",totalNumber);
        result.put("resultList",list);
        return JSONObject.parseObject(JSON.toJSONString(result));
    }

    @ApiOperation(value="精确匹配查询")
    @GetMapping("/termSearch")
    public JSONObject searchByKey(@ApiParam(value="起始页",example="1") @RequestParam(value="startPage",required=false) int startPage,
                                  @ApiParam(value="页数据数",example="5") @RequestParam(value="pageSize",required=false) int pageSize,
                                  @ApiParam(value="关键字",example="keyword") @RequestParam(value="key",required=false)String key) throws IOException {
        SearchRequest request = new SearchRequest("logstash-2020.06.03");
        SearchSourceBuilder builder = new SearchSourceBuilder();
        //查询分页
        builder.from((startPage-1)*pageSize);
        builder.size(pageSize);
        //设置精确条件查询
        String keyField = "message";
        TermQueryBuilder queryBuilder = QueryBuilders.termQuery(keyField,key);
        builder.query(queryBuilder);
        builder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        //设置关键词高亮
        builder.highlighter(getHighlightConfig(keyField));
        request.source(builder);
        SearchResponse response = client.search(request,RequestOptions.DEFAULT);

        List<JSONObject> list = new ArrayList<>();
        for (SearchHit hit : response.getHits().getHits()){
            //显示关键词高亮，将源关键词替换为高亮之后的关键词
            Map<String, Object> sourceAsMap = getHighlightDisplay(hit,keyField);
            JSONObject jo = JSONObject.parseObject(JSON.toJSONString(sourceAsMap));
            list.add(jo);
            System.out.println(jo.get(keyField));
        }
        long totalNumber = response.getHits().getTotalHits();
        System.out.println(response.getHits().getHits().length);
        System.out.println("数量："+ totalNumber);
        Map<String,Object> result = new HashMap<>();
        result.put("resultSum",totalNumber);
        result.put("resultList",list);
        return JSONObject.parseObject(JSON.toJSONString(result));
    }

    @ApiOperation(value="模糊匹配查询")
    @GetMapping("/fuzzySearch")
    public JSONObject searchExistByKey(@ApiParam(value="起始页",example="1") @RequestParam(value="startPage",required=false) int startPage,
                                       @ApiParam(value="页数据数",example="5") @RequestParam(value="pageSize",required=false) int pageSize,
                                       @ApiParam(value="关键字",example="keyword") @RequestParam(value="key",required=false)String key) throws IOException {
        SearchRequest request = new SearchRequest("logstash-2020.06.03");
        SearchSourceBuilder builder = new SearchSourceBuilder();
        //查询分页
        builder.from((startPage-1)*pageSize);
        builder.size(pageSize);
        //设置匹配条件查询
        MatchQueryBuilder queryBuilder = QueryBuilders.matchQuery("message",key);
        builder.query(queryBuilder);
        builder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        //设置查询高亮
        builder.highlighter(getHighlightConfig("message"));
        request.source(builder);
        SearchResponse response = client.search(request,RequestOptions.DEFAULT);

        List<JSONObject> list = new ArrayList<>();
        for (SearchHit hit : response.getHits().getHits()){
            Map<String, Object> sourceAsMap = getHighlightDisplay(hit,"message");

            JSONObject jo = JSONObject.parseObject(JSON.toJSONString(sourceAsMap));
            list.add(jo);
            System.out.println(jo.get("message"));
        }
        System.out.println(response.getHits().getHits().length);
        Long totalNumber = response.getHits().getTotalHits();
        System.out.println("数量：" + totalNumber);
        Map<String,Object> result = new HashMap<>();
        result.put("resultSum",totalNumber);
        result.put("resultList",list);
        return JSONObject.parseObject(JSON.toJSONString(result));
    }

    /**
     *
     * @param keyField
     * @return
     */
    private HighlightBuilder getHighlightConfig(String keyField){
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field(keyField);
        highlightBuilder.requireFieldMatch(false);
        highlightBuilder.preTags("<span class='highLight'>");
        highlightBuilder.postTags("</span>");
        return highlightBuilder;
    }

    /**
     *
     * @param hit
     * @param keyField
     * @return
     */
    private Map<String, Object> getHighlightDisplay(SearchHit hit,String keyField){
        Map<String, HighlightField> highlightFields = hit.getHighlightFields();
        HighlightField message = highlightFields.get(keyField);
        Map<String, Object> sourceAsMap = hit.getSourceAsMap();
        if (message!=null){
            Text[] fragments = message.fragments();
            String newMessage = "";
            for (Text text : fragments){
                newMessage = newMessage + text;
            }
            sourceAsMap.put(keyField,newMessage);
        }
        return sourceAsMap;
    }

    /**
     * 通过数据总数(totalNumber)和单页的数据数量(pageSize)转换出页数(pageNumber)
     * @param totalNumber
     * @param pageSize
     * @return
     */
    private long getPageNumber(long totalNumber,int pageSize){
        long pageNumber = 0;
        long size = Long.parseLong(pageSize+"");
        if (totalNumber%pageSize==0){
            pageNumber = totalNumber / pageSize;
        }else {
            pageNumber = (totalNumber / pageSize)+1;
        }
        return pageNumber;
    }

}
