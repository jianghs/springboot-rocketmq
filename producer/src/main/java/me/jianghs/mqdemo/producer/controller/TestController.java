package me.jianghs.mqdemo.producer.controller;

import me.jianghs.mqdemo.producer.dto.Message;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @className: TestController
 * @description: TODO
 * @author: jianghs430
 * @createDate: 2020/10/30 10:03
 * @version: 1.0
 */
@RestController
public class TestController {
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    /**
     * 普通消息投递
     */
    @GetMapping("/test")
    public String test(String msg) {
        Message message = new Message();
        message.setId(UUID.randomUUID().toString());
        message.setText(msg);

        rocketMQTemplate.convertAndSend("add-bonus", message);
        return "投递消息 => " + msg + " => 成功";
    }
}
