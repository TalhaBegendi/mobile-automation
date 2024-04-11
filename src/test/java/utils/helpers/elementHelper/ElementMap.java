package utils.helpers.elementHelper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.helpers.FileHelper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public enum ElementMap {

    INSTANCE;

    private static final String DEFAULT_DIRECTORY_PATH = "elementValues";
    private final Logger logger = LoggerFactory.getLogger(ElementMap.class);
    private final ConcurrentMap<String, ElementResponse> elementMapList = new ConcurrentHashMap<>();
    private final FileHelper fileHelper = new FileHelper();

    ElementMap() {
        initMap(getFileList());
    }

    private void initMap(List<File> fileList) {
        Gson gson = new Gson();
        Type elementType = new TypeToken<List<ElementResponse>>() {}.getType();
        for (File file : fileList) {
            try {
                List<ElementResponse> elementResponseList = gson.fromJson(new FileReader(file), elementType);
                elementResponseList.forEach(elementResponse -> elementMapList.put(elementResponse.getKey(), elementResponse));
            } catch (FileNotFoundException e) {
                logger.warn("{} not found", e);
            }
        }
    }

    private List<File> getFileList() {
        String directoryPath = System.getProperty("user.dir") + "/src/test/resources/elementValues";
        List<File> fileList = fileHelper.getFileListWithDirectoryNameAndEndWith(directoryPath, ".json");
        if (fileList == null) {
            logger.warn("File Directory Is Not Found! Please Check Directory Location. Default Directory Path = {}", DEFAULT_DIRECTORY_PATH);
            throw new NullPointerException("File directory is not found");
        }
        return fileList;
    }

    public ElementResponse findElementInfoByKey(String key) {
        return elementMapList.get(key);
    }
}