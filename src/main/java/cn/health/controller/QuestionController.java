package cn.health.controller;

import cn.health.domain.Answer;
import cn.health.domain.Questionnaire;
import cn.health.domain.Subject;
import cn.health.service.QuestionSercvice;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionSercvice questionSercvice;
    @Autowired
    private HttpServletRequest httpServletRequest;


    @RequestMapping(value = "/showallquestion", method = {RequestMethod.POST})
    private JSONObject showAllques(@RequestBody Subject subject){

        List<Subject> quse= questionSercvice.showQuestion(subject.getQuestionnaire_id());
        JSONObject json = new JSONObject();
        json.put("code",0);
        json.put("msg","展示所有问卷题目成功");
        json.put("data",quse);
        json.put("count",quse.size());
        return json;
    }

    @RequestMapping(value ="/score",method = {RequestMethod.POST})
    private  JSONObject Score(@RequestBody Answer answer){
        System.out.print(answer.getAnswer());
        System.out.print(answer.getAnswer().size());
        Integer id=(int)httpServletRequest.getSession().getAttribute("LOGIN_USER");

        String res=questionSercvice.countScore(answer.getAnswer(),answer.getQuestionnaire_id(),id,answer.getDate());
        JSONObject json = new JSONObject();
        json.put("code",0);
        json.put("msg","展示所有问卷结果成功");
        json.put("data",res);
        return json;
    }


    @RequestMapping(value ="/newQ",method = {RequestMethod.POST})
    private JSONObject newQues(@RequestBody Questionnaire questionnaire){
        questionSercvice.newQuestion(questionnaire);
        JSONObject json = new JSONObject();
        json.put("code",0);
        json.put("msg","新建问卷成功");
        return json;
    }

    @RequestMapping(value ="/addQ",method = {RequestMethod.POST})
    private JSONObject addQues(@RequestBody Subject subject){
        System.out.println(subject.getQuestion()+"###");
        System.out.println(subject.getA1()+"###");
        System.out.println(subject.getPoint()+"###");
        questionSercvice.addQuestion(subject);
        JSONObject json = new JSONObject();
        json.put("code",0);
        json.put("msg","添加问题成功");
        return json;
    }

    @RequestMapping(value = "/showQ",method = {RequestMethod.GET})
    private JSONObject showQues(){
        JSONObject json = new JSONObject();
        List<Questionnaire> questionnaires=questionSercvice.showALLQ();
        json.put("code",0);
        json.put("msg","展示问卷概况成功");
        json.put("data",questionnaires);
        return json;
    }
}
