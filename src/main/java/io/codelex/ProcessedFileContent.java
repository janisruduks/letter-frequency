package io.codelex;

import java.io.IOException;
import java.nio.file.Files;

public class ProcessedFileContent implements FileContentInterface {

    private final FileRetrieverInterface fileRetrieverInterface;

    public ProcessedFileContent(FileRetrieverInterface fileRetrieverInterface) {
        this.fileRetrieverInterface = fileRetrieverInterface;
    }

    @Override
    public String getCleanedFileContent() throws IOException, FileDoesntExistException {
        return Files.readString(fileRetrieverInterface.getFile().toPath())
                .toLowerCase()
                .replaceAll("[^a-z]", "");
    }
}