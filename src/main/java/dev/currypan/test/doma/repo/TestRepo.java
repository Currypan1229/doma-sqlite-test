package dev.currypan.test.doma.repo;

import dev.currypan.test.doma.SQLConfig;
import dev.currypan.test.doma.dao.TestDao;
import dev.currypan.test.doma.dao.TestDaoImpl;
import dev.currypan.test.doma.entity.TestEntity;

public class TestRepo {
    private static final TestDao dao = new TestDaoImpl(SQLConfig.CONFIG);

    public static TestEntity selectById(final long id) {
        return dao.selectById(id);
    }

    public static void save(final TestEntity entity) {
        synchronized (dao) {
            if (entity.getVersionNo() <= 0) {
                dao.insert(entity);
            } else {
                dao.update(entity);
            }
        }
    }
}
