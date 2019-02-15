package org.oasystem_dazhu.utils;

import java.io.File;

/**
 * Created by www on 2019/1/20.
 */

public class FileUtil {
    public static void deleteFile(File file) {
        if (!file.exists())
            return;
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                deleteFile(f);
            }
        } else if (file.exists()) {
            file.delete();
        }
    }
}
