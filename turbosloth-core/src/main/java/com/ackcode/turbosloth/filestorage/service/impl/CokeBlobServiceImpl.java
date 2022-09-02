package com.ackcode.turbosloth.filestorage.service.impl;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import org.malagu.linq.JpaUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ackcode.turbosloth.filestorage.domain.CokeBlob;
import com.ackcode.turbosloth.filestorage.service.CokeBlobService;

@Service
@Transactional
public class CokeBlobServiceImpl implements CokeBlobService {

  @Override
  public CokeBlob put(byte[] data) {
    CokeBlob cokeBlob = new CokeBlob();
    cokeBlob.setData(data);
    cokeBlob.setCreateTime(new Date());
    JpaUtil.persist(cokeBlob);
    return cokeBlob;
  }

  @Override
  public CokeBlob put(String data) {
    return put(data.getBytes(StandardCharsets.UTF_8));
  }

  @Override
  public int update(Long id, String data) {
    return update(id, data.getBytes(StandardCharsets.UTF_8));
  }

  @Override
  public int update(Long id, byte[] data) {
    return JpaUtil.linu(CokeBlob.class).set("data", data).set("createTime", new Date()).update();
  }

  @Override
  public CokeBlob get(Long id) {
    return JpaUtil.linq(CokeBlob.class).equal("id", id).findOne();
  }

}
