package com.ackcode.turbosloth.notification.service.impl;

import java.util.Collection;
import java.util.Map;
import com.ackcode.turbosloth.core.domain.User;
import com.ackcode.turbosloth.notification.domain.NotificationReceiver;
import com.ackcode.turbosloth.notification.service.NotificationReceiverSerivce;
import com.ackcode.turbosloth.notification.service.userprovider.NotificationReceiverProvider;

public class NotificationReceiverSerivceImpl implements NotificationReceiverSerivce {

  public Collection<User> getReceiver(String code, Map<String, Object> variables) {

    Collection<NotificationReceiver> notificationReceivers = getNotificationReceiver(code);
    for (NotificationReceiver notificationReceiver : notificationReceivers) {
      NotificationReceiverProvider notificationReceiverProvider =
          notificationReceiverProviderMap.get(notificationReceiver.getType());

      if (notificationReceiverProvider != null) {
        notificationReceiverProvider.findReceivers(notificationReceiver, variables);
      }
    }

    return null;
  }

  Collection<NotificationReceiver> getNotificationReceiver(String code) {
    return null;
  }

  private Map<String, NotificationReceiverProvider> notificationReceiverProviderMap;

}
