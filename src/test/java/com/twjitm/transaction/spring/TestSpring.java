package com.twjitm.transaction.spring;import com.twjitm.transaction.service.redis.NettyTransactionRedisService;import com.twjitm.transaction.service.redis.impl.NettyTransactionRedisServiceImpl;import com.twjitm.transaction.service.transaction.NettyTransactionService;import org.springframework.context.support.ClassPathXmlApplicationContext;/** * @author EGLS0807 - [Created on 2018-08-27 17:03] * @company http://www.g2us.com/ * @jdk java version "1.8.0_77" */public class TestSpring {    public static  ClassPathXmlApplicationContext initSpring(){        ClassPathXmlApplicationContext classPathXmlApplicationContext=new                ClassPathXmlApplicationContext(new String[]{"classpath:bean/*.xml"});        return classPathXmlApplicationContext;    }    public static void main(String[] args) {        ClassPathXmlApplicationContext applicationContext = TestSpring.initSpring();        NettyTransactionRedisServiceImpl rdis = (NettyTransactionRedisServiceImpl) applicationContext.getBean("nettyTransactionRedisService");    }}