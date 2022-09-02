package com.ackcode.turbosloth.notification.service.userprovider;

import java.util.Collection;
import java.util.Map;
import com.ackcode.turbosloth.core.domain.User;
import com.ackcode.turbosloth.notification.domain.NotificationReceiver;

/**
 * 用户选择
 * 
 */

public interface NotificationReceiverProvider {

  /**
   * 用户选择器类型
   * 
   * @return
   */
  String getType();

  /**
   * 用户选择器描述
   * 
   * @return
   */
  String getDesc();

  /**
   * 用户选择器URI
   * 
   * @return
   */
  String getUri();

  /**
   * 用户选择框配置
   * 
   * @return
   */
  String getDialogConfig();

  /**
   * 加载用户编号
   * 
   * @param plan
   * @param variables
   * @return
   */
  Collection<User> findReceivers(NotificationReceiver notificationReceiver, Map<String, Object> variables);
}
