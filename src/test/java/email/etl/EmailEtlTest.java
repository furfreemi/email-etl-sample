package email.etl;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmailEtlTest {

    @Test
    public void transformsAndLoadsExtractedData() {
        String expectedFirst = "aaa@example.com";
        String expectedSecond = "bbb@example.org";
        Reader reader = new StringReader(String.join(System.lineSeparator(), expectedSecond, "invalid..@example.com", expectedFirst));
        Writer writer = new StringWriter();

        new EmailEtl(reader, writer).extractTransformLoad();

        assertEquals(String.join(System.lineSeparator(), expectedFirst, expectedSecond), writer.toString());
    }
}