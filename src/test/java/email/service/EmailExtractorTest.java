package email.service;


import email.model.Email;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmailExtractorTest {

    @Test
    public void filtersOutInvalidEmails() throws IOException {
        String invalidEmail1 = "invalid.email";
        String invalidEmail2 = "invalid@email";
        Reader reader = new StringReader(String.join(System.lineSeparator(), invalidEmail1, invalidEmail2));
        List<Email> validEmails = new EmailExtractor(reader).read();

        assertTrue(validEmails.isEmpty());
    }

    @Test
    public void createsListOfEmailsFromInput() throws IOException {
        String email1 = "email@example.com";
        String invalidEmail = "@example.com";
        String email2 = "email2@test.example.com";
        Reader reader = new StringReader(String.join(System.lineSeparator(), email1, invalidEmail, email2));

        List<Email> validEmails = new EmailExtractor(reader).read();

        assertEquals(2, validEmails.size());
        assertEquals(email1, validEmails.get(0).getEmailAddress());
        assertEquals(email2, validEmails.get(1).getEmailAddress());
    }

}