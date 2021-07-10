package cn.health.util;

import java.util.HashMap;
import java.util.List;

public class Layui extends HashMap<String,Object> {
    //成功返回
    public static Layui data(Long count,List<?> data){
        Layui r = new Layui();
        r.put("code", 0);
        r.put("msg", "成功");
        r.put("data", data);
        r.put("count", count);

        return r;
    }
}