package io.codelex;

import java.io.File;

public interface FileRetrieverInterface {
    File getFile() throws FileDoesntExistException;
}
