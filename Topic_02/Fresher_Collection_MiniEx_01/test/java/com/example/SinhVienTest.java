package com.example;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SinhVienTest {

    @Test
    void themDiem() {
    }

    @Test
    void tinhDiemTrungBinh() {
    }

    @Test
    void bangDiem() {
        MonHoc monHoc = new MonHoc();
        monHoc.setTen("CTDLGT");
        monHoc.setTcLT(3);
        monHoc.setTcTH(4);

        MonHoc monHoc2 = new MonHoc();
        monHoc.setTen("CTDLGT 2");
        monHoc.setTcLT(3);
        monHoc.setTcTH(4);

        Diem diem = new Diem.Builder().mon(monHoc)
                .diem(8)
                .build();

        Set<Diem> monDaHoc = new HashSet<Diem>();
        monDaHoc.add(diem);

        SinhVien sv = new SinhVien.Builder().mssv("123123")
                .ten("Le Thai Anh")
                .monDaHoc(monDaHoc)
                .build();

        System.out.println(sv.bangDiem());
    }

    @Test
    void xepLoai() {

    }
}