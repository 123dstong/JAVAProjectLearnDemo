package com.example.swing.ui;

import com.example.swing.model.User;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户管理面板
 * 类似于 .NET WinForms 的 UserControl
 */
public class UserPanel extends JPanel {

    private JTable userTable;
    private DefaultTableModel tableModel;
    private JTextField searchField;
    private JLabel recordCountLabel;
    private List<User> userList;

    /**
     * 构造方法
     */
    public UserPanel() {
        userList = new ArrayList<>();
        initData();
        initUI();
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
    }

    /**
     * 初始化UI
     */
    private void initUI() {
        setLayout(new BorderLayout());
        setBackground(new Color(232, 245, 233));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // 标题栏
        JPanel headerPanel = createHeaderPanel();
        add(headerPanel, BorderLayout.NORTH);

        // 表格
        JScrollPane tableScrollPane = createTableScrollPane();
        add(tableScrollPane, BorderLayout.CENTER);

        // 底部面板
        JPanel bottomPanel = createBottomPanel();
        add(bottomPanel, BorderLayout.SOUTH);
    }

    /**
     * 创建标题栏面板
     */
    private JPanel createHeaderPanel() {
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setOpaque(false);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        // 标题
        JLabel titleLabel = new JLabel("用户管理");
        titleLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 24));
        titleLabel.setForeground(new Color(27, 94, 32));
        headerPanel.add(titleLabel, BorderLayout.WEST);

        // 按钮面板
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        buttonPanel.setOpaque(false);

        JButton addBtn = createStyledButton("添加用户", new Color(76, 175, 80));
        addBtn.addActionListener(e -> addUser());

        JButton refreshBtn = createStyledButton("刷新", new Color(33, 150, 243));
        refreshBtn.addActionListener(e -> refreshTable());

        JButton deleteBtn = createStyledButton("删除选中", new Color(244, 67, 54));
        deleteBtn.addActionListener(e -> deleteSelectedUser());

        buttonPanel.add(addBtn);
        buttonPanel.add(refreshBtn);
        buttonPanel.add(deleteBtn);

        headerPanel.add(buttonPanel, BorderLayout.EAST);

        return headerPanel;
    }

    /**
     * 创建样式按钮
     */
    private JButton createStyledButton(String text, Color bgColor) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                if (getModel().isPressed()) {
                    g2.setColor(bgColor.darker());
                } else if (getModel().isRollover()) {
                    g2.setColor(bgColor.brighter());
                } else {
                    g2.setColor(bgColor);
                }
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 5, 5);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        button.setForeground(Color.WHITE);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setPreferredSize(new Dimension(100, 35));
        return button;
    }

    /**
     * 创建表格滚动面板
     */
    private JScrollPane createTableScrollPane() {
        // 表格列名
        String[] columnNames = {"ID", "姓名", "邮箱", "电话", "年龄", "操作"};

        // 表格模型
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 5; // 只有操作列可编辑
            }
        };

        // 填充数据
        refreshTableModel();

        // 创建表格
        userTable = new JTable(tableModel);
        userTable.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
        userTable.setRowHeight(35);
        userTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        userTable.setGridColor(new Color(200, 230, 201));
        userTable.setBackground(Color.WHITE);
        userTable.setSelectionBackground(new Color(200, 230, 201));
        userTable.setSelectionForeground(new Color(27, 94, 32));

        // 设置表头样式
        JTableHeader header = userTable.getTableHeader();
        header.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
        header.setBackground(new Color(33, 150, 243));
        header.setForeground(Color.WHITE);
        header.setOpaque(true);
        header.setPreferredSize(new Dimension(0, 40));
        
        // 设置表头渲染器
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                label.setBackground(new Color(158, 158, 158));
                label.setForeground(Color.WHITE);
                label.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
                label.setOpaque(true);
                label.setHorizontalAlignment(SwingConstants.CENTER);
                return label;
            }
        });

        // 设置列宽
        userTable.getColumnModel().getColumn(0).setPreferredWidth(60);
        userTable.getColumnModel().getColumn(1).setPreferredWidth(100);
        userTable.getColumnModel().getColumn(2).setPreferredWidth(200);
        userTable.getColumnModel().getColumn(3).setPreferredWidth(130);
        userTable.getColumnModel().getColumn(4).setPreferredWidth(70);
        userTable.getColumnModel().getColumn(5).setPreferredWidth(100);

        // 设置操作列的按钮渲染器
        setupActionColumn();

        // 搜索面板
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        searchPanel.setOpaque(false);

        JLabel searchLabel = new JLabel("搜索:");
        searchLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
        searchPanel.add(searchLabel);

        searchField = new JTextField(20);
        searchField.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
        searchField.setPreferredSize(new Dimension(200, 30));
        searchPanel.add(searchField);

        JButton searchBtn = createStyledButton("搜索", new Color(33, 150, 243));
        searchBtn.addActionListener(e -> searchUser());
        searchPanel.add(searchBtn);

        JButton clearBtn = createStyledButton("清空", new Color(158, 158, 158));
        clearBtn.addActionListener(e -> {
            searchField.setText("");
            refreshTable();
        });
        searchPanel.add(clearBtn);

        // 包装表格和搜索面板
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setOpaque(false);
        tablePanel.add(searchPanel, BorderLayout.NORTH);
        tablePanel.add(new JScrollPane(userTable), BorderLayout.CENTER);

        return new JScrollPane(tablePanel);
    }

    /**
     * 设置操作列的按钮
     */
    private void setupActionColumn() {
        userTable.getColumnModel().getColumn(5).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                
                JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
                panel.setBackground(isSelected ? new Color(200, 230, 201) : Color.WHITE);
                
                JLabel editBtn = new JLabel("编辑");
                editBtn.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
                editBtn.setForeground(Color.WHITE);
                editBtn.setOpaque(true);
                editBtn.setBackground(new Color(33, 150, 243));
                editBtn.setHorizontalAlignment(SwingConstants.CENTER);
                editBtn.setPreferredSize(new Dimension(55, 25));
                
                panel.add(editBtn);
                return panel;
            }
        });
        
        // 添加点击事件
        userTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int row = userTable.rowAtPoint(e.getPoint());
                int col = userTable.columnAtPoint(e.getPoint());
                if (col == 5 && row >= 0) {
                    editUser(row);
                }
            }
        });
    }

    /**
     * 创建底部面板
     */
    private JPanel createBottomPanel() {
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setOpaque(false);
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        recordCountLabel = new JLabel("共 " + userList.size() + " 条记录");
        recordCountLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        recordCountLabel.setForeground(new Color(102, 102, 102));
        bottomPanel.add(recordCountLabel, BorderLayout.WEST);

        return bottomPanel;
    }

    /**
     * 刷新表格数据
     */
    private void refreshTableModel() {
        tableModel.setRowCount(0);
        for (User user : userList) {
            Object[] row = {user.getId(), user.getName(), user.getEmail(), 
                           user.getPhone(), user.getAge(), ""};
            tableModel.addRow(row);
        }
        if (recordCountLabel != null) {
            recordCountLabel.setText("共 " + userList.size() + " 条记录");
        }
    }

    /**
     * 刷新表格
     */
    private void refreshTable() {
        refreshTableModel();
        JOptionPane.showMessageDialog(this, "已刷新", "提示", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * 添加用户
     */
    private void addUser() {
        // 创建输入对话框
        String name = JOptionPane.showInputDialog(this, "请输入用户名:", "添加用户", JOptionPane.PLAIN_MESSAGE);
        if (name != null && !name.trim().isEmpty()) {
            int newId = userList.size() + 1;
            User newUser = new User(newId, name, name + "@example.com", "1380013800" + newId, 25);
            userList.add(newUser);
            refreshTableModel();
            JOptionPane.showMessageDialog(this, "用户 " + name + " 已添加", "成功", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * 编辑用户
     */
    private void editUser(int row) {
        User user = userList.get(row);
        String name = JOptionPane.showInputDialog(this, "修改用户名:", user.getName());
        if (name != null && !name.trim().isEmpty()) {
            user.setName(name);
            user.setEmail(name + "@example.com");
            refreshTableModel();
            JOptionPane.showMessageDialog(this, "用户信息已更新", "成功", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * 删除选中用户
     */
    private void deleteSelectedUser() {
        int selectedRow = userTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "请先选择要删除的用户", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }

        User user = userList.get(selectedRow);
        int result = JOptionPane.showConfirmDialog(this, 
            "确定要删除用户 " + user.getName() + " 吗?", 
            "确认删除", 
            JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.YES_OPTION) {
            userList.remove(selectedRow);
            refreshTableModel();
            JOptionPane.showMessageDialog(this, "用户已删除", "成功", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * 搜索用户
     */
    private void searchUser() {
        String keyword = searchField.getText().trim().toLowerCase();
        if (keyword.isEmpty()) {
            refreshTableModel();
            return;
        }

        tableModel.setRowCount(0);
        for (User user : userList) {
            if (user.getName().toLowerCase().contains(keyword) ||
                user.getEmail().toLowerCase().contains(keyword) ||
                user.getPhone().contains(keyword)) {
                Object[] row = {user.getId(), user.getName(), user.getEmail(), 
                               user.getPhone(), user.getAge(), ""};
                tableModel.addRow(row);
            }
        }
        recordCountLabel.setText("共找到 " + tableModel.getRowCount() + " 条记录");
    }
}