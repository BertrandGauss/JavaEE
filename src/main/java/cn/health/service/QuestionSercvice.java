package cn.health.service;

import cn.health.domain.Questionnaire;
import cn.health.domain.Subject;
import cn.health.domain.User_questionnaire_Grade;
import cn.health.mapper.QuestionnaireMapper;
import cn.health.mapper.Subject_Mapper;

import cn.health.mapper.User_questionnaire_GradeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class QuestionSercvice {

    @Autowired
    private Subject_Mapper subjectMapper;
    @Autowired
    private User_questionnaire_GradeMapper user_questionnaire_gradeMapper;
    @Autowired
    private QuestionnaireMapper questionnaireMapper;

    public List<Subject> showQuestion(Integer questionId){

            return subjectMapper.getALL(questionId);

    }

    public String countScore(List<Integer> Answer, Integer questionnaire_id, Integer user_id, Date date){

        Integer score=0;
        List<Integer> point= subjectMapper.getScore(questionnaire_id);
        System.out.println(questionnaire_id);
        System.out.println("答案"+point.size());
        for(int i=0;i<Answer.size();i++){
            score+=point.get(i)*(Answer.get(i)-1);
        }

        User_questionnaire_Grade user_questionnaire_grade=new User_questionnaire_Grade();
        user_questionnaire_grade.setDate(date);
        user_questionnaire_grade.setUser_id(user_id);
        user_questionnaire_grade.setQuestionnaire_id(questionnaire_id);
        user_questionnaire_grade.setGrade(score);
        if(user_questionnaire_gradeMapper.findEist(questionnaire_id,user_id,date)==null)
            user_questionnaire_gradeMapper.add(user_questionnaire_grade);
        else
            user_questionnaire_gradeMapper.update(user_questionnaire_grade);
        String res="";
        if(questionnaire_id==1){
            if(score<=4){
                res="<center>无抑郁症状</center>&nbsp;&nbsp&nbsp;&nbsp&nbsp;&nbsp请继续保持积极阳光的生活态度，面对人生，相信你会遇到很多惊喜，同时也能给他人带来快乐！";
            }else if(score<=7)
                res="<center>轻度抑郁症状</center>&nbsp;&nbsp&nbsp;&nbsp&nbsp;&nbsp偶尔的心绪不宁和失眠会对你造成一些小的影响，虽然不大，但是不要忽略它。时常会感到焦虑不安，一定程度上的悲观厌世，这都有可能影响你正常的人际交往，并有可能引发潜在性的疾病，关注你的身体和心理健康，阅读一些相关的心理书籍，对人生形成更深刻的认识，学会对朋友诉说心中的烦闷，会对你有很大的帮助。";
            else if(score<=15)
                res="<center>中度抑郁症状</center>&nbsp;&nbsp&nbsp;&nbsp&nbsp;&nbsp出现情绪低下、心境恶劣的情况，有明显的失眠症状，思维行动变慢，焦虑症状明显，抑郁症状已经十分明显，请在条件允许的情况，及时联系心理医生或者相关专家进行治疗，在配合药物治疗的同时改善自身的生活环境，提高睡眠质量，加强与家庭成员的交流沟通。";
            else
                res="<center>重度抑郁症状</center>&nbsp;&nbsp&nbsp;&nbsp&nbsp;&nbsp症状非常严重，请积极配合医生的治疗。重度抑郁症患者大部分时间心情抑郁，对平时感兴趣的活动失去了兴趣，体重显著下降或增加，食欲显著降低或增加，每天失眠或睡眠过多等症状，并且极有可能出现自杀的行为。作为患者的家属应做好安全防范措施，积极配合医生的治疗，为病人创造一个良好的生活环境，帮助患者早日康复。";
        }else if(questionnaire_id==2){
            if(score<=3)
                res="<center>差</center>&nbsp;&nbsp&nbsp;&nbsp&nbsp;&nbsp这部分人可能已经患有某些慢性病，需要从整体上调理，建议及时就医，遵医嘱对基础病变进行正规治疗。生活上，要严格按照《中国居民膳食指南》管理饮食，这是最关键的。在此基础上辅以力所能及的运动，循序渐进，慢慢让身体走上正轨。";
            else if(score<=6)
                res="<center>及格</center>&nbsp;&nbsp&nbsp;&nbsp&nbsp;&nbsp这是一条健康与疾病的警戒线，也就是亚健康状态，意味着身体多处亮起了红灯。处于“及格线”的人可能存在一些疾病前期表现，比如血压、血脂、血糖高，但还没有患上心脑血管疾病；腰酸、背痛、腿抽筋，但腿脚还算利索。他们需要在四方面打好基础。一是均衡营养，多吃粗粮、杂粮、蔬果，把体内多余脂肪赶走。二是保障睡眠，上床前3小时不要吃东西，入睡前不玩手机，养成好的睡眠习惯。三是善待压力，别把事情看得太重。四是坚持每周3次、每次半小时左右的有氧运动，老年人可选择快步走、游泳、广场舞。";
            else if(score<=8)
                res="<center>良好</center>&nbsp;&nbsp&nbsp;&nbsp&nbsp;&nbsp这部分人往往失分在某一大类项目，也就是“偏科”。比如运动耐力和核心肌群都不太令人满意，也可能因工作压力大造成精神紧张、失眠、健忘，只要及时弥补不足，很快就会见效。身体偏弱的人，可以采取有氧运动和无氧运动相结合的方法，坚持跑步的同时进行核心肌肉群训练，如平板支撑。压力大的人，要学会缓解压力，可以采用一种叫“利用单调无聊的时间”的技巧：如堵车或在超市排队时，要进行冥想练习，吸气5次，呼气5次，减少环境对情绪的影响。";
            else
                res="<center>优秀</center>&nbsp;&nbsp&nbsp;&nbsp&nbsp;&nbsp你的身心整体情况良好，能在这样一个高压力、高竞争的环境下保持好体格，实属不易。建议继续保持现有的生活方式和饮食习惯，同时带动你身边的人，把健康传递给每个人。";
        }else
            res=score.toString();
        return res;
    }

    //管理员新建问卷
    public void newQuestion(Questionnaire questionnaire){
        questionnaireMapper.add(questionnaire);
    }
    //管理员添加问题
    public void addQuestion(Subject subject){
           subjectMapper.add(subject);
           questionnaireMapper.update(questionnaireMapper.selectByqID(subject.getQuestionnaire_id())+1,subject.getQuestionnaire_id());
    }

}
