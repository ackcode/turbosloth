package com.ackcode.turbosloth.filestorage.domain;

public interface CokeFileInfo {


  String getFileNo();

  void setFileNo(String fileNo);

  String getFilename();

  void setFilename(String filename);


  String getFileStorageType();

  void setFileStorageType(String fileStorageType);

  String getRelativePath();

  void setRelativePath(String relativePath);

  String getAbsolutePath();

  void setAbsolutePath(String absolutePath);


}
