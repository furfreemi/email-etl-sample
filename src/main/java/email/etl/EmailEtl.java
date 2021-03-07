package email.etl;

import email.model.Email;
import email.service.EmailExtractor;
import email.service.EmailDomainSortTransformer;
import email.service.EmailLoader;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmailEtl {

    private final EmailExtractor extractor;
    private final EmailDomainSortTransformer transformer;
    private final EmailLoader loader;
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    public EmailEtl(EmailExtractor extractor, EmailDomainSortTransformer transformer, EmailLoader loader) {
        this.extractor = extractor;
        this.transformer = transformer;
        this.loader = loader;
    }

    public void extractTransformLoad() {
        try {
            List<Email> emails = extractor.read();
            transformer.sort(emails);
            loader.write(emails);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Unable to complete ETL operation. Exception: " + e.getMessage(), e);
        }
    }
}
