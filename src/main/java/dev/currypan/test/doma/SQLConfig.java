package dev.currypan.test.doma;

import lombok.Getter;
import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.JdbcLogger;
import org.seasar.doma.jdbc.UnknownColumnHandler;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.SqliteDialect;
import org.seasar.doma.jdbc.tx.LocalTransactionDataSource;
import org.seasar.doma.jdbc.tx.LocalTransactionManager;
import org.seasar.doma.slf4j.Slf4jJdbcLogger;

@Getter
public class SQLConfig implements Config {

    public static final SQLConfig CONFIG = new SQLConfig();

    private final Dialect dialect;
    private final LocalTransactionDataSource dataSource;
    private final JdbcLogger jdbcLogger;
    private final LocalTransactionManager transactionManager;
    private final UnknownColumnHandler unknownColumnHandler;

    private SQLConfig() {
        dialect = new SqliteDialect();
        dataSource = new LocalTransactionDataSource("jdbc:sqlite:test.db?jdbc.explicit_readonly=true&busy_timeout=1000000", null, null);
        jdbcLogger = new Slf4jJdbcLogger();
        transactionManager = new LocalTransactionManager(dataSource.getLocalTransaction(getJdbcLogger()));
        unknownColumnHandler = new IUnknownColumnHandler();
    }

    @Override
    public int getBatchSize() {
        return 1000;
    }
}
