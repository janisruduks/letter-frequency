package io.codelex;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class LetterFrequencyTest {


    @Test
    @DisplayName("Should return mapped frequency of characters")
    public void getCleanedFileContentTest1() throws FileDoesntExistException, IOException {
        FileContentInterface mockContentInterface = Mockito.mock(FileContentInterface.class);
        String mockContent = "aaabbbcc";
        when(mockContentInterface.getCleanedFileContent()).thenReturn(mockContent);
        LetterFrequency mockLetterFrequency = new LetterFrequency(mockContentInterface);
        Map<Character, Long> expectedContent = new HashMap<>();
        expectedContent.put('a', 3L);
        expectedContent.put('b', 3L);
        expectedContent.put('c', 2L);
        assertEquals(expectedContent, mockLetterFrequency.getLetterFrequency());
    }

    @Test
    @DisplayName("Should return mapped frequency of characters")
    public void getCleanedFileContentTest2() throws FileDoesntExistException, IOException {
        FileContentInterface mockContentInterface = Mockito.mock(FileContentInterface.class);
        String mockContent = "gggggggggg";
        when(mockContentInterface.getCleanedFileContent()).thenReturn(mockContent);
        LetterFrequency mockLetterFrequency = new LetterFrequency(mockContentInterface);
        Map<Character, Long> expectedContent = new HashMap<>();
        expectedContent.put('g', 10L);
        assertEquals(expectedContent, mockLetterFrequency.getLetterFrequency());
    }


}
