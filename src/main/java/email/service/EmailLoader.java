package email.service;

import email.model.Email;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class EmailLoader {

    private final Writer writer;

    public EmailLoader(Writer writer) {
        this.writer = writer;
    }

    public void write(List<Email> emails) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            for (int i = 0, emailsSize = emails.size(); i < emailsSize; i++) {
                Email email = emails.get(i);
                bufferedWriter.write(email.getEmailAddress());
                if (i < emailsSize - 1){
                    bufferedWriter.newLine();
                }
            }
        }
    }

}
