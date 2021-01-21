package ru.netology.manager;

import java.util.*;
import java.util.stream.Collectors;

public class FileOpenManager {
    private Map<String, String> map = new HashMap<>();

    public void saveMap(String extension, String application) {
        map.put(extension, application);
    }

    public void saveAllMap(Map<String, String> maps) {
        map.putAll(maps);
    }

    public String applicationForOpenExtension(String extension) {
        if (map.containsKey(extension)) {
            String application = map.get(extension);
            return application;
        }
        return null;
    }

    public void removeBinding(String extension) {
        if (map.containsKey(extension)) {
            map.put(extension, null);
        }
    }

    public Set<String> extensionAll() {
        Set<String> extension = map.keySet();
        return extension;
    }

    public Set<String> applicationAll() {
        Collection<String> applications = map.values();
        Set<String> result = applications.stream().collect(Collectors.toSet());
        return result;
    }
}
