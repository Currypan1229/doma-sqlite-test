package dev.currypan.test;

import dev.currypan.test.doma.SQLConfig;
import dev.currypan.test.doma.dao.TestDao;
import dev.currypan.test.doma.dao.TestDaoImpl;
import org.seasar.doma.jdbc.tx.TransactionManager;

public class TestApp {
    public static void main(final String[] args) {
        final TransactionManager tm = SQLConfig.singleton().getTransactionManager();
        tm.required(() -> {
            final TestDao dao = new TestDaoImpl(SQLConfig.singleton());
            dao.selectAll();
        });
    }
}
