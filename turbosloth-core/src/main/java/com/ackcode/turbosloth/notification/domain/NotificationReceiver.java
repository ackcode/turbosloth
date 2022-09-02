package com.ackcode.turbosloth.notification.domain;

public interface NotificationReceiver {

  public String getType();

  public String getName();

  public String getIdentifier();

}
