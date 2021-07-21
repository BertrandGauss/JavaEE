package cn.health.controller;

import cn.health.util.FileUtil;
import cn.health.util.ImageToBase64;
import cn.health.util.FoodDetectUtil;
import com.tencentcloudapi.tiia.v20190529.models.DetectLabelResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class ImageController {

    private final ResourceLoader resourceLoader;

    @Autowired
    public ImageController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Value("${web.upload-path}")
    private String path;

    /**
     * 跳转到文件上传页面
     * @return
     */
    @RequestMapping("test")
    public String toUpload(){
        return "test";
    }

    /**
     *
     * @param file 要上传的文件
     * @return
     */
    @RequestMapping("fileUpload")
    public String upload(@RequestParam("fileName") MultipartFile file, Map<String, Object> map){

        // 要上传的目标文件存放路径
        String localPath = "E:/javaProject/image";
        // 上传成功或者失败的提示
        String msg = "";

        if (FileUtil.upload(file, localPath, file.getOriginalFilename())){
            // 上传成功，给出页面提示
            msg = "上传成功！";
        }else {
            msg = "上传失败！";

        }

        // 显示图片
        map.put("msg", msg);

        map.put("fileName", file.getOriginalFilename());

        DetectLabelResponse res=FoodDetectUtil.detectFood(localPath+'\\'+ file.getOriginalFilename());
        map.put("data1",res.getLabels()[0].getName());
        map.put("con1",res.getLabels()[0].getConfidence());
        map.put("data2",res.getLabels()[1].getName());
        map.put("con2",res.getLabels()[1].getConfidence());
        map.put("data3",res.getLabels()[2].getName());
        map.put("con3",res.getLabels()[2].getConfidence());
        map.put("data4",res.getLabels()[3].getName());
        map.put("con4",res.getLabels()[3].getConfidence());
        return "forward:/test";
    }

    /**
     * 显示单张图片
     * @return
     */
    @RequestMapping("show")
    public ResponseEntity showPhotos(String fileName){

        try {
            // 由于是读取本机的文件，file是一定要加上的， path是在application配置文件中的路径
            return ResponseEntity.ok(resourceLoader.getResource("file:" + path + fileName));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }



}