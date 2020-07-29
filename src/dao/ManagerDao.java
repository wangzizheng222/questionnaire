package dao;

import entity.Manager;

import java.awt.event.MouseAdapter;
import java.sql.SQLException;
import java.util.List;

/**
 * manager表操作接口
 */
public interface ManagerDao {
    public void add(Manager manager) throws SQLException;
    public void delete(String name) throws SQLException;
    public void update(Manager manager) throws SQLException;
    public List<Manager> findBy(String name) throws SQLException;
    public List<Manager> findAll() throws SQLException;
}
