package com.li.oldfile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

public class USBFileRecovery {
    // U 盘路径
    private static final String USB_PATH = "F:\\";
    // 恢复文件保存路径
    private static final String SAVE_PATH = "C:\\Users\\Administrator\\Desktop\\files";

    public static void main(String[] args) throws IOException {
        // 获取已删除的文件列表
        List<File> deletedFiles = getDeletedFiles(USB_PATH);
        // 恢复文件数据并保存到指定目录
        recoverFiles(deletedFiles, SAVE_PATH);
    }

    /**
     * 获取已删除的文件列表
     */
    private static List<File> getDeletedFiles(String path) throws IOException {
        List<File> deletedFiles = new ArrayList<>();
        File root = new File(path);
        for (File file : root.listFiles()) {
            if (file.isDirectory()) {
                deletedFiles.addAll(getDeletedFiles(file.getAbsolutePath()));
            } else if (file.getName().startsWith("._") && file.exists()) {
                // Mac 系统会生成一些以 "._" 开头的隐藏文件，需要排除
            } else if (file.getName().startsWith(".") && file.exists()) {
                // Linux 系统会生成一些以 "." 开头的隐藏文件，需要排除
            } else {
                // 判断文件是否被删除
                if (!file.exists()) {
                    deletedFiles.add(file);
                }
            }
        }
        return deletedFiles;
    }

    /**
     * 恢复文件数据并保存到指定目录
     */
    private static void recoverFiles(List<File> deletedFiles, String savePath) throws IOException {
        if (deletedFiles.isEmpty()) {
            System.out.println("没有找到已删除的文件");
            return;
        }
        // 创建恢复文件保存目录
        Path path = Paths.get(savePath);
        Files.createDirectories(path);
        // 遍历已删除的文件列表，恢复文件数据并保存到指定目录
        for (File file : deletedFiles) {
            byte[] fileBytes = FileUtils.readFileToByteArray(file);
            String fileName = StringUtils.substringAfterLast(file.getAbsolutePath(), File.separator);
            String fileExt = StringUtils.substringAfterLast(fileName, ".");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            String timeStr = sdf.format(new Date());
            String newFileName = timeStr + "_" + fileName;
            File newFile = new File(savePath + newFileName);
            FileUtils.writeByteArrayToFile(newFile, fileBytes);
            System.out.println("已恢复文件：" + newFile.getAbsolutePath());
        }
        System.out.println("已恢复 " + deletedFiles.size() + " 个文件");
    }
}