package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiemTest {
    @Test
    void testBuilder() {
        MonHoc monHoc = new MonHoc();

        Diem diem = new Diem.Builder().mon(monHoc)
                .diem(1)
                .build();

        System.out.println(diem);
    }
}