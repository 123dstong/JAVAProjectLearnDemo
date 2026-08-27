package com.example.demo;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        System.out.println("欢迎来到Java学习示例!");
        System.out.println();

        // 演示基本数据类型
        demonstrateBasicTypes();

        // 演示控制流
        demonstrateControlFlow();

        // 演示数组和集合
        demonstrateArraysAndCollections();

        // 演示面向对象编程
        demonstrateOOP();

        // 演示异常处理
        demonstrateExceptionHandling();
    }

    private static void demonstrateBasicTypes() {
        System.out.println("=== 基本数据类型演示 ===");

        // 整数类型
        byte byteVar = 127;
        short shortVar = 32767;
        int intVar = 2147483647;
        long longVar = 9223372036854775807L;

        // 浮点类型
        float floatVar = 3.14f;
        double doubleVar = 3.141592653589793;

        // 字符类型
        char charVar = 'A';

        // 布尔类型
        boolean booleanVar = true;

        System.out.println("byte: " + byteVar);
        System.out.println("short: " + shortVar);
        System.out.println("int: " + intVar);
        System.out.println("long: " + longVar);
        System.out.println("float: " + floatVar);
        System.out.println("double: " + doubleVar);
        System.out.println("char: " + charVar);
        System.out.println("boolean: " + booleanVar);
        System.out.println();
    }

    private static void demonstrateControlFlow() {
        System.out.println("=== 控制流演示 ===");

        // if-else语句
        int score = 85;
        if (score >= 90) {
            System.out.println("成绩优秀: " + score);
        } else if (score >= 80) {
            System.out.println("成绩良好: " + score);
        } else if (score >= 70) {
            System.out.println("成绩中等: " + score);
        } else {
            System.out.println("成绩需要提高: " + score);
        }

        // for循环
        System.out.print("1到10的和: ");
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        System.out.println(sum);

        // while循环
        System.out.print("1到10的乘积: ");
        long product = 1;
        int i = 1;
        while (i <= 10) {
            product *= i;
            i++;
        }
        System.out.println(product);

        // switch语句
        char grade = 'B';
        switch (grade) {
            case 'A':
                System.out.println("优秀");
                break;
            case 'B':
                System.out.println("良好");
                break;
            case 'C':
                System.out.println("中等");
                break;
            default:
                System.out.println("其他");
        }
        System.out.println();
    }

    private static void demonstrateArraysAndCollections() {
        System.out.println("=== 数组和集合演示 ===");

        // 数组
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.print("数组元素: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        // ArrayList
        java.util.List<String> fruits = new java.util.ArrayList<>();
        fruits.add("苹果");
        fruits.add("香蕉");
        fruits.add("橙子");

        System.out.print("水果列表: ");
        for (String fruit : fruits) {
            System.out.print(fruit + " ");
        }
        System.out.println();

        // HashMap
        java.util.Map<String, Integer> scores = new java.util.HashMap<>();
        scores.put("数学", 95);
        scores.put("英语", 88);
        scores.put("物理", 92);

        System.out.println("成绩映射:");
        for (java.util.Map.Entry<String, Integer> entry : scores.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();
    }

    private static void demonstrateOOP() {
        System.out.println("=== 面向对象编程演示 ===");

        // 创建对象
        Person person1 = new Person("张三", 25);
        Person person2 = new Person("李四", 30);

        System.out.println("人物1: " + person1);
        System.out.println("人物2: " + person2);

        // 调用方法
        person1.haveBirthday();
        System.out.println("人物1过生日后: " + person1);

        // 继承示例
        Student student = new Student("王五", 20, "计算机科学");
        System.out.println("学生: " + student);
        student.study();
        System.out.println();
    }

    private static void demonstrateExceptionHandling() {
        System.out.println("=== 异常处理演示 ===");

        try {
            int result = divide(10, 0);
            System.out.println("结果: " + result);
        } catch (ArithmeticException e) {
            System.out.println("捕获算术异常: " + e.getMessage());
        }

        try {
            String str = null;
            str.length();
        } catch (NullPointerException e) {
            System.out.println("捕获空指针异常: " + e.getMessage());
        }

        // 自定义异常
        try {
            checkAge(15);
        } catch (InvalidAgeException e) {
            System.out.println("捕获自定义异常: " + e.getMessage());
        }
        System.out.println();
    }

    private static int divide(int a, int b) {
        return a / b;
    }

    private static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("年龄必须大于等于18岁");
        }
        System.out.println("年龄验证通过: " + age);
    }
}