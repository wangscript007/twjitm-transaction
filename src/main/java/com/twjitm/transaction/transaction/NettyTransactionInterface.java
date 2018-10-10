package com.twjitm.transaction.transaction;import com.twjitm.transaction.transaction.enums.NettyTransactionCause;import com.twjitm.transaction.transaction.exception.NettyTransactionException;/** * @author EGLS0807 - [Created on 2018-08-27 10:07] * @company http://www.g2us.com/ * @jdk java version "1.8.0_77" */public interface NettyTransactionInterface {    /** 激活，构造*/    int ACTIVE = 0;    /** 尝试提交*/  int TRYCOMMITED = 1;    /** 正式提交*/    int COMMITED = 2;    /** 正式回滚*/    int ROLLEDBACK = 3;    /**     * 事务提交     * @throws NettyTransactionException     */     void commit() throws NettyTransactionException;    /**     * 事务回滚     * @throws NettyTransactionException     */     void rollback() throws NettyTransactionException;    /**     * 是否可以提交     * @return     */     boolean canCommit();    /**     * 尝试性提交     */     void tryCommit() throws NettyTransactionException;    /**     * 获取事务原因     * @return     */     NettyTransactionCause getCause();    /**     * 是否可以创建锁     * @return     */     boolean createNettyTransactionLock() throws NettyTransactionException;    /**     * 释放锁     * @return     */     void releaseNettyTransactionLock();}