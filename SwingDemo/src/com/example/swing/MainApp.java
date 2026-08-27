package com.example.swing;

import com.example.swing.ui.MainFrame;
import javax.swing.*;

/**
 * Java Swing 桌面应用主类
 * 类似于 .NET WinForms 的应用程序入口
 */
public class MainApp {

    /**
     * 主方法入口
     */
    public static void main(String[] args) {
        // 设置外观为系统原生外观
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 在事件调度线程中启动应用
        SwingUtilities.invokeLater(() -> {
            try {
                // 创建并显示主窗口
                MainFrame mainFrame = new MainFrame();
                mainFrame.setVisible(true);
                System.out.println("Swing 应用程序启动成功!");
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, 
                    "启动失败: " + e.getMessage(), 
                    "错误", 
                    JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}