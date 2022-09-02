package com.ackcode.turbosloth.filestorage.service;

public interface RelativePathGeneratorStrategy {

  String generate(String filename);

  String getName();

}
