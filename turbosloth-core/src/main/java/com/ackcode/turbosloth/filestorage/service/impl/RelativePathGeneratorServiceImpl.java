package com.ackcode.turbosloth.filestorage.service.impl;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import com.ackcode.turbosloth.filestorage.service.RelativePathGeneratorService;
import com.ackcode.turbosloth.filestorage.service.RelativePathGeneratorStrategy;

public class RelativePathGeneratorServiceImpl implements RelativePathGeneratorService {

  @Override
  public String generate(String filename) {
    return relativePathGeneratorStrategy.generate(filename);
  }

  private RelativePathGeneratorStrategy relativePathGeneratorStrategy;

  private Collection<RelativePathGeneratorStrategy> relativePathGeneratorStrategyCollection;

  private String strategy;

  public void configStrategy() {
    if (relativePathGeneratorStrategyCollection == null
        || relativePathGeneratorStrategyCollection.isEmpty()) {
      return;
    }

    RelativePathGeneratorStrategy myRelativePathGeneratorStrategy = null;;
    if (strategy == null || strategy.isEmpty()) {
      myRelativePathGeneratorStrategy = relativePathGeneratorStrategyCollection.iterator().next();
    }

    for (RelativePathGeneratorStrategy relativePathGeneratorStrategy : relativePathGeneratorStrategyCollection) {
      if (strategy.equals(relativePathGeneratorStrategy.getName())) {
        myRelativePathGeneratorStrategy = relativePathGeneratorStrategy;
      }
    }

    if (myRelativePathGeneratorStrategy == null) {
      throw new RuntimeException("未能匹配到策略 " + strategy);
    }

    this.relativePathGeneratorStrategy = myRelativePathGeneratorStrategy;

  }

  @Autowired
  public void setRelativePathGeneratorStrategyCollection(
      Collection<RelativePathGeneratorStrategy> relativePathGeneratorStrategyCollection) {
    this.relativePathGeneratorStrategyCollection = relativePathGeneratorStrategyCollection;
    configStrategy();
  }

  @Value("${coke.filestorage.relativepathgenerator:}")
  public void setStrategy(String strategy) {
    this.strategy = strategy;
    configStrategy();
  }

}
