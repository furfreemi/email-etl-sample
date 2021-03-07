package email.etl;

import email.model.Email;
import email.service.EmailDomainSortTransformer;
import email.service.EmailExtractor;
import email.service.EmailLoader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.mockito.Mockito.*;

class EmailEtlTest {

    @Test
    public void transformsAndLoadsExtractedData() throws IOException {
        EmailExtractor extractorMock = mock(EmailExtractor.class);
        EmailDomainSortTransformer transformerMock = mock(EmailDomainSortTransformer.class);
        EmailLoader loaderMock = mock(EmailLoader.class);
        List<Email> expectedList = List.of(new Email("aa", "example.com"));

        when(extractorMock.read()).thenReturn(expectedList);

        new EmailEtl(extractorMock, transformerMock, loaderMock).extractTransformLoad();

        verify(transformerMock).sort(expectedList);
        verify(loaderMock).write(expectedList);
    }
}