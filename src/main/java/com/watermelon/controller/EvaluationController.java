package com.watermelon.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.watermelon.entity.Course;
import com.watermelon.entity.IndividualEvaluation;
import com.watermelon.entity.User;
import com.watermelon.service.EvaluationService;
import com.watermelon.service.UserService;
import com.watermelon.utils.ResultUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.text.DecimalFormat;
import java.util.*;

import static com.alibaba.fastjson.JSON.parseObject;

@RestController
@RequestMapping("/evaluation")
public class EvaluationController {
    @Autowired
    private EvaluationService evaluationService;
    @Autowired
    private UserService userService;

    //获取可评价的课程
//    @GetMapping("/teacher/courses")
//    public Object findCoursesOfTeacher(HttpSession session){
//        Object username = session.getAttribute("username");
//        User user = userService.getUserByName((String) username);
//        return ResultUtil.success(evaluationService.getCoursesByTeacherId(user.getId()));
//    }

    @GetMapping("teacher/courses")
    public Object findEvaluCoursesOfTeacher(int startPage, int pageSize,String courseName,HttpSession session){
        Object username = session.getAttribute("username");
        User user = userService.getUserByName((String) username);
        return ResultUtil.success(evaluationService.getCoursesByTeacherId(user.getId(),startPage,pageSize,courseName));
    }

//    @GetMapping("/courses/byStudentId")
//    public Object findCoursesByStuId(int id){
//        return ResultUtil.success(evaluationService.getCoursesByStuId(id));
//    }


    @GetMapping("student/courses")
    public Object findCoursesByStuId(int startPage, int pageSize,String courseName,HttpSession session){
        Object username = session.getAttribute("username");
        User user = userService.getUserByName((String) username);
        return ResultUtil.success(evaluationService.getCoursesByStuId(user.getId(),startPage,pageSize,courseName));
    }

//    @GetMapping("/courses/bySuperId")
//    public Object findTeachersBySuperId(int id){
//        return ResultUtil.success(evaluationService.getCoursesBySuperId(id));
//    }

    @GetMapping("/supervisor/courses")
    public Object findTeachersBySuperId(int startPage, int pageSize,String courseName, HttpSession session){
        Object username = session.getAttribute("username");
        User user = userService.getUserByName((String) username);
        return ResultUtil.success(evaluationService.getCoursesBySuperId(user.getId(),startPage,pageSize,courseName));
    }
//获取个人评价
    @GetMapping("/superIndividualEvaluation")
    public Object findSuperIndividualEvaluation(int teacherId, int courseId,HttpSession session){
        User user = userService.getUserByName((String) session.getAttribute("username"));
        return ResultUtil.success(evaluationService.getSuperIndiEvaluation(user.getId(),teacherId,courseId));
    }

    @GetMapping("/teacherIndividualEvaluation")
    public Object findTeacherIndividualEvaluation(int TeacherId,int courseId,HttpSession session){
        User user = userService.getUserByName((String) session.getAttribute("username"));
        return ResultUtil.success(evaluationService.getTeacherIndiEvaluation(user.getId(),TeacherId,courseId));
    }

    @GetMapping("/studentIndividualEvaluation")
    public Object findStudentIndividualEvaluation(int teacherId,int courseId,HttpSession session){
        User user = userService.getUserByName((String) session.getAttribute("username"));
        return ResultUtil.success(evaluationService.getStudentIndiEvaluation(user.getId(),teacherId,courseId));
    }
//插入个人评价
    @PostMapping("/studentIndividualEvaluation")
    public Object addStudentIndividualEvaluation(@RequestBody @Valid IndividualEvaluation individualEvaluation,HttpSession session){
        User user = userService.getUserByName((String) session.getAttribute("username"));
        individualEvaluation.setFromId(user.getId());
        individualEvaluation.setTotalScore(((double)(individualEvaluation.getScore1() + individualEvaluation.getScore2() + individualEvaluation.getScore3() + individualEvaluation.getScore4() + individualEvaluation.getScore5() + individualEvaluation.getScore6())/6));
        evaluationService.addStudentIndiEvaluation(individualEvaluation);
        return ResultUtil.success();
    }

    @PostMapping("/teacherIndividualEvaluation")
    public Object addTeacherIndividualEvaluation(@RequestBody @Valid IndividualEvaluation individualEvaluation,HttpSession session){
        User user = userService.getUserByName((String) session.getAttribute("username"));
        individualEvaluation.setFromId(user.getId());
        individualEvaluation.setTotalScore(((double)(individualEvaluation.getScore1() + individualEvaluation.getScore2() + individualEvaluation.getScore3() + individualEvaluation.getScore4() + individualEvaluation.getScore5() + individualEvaluation.getScore6())/6));
        evaluationService.addTeacherIndiEvaluation(individualEvaluation);
        return ResultUtil.success();
    }

