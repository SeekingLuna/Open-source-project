package com.li.统计代码行数;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JavaFileLineCounter {

    public static int countLines(File file) throws IOException {
        int count = 0;
        BufferedReader reader = new BufferedReader(new FileReader(file));
        while (reader.readLine() != null) {
            count++;
        }
        reader.close();
        return count;
    }

    public static void countJavaFilesLines(File directory, List<JavaFileInfo> javaFilesInfo) throws IOException {
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                countJavaFilesLines(file, javaFilesInfo);
            } else if (file.getName().endsWith(".java")) {
                int lines = countLines(file);
                javaFilesInfo.add(new JavaFileInfo(file.getAbsolutePath(), lines));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String directoryPath = "D:\\JavaDevelop\\yuh-demo";
        File directory = new File(directoryPath);

        // 统计Java文件代码行数
        List<JavaFileInfo> javaFilesInfo = new ArrayList<>();
        countJavaFilesLines(directory, javaFilesInfo);

        // 按代码行数从大到小排序
        Collections.sort(javaFilesInfo, new Comparator<JavaFileInfo>() {
            @Override
            public int compare(JavaFileInfo f1, JavaFileInfo f2) {
                return Integer.compare(f2.lines, f1.lines);
            }
        });

        // 输出最长的代码行数的Java类路径
        System.out.println("Top 5 Java classes with longest code lines:");
        int topN = 30;
        for (int i = 0; i < topN && i < javaFilesInfo.size(); i++) {
            JavaFileInfo fileInfo = javaFilesInfo.get(i);
            System.out.println(fileInfo.filePath + " (lines: " + fileInfo.lines + ")");
        }
    }

    private static class JavaFileInfo {
        public String filePath;
        public int lines;

        public JavaFileInfo(String filePath, int lines) {
            this.filePath = filePath;
            this.lines = lines;
        }
    }
}