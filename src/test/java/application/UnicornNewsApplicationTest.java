package application;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UnicornNewsApplicationTest {
    private final Path articlesDirectory = Paths.get("target/site/articles");

    @Test
    void publicationIdentityRemainsStable() throws IOException {
        List<String> fileNames;
        long fileCount;
        List<String> fileNamesAfter;
        long fileCountAfter;

        deleteAllFiles(articlesDirectory);
        UnicornNewsApplication.main(new String[]{});
        fileNames = readFileNames();
        fileCount = readFileCount();

        deleteAllFiles(articlesDirectory);
        UnicornNewsApplication.main(new String[]{});
        fileNamesAfter = readFileNames();
        fileCountAfter = readFileCount();

        assertEquals(fileNames.stream().sorted().toList(),
                fileNamesAfter.stream().sorted().toList());
        assertEquals(10, fileCount);
        assertEquals(10, fileCountAfter);
    }

    private void deleteAllFiles(Path directory) throws IOException {
        try {
            if (Files.exists(directory) && Files.isDirectory(directory)) {
                try (var stream = Files.list(directory)) {
                    stream.filter(Files::isRegularFile)
                            .forEach(file -> {
                                try {
                                    Files.delete(file);
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            });
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private long readFileCount() throws IOException {
        try (Stream<Path> stream = Files.list(articlesDirectory)) {
            return stream.count();
        }
    }

    private List<String> readFileNames() throws IOException {
        try (Stream<Path> stream = Files.list(articlesDirectory)) {
            return stream.map(Path::getFileName).map(String::valueOf).toList();
        }
    }
}