package com.carfriend.Util;

import com.carfriend.Exception.FileUploadException;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.UUID;

public class FileHandler {
    //限制上传5mb的图片
    private static final int MAXSIZE = 5 * 1024 * 1024;
    private static ArrayList<String> fileType = new ArrayList<>();

    //限制文件类型
    static {
        fileType.add("image/png");
        fileType.add("image/jpg");
        fileType.add("image/jpeg");
    }

    /**
     * 判断是否超出最大上传限制
     *
     * @param file 文件
     * @return 返回false，表示可以上传
     */
    public static boolean IsOutMaxSize(MultipartFile file) {
        return file.getSize() > MAXSIZE ? true : false;
    }

    /**
     * 判断是否不属于上传的文件范围
     *
     * @param file 文件
     * @return true表示属于可上传的玩家范围
     */
    public static boolean IsExistType(MultipartFile file) {
        return fileType.contains(file.getContentType());
    }


    /**
     * 保存文件
     *
     * @param file 文件对象
     * @param path 文件路径
     * @param home 系统上下文对象
     * @return 格式化后的文件名
     */
    public static String transferFile(MultipartFile file, String path, ApplicationHome home) throws Exception {
        String origin = file.getOriginalFilename();
        String suffix = "." + origin.split("\\.")[1];
        //完整的文件名
        String filename = UUID.randomUUID().toString().replace("-", "") + suffix;
        //获取文件分隔符
        String spec = FileSystems.getDefault().getSeparator();
        String pre = home.getDir().getParentFile().getParentFile().getAbsolutePath()
                + spec + "src" + spec + "main" + spec + "resources" + spec + "static" + spec + path + spec;
        //完整的文件路径
        String savePath = pre + filename;
        //判断文件的父保存路径是否存在
        File filepath = new File(pre);
        if (!filepath.exists()) {
            filepath.mkdir();
        }
        try {
            file.transferTo(new File(savePath));
        } catch (FileUploadException exception) {
            throw new FileUploadException();
        }
        return filename;
    }

    /**
     * 判断上传的文件是否可用
     *
     * @param file 文件对象
     * @return 是否可用
     */
    public static boolean FileIsAvailable(MultipartFile file) {
        if (file.isEmpty()) return false;
        if (IsOutMaxSize(file)) return false;
        if (!IsExistType(file)) return false;
        return true;
    }
}
