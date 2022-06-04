package com.example;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class LopHoc {
    private String ten;
    private String giaoVien;
    private List<SinhVien> dsLop = new ArrayList<SinhVien>();

    public static class Builder {
        private String ten;
        private String giaoVien;
        private List<SinhVien> dsLop = new ArrayList<>();

        public Builder ten(String ten) {
            this.ten = ten;
            return this;
        }

        public Builder giaoVien(String giaoVien) {
            this.giaoVien = giaoVien;
            return this;
        }

        public Builder dsLop(List<SinhVien> dsLop) {
            this.dsLop = dsLop;
            return this;
        }

        public LopHoc build() {
            LopHoc lopHoc = new LopHoc();
            lopHoc.ten = this.ten;
            lopHoc.giaoVien = this.giaoVien;
            lopHoc.dsLop = this.dsLop;
            return lopHoc;
        }
    }

    private LopHoc() {

    }

    private LopHoc(String ten, String giaoVien) {
        this.ten = ten;
        this.giaoVien = giaoVien;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGiaoVien() {
        return giaoVien;
    }

    public void setGiaoVien(String giaoVien) {
        this.giaoVien = giaoVien;
    }

    public List<SinhVien> getDsLop() {
        return dsLop;
    }

    public void setDsLop(List<SinhVien> dsLop) {
        this.dsLop = dsLop;
    }

    public boolean them(SinhVien svMoi) {
        return dsLop.add(svMoi);
    }

    //TODO Cau 4
    public String inDiem() {
    /*
    Danh Sach Diem Lop : ten
    Giao Vien Chu Nhiem : giaoVien
    STT      MSSV        Ten              Diem TB   XepLoai
    1        123456      Nguyen Van A     8.4       GIOI
    2        678919      Nguyen Van B     6         TB-KHA
    3        112456      Nguyen Van C     7         KHA
    */
        //...
        StringBuilder result = new StringBuilder("");
        AtomicInteger index = new AtomicInteger(1);
        result.append("Danh Sach Diem Lop: " + this.ten + "\n");
        result.append("Giao Vien Chu Nhiem: " + this.giaoVien + "\n");
        result.append("STT \t MSSV \t Ten \t Diem TB \t XepLoai \n");
        dsLop.forEach(sv -> result.append(index.getAndIncrement() + "\t"
                + sv.getMssv() + "\t"
                + sv.getTen() + "\t"
                + sv.tinhDiemTrungBinh() + "\t"
                + sv.xepLoai() + "\n"));

        return result.toString();
    }

    //TODO Cau 5
    public List<SinhVien> top10() {
        //Tra ve danh sach 10 sinh vien co diem trung binh lon nhat lop
        //...
        return (List<SinhVien>) dsLop.stream()
                .sorted((sv1, sv2) -> (int) (sv1.tinhDiemTrungBinh() - sv2.tinhDiemTrungBinh()))
                .limit(10);
    }

    //TODO Cau 6
    public List<SinhVien> sinhVienYeu() {
        //Tra ve danh sach vien vien xep loai YEU
        //...
        return (List<SinhVien>) dsLop.stream().filter(sv -> sv.xepLoai().equals("YEU"));
    }
}
