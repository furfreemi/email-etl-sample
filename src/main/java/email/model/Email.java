package email.model;

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
}


