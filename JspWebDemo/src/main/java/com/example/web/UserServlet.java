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
 * 用户Servlet
 * 类似于 .NET Web Forms 的 CodeBehind
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {

    private List<User> userList = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        // 初始化示例数据
        userList.add(new User(1, "张三", "zhangsan@example.com", "13800138001", 25));
        userList.add(new User(2, "李四", "lisi@example.com", "13800138002", 30));
        userList.add(new User(3, "王五", "wangwu@example.com", "13800138003", 28));
        userList.add(new User(4, "赵六", "zhaoliu@example.com", "13800138004", 35));
        userList.add(new User(5, "钱七", "qianqi@example.com", "13800138005", 22));
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
            case "add":
                showAddForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteUser(request, response);
                break;
            case "search":
                searchUsers(request, response);
                break;
            default:
                listUsers(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "insert":
                insertUser(request, response);
                break;
            case "update":
                updateUser(request, response);
                break;
            default:
                listUsers(request, response);
                break;
        }
    }

    /**
     * 显示用户列表
     */
    private void listUsers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("/user/list.jsp").forward(request, response);
    }

    /**
     * 显示添加表单
     */
    private void showAddForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/user/form.jsp").forward(request, response);
    }

    /**
     * 显示编辑表单
     */
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = findUserById(id);
        if (user != null) {
            request.setAttribute("user", user);
        }
        request.getRequestDispatcher("/user/form.jsp").forward(request, response);
    }

    /**
     * 添加用户
     */
    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = userList.size() + 1;
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        int age = Integer.parseInt(request.getParameter("age"));

        userList.add(new User(id, name, email, phone, age));
        request.setAttribute("message", "用户添加成功！");
        listUsers(request, response);
    }

    /**
     * 更新用户
     */
    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        int age = Integer.parseInt(request.getParameter("age"));

        User user = findUserById(id);
        if (user != null) {
            user.setName(name);
            user.setEmail(email);
            user.setPhone(phone);
            user.setAge(age);
        }
        request.setAttribute("message", "用户更新成功！");
        listUsers(request, response);
    }

    /**
     * 删除用户
     */
    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        userList.removeIf(user -> user.getId() == id);
        request.setAttribute("message", "用户删除成功！");
        listUsers(request, response);
    }

    /**
     * 搜索用户
     */
    private void searchUsers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        List<User> searchResult = new ArrayList<>();
        for (User user : userList) {
            if (user.getName().contains(keyword) || user.getEmail().contains(keyword)) {
                searchResult.add(user);
            }
        }
        request.setAttribute("userList", searchResult);
        request.getRequestDispatcher("/user/list.jsp").forward(request, response);
    }

    /**
     * 根据ID查找用户
     */
    private User findUserById(int id) {
        for (User user : userList) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
}