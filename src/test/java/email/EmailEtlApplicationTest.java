package email;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmailEtlApplicationTest {

    @TempDir
    File tempDirectory;

    @Test
    public void writesValidSortedEmailsToOutputFile() throws IOException {
        File inputFile = new File(tempDirectory, "testFile.txt");
        Files.write(inputFile.toPath(), Arrays.asList(
                "abc@abc.com",
                "cde@yahoo.com",
                "joe@npr.org",
                "rwq@abc.org",
                "dave@gibson.com",
                "just\"not\"right@example.com",
                "Abc.example.com"
        ));

        List<String> expectedOutput = Arrays.asList(
                "abc@abc.com",
                "rwq@abc.org",
                "dave@gibson.com",
                "joe@npr.org",
                "cde@yahoo.com"
        );

        String outputFile = inputFile.getPath() + ".output";
        EmailEtlApplication.main(new String[]{inputFile.getPath(), outputFile});

        assertTrue(Files.exists(Path.of(outputFile)));
        assertLinesMatch(expectedOutput, Files.readAllLines(Path.of(outputFile)));
    }
}