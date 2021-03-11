package com.songj.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 * @ClassName: JDBCUtils
 * @BelongPackage: com.songj.util
 * @Description:
 * @Author: Jisai
 * @Date: 2021/3/10 下午3:09
 * @Version: v1.0
 */
public class JDBCUtils {

    private static String driverName = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://182.92.240.221:3306/test";
    private static String user = "root";
    private static String password = "root";
    /**
     * 链接数据库
     */
    static {
        try {
            Class.forName(JDBCUtils.driverName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取链接对象connection
     * @return
     */
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(JDBCUtils.url, JDBCUtils.user, JDBCUtils.password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 关闭资源
     * @param conn
     * @param st
     * @param rs
     */
    public static void close(Connection conn,Statement st,ResultSet rs) {
        if(rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(st != null) {
            try {
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

