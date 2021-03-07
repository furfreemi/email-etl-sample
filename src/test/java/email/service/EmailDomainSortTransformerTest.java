package email.service;

import email.model.Email;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class EmailDomainSortTransformerTest {

    @Test
    public void sortsEmailsByDomain() {
        Email expectedFirst = new Email("a", "a.example.org");
        Email expectedSecond = new Email("a", "b.example.org");
        Email expectedThird = new Email("a", "example.com");
        List<Email> emails = new ArrayList<>(Arrays.asList(
                expectedSecond,
                expectedThird,
                expectedFirst
        ));

        new EmailDomainSortTransformer().sort(emails);

        Assertions.assertEquals(expectedFirst, emails.get(0));
        Assertions.assertEquals(expectedSecond, emails.get(1));
        Assertions.assertEquals(expectedThird, emails.get(2));
    }

    @Test
    public void sortsEmailsByUsernameIfSameDomain() {
        String domain = "example.org";
        Email expectedFirst = new Email("a", domain);
        Email expectedSecond = new Email("b", domain);
        Email expectedThird = new Email("z", domain);
        List<Email> emails = new ArrayList<>(Arrays.asList(
                expectedThird,
                expectedFirst,
                expectedSecond
        ));

        new EmailDomainSortTransformer().sort(emails);

        Assertions.assertEquals(expectedFirst, emails.get(0));
        Assertions.assertEquals(expectedSecond, emails.get(1));
        Assertions.assertEquals(expectedThird, emails.get(2));
    }
}