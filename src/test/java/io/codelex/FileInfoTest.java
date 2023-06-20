package io.codelex;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class FileInfoTest {

    @Test
    @DisplayName("Should be able to store and retrieve stored string")
    public void storeAndRetrieveTest1() {
        FileInfo fileInfo1 = new FileInfo("hello world");
        FileInfo fileInfo2 = new FileInfo("public static void main string args");
        assertEquals("hello world", fileInfo1.getFileName());
        assertEquals("public static void main string args", fileInfo2.getFileName());
    }

    @Test
    @DisplayName("Two FileInfo objects with the same values should be equal")
    public void compareTest1() {
        FileInfo fileInfo1 = new FileInfo("abc");
        FileInfo fileInfo2 = new FileInfo("abc");
        FileInfo fileInfo3 = new FileInfo("gfc");
        assertEquals(fileInfo1, fileInfo2);
        assertNotEquals(fileInfo3, fileInfo1);
    }

    @Test
    public void testHashCode() {
        FileInfo fileInfo1 = new FileInfo("abc");
        FileInfo fileInfo2 = new FileInfo("abc");
        FileInfo fileInfo3 = new FileInfo("hello world");
        assertEquals(fileInfo1.hashCode(), fileInfo2.hashCode());
        assertNotEquals(fileInfo1.hashCode(), fileInfo3.hashCode());
    }
}
