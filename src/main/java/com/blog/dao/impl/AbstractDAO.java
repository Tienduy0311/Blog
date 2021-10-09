package com.blog.dao.impl;

import com.blog.dao.GenericDAO;
import com.blog.mapper.RowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AbstractDAO<T> implements GenericDAO<T> {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet resultSet = null;

    private ResourceBundle bundle = ResourceBundle.getBundle("db");

    private Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        try {
            Class.forName(bundle.getString("className"));
            String url = bundle.getString("url");
            String username = bundle.getString("userName");
            String password = bundle.getString("password");
            try {
                conn = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                throw ex;
            }
        } catch (ClassNotFoundException e) {
            throw e;
        }
        return conn;
    }

    @Override
    public <T> List<T> query(String sql, RowMapper<T> mapper, Object... parameter) throws SQLException, ClassNotFoundException {
        List<T> tList = new ArrayList<>();
        try {
            this.conn = getConnection();
            this.ps = this.conn.prepareStatement(sql);
            setParameter(this.ps, parameter);
            this.resultSet = this.ps.executeQuery();
            while (this.resultSet.next()) {
                tList.add(mapper.mapRow(this.resultSet));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw ex;
        } finally {
            close();
        }
        return tList;
    }

    @Override
    public <T> List<T> query(String sql, RowMapper<T> mapper, List<Object> parameter) throws SQLException, ClassNotFoundException {
        List<T> tList = new ArrayList<>();
        try {
            this.conn = getConnection();
            this.ps = this.conn.prepareStatement(sql);
            setParameter(this.ps, parameter);
            this.resultSet = this.ps.executeQuery();
            while (this.resultSet.next()) {
                tList.add(mapper.mapRow(this.resultSet));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.getMessage();
        } finally {
            close();
        }
        return tList;
    }

    @Override
    public Long insert(String sql, Object... parameter) throws SQLException, ClassNotFoundException {
        Long rs = null;
        try {
            this.conn = getConnection();
            this.conn.setAutoCommit(false);
            this.ps = this.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            setParameter(this.ps, parameter);
            this.ps.executeUpdate();
            this.resultSet = this.ps.getGeneratedKeys();
            if (this.resultSet.next()) {
                rs = this.resultSet.getLong(1);
            }
            this.conn.commit();
        } catch (SQLException | ClassNotFoundException e) {
            this.conn.rollback();
            throw e;
        } finally {
            close();
        }
        return rs;
    }

    @Override
    public <T> T fillById(String sql, RowMapper<T> mapper, Long id, T model) throws SQLException, ClassNotFoundException {
        try {
            this.conn = getConnection();
            this.ps = this.conn.prepareStatement(sql);
            this.ps.setLong(1, id);
            this.resultSet = this.ps.executeQuery();
            if (this.resultSet.next()) {
                model = mapper.mapRow(this.resultSet);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw e;
        } finally {
            close();
        }
        return model;
    }

    @Override
    public <T> T fillBy(String sql, RowMapper<T> mapper, T model, Object... parameter) throws SQLException, ClassNotFoundException {
        try {
            this.conn = getConnection();
            this.ps = this.conn.prepareStatement(sql);
            setParameter(this.ps, parameter);
            this.resultSet = this.ps.executeQuery();
            if (this.resultSet.next()) {
                model = mapper.mapRow(this.resultSet);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw e;
        } finally {
            close();
        }
        return model;
    }

    @Override
    public void update(String sql, Object... parameter) throws SQLException, ClassNotFoundException {
        try {
            this.conn = getConnection();
            this.conn.setAutoCommit(false);
            this.ps = this.conn.prepareStatement(sql);
            setParameter(this.ps, parameter);
            this.ps.executeUpdate();
            this.conn.commit();
        } catch (SQLException | ClassNotFoundException e) {
            this.conn.rollback();
            throw e;
        } finally {
            close();
        }
    }

    @Override
    public Integer count(String sql) throws SQLException {
        int rs = 0;
        try {
            this.conn = getConnection();
            this.ps = conn.prepareStatement(sql);
            this.resultSet = this.ps.executeQuery();
            if (this.resultSet.next()) {
                rs = this.resultSet.getInt(1);
            }
            return rs;
        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
        } finally {
            close();
        }
        return 0;
    }

    private void setParameter(PreparedStatement ps, Object... parameter) {
        try {
            for (int i = 0; i < parameter.length; i++) {
                if (parameter[i] instanceof Long) {
                    ps.setLong(i + 1, (Long) parameter[i]);
                } else if (parameter[i] instanceof String) {
                    ps.setString(i + 1, (String) parameter[i]);
                } else if (parameter[i] instanceof Timestamp) {
                    ps.setTimestamp(i + 1, (Timestamp) parameter[i]);
                } else if (parameter[i] instanceof Integer) {
                    ps.setInt(i + 1, (Integer) parameter[i]);
                }
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
    }

    private void setParameter(PreparedStatement ps, List<Object> parameter) {
        try {
            if (parameter.isEmpty()) {
                return;
            }
            for (int i = 0; i < parameter.size(); i++) {
                Object param = parameter.get(i);
                if (param instanceof Long) {
                    ps.setLong(i + 1, (Long) param);
                } else if (param instanceof String) {
                    ps.setString(i + 1, (String) param);
                } else if (param instanceof Timestamp) {
                    ps.setTimestamp(i + 1, (Timestamp) param);
                } else if (param instanceof Integer) {
                    ps.setInt(i + 1, (Integer) param);
                }
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
    }

    private void close() throws SQLException {
        try {
            if (this.resultSet != null) {
                this.resultSet.close();
                this.resultSet = null;
            }
            if (this.ps != null) {
                this.ps.close();
                this.ps = null;
            }
            if (this.conn != null) {
                this.conn.close();
                this.conn = null;
            }
        } catch (SQLException e) {
            throw e;
        }
    }
}
