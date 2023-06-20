package io.codelex;

import java.io.File;

public interface FileRetriever {
    File getFile() throws FileDoesntExistException;
}
