package email.service;

import email.model.Email;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmailLoaderTest {

    @Test
    public void writesNewlineDelimitedEmails() throws IOException {
        Writer writer = new StringWriter();

        Email email1 = new Email("email1", "example.edu");
        Email email2 = new Email("email2", "example.org");
        List<Email> emails = new ArrayList<>(Arrays.asList(
                email1,
                email2
        ));

        new EmailLoader(writer).write(emails);
        String expectedOutput = String.join(System.lineSeparator(), "email1@example.edu", "email2@example.org");
        assertEquals(expectedOutput, writer.toString());
    }


}