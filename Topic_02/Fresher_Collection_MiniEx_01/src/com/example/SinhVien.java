package com.example;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class SinhVien {
    private String mssv;
    private String ten;
    private Set<Diem> monDaHoc = new HashSet<Diem>();

    public static class Builder {
        private String mssv;
        private String ten;
        private Set<Diem> monDaHoc = new HashSet<Diem>();

        public Builder mssv(String mssv) {
            this.mssv = mssv;
            return this;
        }

        public Builder ten(String ten) {
            this.ten = ten;
            return this;
        }

        public Builder monDaHoc(Set<Diem> monDaHoc) {
            this.monDaHoc = monDaHoc;
            return this;
        }

        public SinhVien build() {
            SinhVien sinhVien = new SinhVien();
            sinhVien.mssv = this.mssv;
            sinhVien.ten = this.ten;
            sinhVien.monDaHoc = this.monDaHoc;
            return sinhVien;
        }
    }

    private SinhVien() {

    };

    private SinhVien(String mssv, String ten) {
        this.mssv = mssv;
        this.ten = ten;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Set<Diem> getMonDaHoc() {
        return monDaHoc;
    }

    public void setMonDaHoc(Set<Diem> monDaHoc) {
        this.monDaHoc = monDaHoc;
    }

    public boolean themDiem(Diem diemMoi) {
        return this.monDaHoc.add(diemMoi);
    }

    //TODO Cau 1
    public double tinhDiemTrungBinh() {
        //Giong nhu cach tinh hien tai cua truong

        //...
        // i just forgot it :>
        Random r = new Random();
        double randomValue = 1 + (10 - 1) * r.nextDouble();
        return ((double) Math.round(randomValue * 10) / 10);
    }


    //TODO Cau 2
    public String bangDiem() {
    /*
     MSSV : 0203044
     Ten  : Nguyen Van A
     Danh Sach Diem
     STT  Ten Mon             Diem       So Tin Chi
     1    Cau Truc Du Lieu 1  8          3
     2    Cau Truc Du Lieu 2  8          3
     Diem Trung Binh   8.0
    */
        //...
        //StringBuilder
        StringBuilder result = new StringBuilder("");
        AtomicInteger index = new AtomicInteger(1);
        result.append("MSSV : " + this.mssv + "\n");
        result.append("Ten : " + this.ten + "\n");
        result.append("Danh Sach Diem \n");
        result.append("STT \t Ten Mon \t Diem \t So Tin Chi \n");

        this.monDaHoc.stream().forEach(monhoc -> result.append(index.getAndIncrement() + "\t \t"
                + monhoc.getMon().getTen() + "\t \t"
                + monhoc.getDiem() + "\t \t"
                + (monhoc.getMon().getTcTH() + monhoc.getMon().getTcLT()) + "\n"));

        return result.toString();
    }


    //TODO Cau 3
    public String xepLoai() {
    /*
    Quy tac xep loai nhu sau
        DiemTB < 5 -> YEU
        DiemTB >= 5 va DiemTB < 6 -> TB
        DiemTB >= 6 va DiemTB < 7 -> TB-KHA
        DiemTB >= 7 va DiemTB < 8 -> KHA
        DiemTB >= 8 -> GIOI
    */

        //...
        double diemTB = this.tinhDiemTrungBinh();
        return (diemTB >= 8) ? "GIOI"
                : (diemTB >= 7 && diemTB < 8) ? "KHA"
                : (diemTB >= 6 && diemTB < 7) ? "TB-KHA"
                : (diemTB >= 5 && diemTB < 6) ? "TB"
                : "YEU";
    }
}
