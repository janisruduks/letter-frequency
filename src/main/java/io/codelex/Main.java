package io.codelex;

import java.io.IOException;
import java.util.Scanner;

public class LetterFrequencyTest {

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter text file name for which you want to generate letter frequency.");
        String fileName = keyboard.next();
        FileRetrieverInterface fileRetrieverInterface = new FileRetriever(fileName);
        FileContentInterface fileContentInterface = new ProcessedFileContent(fileRetrieverInterface);
        LetterFrequency letterFrequency = new LetterFrequency(fileContentInterface);
        try {
            System.out.println(letterFrequency.getLetterFrequency());
        } catch (IOException | FileDoesntExistException e) {
            e.printStackTrace();
        }
    }
}