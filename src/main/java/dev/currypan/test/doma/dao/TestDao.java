package dev.currypan.test.doma.dao;

import dev.currypan.test.doma.entity.TestEntity;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Script;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

import java.util.List;

@Dao
public interface TestDao {
    @Script
    void createTable();

    @Select
    List<TestEntity> selectAll();

    @Insert
    int insert(TestEntity entity);

    @Update
    int update(TestEntity entity);

    @Select
    TestEntity selectById(long id);
}
