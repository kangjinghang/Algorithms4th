package io.github.kangjinghang.chapter1_3.exercise;

import edu.princeton.cs.algs4.StdOut;
import io.github.kangjinghang.chapter1_3.Queue;

import java.io.File;

/**
 * 文件列表。文件夹就是一列文件和文件夹的列表。编写一个程序，从命令行接受一个文件夹名
 * 作为参数，打印出该文件夹下的所有文件并用递归的方式在所有子文件夹的名下（缩进）列出
 * 其下的所有文件。 提示：使用队列，并参考 java.io.File
 */
public class Ex43 {

    private static class MyFile {
        String name;
        int level;

        public MyFile(String name, int level) {
            this.name = name;
            this.level = level;
        }
    }

    public static void showAllDirAndFile(File f, Queue<MyFile> q, int level) {
        if (f == null) return;
        level++;
        MyFile myfile = new MyFile(f.getName(), level);
        q.enqueue(myfile);
        if (f.isDirectory()) {
            File[] files = f.listFiles();
            assert files != null;
            for (File file : files) {
                showAllDirAndFile(file, q, level);
            }
        }

    }

    public static void main(String[] args) {
//        String dirName = args[0];
        String dirName = "/Users/kangjinghang/workspace/github/Algorithms4th/src";
//        String dirName = "/Users/kangjinghang/workspace/github/Algorithms4th/bin";
        File f = new File(dirName);
        Queue<MyFile> q = new Queue<>();
        int level = 0;
        showAllDirAndFile(f, q, level);

        for (MyFile file : q) {
            StdOut.printf("%" + 3 * file.level + "s|_%s\n", "", file.name);
        }
    }

}
