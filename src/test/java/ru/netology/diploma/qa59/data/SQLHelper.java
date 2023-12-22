package ru.netology.diploma.qa59.data;

import lombok.SneakyThrows;
import lombok.Value;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLHelper {
    private static QueryRunner runner = new QueryRunner();

    private static Connection getConn() throws Exception {

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
    }

    @SneakyThrows
    public static SQLHelper.SQLCrRqst getSQLInfoCrRqst() {
        var codeSQL = "SELECT * FROM credit_request_entity ORDER BY created DESC LIMIT 1";
        var conn = getConn();
        return runner.query(conn, codeSQL, new BeanHandler<>(SQLCrRqst.class));
    }

    @SneakyThrows
    public static SQLHelper.SQLOrder getSQLInfoOrder() {
        var codeSQL = "SELECT * FROM order_entity ORDER BY created DESC LIMIT 1";
        var conn = getConn();
        return runner.query(conn, codeSQL, new BeanHandler<>(SQLOrder.class));
    }

    @SneakyThrows
    public static SQLHelper.SQLPayment getSQLInfoPayment() {
        var codeSQL = "SELECT * FROM payment_entity ORDER BY created DESC LIMIT 1";
        var conn = getConn();
        return runner.query(conn, codeSQL, new BeanHandler<>(SQLPayment.class));
    }

    @SneakyThrows
    public static void cleanDatabase() {
        var conn = getConn();
        runner.execute(conn, "DELETE FROM credit_request_entity");
        runner.execute(conn, "DELETE FROM order_entity");
        runner.execute(conn, "DELETE FROM payment_entity");
    }

    @Value
    public static class SQLCrRqst {
        String id;
        String bankId;
        String created;
        String status;
    }

    @Value
    public static class SQLOrder {
        String id;
        String created;
        String credit_id;
        String payment_id;
    }

    @Value
    public static class SQLPayment {
        String id;
        String amount;
        String created;
        String status;
        String transId;
    }
}