    @PostMapping("/superIndividualEvaluation")
    public Object addSuperIndividualEvaluation(@RequestBody @Valid IndividualEvaluation individualEvaluation,HttpSession session){
        User user = userService.getUserByName((String) session.getAttribute("username"));
        individualEvaluation.setFromId(user.getId());
        individualEvaluation.setTotalScore(((double)(individualEvaluation.getScore1() + individualEvaluation.getScore2() + individualEvaluation.getScore3() + individualEvaluation.getScore4() + individualEvaluation.getScore5() + individualEvaluation.getScore6())/6));
        evaluationService.addSuperIndiEvaluation(individualEvaluation);
        return ResultUtil.success();
    }

// 获取教师总评价
    @GetMapping("/summaryEvaluation/byTeacherId")
    public Object findSummaryEvaluation(int courseId,HttpSession session){
        User user = userService.getUserByName((String) session.getAttribute("username"));
        return ResultUtil.success(evaluationService.getSummaryEvaluation(user.getId(),courseId));
    }

 //管理员获取教师总评价
    @GetMapping("admin/summaryEvaluation")
    public Object findAllSummaryEvaluation(int startPage,int pageSize,String courseName) {
        Page p = (Page) evaluationService.getCoursesByAdmin(startPage,pageSize,courseName);
        JSONObject page =  new JSONObject();
        page.put("total",p.getTotal());
        page.put("size",p.getSize());
        page.put("current",p.getCurrent());
        page.put("pages",p.getPages());
        JSONArray records = (JSONArray) JSONArray.toJSON(p.getRecords());
//        JSONArray newRrecords = new JSONArray();
        for(int j = 0;j < records.size();j++) {
            int courseId = ((JSONObject)records.get(j)).getInteger("id");
            int teacherId = ((JSONObject) records.get(j)).getJSONObject("teacher").getInteger("id");
            List<Map> summaryList = evaluationService.getSummaryEvaluation(teacherId,courseId);
            Double totalAvg = 0.0;
            //若其中一个角色未评价，则不返回
            int count = 0;
            for(int i=0;i < summaryList.size();i++) {
                switch ((String)((HashMap)summaryList.get(i)).get("role_name")) {
                    case "学生":
                        totalAvg += Double.parseDouble((String.valueOf(((HashMap)summaryList.get(i)).get("total_score"))) ) * 0.3;
                        count++;
                        break;
                    case "教师":
                        totalAvg += Double.parseDouble((String.valueOf(((HashMap)summaryList.get(i)).get("total_score"))) ) * 0.3;
                        count++;
                        break;
                    case "督导":
                        totalAvg += Double.parseDouble(String.valueOf( ((HashMap)summaryList.get(i)).get("total_score"))) * 0.4;
                        count++;
                        break;
                }
            }
            if(count >= 3) {
                ((JSONObject) records.get(j)).put("totalAvg",new DecimalFormat("#.00").format(totalAvg));
            }
        }
        page.put("records",records);
        return ResultUtil.success(JSONObject.parseObject(page.toJSONString()));
    }
    
//管理员通过教师id获取详细评价
    @GetMapping("admin/summaryEvaluation/byTeacherId")
    public Object findSummaryEvaluationByTeacher(int teacherId,int courseId){
        return ResultUtil.success(evaluationService.getSummaryEvaluation(teacherId,courseId));
    }

// 获取教师的所有课程
    @GetMapping("/teacher/courseList")
    public Object findAllCourses(int startPage,int pageSize,HttpSession session) {
        User user = userService.getUserByName((String) session.getAttribute("username"));
        return ResultUtil.success(evaluationService.getCoursesOfTeacher(user.getId(),startPage,pageSize));
    }

// 获取教师建议
    @GetMapping("/teacher/advices")
    public Object findAdvices(int courseId,int roleId,int startPage,int pageSize,HttpSession session) {
        User user = userService.getUserByName((String) session.getAttribute("username"));
        IPage p = evaluationService.getAdvices(user.getId(),courseId,roleId,startPage,pageSize);
        List newlist = new ArrayList();
        List list = p.getRecords();
        for(Object advice:list) {
            Map<String,String> newMap = new HashMap<String,String>();
            newMap.put("advicecontent", (String) advice);
            newlist.add(newMap);
        }
        p.setRecords(newlist);
        return ResultUtil.success(p);
    }
}
