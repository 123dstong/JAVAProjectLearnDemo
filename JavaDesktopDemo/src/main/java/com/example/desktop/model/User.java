package com.example.desktop.model;

import javafx.scene.control.Button;

/**
 * 用户模型类
 */
public class User {

    private int id;
    private String name;
    private String email;
    private String phone;
    private int age;

    public User() {
    }

    public User(int id, String name, String email, String phone, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.age = age;
    }

    // Getter和Setter方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 获取操作按钮（用于表格显示）
     */
    public Button getActions() {
        Button editBtn = new Button("编辑");
        editBtn.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-cursor: hand;");
        editBtn.setOnAction(e -> {
            System.out.println("编辑用户: " + name);
        });
        return editBtn;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                '}';
    }
}