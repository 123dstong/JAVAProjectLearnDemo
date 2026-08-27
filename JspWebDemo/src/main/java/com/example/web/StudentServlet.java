package com.example.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 学生Servlet
 */
@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    private List<Student> studentList = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        // 初始化示例数据
        studentList.add(new Student(1, "S001", "张三", "计算机1班", 92));
        studentList.add(new Student(2, "S002", "李四", "计算机1班", 85));
        studentList.add(new Student(3, "S003", "王五", "计算机2班", 78));
        studentList.add(new Student(4, "S004", "赵六", "计算机2班", 95));
        studentList.add(new Student(5, "S005", "钱七", "计算机3班", 88));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "list":
            default:
                listStudents(request, response);
                break;
        }
    }

    /**
     * 显示学生列表
     */
    private void listStudents(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("studentList", studentList);
        request.getRequestDispatcher("/student/list.jsp").forward(request, response);
    }
}