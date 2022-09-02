package com.ackcode.turbosloth.notification.service;

import java.util.Collection;
import java.util.Map;
import com.ackcode.turbosloth.core.domain.User;

public interface NotificationReceiverSerivce {

  Collection<User> getReceiver(String code, Map<String, Object> variables);
}
