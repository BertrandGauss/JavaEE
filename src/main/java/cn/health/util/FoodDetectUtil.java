package cn.health.util;


import com.alibaba.fastjson.JSONObject;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.tiia.v20190529.TiiaClient;
import com.tencentcloudapi.tiia.v20190529.models.*;

public class FoodDetectUtil
{
    public  static DetectLabelResponse detectFood(String fileName) {

        try{
            // 实例化一个认证对象，入参需要传入腾讯云账户secretId，secretKey,此处还需注意密钥对的保密
            // 密钥可前往https://console.cloud.tencent.com/cam/capi网站进行获取
            //自己申请的
            Credential cred = new Credential("AKIDNZVAYfV4MNyJM8droUszpOfgPr2wZv0o", " Zrsb4F9m7ByUjhOpyrSmpb7MK1RZQ06w");
            cred.setSecretId("AKIDNZVAYfV4MNyJM8droUszpOfgPr2wZv0o");
            cred.setSecretKey("Zrsb4F9m7ByUjhOpyrSmpb7MK1RZQ06w");
            // 实例化一个http选项，可选的，没有特殊需求可以跳过
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("tiia.tencentcloudapi.com");
            // 实例化一个client选项，可选的，没有特殊需求可以跳过
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setSignMethod("TC3-HMAC-SHA256");
            clientProfile.setHttpProfile(httpProfile);
            // 实例化要请求产品的client对象,clientProfile是可选的
            TiiaClient client = new TiiaClient(cred, "ap-beijing", clientProfile);
            // 实例化一个请求对象,每个接口都会对应一个request对象
            DetectLabelRequest req = new DetectLabelRequest();
            String base64=ImageToBase64.ImageToBase64(fileName);
            req.setImageBase64(base64);
            System.out.println(fileName);

            System.out.println("base64:"+base64);
            // 返回的resp是一个DetectLabelResponse的实例，与请求对象对应
            DetectLabelResponse resp = client.DetectLabel(req);

            // 输出json格式的字符串回包
            System.out.println(DetectLabelResponse.toJsonString(resp));
            return resp;
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
            return null;
        }
    }
}