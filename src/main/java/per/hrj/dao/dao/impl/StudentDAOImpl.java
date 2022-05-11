package per.hrj.dao.dao.impl;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import per.hrj.dao.bean.Student;
import per.hrj.dao.connection.DataBaseConnection;
import per.hrj.dao.dao.StudentDAO;

public class StudentDAOImpl implements StudentDAO {
    // ��Ӳ���
    public void insert(Student s) {
        String sql = "insert into student (id, name) values (?,?)";
        PreparedStatement pstmt = null;
        DataBaseConnection conn = null;
        //������ݿ�ľ������
        try {
            conn = new DataBaseConnection();
            pstmt = conn.getConnection().prepareStatement(sql);
            pstmt.setLong(1, s.getID());
            pstmt.setString(2, s.getName());
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
        }
    }

    public void update(Student s) {
        String sql = "update student set name = ? where id = ?";
        PreparedStatement pstmt = null;
        DataBaseConnection conn = null;
        //������ݿ�ľ������
        try {
            conn = new DataBaseConnection();

            pstmt = conn.getConnection().prepareStatement(sql);
            pstmt.setString(1, s.getName());
            pstmt.setLong(2, s.getID());

            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (Exception e) {

        }
    }

    public void delete(long iD) {
        String sql = "delete  from student where id = ?";
        PreparedStatement pstmt = null;
        DataBaseConnection conn = null;
        //������ݿ�ľ������
        try {
            conn = new DataBaseConnection();

            pstmt = conn.getConnection().prepareStatement(sql);
            pstmt.setLong(1, iD);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (Exception e) {

        }
    }

    public List<Student> findAll() {
        String sql = "select * from student";
        PreparedStatement pstmt = null;
        DataBaseConnection conn = null;
        //������ݿ�ľ������
        List<Student> list = new ArrayList<>();
        try {
            conn = new DataBaseConnection();
            pstmt = conn.getConnection().prepareStatement(sql);
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                long id = resultSet.getLong(1);
                student.setID(id);
                String name = resultSet.getString(2);
                student.setName(name);
                list.add(student);
            }
            pstmt.close();
            conn.close();
        } catch (Exception e) {
        }
        return list;
    }

    public Student findByID(long iD) {
        String sql = "select * from student where id = ?";
        PreparedStatement pstmt = null;
        DataBaseConnection conn = null;
        Student student = null;
        //������ݿ�ľ������
        try {
            student = new Student();
            conn = new DataBaseConnection();
            pstmt = conn.getConnection().prepareStatement(sql);
            pstmt.setLong(1, iD);
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {//�ù������ƶ���û�и���ͷ���false
                long id = resultSet.getLong(1);//�õ���һ��
                String name = resultSet.getString(2);//�õ��ڶ���
                student.setID(id);
                student.setName(name);
            }
            pstmt.close();
            conn.close();
        } catch (Exception e) {

        }
        return student;
    }

}
