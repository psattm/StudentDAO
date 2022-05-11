package per.hrj.dao;

import per.hrj.dao.bean.Student;
import per.hrj.dao.connection.DataBaseConnection;
import per.hrj.dao.dao.StudentDAO;
import per.hrj.dao.dao.impl.StudentDAOImpl;

import java.sql.Connection;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Connection connection = dataBaseConnection.getConnection();
        StudentDAO studentDAO = new StudentDAOImpl();
        List<Student> students = studentDAO.findAll();
        System.out.println("all " + students);
        Student student = studentDAO.findByID(1);
        System.out.println("id = 1 : " + student);
        Student updatedStudent = new Student(3, "abc");
        System.out.println("all " + studentDAO.findAll());
        Student insertedStudent = new Student(10 , "dqweqwe");
        studentDAO.insert(insertedStudent);
        System.out.println("all " + studentDAO.findAll());
        studentDAO.delete(10);
        System.out.println("all " + studentDAO.findAll());

    }
}
