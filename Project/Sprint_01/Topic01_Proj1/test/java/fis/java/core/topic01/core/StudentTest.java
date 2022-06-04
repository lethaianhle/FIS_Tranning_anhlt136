package fis.java.core.topic01.core;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    @Test
    void getCode() {
        Student student = new Student(1, "Nguyen Thanh Phuoc", new Date());

        assertEquals(1, student.getCode());
    }
}