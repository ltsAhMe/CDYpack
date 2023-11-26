package org.CDA.commend.Run;

import java.io.*;
import java.util.Scanner;

public class write {
    public static void Runtime(String[] args){
        Scanner scanner = new Scanner(System.in);
        String fileName = "";
        if (args.length>1){
            fileName = args[1];
        }// 编辑的文件名

        System.out.println("欢迎使用文本编辑器！");
        System.out.println("请输入以下命令：");
        System.out.println("r 读取文件内容");
        System.out.println("w 写入文件内容");
        System.out.println("q 退出编辑器");

        while (true) {
            System.out.print("请输入命令：");
            String command[] = scanner.nextLine().split(" ");

            if (command[0].equals("r")) {
                if (command.length>1){
                    readFile(command[1]);
                }else {
                    readFile(fileName);
                }
            } else if (command[0].equals("w")) {
                if (command.length>1){
                    writeFile(command[1]);
                }else {
                    writeFile(fileName);
                }
            } else if (command[0].equals("q")) {
                System.out.println("感谢使用控制台文本编辑器！");
                break;
            } else {
                System.out.println("无效的命令，请重新输入！");
            }
        }

    }
    public static void HelpShow(String[] args){
        System.out.println("can write text");
    }

    private static void readFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("读取文件失败：" + e.getMessage());
        }
    }

    private static void writeFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入要写入文件的内容（输入\"q\"结束写入）：");

            while (true) {
                String line = scanner.nextLine();
                if (line.equals("q")) {
                    break;
                }
                writer.write(line);
                writer.newLine();
            }

            System.out.println("文件写入成功！");
        } catch (IOException e) {
            System.out.println("写入文件失败：" + e.getMessage());
        }
    }
}