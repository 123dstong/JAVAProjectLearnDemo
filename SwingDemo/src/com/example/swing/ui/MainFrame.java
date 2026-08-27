package com.example.swing.ui;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

/**
 * 主窗口类
 * 类似于 .NET WinForms 的 Form
 */
public class MainFrame extends JFrame {

    private JPanel contentPanel;
    private JLabel statusLabel;
    private JButton currentButton;

    // 颜色常量
    private static final Color PRIMARY_COLOR = new Color(46, 125, 50);
    private static final Color SECONDARY_COLOR = new Color(76, 175, 80);
    private static final Color BG_COLOR = new Color(232, 245, 233);
    private static final Color CARD_COLOR = Color.WHITE;

    /**
     * 构造方法 - 初始化主窗口
     */
    public MainFrame() {
        initFrame();
        initMenuBar();
        initStatusBar();
        initLayout();
    }

    /**
     * 初始化窗口属性
     */
    private void initFrame() {
        setTitle("Java Swing 桌面应用示例 - 类似 WinForms");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(800, 600));
        getContentPane().setBackground(BG_COLOR);
    }

    /**
     * 初始化菜单栏
     */
    private void initMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        // 文件菜单
        JMenu fileMenu = new JMenu("文件(F)");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        
        JMenuItem newItem = new JMenuItem("新建(N)");
        newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
        newItem.addActionListener(e -> showInfo("新建", "创建新文件"));
        
        JMenuItem openItem = new JMenuItem("打开(O)");
        openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
        openItem.addActionListener(e -> showInfo("打开", "打开文件"));
        
        JMenuItem saveItem = new JMenuItem("保存(S)");
        saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        saveItem.addActionListener(e -> showInfo("保存", "保存文件"));
        
        JMenuItem exitItem = new JMenuItem("退出(X)");
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_DOWN_MASK));
        exitItem.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(this, 
                "确定要退出吗?", "确认退出", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
        
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        // 编辑菜单
        JMenu editMenu = new JMenu("编辑(E)");
        editMenu.setMnemonic(KeyEvent.VK_E);
        
        JMenuItem copyItem = new JMenuItem("复制(C)");
        copyItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
        
        JMenuItem pasteItem = new JMenuItem("粘贴(V)");
        pasteItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK));
        
        editMenu.add(copyItem);
        editMenu.add(pasteItem);

        // 帮助菜单
        JMenu helpMenu = new JMenu("帮助(H)");
        helpMenu.setMnemonic(KeyEvent.VK_H);
        
        JMenuItem aboutItem = new JMenuItem("关于(A)");
        aboutItem.addActionListener(e -> showAboutDialog());
        
        helpMenu.add(aboutItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        setJMenuBar(menuBar);
    }

    /**
     * 初始化布局
     */
    private void initLayout() {
        setLayout(new BorderLayout());

        // 左侧导航面板
        JPanel navPanel = createNavPanel();
        add(navPanel, BorderLayout.WEST);

        // 中间内容面板
        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBackground(BG_COLOR);
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        add(contentPanel, BorderLayout.CENTER);

        // 默认显示首页
        showHomePanel();
    }

    /**
     * 创建导航面板
     */
    private JPanel createNavPanel() {
        JPanel navPanel = new JPanel();
        navPanel.setLayout(new BoxLayout(navPanel, BoxLayout.Y_AXIS));
        navPanel.setBackground(PRIMARY_COLOR);
        navPanel.setPreferredSize(new Dimension(200, 0));
        navPanel.setBorder(new EmptyBorder(20, 15, 20, 15));

        // 标题
        JLabel titleLabel = new JLabel("Swing 应用");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 18));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setBorder(new EmptyBorder(0, 0, 20, 0));
        navPanel.add(titleLabel);

        // 分隔线
        JSeparator separator = new JSeparator();
        separator.setMaximumSize(new Dimension(170, 1));
        separator.setForeground(new Color(255, 255, 255, 100));
        navPanel.add(separator);
        navPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // 导航按钮
        JButton homeBtn = createNavButton("首页", e -> showHomePanel());
        JButton userBtn = createNavButton("用户管理", e -> showUserPanel());
        JButton dataBtn = createNavButton("数据统计", e -> showDataPanel());
        JButton settingBtn = createNavButton("系统设置", e -> showSettingPanel());
        JButton aboutBtn = createNavButton("关于", e -> showAboutDialog());

        navPanel.add(homeBtn);
        navPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        navPanel.add(userBtn);
        navPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        navPanel.add(dataBtn);
        navPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        navPanel.add(settingBtn);
        navPanel.add(Box.createRigidArea(new Dimension(0, 5)));

        // 弹性空间
        navPanel.add(Box.createVerticalGlue());

        navPanel.add(aboutBtn);

        return navPanel;
    }

    /**
     * 创建导航按钮
     */
    private JButton createNavButton(String text, ActionListener listener) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                if (getModel().isPressed()) {
                    g2.setColor(new Color(25, 118, 210));
                } else if (getModel().isRollover()) {
                    g2.setColor(new Color(25, 118, 210));
                } else {
                    g2.setColor(new Color(33, 150, 243));
                }
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 5, 5);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(170, 40));
        button.setPreferredSize(new Dimension(170, 40));
        button.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
        button.setForeground(Color.WHITE);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        button.addActionListener(listener);
        return button;
    }

    /**
     * 初始化状态栏
     */
    private void initStatusBar() {
        JPanel statusPanel = new JPanel(new BorderLayout());
        statusPanel.setBackground(new Color(200, 230, 201));
        statusPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(165, 214, 167)),
            new EmptyBorder(5, 15, 5, 15)
        ));
        
        statusLabel = new JLabel("就绪");
        statusLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        statusLabel.setForeground(new Color(51, 51, 51));
        statusPanel.add(statusLabel, BorderLayout.WEST);
        
        JLabel versionLabel = new JLabel("Swing | JDK 1.8");
        versionLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        versionLabel.setForeground(new Color(51, 51, 51));
        statusPanel.add(versionLabel, BorderLayout.EAST);
        
        add(statusPanel, BorderLayout.SOUTH);
    }

    /**
     * 显示首页面板
     */
    private void showHomePanel() {
        contentPanel.removeAll();
        
        JPanel homePanel = new JPanel();
        homePanel.setLayout(new BoxLayout(homePanel, BoxLayout.Y_AXIS));
        homePanel.setOpaque(false);

        // 标题
        JLabel titleLabel = new JLabel("欢迎使用 Java Swing 桌面应用");
        titleLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 24));
        titleLabel.setForeground(new Color(27, 94, 32));
        titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        homePanel.add(titleLabel);
        homePanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // 卡片面板
        JPanel cardsPanel = new JPanel(new GridLayout(1, 3, 20, 0));
        cardsPanel.setOpaque(false);
        cardsPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        cardsPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 200));

        cardsPanel.add(createCard("用户管理", "管理用户信息，支持增删改查"));
        cardsPanel.add(createCard("数据统计", "查看数据统计图表和报表"));
        cardsPanel.add(createCard("系统设置", "配置应用程序参数"));

        homePanel.add(cardsPanel);
        homePanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // 系统信息面板
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBackground(CARD_COLOR);
        infoPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(165, 214, 167)),
            new EmptyBorder(15, 15, 15, 15)
        ));
        infoPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel infoTitle = new JLabel("系统信息");
        infoTitle.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
        infoTitle.setForeground(new Color(27, 94, 32));
        infoPanel.add(infoTitle);
        infoPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        infoPanel.add(new JLabel("应用版本: 1.0.0"));
        infoPanel.add(new JLabel("Java版本: 1.8.0_333"));
        infoPanel.add(new JLabel("框架: Java Swing"));
        infoPanel.add(new JLabel("运行模式: 桌面应用程序"));

        homePanel.add(infoPanel);

        contentPanel.add(new JScrollPane(homePanel), BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
        statusLabel.setText("当前页面: 首页");
    }

    /**
     * 创建卡片
     */
    private JPanel createCard(String title, String description) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(CARD_COLOR);
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(165, 214, 167)),
            new EmptyBorder(20, 20, 20, 20)
        ));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
        titleLabel.setForeground(new Color(46, 125, 50));
        card.add(titleLabel);
        card.add(Box.createRigidArea(new Dimension(0, 10)));

        JLabel descLabel = new JLabel("<html>" + description + "</html>");
        descLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        descLabel.setForeground(new Color(102, 102, 102));
        card.add(descLabel);

        return card;
    }

    /**
     * 显示用户管理面板
     */
    private void showUserPanel() {
        contentPanel.removeAll();
        
        UserPanel userPanel = new UserPanel();
        contentPanel.add(userPanel, BorderLayout.CENTER);
        
        contentPanel.revalidate();
        contentPanel.repaint();
        statusLabel.setText("当前页面: 用户管理");
    }

    /**
     * 显示数据统计面板
     */
    private void showDataPanel() {
        contentPanel.removeAll();
        
        JPanel dataPanel = new JPanel();
        dataPanel.setLayout(new BoxLayout(dataPanel, BoxLayout.Y_AXIS));
        dataPanel.setOpaque(false);

        // 标题
        JLabel titleLabel = new JLabel("数据统计");
        titleLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 24));
        titleLabel.setForeground(new Color(27, 94, 32));
        titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        dataPanel.add(titleLabel);
        dataPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // 统计卡片
        JPanel statsPanel = new JPanel(new GridLayout(1, 4, 15, 0));
        statsPanel.setOpaque(false);
        statsPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        statsPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));

        statsPanel.add(createStatCard("总用户数", "1,234", "+12%"));
        statsPanel.add(createStatCard("活跃用户", "856", "+5%"));
        statsPanel.add(createStatCard("今日访问", "3,456", "-3%"));
        statsPanel.add(createStatCard("运行时间", "45天", "正常"));

        dataPanel.add(statsPanel);

        contentPanel.add(new JScrollPane(dataPanel), BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
        statusLabel.setText("当前页面: 数据统计");
    }

    /**
     * 创建统计卡片
     */
    private JPanel createStatCard(String label, String value, String change) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(CARD_COLOR);
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(165, 214, 167)),
            new EmptyBorder(20, 20, 20, 20)
        ));

        JLabel labelComp = new JLabel(label);
        labelComp.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
        labelComp.setForeground(new Color(117, 117, 117));
        card.add(labelComp);
        card.add(Box.createRigidArea(new Dimension(0, 10)));

        JLabel valueComp = new JLabel(value);
        valueComp.setFont(new Font("Microsoft YaHei", Font.BOLD, 28));
        valueComp.setForeground(new Color(27, 94, 32));
        card.add(valueComp);
        card.add(Box.createRigidArea(new Dimension(0, 5)));

        JLabel changeComp = new JLabel(change);
        changeComp.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        changeComp.setForeground(change.startsWith("+") ? new Color(76, 175, 80) : new Color(244, 67, 54));
        card.add(changeComp);

        return card;
    }

    /**
     * 显示系统设置面板
     */
    private void showSettingPanel() {
        contentPanel.removeAll();
        
        JPanel settingPanel = new JPanel();
        settingPanel.setLayout(new BoxLayout(settingPanel, BoxLayout.Y_AXIS));
        settingPanel.setOpaque(false);

        // 标题
        JLabel titleLabel = new JLabel("系统设置");
        titleLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 24));
        titleLabel.setForeground(new Color(27, 94, 32));
        titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        settingPanel.add(titleLabel);
        settingPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // 设置表单
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(CARD_COLOR);
        formPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(165, 214, 167)),
            new EmptyBorder(20, 20, 20, 20)
        ));
        formPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        // 应用名称
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(new JLabel("应用名称:"), gbc);
        gbc.gridx = 1;
        formPanel.add(new JTextField("Java Swing 桌面应用示例", 30), gbc);

        // 主题选择
        gbc.gridx = 0; gbc.gridy = 1;
        formPanel.add(new JLabel("主题:"), gbc);
        gbc.gridx = 1;
        String[] themes = {"默认主题", "深色主题", "浅色主题"};
        formPanel.add(new JComboBox<>(themes), gbc);

        // 字体大小
        gbc.gridx = 0; gbc.gridy = 2;
        formPanel.add(new JLabel("字体大小:"), gbc);
        gbc.gridx = 1;
        JSpinner fontSizeSpinner = new JSpinner(new SpinnerNumberModel(14, 12, 24, 1));
        formPanel.add(fontSizeSpinner, gbc);

        // 自动保存
        gbc.gridx = 0; gbc.gridy = 3;
        formPanel.add(new JLabel("自动保存:"), gbc);
        gbc.gridx = 1;
        formPanel.add(new JCheckBox("启用", true), gbc);

        // 按钮
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.EAST;
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        buttonPanel.setOpaque(false);
        
        JButton resetBtn = new JButton("恢复默认");
        resetBtn.addActionListener(e -> showInfo("提示", "已恢复默认设置"));
        
        JButton saveBtn = new JButton("保存设置");
        saveBtn.setBackground(new Color(76, 175, 80));
        saveBtn.setForeground(Color.WHITE);
        saveBtn.addActionListener(e -> showInfo("提示", "设置已保存"));
        
        buttonPanel.add(resetBtn);
        buttonPanel.add(saveBtn);
        formPanel.add(buttonPanel, gbc);

        settingPanel.add(formPanel);

        contentPanel.add(new JScrollPane(settingPanel), BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
        statusLabel.setText("当前页面: 系统设置");
    }

    /**
     * 显示关于对话框
     */
    private void showAboutDialog() {
        String message = "Java Swing 桌面应用示例\n\n" +
            "版本: 1.0.0\n" +
            "Java版本: 1.8.0_333\n" +
            "框架: Java Swing\n\n" +
            "这是一个用于学习Java Swing开发的示例项目。\n" +
            "类似于 .NET WinForms 的桌面应用程序。";

        JOptionPane.showMessageDialog(this, 
            message, 
            "关于", 
            JOptionPane.INFORMATION_MESSAGE);
        statusLabel.setText("当前页面: 关于");
    }

    /**
     * 显示信息对话框
     */
    private void showInfo(String title, String message) {
        JOptionPane.showMessageDialog(this, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
}