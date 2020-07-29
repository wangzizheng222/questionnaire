package daoimpl;

import dao.ManagerDao;
import entity.Manager;
import util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManagerDaoImpl implements ManagerDao {
    @Override
    public void add(Manager manager) throws SQLException {
        Connection conn=null;
        PreparedStatement ps=null;

        conn= DBUtils.getConnection();

        try {
            String sql="insert into manager(name, password) VALUES (?,?)";
            ps=conn.prepareStatement(sql);

            ps.setString(1,manager.getName());
            ps.setString(2,manager.getPassword());

            int res=ps.executeUpdate();
            if (res>0){
                System.out.println("successfully");
            }else {
                System.out.println("failed");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtils.close(null,ps,conn);
        }
    }

    @Override
    public void delete(String name) throws SQLException {
        Connection conn=null;
        PreparedStatement ps=null;

        conn= DBUtils.getConnection();

        try {
            String sql="delete from manager where name=?";
            ps=conn.prepareStatement(sql);

            ps.setString(1,name);

            int res=ps.executeUpdate();
            if (res>0){
                System.out.println("successfully");
            }else {
                System.out.println("failed");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtils.close(null,ps,conn);
        }
    }

    @Override
    public void update(Manager manager) throws SQLException {
        Connection conn=null;
        PreparedStatement ps=null;

        conn= DBUtils.getConnection();

        try {
            String sql="update manager set name=?,password=? where name=?";
            ps=conn.prepareStatement(sql);

            ps.setString(1,manager.getName());
            ps.setString(2,manager.getPassword());
            ps.setString(3,manager.getName());

            int res=ps.executeUpdate();
            if (res>0){
                System.out.println("successfully");
            }else {
                System.out.println("failed");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtils.close(null,ps,conn);
        }
    }

    @Override
    public List<Manager> findBy(String name) throws SQLException {
        Connection conn=null;
        PreparedStatement ps=null;
        Manager manager=null;
        ResultSet rs=null;
        List<Manager> list=new ArrayList<>();

        conn= DBUtils.getConnection();

        try {
            String sql="select name, password from manager where name=?";
            ps=conn.prepareStatement(sql);

            ps.setString(1,name);

            rs=ps.executeQuery();
            while (rs.next()){
                manager=new Manager();
                manager.setName(rs.getString(1));
                manager.setPassword(rs.getString(2));

                list.add(manager);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtils.close(rs,ps,conn);
        }
        return list;
    }

    @Override
    public List<Manager> findAll() throws SQLException {
        Connection conn=null;
        PreparedStatement ps=null;
        Manager manager=null;
        ResultSet rs=null;
        List<Manager> list=new ArrayList<>();

        conn= DBUtils.getConnection();

        try {
            String sql="select name, password from manager";
            ps=conn.prepareStatement(sql);

            rs=ps.executeQuery();
            while (rs.next()){
                manager=new Manager();
                manager.setName(rs.getString(1));
                manager.setPassword(rs.getString(2));

                list.add(manager);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtils.close(rs,ps,conn);
        }
        return list;
    }
}
