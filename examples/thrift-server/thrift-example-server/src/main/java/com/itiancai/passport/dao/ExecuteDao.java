package com.itiancai.passport.dao;

import com.itiancai.passport.thrift.PassportResult;
import com.itiancai.passport.thrift.PassportResult$;
import com.itiancai.passport.thrift.Source$;
import com.itiancai.passport.thrift.User$;
import com.twitter.finagle.stats.StatsReceiver;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import scala.Option;

@Repository
public class ExecuteDao {

  private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ExecuteDao.class);

  private PassportResult$ myvar = PassportResult$.MODULE$;

  @Autowired
  private Environment environment;

  @Autowired
  private StatsReceiver statsReceiver;

  @Value("${server.port}")
  private String serverPort;

  public PassportResult msg2(String msg){

    statsReceiver.scope("message").counter0("aaa").incr();

    logger.info(222 + "= " + environment.getProperty("server.port2") + "---=" + serverPort);

    return  myvar.apply("1","1", Option.apply(User$.MODULE$.apply("1", "1", Source$.MODULE$.apply(1), Option.apply("11"))));
  }
}
