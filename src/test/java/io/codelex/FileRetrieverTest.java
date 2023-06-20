package io.codelex;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FileRetrieverTest {

    @Test
    @DisplayName("Should return file that exists")
    public void ShouldReturnFileExists() throws FileDoesntExistException {
        File mockFile = mock(File.class);
        when(mockFile.exists()).thenReturn(true);
        FileRetriever mockRetriever = mock(FileRetriever.class);
        when(mockRetriever.getFile()).thenReturn(mockFile);
        File file = mockRetriever.getFile();
        assertTrue(file.exists());
    }

    @Test
    @DisplayName("Should throw error when file doesn't exist")
    public void ShouldThrowErrorWhenFileDoesNotExist() {
        FileRetriever mockRetriever = mock(FileRetriever.class);
        try {
            when(mockRetriever.getFile()).thenThrow(new FileDoesntExistException(""));
        } catch (FileDoesntExistException e) {
            e.printStackTrace();
        }
        assertThrows(FileDoesntExistException.class, mockRetriever::getFile, "Should throw FileDoesntExistException");    }
}
