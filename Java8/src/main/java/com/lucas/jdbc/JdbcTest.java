package com.lucas.jdbc;

import org.junit.Test;

import java.sql.*;

/**
 * @author Lucas
 * @Description TODO
 * @date 2021-08-24 13:16
 */
public class JdbcTest {
    @Test
    public void jdbcTest() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:sqlserver://192.168.19.128:1433;DatabaseName=ShareSystemServer;useAffectedRows=true";
        String user = "sa";
        String pwd = "lscj1#";

        Connection conn = null;
        String sql = null;
        ResultSet rs = null;
        Statement st = null;
        PreparedStatement ps = null;
        try {
            conn = DriverManager.getConnection(url, user, pwd);
            //设置隔离级别
            conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            //设置事务
            conn.setAutoCommit(false);

            sql = "select Count(*) from BS_ProjectInfo";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
//            rs.afterLast();
//            rs.previous();
            rs.next();
            System.out.println("Count:"+ rs.getInt(1));


            sql = "select * from BS_ProjectInfo where ProjCreateTime like ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "2021%");
            rs = ps.executeQuery();
            while (rs.next()) {
                String projCreateTime = rs.getString("ProjCreateTime");
                System.out.println(projCreateTime);
            }

            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                rs = null;
            }

            if (ps != null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                ps = null;
            }

            if (st != null){
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                st = null;
            }

            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                conn = null;
            }
        }


    }
}
