package com.xiaoming;

import java.util.Scanner;

public class Calculate {
    private static void add() {
        System.out.print("请输入第一个数：");
        double a = getDouble();
        System.out.print("请输入第二个数：");
        double b = getDouble();
        System.out.println(a + " + " + b + " = " + (a + b));
    }

    private static void reduce() {
        System.out.print("请输入第一个数：");
        double a = getDouble();
        System.out.print("请输入第二个数：");
        double b = getDouble();
        System.out.println(a + " - " + b + " = " + (a - b));
    }

    private static void multi() {
        System.out.print("请输入第一个数：");
        double a = getDouble();
        System.out.print("请输入第二个数：");
        double b = getDouble();
        System.out.println(a + " * " + b + " = " + (a * b));
    }

    private static void divide() {
        System.out.print("请输入被除数：");
        double a = getDouble();
        System.out.print("请输入除数：");
        double b = getDouble();
        if (b == 0){
            System.out.println("除数不能为0");
            return;
        }
        System.out.println(a + " / " + b + " = " + (a / b));
    }

    public static void main(String[] args) {
        System.out.println("************欢迎使用ZW计算器************");
        boolean flag = true;
        while(flag){
            System.out.println("************请选择功能************");
            System.out.println("1.加" + "\t" + "2.减" + "\t" + "3.乘" + "\t" + "4.除");
            System.out.print("请选择：");
            int num = getInt();
            switch (num) {
                case 1:
                    add();
                    break;
                case 2:
                    reduce();
                    break;
                case 3:
                    multi();
                    break;
                case 4:
                    divide();
                    break;
            }
            System.out.println("是否继续？" + "\t" +"Y:是；N:否");
            System.out.print("请输入：");
            String is = getString();
            if ("Y".equals(is)){
                flag = true;
            }else if("N".equals(is)){
                flag = false;
            }
        }
        System.out.println("程序已退出");
    }

    /**
     * 生成字符串 Y/N
     * @return
     */
    private static String getString() {
        String str = new Scanner(System.in).next();
        if (!"Y".equals(str) && !"N".equals(str)){
            System.out.println("输入错误！");
            System.out.print("请重新输入：");
            str = getString();
        }
        return str;

    }

    /**
     * 输入int整数
     *
     * @return
     */
    private static int getInt() {
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        try {
            num = scanner.nextInt();
        } catch (Exception e) {
            System.out.print("输入错误！请输入整数：");
            num = getInt();
        }
        return num;
    }

    /**
     * 输入double类型的数
     *
     * @return
     */
    private static double getDouble() {
        Scanner scanner = new Scanner(System.in);
        Double num = 0.0;
        try {
            num = scanner.nextDouble();
        } catch (Exception e) {
            System.out.print("输入错误！请输入double类型的数：");
            num = getDouble();
        }
        return num;
    }
}
