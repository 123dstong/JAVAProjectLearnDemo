package com.example.desktop.controller;

import com.example.desktop.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * 用户管理控制器
 */
public class UserController {

    @FXML
    private TableView<User> userTable;

    @FXML
    private TableColumn<User, Integer> idColumn;

    @FXML
    private TableColumn<User, String> nameColumn;

    @FXML
    private TableColumn<User, String> emailColumn;

    @FXML
    private TableColumn<User, String> phoneColumn;

    @FXML
    private TableColumn<User, Integer> ageColumn;

    @FXML
    private TextField searchField;

    @FXML
    private Label recordCount;

    private ObservableList<User> userList = FXCollections.observableArrayList();
    private ObservableList<User> filteredList = FXCollections.observableArrayList();

    /**
     * 初始化方法
     */
    @FXML
    public void initialize() {
        // 初始化示例数据
        initData();

        // 设置表格列
        setupTableColumns();

        // 绑定数据
        userTable.setItems(filteredList);
        updateRecordCount();
    }

    /**
     * 初始化示例数据
     */
    private void initData() {
        userList.add(new User(1, "张三", "zhangsan@example.com", "13800138001", 25));
        userList.add(new User(2, "李四", "lisi@example.com", "13800138002", 30));
        userList.add(new User(3, "王五", "wangwu@example.com", "13800138003", 28));
        userList.add(new User(4, "赵六", "zhaoliu@example.com", "13800138004", 35));
        userList.add(new User(5, "钱七", "qianqi@example.com", "13800138005", 22));

        filteredList.addAll(userList);
    }

    /**
     * 设置表格列
     */
    private void setupTableColumns() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
    }

    /**
     * 添加用户
     */
    @FXML
    private void addUser() {
        // 创建输入对话框
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("添加用户");
        dialog.setHeaderText("请输入新用户名称");
        dialog.setContentText("用户名:");

        dialog.showAndWait().ifPresent(name -> {
            if (!name.trim().isEmpty()) {
                int newId = userList.size() + 1;
                User newUser = new User(newId, name, name + "@example.com", "1380013800" + newId, 25);
                userList.add(newUser);
                refreshUsers();
                showInfo("成功", "用户 " + name + " 已添加");
            }
        });
    }

    /**
     * 刷新用户列表
     */
    @FXML
    private void refreshUsers() {
        filteredList.clear();
        filteredList.addAll(userList);
        updateRecordCount();
    }

    /**
     * 搜索用户
     */
    @FXML
    private void searchUser() {
        String keyword = searchField.getText().trim().toLowerCase();
        if (keyword.isEmpty()) {
            refreshUsers();
            return;
        }

        filteredList.clear();
        for (User user : userList) {
            if (user.getName().toLowerCase().contains(keyword) ||
                user.getEmail().toLowerCase().contains(keyword)) {
                filteredList.add(user);
            }
        }
        updateRecordCount();
    }

    /**
     * 清空搜索
     */
    @FXML
    private void clearSearch() {
        searchField.clear();
        refreshUsers();
    }

    /**
     * 删除选中用户
     */
    @FXML
    private void deleteSelected() {
        User selected = userTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showWarning("提示", "请先选择要删除的用户");
            return;
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("确认删除");
        alert.setHeaderText("确定要删除该用户吗?");
        alert.setContentText("用户: " + selected.getName());

        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                userList.remove(selected);
                refreshUsers();
                showInfo("成功", "用户已删除");
            }
        });
    }

    /**
     * 更新记录数显示
     */
    private void updateRecordCount() {
        recordCount.setText("共 " + filteredList.size() + " 条记录");
    }

    /**
     * 显示信息对话框
     */
    private void showInfo(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    /**
     * 显示警告对话框
     */
    private void showWarning(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}