package com.example.obs.Controller;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("/aip")
public class AipController {

    private static final Logger logger = LoggerFactory.getLogger(AipController.class);

    private static final String appId = "22846466";

    private static final String ak = "Rlg50PDYqM3ePuAKRXGXEYI1";

    private static final String sk = "S3xcN9iuiQMIaN012eA2zQS23DBzjzgc";

    @GetMapping("/test")
    @ResponseBody
    public String test(){
        AipOcr client = new AipOcr(appId,ak,sk);
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("language_type", "CHN_ENG");
        options.put("detect_direction", "true");
        options.put("detect_language", "true");
        options.put("probability", "true");

        // 参数为本地图片路径
        String image = "1603243281.png";
        JSONObject res = client.basicGeneral(image, options);
        return res.toString(2);
    }

}
