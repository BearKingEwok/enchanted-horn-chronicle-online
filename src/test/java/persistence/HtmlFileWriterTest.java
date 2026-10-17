package persistence;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HtmlFileWriterTest {
    private final HtmlFileWriter htmlFileWriter = new HtmlFileWriter();
    @TempDir
    Path tempDir;

    @Test
    void writesHtmlFile() throws IOException {
        htmlFileWriter.write(tempDir.resolve("index.html"), "test");
        assertEquals("test", Files.readString(tempDir.resolve("index.html")));
    }

    @Test
    void throwsNPEIfPathNull() {
        assertThrows(NullPointerException.class,
                () -> htmlFileWriter.write(null,
                        "test"));
    }

    @Test
    void throwsNPEIfHtmlNull() {
        assertThrows(NullPointerException.class,
                () -> htmlFileWriter.write(tempDir.resolve("index.html"),
                        null));
    }
}