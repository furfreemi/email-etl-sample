package email.model;

import java.util.Objects;

public class Email {

    private final String domainName;
    private final String username;

    public Email(String username, String domainName) throws IllegalArgumentException {
        this.username = username;
        this.domainName = domainName;
    }

    public String getDomainName() {
        return domainName;
    }

    public String getUsername() {
        return username;
    }

    public String getEmailAddress() {
        return username + '@' + domainName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(domainName, email.domainName) && Objects.equals(username, email.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(domainName, username);
    }
}


