package dev.currypan.test.doma.dao;

import dev.currypan.test.doma.entity.TestEntity;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import java.util.List;

@Dao
public interface TestDao {
    @Select
    List<TestEntity> selectAll();
}
