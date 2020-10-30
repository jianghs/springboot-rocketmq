package me.jianghs.mqdemo.consumer.listener;

import lombok.extern.slf4j.Slf4j;
import me.jianghs.mqdemo.consumer.dto.Message;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @className: AddBonusListener
 * @description: TODO
 * @author: jianghs430
 * @createDate: 2020/10/30 10:10
 * @version: 1.0
 */
@Slf4j
@Service
@RocketMQMessageListener(consumerGroup = "test-group", topic = "add-bonus")
public class AddBonusListener implements RocketMQListener<Message> {
    @Override
    public void onMessage(Message msg) {
        log.warn("消费到消息 => "+ msg.toString());
    }
}
