package com.example.admin.baithuchanhso3;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;

public class Student extends AppCompatButton {
    private String hoten;
    private int tuoi;
    private boolean gioitinh;
    public Student(Context context, String hoten, int tuoi, boolean gioitinh) {
        super(context);
        this.hoten = hoten;
        this.tuoi = tuoi;
        this.gioitinh = gioitinh;
    }

    @Override
    public String toString(){
        return "Họ và Tên : " + getHoten() + " , Tuổi : " + getTuoi() +" , Giới Tính: " + ((isGioitinh())? "NAM" : "NỮ");
    }

    public String getHoten() {
        return hoten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public boolean isGioitinh() {
        return gioitinh;
    }
}
