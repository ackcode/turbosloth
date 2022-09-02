package com.ackcode.turbosloth.notification.service.channel;

import java.util.Collection;
import java.util.Map;
import com.ackcode.turbosloth.core.domain.User;
import com.ackcode.turbosloth.notification.domain.Notification;


public interface NotificationChannel {
  /**
   * 通知方式唯一编码
   * 
   * @return
   */
  String getType();

  /**
   * 通知方式描述
   * 
   * @return
   */
  String getDesc();

  /**
   * 发送通知
   * 
   * @param receivers 接收通知者
   * @param title 通知标题
   * @param content 通知内容
   * @param variables 变量，每个接收人信息不同时使用
   */
  void send(Collection<User> receivers, Notification notification,
      Map<String, Object> variables);

  void send(User receivers, Notification notification,
      Map<String, Object> variables);

  void archieve(String identifier);

}
