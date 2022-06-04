package fis.java.core.topic01.dao.mem;

import fis.java.core.topic01.core.Student;
import fis.java.core.topic01.dao.ISortStrategy;
import fis.java.core.topic01.dao.IStudentDAO;
import fis.java.core.topic01.dao.SelectionSortStrategy;

public class StudentDAOMem implements IStudentDAO {
    public final int MAX = 100;
    private Student[] students;
    private int count;
    private ISortStrategy sortStrategy;

    public StudentDAOMem(){
        this.count = 0;
        this.students = new Student[MAX];
        this.sortStrategy = new SelectionSortStrategy();
    }

    @Override
    public void addStudent(Student student){
        //TODO
    }

    @Override
    public Student remove(int code){
        //TODO
        return null;
    }

    @Override
    public void display(){
        //TODO
    }

    @Override
    public void sort(){
        //TODO
    }

    @Override
    public void setSortStrategy(ISortStrategy iSortStrategy){
        this.sortStrategy = sortStrategy;
    }
}
