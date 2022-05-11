package per.hrj.dao.dao;

import per.hrj.dao.bean.Student;

import java.util.*;


public interface StudentDAO {
    public void insert(Student s);

    public void update(Student s);

    public void delete(long iD);

    public Student findByID(long iD);

    public List<Student> findAll();
} 

