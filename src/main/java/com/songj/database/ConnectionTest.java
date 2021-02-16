package com.songj.database;

import java.sql.*;

/**
 * @ClassName: ConnectionTest
 * @BelongPackage: com.songj.database
 * @Description: 数据库链接测试
 * 参考：https://www.jb51.net/article/121373.htm；
 * @Author: Jisai
 * @Date: 2021/1/18 下午4:33
 * @Version: v1.0
 */
public class ConnectionTest {
    private static final String databaseUrl = "jdbc:mysql://182.92.240.221:3306/db1";
    private static final String userName = "root";
    private static final String password = "root";

    Connection conn=null;
    Statement st=null;
    ResultSet rs=null;

    public static void main(String[] args) {
        ConnectionTest ct = new ConnectionTest();
        try {
            ct.connectionTest();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void connectionTest()  throws Exception {
        try {
            //1.注册驱动
            //静态代码块----》类加载了就会执行：java.sql.DriverManager.registerDriver(new Driver());
            //因此以下代码，相当于注册了两次
            //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Class.forName("com.mysql.jdbc.Driver");//修改
            //2.建立连接 参数一：协议+访问的数据库，参数二：用户名，参数三：密码
            Connection conn= DriverManager.getConnection(databaseUrl, userName, password);
            if(conn != null){
                System.out.println("获取数据库链接 成功 ！");
            }
            //3.创建statement,跟数据库打交道，一定需要这个对象
            Statement st = conn.createStatement();
            //4.执行查询，得到结果集
            String sql = "select * from t_news limit 10";
            ResultSet rs=st.executeQuery(sql);
            //遍历每一条记录
            while(rs.next()) {
                String id=rs.getString("id");
                String address=rs.getString("address");

                System.out.println("id="+id+"==address="+address);
            }

        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
            rs.close();
            st.close();
            conn.close();
        }
    }

}
