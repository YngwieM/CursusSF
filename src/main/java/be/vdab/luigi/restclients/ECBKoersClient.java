package be.vdab.luigi.restclients;

import be.vdab.luigi.exceptions.KoersClientException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;

@Component
@Qualifier("ECB")
class ECBKoersClient implements KoersClient {
    private final URL url;
    private final XMLInputFactory factory = XMLInputFactory.newInstance();

    ECBKoersClient(@Value("${ecbKoersURL}") URL url) {
       this.url = url;
    }
    @Override
    public BigDecimal getDollarKoers() {
        try (var stream = url.openStream()) {
            var reader = factory.createXMLStreamReader(stream);
            while (reader.hasNext()) {
                if (reader.next() == XMLStreamConstants.START_ELEMENT
 && "USD".equals(reader.getAttributeValue(null, "currency"))) {
                    return new BigDecimal(reader.getAttributeValue(null, "rate"));
                }
            }
            throw new KoersClientException("XML van ECB bevat geen USD.");
        } catch (IOException | NumberFormatException | XMLStreamException ex) {
            throw new KoersClientException("Kan koers niet lezen via ECB.", ex);
        }
    }
}