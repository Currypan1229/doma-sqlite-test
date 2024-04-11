package dev.currypan.test;

import dev.currypan.test.doma.SQLConfig;
import dev.currypan.test.doma.dao.TestDaoImpl;
import dev.currypan.test.doma.entity.TestEntity;
import dev.currypan.test.doma.repo.TestRepo;
import org.seasar.doma.jdbc.tx.TransactionManager;

import java.util.Random;

public class TestApp {
    public static void main(final String[] args) throws InterruptedException {
        final TransactionManager tm = SQLConfig.CONFIG.getTransactionManager();

        tm.required(() -> {
            new TestDaoImpl(SQLConfig.CONFIG).createTable();
        });

        //Thread.sleep(1000);


        //Async thread
        new Thread(() -> {
            tm.required(() -> {
                TestEntity entity = TestRepo.selectById(0);
                if (entity == null) {
                    entity = new TestEntity();
                    entity.setId(0);
                }
                entity.setValue(String.valueOf((char) new Random().nextInt()));

                TestRepo.save(entity);
            });
        }).start();
        new Thread(() -> tm.required(() -> {
            //new TestDaoImpl(SQLConfig.CONFIG).selectAll();
            TestEntity entity = TestRepo.selectById(1);
            if (entity == null) {
                entity = new TestEntity();
                entity.setId(1);
            }
            entity.setValue("Index1");
            TestRepo.save(entity);
        })).start();
    }
}
