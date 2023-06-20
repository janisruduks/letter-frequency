package io.codelex;

import java.io.IOException;

public interface FileContent {
    String getCleanedFileContent() throws IOException, FileDoesntExistException;
}