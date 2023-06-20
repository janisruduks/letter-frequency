package io.codelex;

import java.io.IOException;

public interface FileContentInterface {
    String getCleanedFileContent() throws IOException, FileDoesntExistException;
}