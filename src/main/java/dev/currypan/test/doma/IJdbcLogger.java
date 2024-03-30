package dev.currypan.test.doma;

import org.seasar.doma.jdbc.JdbcLogger;
import org.seasar.doma.jdbc.Sql;
import org.seasar.doma.jdbc.SqlExecutionSkipCause;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

public class IJdbcLogger implements JdbcLogger {
    private final Logger log = LoggerFactory.getLogger(IJdbcLogger.class);

    @Override
    public void logDaoMethodEntering(final String callerClassName, final String callerMethodName, final Object... parameters) {
        this.log.info("Start dao  | Class:{}  | Method:{}", callerClassName, callerMethodName);
    }

    @Override
    public void logDaoMethodExiting(final String callerClassName, final String callerMethodName, final Object result) {
        this.log.info("Ended dao  | Class:{}  | Method:{}", callerClassName, callerMethodName);
    }

    @Override
    public void logDaoMethodThrowing(final String callerClassName, final String callerMethodName, final RuntimeException e) {
        this.log.error("Throwing from dao  | Class:{}  | Method:{}", callerClassName, callerMethodName);
        this.log.error(e.getMessage());
        log.error(e.getMessage(), e);
    }

    @Override
    public void logSqlExecutionSkipping(final String callerClassName, final String callerMethodName, final SqlExecutionSkipCause cause) {
        this.log.debug("Skipped sql  | Cause:{}  | Class:{}  | Method:{}", cause.name(), callerClassName, callerMethodName);
    }

    @Override
    public void logSql(final String callerClassName, final String callerMethodName, final Sql<?> sql) {
        this.log.debug("Execute the sql  | Class:{}  | Method:{}", callerClassName, callerMethodName);
        this.log.debug(sql.getRawSql());
    }

    @Override
    public void logTransactionBegun(final String callerClassName, final String callerMethodName, final String transactionId) {
        this.log.debug("Begun transaction  | TransID:{}  | Class:{}  | Method:{}", transactionId, callerClassName, callerMethodName);
    }

    @Override
    public void logTransactionEnded(final String callerClassName, final String callerMethodName, final String transactionId) {
        this.log.debug("Ended transaction  | TransID:{}  | Class:{}  | Method:{}", transactionId, callerClassName, callerMethodName);
    }

    @Override
    public void logTransactionCommitted(final String callerClassName, final String callerMethodName, final String transactionId) {
        this.log.debug("Committed transaction  | TransID:{}  | Class:{}  | Method:{}", transactionId, callerClassName, callerMethodName);
    }

    @Override
    public void logTransactionSavepointCreated(final String callerClassName, final String callerMethodName, final String transactionId, final String savepointName) {
        this.log.debug("Created transaction save point  | TransID:{}  | Point:{}  | Class:{}  | Method:{}", transactionId, savepointName, callerClassName, callerMethodName);
    }

    @Override
    public void logTransactionRolledback(final String callerClassName, final String callerMethodName, final String transactionId) {
        this.log.debug("Rolled back transaction  | TransID:{}  | Class:{}  | Method:{}", transactionId, callerClassName, callerMethodName);
    }

    @Override
    public void logTransactionSavepointRolledback(final String callerClassName, final String callerMethodName, final String transactionId, final String savepointName) {
        this.log.debug("Rolled back transaction to save point  | TransID:{}  | Point:{}  | Class:{}  | Method:{}", transactionId, savepointName, callerClassName, callerMethodName);
    }

    @Override
    public void logTransactionSavepointReleased(final String callerClassName, final String callerMethodName, final String transactionId, final String savepointName) {
        this.log.debug("Released transaction save point  | TransID:{}  | Point:{}  | Class:{}  | Method:{}", transactionId, savepointName, callerClassName, callerMethodName);
    }

    @Override
    public void logTransactionRollbackFailure(final String callerClassName, final String callerMethodName, final String transactionId, final SQLException e) {
        this.log.error("Failed rolling back transaction  | TransID:{}  | Class:{}  | Method:{}", transactionId, callerClassName, callerMethodName);
        this.log.error(e.getMessage());
        log.error(e.getMessage(), e);
    }

    @Override
    public void logAutoCommitEnablingFailure(final String callerClassName, final String callerMethodName, final SQLException e) {
        this.log.error("Failed enabling auto commit  | Class:{}  | Method:{}", callerClassName, callerMethodName);
        this.log.error(e.getMessage());
        log.error(e.getMessage(), e);
    }

    @Override
    public void logTransactionIsolationSettingFailure(final String callerClassName, final String callerMethodName, final int isolationLevel, final SQLException e) {
        this.log.error("Failed setting transaction isolation  | IsolationLv:{}  | Class:{}  | Method:{}", isolationLevel, callerClassName, callerMethodName);
        this.log.error(e.getMessage());
        log.error(e.getMessage(), e);
    }

    @Override
    public void logConnectionClosingFailure(final String callerClassName, final String callerMethodName, final SQLException e) {
        this.log.error("Failed closing connection  | Class:{}  | Method:{}", callerClassName, callerMethodName);
        this.log.error(e.getMessage());
        log.error(e.getMessage(), e);
    }

    @Override
    public void logStatementClosingFailure(final String callerClassName, final String callerMethodName, final SQLException e) {
        this.log.error("Failed closing statement  | Class:{}  | Method:{}", callerClassName, callerMethodName);
        this.log.error(e.getMessage());
        log.error(e.getMessage(), e);
    }

    @Override
    public void logResultSetClosingFailure(final String callerClassName, final String callerMethodName, final SQLException e) {
        this.log.error("Failed closing result set  | Class:{}  | Method:{}", callerClassName, callerMethodName);
        this.log.error(e.getMessage());
        log.error(e.getMessage(), e);
    }
}
