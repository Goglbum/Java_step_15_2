package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class FileOpenManagerTest {
    private FileOpenManager manager = new FileOpenManager();
    Map<String, String> mapTest = new HashMap<>();

    @BeforeEach
    public void setUp() {
        mapTest.put(".html", "Google Chrome");
        mapTest.put(".jpg", "Paint");
        mapTest.put(".JPG", "Windows Photo Viewer");
        mapTest.put(".java", "IntelliJ IDEA");
        manager.saveAllMap(mapTest);
        manager.saveMap("py", "PyCharm");
    }

    @Test
    public void applicationForOpenExtension() {
        String actual = manager.applicationForOpenExtension(".JPG");
        String expected = "Windows Photo Viewer";
        actual.equalsIgnoreCase(expected);
    }

    @Test
    public void removeBinding() {
        manager.removeBinding(".JPG");
        String actual = manager.applicationForOpenExtension(".JPG");
        String expected = null;
        assertEquals(actual, expected);
    }

    @Test
    public void extensionAll() {
        Set<String> actual = manager.extensionAll();
        Set<String> expected = new HashSet<>();
        expected.add(".html");
        expected.add(".jpg");
        expected.add(".JPG");
        expected.add(".java");
        expected.add("py");
        assertEquals(actual,expected);
    }

    @Test
    public void applicationAll() {
        Set<String> actual = manager.applicationAll();
        Set<String> expected = new HashSet<>();
        expected.add("Google Chrome");
        expected.add("Paint");
        expected.add("Windows Photo Viewer");
        expected.add("IntelliJ IDEA");
        expected.add("PyCharm");
        assertEquals(actual,expected);
    }

}