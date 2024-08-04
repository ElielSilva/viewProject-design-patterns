package br.edu.ifpe.viewProjectDesgnPatterns.Shareds.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class Logger implements  ILogger {

    private static Logger instance;

    private static final String path = "/src/br/edu/ifpe/viewProjectDesgnPatterns/Shareds/Logger/Data/log.txt";
    private static final String pathError = "/src/br/edu/ifpe/viewProjectDesgnPatterns/Shareds/Logger/Data/logError.txt";
    private static final String pathInfo = "/src/br/edu/ifpe/viewProjectDesgnPatterns/Shareds/Logger/Data/logInfo.txt";

    public static Logger getInstance() {
        if(instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    @Override
    public void log(String message, LoggerType type) {
        writeLogs(message, path);
        switch (type) {
            case INFO:
                writeLogs(message, pathInfo);
                break;
            case ERROR:
                writeLogs(message, pathError);
                break;
        }
    }

    private void writeLogs(String message, String path) {
        File file = getOrCreateFile(path);
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(message + "\n");
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private File getOrCreateFile(String path) {
        File result = null;
        String userDirectory = FileSystems.getDefault()
                .getPath("")
                .toAbsolutePath()
                .toString();
        try {
            Path pathFile = FileSystems.getDefault().getPath(userDirectory + path).toAbsolutePath();
            result = pathFile.toFile();
            var _ = result.createNewFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

}
