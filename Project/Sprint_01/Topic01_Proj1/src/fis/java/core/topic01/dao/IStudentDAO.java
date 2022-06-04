package fis.java.core.topic01.dao;

import fis.java.core.topic01.core.Student;

public interface IStudentDAO {
    void addStudent(Student student);

    Student remove(int code);

    void display();

    void sort();

    void setSortStrategy(ISortStrategy iSortStrategy);
}
