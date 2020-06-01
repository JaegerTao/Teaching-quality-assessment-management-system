package com.watermelon.service.elasticsearch;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.watermelon.config.ElasticSearchConfig;
import com.watermelon.entity.User;
import com.watermelon.entity.UserBehavior;
import com.watermelon.service.UserService;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UserBehaviorService {
    @Autowired
    RestHighLevelClient client;

    @Autowired
    UserService userService;

    public void addBehavior(UserBehavior userBehavior) throws IOException, ParseException {
        User user = userService.getUserById(userBehavior.getId());
        userBehavior.setName(userService.getNameById(user.getId()));
        userBehavior.setUsername(user.getName());
        userBehavior.setRole(user.getRole().getName());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = dateFormat.format(new Date());
        userBehavior.setCreateDate(dateStr);

        IndexRequest indexRequest = new IndexRequest("userbehavior","_doc").source(JSON.toJSONString(userBehavior), XContentType.JSON);
        IndexResponse indexResponse = this.client.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println(indexResponse);
    }
}
