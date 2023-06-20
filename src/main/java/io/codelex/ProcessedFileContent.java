package io.codelex;

import java.io.IOException;
import java.nio.file.Files;

public class ProcessedFileContentInterface implements FileContentInterface {

    private final FileRetrieverInterface fileRetrieverInterface;

    public ProcessedFileContentInterface(FileRetrieverInterface fileRetrieverInterface) {
        this.fileRetrieverInterface = fileRetrieverInterface;
    }

    @Override
    public String getCleanedFileContent() throws IOException, FileDoesntExistException {
        return Files.readString(fileRetrieverInterface.getFile().toPath())
                .toLowerCase()
                .replaceAll("[^a-z]", "");
    }
}