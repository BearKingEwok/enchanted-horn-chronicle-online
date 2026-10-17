package persistence;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class HtmlFileWriter {
    public void write(Path target, String html) throws IOException {
        Objects.requireNonNull(target);
        Objects.requireNonNull(html);

        try (BufferedWriter writer = Files.newBufferedWriter(target, StandardCharsets.UTF_8)) {
            writer.write(html);
        }
    }
}
