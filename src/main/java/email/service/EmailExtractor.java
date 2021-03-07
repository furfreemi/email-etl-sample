package email.service;

import email.model.Email;
import org.apache.commons.validator.routines.EmailValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmailExtractor {

    private final Reader reader;

    public EmailExtractor(Reader reader) {
        this.reader = reader;
    }

    public List<Email> extractValid() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(reader); Stream<String> lines = bufferedReader.lines()) {
            return lines
                    .filter(EmailValidator.getInstance()::isValid)
                    .map(this::createEmail)
                    .collect(Collectors.toList());
        }
    }

    private Email createEmail(String line) {
        String[] emailComponents = line.split("@");
        return new Email(emailComponents[0], emailComponents[1]);
    }
}
