package com.git;

import com.git.config.MqConfig;
import com.git.inter.SendMsg;
import com.git.model.dto.MqMsgDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class RunMqApp {

    private static final Logger logger = LoggerFactory.getLogger(RunMqApp.class);

    public static void main(String[] args) {
        System.setProperty("-Dlog4j.skipJansi","fasle");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MqConfig.class);
        context.start();
        logger.info("项目启动成功");
        MqMsgDto mqMsgDto = new MqMsgDto();
        mqMsgDto.setContent("测试");
        int i = 1;
        while (true){
            mqMsgDto.setContent("测试"+i);
            SendMsg sendMsg = context.getBean(SendMsg.class);
            logger.info("开始发送此消息，时间为：{}",new Date());
            sendMsg.sendQueue("queuq22",mqMsgDto);
            sendMsg.sendTopic("topic22",mqMsgDto);

            try {
                Thread.sleep(1000*10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }


    }
}
