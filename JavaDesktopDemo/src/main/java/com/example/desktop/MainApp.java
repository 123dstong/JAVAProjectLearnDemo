package com.example.desktop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX桌面应用主类
 */
public class MainApp extends Application {

    private static final String APP_TITLE = "JavaFX桌面应用示例";
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 700;

    @Override
    public void start(Stage primaryStage) {
        try {
            // 加载主界面FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainView.fxml"));
            Parent root = loader.load();

            // 创建场景
            Scene scene = new Scene(root, WIDTH, HEIGHT);

            // 加载CSS样式
            scene.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());

            // 设置窗口属性
            primaryStage.setTitle(APP_TITLE);
            primaryStage.setScene(scene);
            primaryStage.setMinWidth(800);
            primaryStage.setMinHeight(600);
            primaryStage.show();

            System.out.println("应用程序启动成功!");
            System.out.println("窗口大小: " + WIDTH + " x " + HEIGHT);

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("加载界面失败: " + e.getMessage());
        }
    }

    /**
     * 主方法入口
     */
    public static void main(String[] args) {
        launch(args);
    }
}