package com.fis.cems.util;

import com.fis.cems.dao.jdbc.AbstractDAO;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class ConnectionUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractDAO.class);

    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("app-conf");

    private static final String USER = resourceBundle.getString("user");

    private static final String PASSWORD = resourceBundle.getString("password");

    private static final String URL = resourceBundle.getString("url");

    public static Connection getConnection() throws Exception {
////         No connection pool
//         Connection conn = DriverManager.getConnection (URL, USER_NAME, PASSWORD);

////         Has connection pool
////         C3P0
//         Connection conn = c3p0DataSource().getConnection();

//         HikariCP
        Connection conn = ds.getConnection();

        return conn;
    }

    public static ComboPooledDataSource c3p0DataSource() throws PropertyVetoException
    {
        ComboPooledDataSource cpd = new ComboPooledDataSource();
        cpd.setJdbcUrl(URL);
        cpd.setUser(USER);
        cpd.setPassword(PASSWORD);

        // Optional Settings
        cpd.setInitialPoolSize(5);
        cpd.setMinPoolSize(5);
        cpd.setAcquireIncrement(5);
        cpd.setMaxPoolSize(20);
        cpd.setMaxStatements(100);

        LOGGER.info("Create c3p0 connection pool!! {}", cpd);
        return cpd;
    }

//    private static HikariConfig config = new HikariConfig();

    private static HikariConfig config = new HikariConfig("/hikari-conf.properties");

    private static HikariDataSource ds = new HikariDataSource(config);

//    static {
//        config.setJdbcUrl( URL );
//        config.setUsername( USER );
//        config.setPassword( PASSWORD );
//        config.addDataSourceProperty( "cachePrepStmts" , "true" );
//        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
//        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
//
//        ds = new HikariDataSource(config);
//    }
}
