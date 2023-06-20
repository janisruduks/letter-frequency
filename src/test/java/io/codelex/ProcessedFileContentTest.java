package io.codelex;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class ProcessedFileContentTest {

    @Test
    @DisplayName("Should return cleaned content from file")
    public void getCleanedFileContentTest() throws FileDoesntExistException, IOException {
        FileRetrieverInterface mockFileRetriever = Mockito.mock(FileRetrieverInterface.class);
        File testFile = new File("src/main/resources/test-file.txt");
        when(mockFileRetriever.getFile()).thenReturn(testFile);
        ProcessedFileContent processedFileContent = new ProcessedFileContent(mockFileRetriever);
        String expectedContent = Files.readString(testFile.toPath()).toLowerCase().replaceAll("[^a-z]", "");
        String actualContent = processedFileContent.getCleanedFileContent();
        assertEquals(expectedContent, actualContent);
    }

    @Test
    @DisplayName("Should throw exception if file is not provided")
    public void shouldThrowExceptionIfFileIsNotProvided() throws FileDoesntExistException {
        FileRetrieverInterface mockFileRetriever = Mockito.mock(FileRetrieverInterface.class);
        when(mockFileRetriever.getFile()).thenThrow(new FileDoesntExistException("File not found"));
        ProcessedFileContent processedFileContent = new ProcessedFileContent(mockFileRetriever);
        assertThrows(FileDoesntExistException.class, processedFileContent::getCleanedFileContent);
    }
}
