package com.example.web;

import java.io.Serializable;

/**
 * 学生实体类 (JavaBean)
 */
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String studentNo;
    private String name;
    private String className;
    private double score;

    /**
     * 无参构造方法
     */
    public Student() {
    }

    /**
     * 全参构造方法
     */
    public Student(int id, String studentNo, String name, String className, double score) {
        this.id = id;
        this.studentNo = studentNo;
        this.name = name;
        this.className = className;
        this.score = score;
    }

    // Getter和Setter方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentNo='" + studentNo + '\'' +
                ", name='" + name + '\'' +
                ", className='" + className + '\'' +
                ", score=" + score +
                '}';
    }
}