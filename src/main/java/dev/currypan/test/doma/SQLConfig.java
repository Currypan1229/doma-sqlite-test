package dev.currypan.test.doma;

import lombok.Getter;
import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.JdbcLogger;
import org.seasar.doma.jdbc.UnknownColumnHandler;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.SqliteDialect;
import org.seasar.doma.jdbc.tx.LocalTransactionDataSource;
import org.seasar.doma.jdbc.tx.LocalTransactionManager;
import org.seasar.doma.jdbc.tx.TransactionManager;
import org.seasar.doma.slf4j.Slf4jJdbcLogger;

import javax.sql.DataSource;

@Getter
public class SQLConfig implements Config {
    public static SQLConfig CONFIG = new SQLConfig();

    private final Dialect dialect;
    private final LocalTransactionDataSource localTransactionDataSource;
    private final TransactionManager transactionManager;
    private final DataSource dataSource;
    private final JdbcLogger jdbcLogger;
    private final UnknownColumnHandler unknownColumnHandler;

    public SQLConfig() {
        dialect = new SqliteDialect();
        dataSource = new LocalTransactionDataSource(
                "jdbc:sqlite:test.db",
                null,
                null
        );
        localTransactionDataSource = new LocalTransactionDataSource(dataSource);
        jdbcLogger = new Slf4jJdbcLogger();
        transactionManager = new LocalTransactionManager(localTransactionDataSource.getLocalTransaction(jdbcLogger));
        unknownColumnHandler = new IUnknownColumnHandler();
    }

    @Override
    public int getBatchSize() {
        return 1000;
    }
}
