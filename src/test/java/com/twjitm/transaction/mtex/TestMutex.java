package com.twjitm.transaction.mtex;import com.twjitm.transaction.entity.MutexEntity;import com.twjitm.transaction.service.redis.impl.NettyTransactionRedisServiceImpl;import com.twjitm.transaction.service.transaction.NettyTransactionServiceImpl;import com.twjitm.transaction.spring.TestSpring;import com.twjitm.transaction.transaction.enums.NettyTransactionCause;import com.twjitm.transaction.transaction.enums.NettyTransactionCommitResult;import com.twjitm.transaction.transaction.enums.NettyTransactionEntityCause;import org.springframework.context.support.ClassPathXmlApplicationContext;import org.springframework.util.Assert;/** * 互斥锁测试 * * @author EGLS0807 - [Created on 2018-08-28 10:31] * @company http://www.g2us.com/ * @jdk java version "1.8.0_77" */public class TestMutex {    public static void main(String[] args) {        ClassPathXmlApplicationContext applicationContext = TestSpring.initSpring();        NettyTransactionRedisServiceImpl nettyTransactionRedisService =                (NettyTransactionRedisServiceImpl) applicationContext.getBean                        ("nettyTransactionRedisService");        NettyTransactionServiceImpl nettyTransactionService = (NettyTransactionServiceImpl) applicationContext.getBean("nettyTransactionServiceImpl");        NettyTransactionEntityCause cause = new NettyTransactionEntityCause("mutex");        MutexEntity mutexEntity = new MutexEntity(cause, "mutex", nettyTransactionRedisService);        NettyTransactionCause transactionCause = new NettyTransactionCause("mutex");        NettyTransactionCommitResult result =                nettyTransactionService.commitTransaction(transactionCause, mutexEntity);        System.out.println(result.getResult());        Assert.isTrue(true,"");    }}