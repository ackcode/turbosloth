package com.ackcode.turbosloth.notification.service.impl;

import java.util.Collection;
import java.util.Map;
import com.ackcode.turbosloth.core.domain.User;
import com.ackcode.turbosloth.notification.domain.Notification;
import com.ackcode.turbosloth.notification.service.NotificationReceiverSerivce;
import com.ackcode.turbosloth.notification.service.NotificationService;
import com.ackcode.turbosloth.notification.service.channel.NotificationChannel;

public class NotificationServiceImpl implements NotificationService {

  public void send(String code, Map<String, Object> variables) {
    Notification notification = getNotification(code);

    Collection<User> userCollection = notificationReceiverSerivce.getReceiver(code, variables);
    Collection<NotificationChannel> notificationChannels = getNotificationChannels(code);

    for (NotificationChannel notificationChannel : notificationChannels) {
      notificationChannel.send(userCollection, notification, variables);
    }

  }

  public void archieve(String msgIdentifier) {

  }

  Notification getNotification(String code) {
    return null;
  }

  Collection<NotificationChannel> getNotificationChannels(String code) {
    return null;
  }

  private NotificationReceiverSerivce notificationReceiverSerivce;

}
