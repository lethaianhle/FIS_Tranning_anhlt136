package com.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LopHocTest {

    @Test
    void them() {
    }

    @Test
    void inDiem() {
        LopHoc lopHoc = new LopHoc.Builder()
                .ten("10A11")
                .giaoVien("Le Thi Hang")
                .dsLop(new ArrayList<>())
                .build();
    }

    @Test
    void top10() {
        new LopHoc.Builder().build();
    }

    @Test
    void sinhVienYeu() {
    }

    @Test
    void main() {
    }
}