package com.gaoxiong.springboot.util;

import java.io.File;
import java.io.IOException;

/**
 * @author gaoxiong
 * @ClassName NifaUtil
 * @Description TODO
 * @date 2018/9/23 15:32
 */
public class NifaUtil {
    public static boolean createFile(String filePath) {
        boolean flag = false;
        File file = new File(filePath);
        File dir = file.getParentFile();
        if (!dir.exists()) {
            dir.mkdirs();
        }
        try {
            flag =file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
