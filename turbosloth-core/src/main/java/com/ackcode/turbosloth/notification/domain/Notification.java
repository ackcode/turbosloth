package com.ackcode.turbosloth.notification.domain;

/**
 * 通知类型配置
 * 
 * @author bing
 * 
 */
public interface Notification {


  String getCode();


  String getName();


  String getLink();


  String getSubject();


  String getContent();

}
