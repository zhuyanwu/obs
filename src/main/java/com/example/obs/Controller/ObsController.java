package com.example.obs.Controller;

import com.obs.services.ObsClient;
import com.obs.services.ObsConfiguration;
import com.obs.services.model.*;
import com.obs.services.model.fs.FSStatusEnum;
import com.obs.services.model.fs.FolderContentSummary;
import com.oef.services.OefClient;
import com.oef.services.model.CreateAsynchFetchJobsResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
@RequestMapping("/obs")
public class ObsController {

    private static final Logger logger = LoggerFactory.getLogger(ObsController.class);

//    private static final String endPoint = "obs.cn-east-3.myhuaweicloud.com";
//
//    private static final String ak = "HXK66CXIVKJBZ5KWQXVP";
//
//    private static final String sk = "o5DfcTF2VBFvGxPmAYB1bABxlteOQU4a97iO67Rk";

    private static final String endPoint = "obs.cn-north-4.myhuaweicloud.com";

    private static final String ak = "01EIF6LVEFYG5APFIVI9";

    private static final String sk = "pTfcxU2DQlaIYAXmgyboAOeA6DZZRiKQB4QHxY39";

    @GetMapping("/test")
    public String test(){
//        ObsConfiguration config = new ObsConfiguration();
//        config.setSocketTimeout(30000);
//        config.setConnectionTimeout(10000);
//        config.setEndPoint(endPoint);

        ObsClient obsClient = new ObsClient(ak,sk,endPoint);
//        HeaderResponse response = obsClient.putObject("zhu-bucket", "zhuyanwu/book1", new File("D:\\gitProject\\book2.txt"));
//        obsClient.deleteObject("tongtong-img","file/1_1603101255352.txt");
        ObjectListing objectListing =obsClient.listObjects("tongtong-img");
        logger.info("size: " + objectListing.getObjects().size());
        for(ObsObject obj : objectListing.getObjects()){
            logger.info(obj.getObjectKey());
        }
        return objectListing.toString();

    }
}
