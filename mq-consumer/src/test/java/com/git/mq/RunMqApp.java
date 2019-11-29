package com.git.mq;

import com.git.config.MqConfig;
import com.git.inter.SendMsg;
import com.git.model.dto.MqMsgDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

public class RunMqApp {

    private static final Logger logger = LoggerFactory.getLogger(RunMqApp.class);

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MqConfig.class);
        context.start();
        logger.info("项目启动成功");
        MqMsgDto mqMsgDto = new MqMsgDto();
        mqMsgDto.setContent("测试");
        int i = 1;
        while (true){
        }

    }
}
