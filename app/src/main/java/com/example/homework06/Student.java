package com.example.homework06;

public class Student {
    String fname, lname, department,studentId;
    int imageVal;

    public Student(String fname, String lname, String department, String studentId, int imageVal) {
        this.fname = fname;
        this.lname = lname;
        this.department = department;
        this.studentId = studentId;
        this.imageVal = imageVal;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getImageVal() {
        return imageVal;
    }

    public void setImageVal(int imageVal) {
        this.imageVal = imageVal;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", department='" + department + '\'' +
                ", studentId='" + studentId + '\'' +
                ", imageVal=" + imageVal +
                '}';
    }
}
