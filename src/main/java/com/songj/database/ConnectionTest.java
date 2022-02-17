package com.songj.database;

import cn.hutool.json.JSONUtil;
import com.songj.model.UserInfoDO;
import com.songj.util.JDBCUtils;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void Test(){
        System.out.println(JSONUtil.toJsonStr(getAll()));
    }

    public void connectionTest()  throws Exception {
        try {
            //1.注册驱动
            //静态代码块----》类加载了就会执行：java.sql.DriverManager.registerDriver(new Driver());
            //因此以下代码，相当于注册了两次
            //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Class.forName("com.mysql.jdbc.Driver");//修改
            //2.建立连接 参数一：协议+访问的数据库，参数二：用户名，参数三：密码
            conn= DriverManager.getConnection(databaseUrl, userName, password);
            if(conn != null){
                System.out.println("获取数据库链接 成功 ！");
            }
            //3.创建statement,跟数据库打交道，一定需要这个对象
            st = conn.createStatement();
            //4.执行查询，得到结果集
            String sql = "select * from t_news limit 10";
            rs=st.executeQuery(sql);
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

    public int save(UserInfoDO param) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into user_info values(?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, param.getId());
            ps.setString(2, param.getName());
            ps.setInt(3, param.getAge());
            ps.setString(4, param.getAdress());
            ps.setInt(5, param.getDeleted());
            ps.setString(6, param.getCode());
            int row = ps.executeUpdate();
            return row;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn, ps, null);
        }
        return 0;
    }
    //删除
    public int delete(int studentId) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "delete from user_info where id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, studentId);
            int row = ps.executeUpdate();
            return row;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn, ps, null);
        }
        return 0;
    }
    //更新
    public int update(int id, UserInfoDO param) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "update user_info set id=?,name=?,age=?,adress=?,deleted=?,code=? where id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, param.getId());
            ps.setString(2, param.getName());
            ps.setInt(3, param.getAge());
            ps.setString(4, param.getAdress());
            ps.setInt(5, param.getDeleted());
            ps.setString(6, param.getCode());
            ps.setInt(6, id);
            int row = ps.executeUpdate();
            return row;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn, ps, null);
        }
        return 0;
    }
    //查找一条数据
    public UserInfoDO getById(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from user_info where id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()) {
                UserInfoDO student = new UserInfoDO();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setAdress(rs.getString("adress"));
                student.setDeleted(rs.getInt("deleted"));
                student.setCode(rs.getString("code"));
                return student;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn, ps, rs);
        }
        return null;
    }
    //查找所有数据
    public List<UserInfoDO> getAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from user_info";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            List<UserInfoDO> userInfoList = new ArrayList<>();
            while(rs.next()) {
                UserInfoDO student = new UserInfoDO();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setAdress(rs.getString("adress"));
                student.setDeleted(rs.getInt("deleted"));
                student.setCode(rs.getString("code"));
                userInfoList.add(student);
            }
            return userInfoList;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn, ps, rs);
        }
        return null;
    }
}
