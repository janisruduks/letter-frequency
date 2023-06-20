package io.codelex;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LetterFrequency {

    private final FileContentInterface fileContentInterface;

    public LetterFrequency(FileContentInterface fileContentInterface) {
        this.fileContentInterface = fileContentInterface;
    }

    public Map<Character, Long> getLetterFrequency() throws FileDoesntExistException, IOException {
        return frequencyMap(getCharacterStream());
    }

    private static <Character> Map<Character, Long> frequencyMap(Stream<Character> elements) {
        return elements.collect(
                Collectors.groupingBy(
                        Function.identity(),
                        HashMap::new,
                        Collectors.counting()
                )
        );
    }

    private Stream<Character> getCharacterStream() throws FileDoesntExistException, IOException {
        return getFileContent()
                .chars()
                .mapToObj(c -> (char) c);
    }

    private String getFileContent() throws FileDoesntExistException, IOException {
        return fileContentInterface.getCleanedFileContent();
    }
}
