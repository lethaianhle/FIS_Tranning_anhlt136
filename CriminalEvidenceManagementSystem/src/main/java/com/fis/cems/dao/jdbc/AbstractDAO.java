package com.fis.cems.dao.jdbc;

import com.fis.cems.dao.GenericDAO;
import com.fis.cems.mapper.IMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AbstractDAO<T> implements GenericDAO<T> {
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractDAO.class);
    ResourceBundle resourceBundle = ResourceBundle.getBundle("app-conf");

    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(resourceBundle.getString("driverName"));

            String user = resourceBundle.getString("user");

            String password = resourceBundle.getString("password");

            String url = resourceBundle.getString("url");

            conn = DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException | SQLException e) {
            LOGGER.error("Can not connect to database: {}", e.getMessage());

            return null;
        }

        return conn;
    }

    private void setParameter(PreparedStatement preparedStatement, Object... parameters) throws SQLException {
        for (int i = 0; i < parameters.length; i++) {
            Object parameter = parameters[i];
            int index = i + 1;

            if (parameter instanceof Long) {
                preparedStatement.setLong(index, (long) parameter);
            } else if (parameter instanceof String) {
                preparedStatement.setString(index, (String) parameter);
            } else if (parameter instanceof Integer) {
                preparedStatement.setInt(index, (Integer) parameter);
            } else if (parameter instanceof LocalDateTime) {
                preparedStatement.setTimestamp(index, Timestamp.valueOf((LocalDateTime) parameter));
            }
        }
    }

    @Override
    public <T> List<T> query(String sql, IMapper<T> mapper, Object... parameters) {
        List<T> result = new ArrayList<T>();
        Connection conn = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = conn.prepareStatement(sql);
            setParameter(preparedStatement, parameters);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result.add(mapper.mapRow(resultSet));
            }

        } catch (SQLException e) {
            LOGGER.error("Fail to query: {}", e.getMessage());
            return null;

        } finally {
            try {
                if(resultSet != null) resultSet.close();

                if(preparedStatement != null) preparedStatement.close();

                if (conn != null ) conn.close();

            } catch (SQLException e) {
                LOGGER.error("Fail to close connection: {}", e.getMessage());
                return null;
            }
        }

        return result;
    }

    @Override
    public <T> T get(long id) {
        return null;
    }

    @Override
    public void update(String sql, Object... parameters) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            preparedStatement = conn.prepareStatement(sql);
            setParameter(preparedStatement, parameters);
            preparedStatement.executeUpdate();
            conn.commit();

        } catch (SQLException e) {
            LOGGER.error("Can not update: {}", e.getMessage());

            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    LOGGER.error("Fail to rollback update: {}", e1.getMessage());
                }
            }

        } finally {
            try {
                if(preparedStatement != null) preparedStatement.close();

                if (conn != null ) conn.close();

            } catch (SQLException ex) {
                LOGGER.error("Fail to close connection: {}", ex.getMessage());
            }
        }


    }

    @Override
    public Long create(String sql, Object... parameters) {
        Long id = null;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            setParameter(preparedStatement, parameters);
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                id = resultSet.getLong(1);
            }
            conn.commit();
            return id;

        } catch (SQLException e) {
            LOGGER.error("Fail to create entity: {}", e.getMessage());
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    LOGGER.error("Fail to rollback update: {}", e1.getMessage());
                }
            }
            return null;

        } finally {
            try {
                if(resultSet != null) resultSet.close();

                if(preparedStatement != null) preparedStatement.close();

                if (conn != null ) conn.close();
            } catch (SQLException e) {
                LOGGER.error("Fail to close connection: {}", e.getMessage());
            }
        }
    }

    @Override
    public int count(String sql, Object... parameters) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;

        try {
            conn = getConnection();
            preparedStatement = conn.prepareStatement(sql);
            setParameter(preparedStatement, parameters);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                count = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            LOGGER.error("Fail to execute query: {}", e.getMessage());
            return 0;

        } finally {
            try {
                if(resultSet != null) resultSet.close();

                if(preparedStatement != null) preparedStatement.close();

                if (conn != null ) conn.close();

            } catch (SQLException e) {
                LOGGER.error("Fail to close connection: {}", e.getMessage());
                return 0;
            }
        }

        return count;
    }
}
