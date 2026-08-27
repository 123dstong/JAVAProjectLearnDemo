# Java Swing 桌面应用示例

这是一个使用 Java Swing 开发的桌面应用程序示例，类似于 .NET WinForms。

## 项目结构

```
SwingDemo/
└── src/
    └── com/
        └── example/
            └── swing/
                ├── MainApp.java              # 主应用入口
                ├── ui/
                │   ├── MainFrame.java        # 主窗口 (类似 Form)
                │   └── UserPanel.java        # 用户管理面板 (类似 UserControl)
                ├── model/
                │   └── User.java             # 用户模型类
                └── util/                     # 工具类目录
```

## 环境要求

- JDK 1.8 或更高版本
- IntelliJ IDEA 2025.3.5

## 如何运行

### 方法一：使用 IntelliJ IDEA
1. 打开 IntelliJ IDEA
2. 选择 `File` → `Open`
3. 选择 `SwingDemo` 文件夹
4. 运行 `MainApp.java` 文件

### 方法二：使用命令行
```bash
# 进入项目目录
cd SwingDemo

# 编译
javac -d out src/com/example/swing/*.java src/com/example/swing/**/*.java

# 运行
java -cp out com.example.swing.MainApp
```

## Swing vs WinForms 对比

| Swing 组件 | WinForms 对应 | 说明 |
|------------|---------------|------|
| JFrame | Form | 主窗口 |
| JPanel | UserControl | 面板控件 |
| JButton | Button | 按钮 |
| JLabel | Label | 标签 |
| JTextField | TextBox | 文本框 |
| JTextArea | RichTextBox | 多行文本框 |
| JTable | DataGridView | 表格 |
| JComboBox | ComboBox | 下拉框 |
| JCheckBox | CheckBox | 复选框 |
| JRadioButton | RadioButton | 单选按钮 |
| JMenuBar | MenuStrip | 菜单栏 |
| JToolBar | ToolStrip | 工具栏 |
| JStatusBar | StatusStrip | 状态栏 |
| JOptionPane | MessageBox | 消息对话框 |

## 功能特性

### 1. 主窗口 (MainFrame)
- 菜单栏（文件、编辑、帮助）
- 侧边导航栏
- 状态栏
- 快捷键支持

### 2. 用户管理 (UserPanel)
- 用户列表表格
- 添加用户
- 编辑用户
- 删除用户
- 搜索用户

### 3. 数据统计
- 统计卡片展示
- 数据可视化

### 4. 系统设置
- 设置表单
- 主题选择
- 参数配置

## 代码示例

### 1. 创建按钮
```java
JButton button = new JButton("点击我");
button.setBackground(new Color(76, 175, 80));
button.setForeground(Color.WHITE);
button.addActionListener(e -> {
    JOptionPane.showMessageDialog(frame, "按钮被点击了!");
});
```

### 2. 创建表格
```java
String[] columns = {"ID", "姓名", "邮箱"};
DefaultTableModel model = new DefaultTableModel(columns, 0);
JTable table = new JTable(model);
table.setModel(model);
```

### 3. 创建菜单
```java
JMenuBar menuBar = new JMenuBar();
JMenu fileMenu = new JMenu("文件");
JMenuItem openItem = new JMenuItem("打开");
openItem.addActionListener(e -> openFile());
fileMenu.add(openItem);
menuBar.add(fileMenu);
```

### 4. 显示对话框
```java
// 信息对话框
JOptionPane.showMessageDialog(frame, "操作成功", "提示", JOptionPane.INFORMATION_MESSAGE);

// 确认对话框
int result = JOptionPane.showConfirmDialog(frame, "确定删除吗?", "确认", JOptionPane.YES_NO_OPTION);

// 输入对话框
String name = JOptionPane.showInputDialog(frame, "请输入名称:");
```

## 学习内容

### 1. Swing 基础
- JFrame（窗口）
- JPanel（面板）
- LayoutManager（布局管理器）

### 2. 常用控件
- JButton（按钮）
- JLabel（标签）
- JTextField（文本框）
- JTable（表格）

### 3. 事件处理
- ActionListener（动作监听器）
- MouseListener（鼠标监听器）
- KeyListener（键盘监听器）

### 4. 界面美化
- 设置外观（LookAndFeel）
- 自定义颜色和字体
- 绘制图形

## 扩展练习

1. **添加数据库功能**
   - 集成 SQLite 或 MySQL
   - 实现数据持久化
   - 完整的增删改查

2. **添加文件操作**
   - 文件选择器 (JFileChooser)
   - 文件读写
   - 导入导出功能

3. **添加图形绘制**
   - 使用 Graphics 绘制图形
   - 实现图表功能
   - 数据可视化

4. **添加多线程**
   - 使用 SwingWorker 执行耗时任务
   - 进度条显示
   - 线程安全

## 常见问题

### 1. 界面显示异常
确保在事件调度线程 (EDT) 中创建和修改 UI 组件。

### 2. 中文乱码
设置字体为支持中文的字体，如 "Microsoft YaHei"。

### 3. 布局问题
选择合适的布局管理器，避免使用绝对布局。

## 相关资源

- [Swing 官方文档](https://docs.oracle.com/javase/8/docs/api/javax/swing/package-summary.html)
- [Swing 教程](https://docs.oracle.com/javase/tutorial/uiswing/)
- [Swing 示例](https://examples.javacodegeeks.com/category/java-gui/swing/)

## 许可证

本项目仅供学习参考使用。