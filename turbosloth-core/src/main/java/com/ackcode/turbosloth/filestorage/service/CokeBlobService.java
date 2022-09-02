package com.ackcode.turbosloth.filestorage.service;

import com.ackcode.turbosloth.filestorage.domain.CokeBlob;

public interface CokeBlobService {
  CokeBlob put(byte[] data);

  CokeBlob put(String data);

  CokeBlob get(Long id);

  int update(Long id, String data);

  int update(Long id, byte[] data);


}
