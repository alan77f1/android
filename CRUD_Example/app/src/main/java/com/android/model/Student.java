package com.android.model;

public class Student {


    private String studentId,studentName, studentClass, studentPoint;

    public Student(String studentId, String studentName, String studentClass, String studentPoint) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentClass = studentClass;
        this.studentPoint = studentPoint;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getStudentPoint() {
        return studentPoint;
    }

    public void setStudentPoint(String studentPoint) {
        this.studentPoint = studentPoint;
    }
}
