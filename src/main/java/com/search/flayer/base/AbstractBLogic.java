package com.search.flayer.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Service
public abstract class AbstractBLogic<I, O> implements BLogic<I, O> {

    @Autowired
    PlatformTransactionManager txManager;

    public O execute(I input) throws Exception {

        // 前処理
        preExecute(input);

        O output = null;

        // トランザクション管理の開始
        DefaultTransactionDefinition txDefinition = new DefaultTransactionDefinition();
        txDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus txStatus = txManager.getTransaction(txDefinition);

        try {
            output = doExecute(input);

            // DBへのアクセスが問題なく終了した場合は処理を確定させる
            txManager.commit(txStatus);

        } catch (Exception e) {

            System.out.println("例外発生:" + e.toString());

            // 何らかの事情で更新処理に失敗した場合は処理をロールバックする
            txManager.rollback(txStatus);

            throw new Exception();
        }

        // 後処理
        afterExecute(input);

        return output;
    }

    protected abstract void preExecute(I input);

    protected abstract O doExecute(I input);

    protected abstract void afterExecute(I input);
}
