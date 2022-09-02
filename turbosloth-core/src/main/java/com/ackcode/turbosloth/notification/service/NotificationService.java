package com.ackcode.turbosloth.notification.service;

import java.util.Map;

public interface NotificationService {

  void send(String code, Map<String, Object> variables);

  void archieve(String msgIdentifier);
}
