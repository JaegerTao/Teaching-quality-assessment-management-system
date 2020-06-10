package com.watermelon.service.elasticsearch;

import com.alibaba.fastjson.JSON;
import com.watermelon.entity.Student;
import com.watermelon.entity.Teacher;
import com.watermelon.mapper.StudentMapper;
import com.watermelon.mapper.TeacherMapper;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ExportElasticSearchServiceImpl {

    @Autowired
    private RestHighLevelClient client;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    public void exportStudent() throws IOException {
        BulkRequest request = new BulkRequest();
        request.timeout(TimeValue.timeValueMillis(10000));
        //获取批量数据
        List<Student> students = studentMapper.listStudentWithNoCourse();

        for (int i=0;i<students.size();i++){
            request.add(new IndexRequest("student")
                    .id((i+1)+"")
                    .source(JSON.toJSONString(students.get(i)), XContentType.JSON));
        }
        BulkResponse responses = client.bulk(request, RequestOptions.DEFAULT);
        System.out.println("isFailed: "+responses.hasFailures());
    }

    public void exportTeacher() throws IOException {
        BulkRequest request = new BulkRequest();
        request.timeout(TimeValue.timeValueMillis(10000));
        //获取批量数据
        List<Teacher> teachers = teacherMapper.listTeacher();

        for (int i=0;i<teachers.size();i++){
            request.add(new IndexRequest("student")
                    .id((i+1)+"")
                    .source(JSON.toJSONString(teachers.get(i)), XContentType.JSON));
        }
        BulkResponse responses = client.bulk(request, RequestOptions.DEFAULT);
        System.out.println("isFailed: "+responses.hasFailures());
    }

}
