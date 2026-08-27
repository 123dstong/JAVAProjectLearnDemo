package com.example.desktop.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

import java.io.IOException;

/**
 * 主界面控制器
 */
public class MainController {

    @FXML
    private StackPane contentArea;

    @FXML
    private Label statusLabel;

    /**
     * 显示首页
     */
    @FXML
    private void showHome() {
        loadView("/fxml/HomeView.fxml");
        statusLabel.setText("当前页面: 首页");
    }

    /**
     * 显示用户管理页面
     */
    @FXML
    private void showUserManagement() {
        loadView("/fxml/UserManagementView.fxml");
        statusLabel.setText("当前页面: 用户管理");
    }

    /**
     * 显示数据统计页面
     */
    @FXML
    private void showStatistics() {
        loadView("/fxml/StatisticsView.fxml");
        statusLabel.setText("当前页面: 数据统计");
    }

    /**
     * 显示系统设置页面
     */
    @FXML
    private void showSettings() {
        loadView("/fxml/SettingsView.fxml");
        statusLabel.setText("当前页面: 系统设置");
    }

    /**
     * 显示关于页面
     */
    @FXML
    private void showAbout() {
        loadView("/fxml/AboutView.fxml");
        statusLabel.setText("当前页面: 关于");
    }

    /**
     * 加载FXML视图
     */
    private void loadView(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            contentArea.getChildren().clear();
            contentArea.getChildren().add(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
            statusLabel.setText("加载页面失败: " + e.getMessage());
        }
    }

    /**
     * 初始化方法
     */
    @FXML
    public void initialize() {
        // 默认显示首页
        showHome();
    }
}