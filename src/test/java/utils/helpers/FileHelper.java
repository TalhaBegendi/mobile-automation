package utils.helpers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {

    public static List<File> getFileListWithDirectoryNameAndEndWith(String directoryName, String endWith) {
        List<File> resultList = new ArrayList<>();
        File directory = new File(directoryName);
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(endWith)) {
                    resultList.add(file);
                } else if (file.isDirectory()) {
                    resultList.addAll(getFileListWithDirectoryNameAndEndWith(file.getAbsolutePath(), endWith));
                }
            }
        }
        return resultList;
    }
}