package email.service;

import email.model.Email;

import java.util.Comparator;
import java.util.List;

public class EmailDomainSortTransformer {

    public void sort(List<Email> emails) {
        emails.sort(Comparator.comparing(Email::getDomainName).thenComparing(Email::getUsername));
    }
}
