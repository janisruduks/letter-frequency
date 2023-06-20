package io.codelex;

import java.io.File;

public class FileRetriever implements FileRetrieverInterface {

    private static final String FILE_DIRECTORY = "src/main/java/io/codelex/filesToRead/";
    private final FileInfo fileInfo;

    public FileRetriever(String fileName) {
        this.fileInfo = new FileInfo(fileName);
    }

    @Override
    public File getFile() throws FileDoesntExistException {
        File file = new File(FILE_DIRECTORY + fileInfo.getFileName() + ".txt");
        if (file.exists()) {
            return file;
        }
        throw new FileDoesntExistException("File does not exist.");
    }
}