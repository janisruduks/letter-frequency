package io.codelex;

import java.io.File;

public class FileGetter implements FileRetriever {

    private static final String FILE_DIRECTORY = "src/main/java/io/codelex/filesToRead/";
    private final FileInfo fileInfo;

    public FileGetter(String fileName) {
        this.fileInfo = new FileInfo(fileName);
    }

    @Override
    public File getFile() throws FileDoesntExistException {
        File file = new File(FILE_DIRECTORY + fileInfo.getFileName() + ".txt");
        if (file.exists()) {
            return file;
        }
        throw new FileDoesntExistException();
    }
}