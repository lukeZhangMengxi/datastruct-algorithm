package tools.open_saml.src;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.util.Base64;

import org.junit.Before;
import org.junit.Test;
import org.opensaml.core.config.InitializationException;
import org.opensaml.core.xml.config.XMLObjectProviderRegistrySupport;
import org.opensaml.core.xml.io.UnmarshallingException;
import org.opensaml.core.xml.util.XMLObjectSupport;
import org.opensaml.saml.saml2.core.Response;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import net.shibboleth.utilities.java.support.component.ComponentInitializationException;
import net.shibboleth.utilities.java.support.xml.BasicParserPool;
import net.shibboleth.utilities.java.support.xml.XMLParserException;

public class ParseXML {

    private BasicParserPool domParser;

    private static final String AN_ENCODED_RESPONSE = "PHNhbWxwOlJlc3BvbnNlIElEPSJfMTEzMjlhZjQtYTdkMC00MDkwLTg3N2QtYTJkNWNlYWRlZWU0IiBWZXJzaW9uPSIyLjAiIElzc3VlSW5zdGFudD0iMjAxNi0wMy0yMVQxNjo1MDo0Ny4zOTlaIiBEZXN0aW5hdGlvbj0iaHR0cHM6Ly9sb2NhbGhvc3Q6ODQ0My9yZXN0L3NlYXJjaC9sb2dpbi9hZGZzIiBDb25zZW50PSJ1cm46b2FzaXM6bmFtZXM6dGM6U0FNTDoyLjA6Y29uc2VudDp1bnNwZWNpZmllZCIgSW5SZXNwb25zZVRvPSJ6ZjE3MDkyNGItZjVlYy00Y2I1LWE5YWUtMmFiMmNmZDcxNGQzIiB4bWxuczpzYW1scD0idXJuOm9hc2lzOm5hbWVzOnRjOlNBTUw6Mi4wOnByb3RvY29sIj48SXNzdWVyIHhtbG5zPSJ1cm46b2FzaXM6bmFtZXM6dGM6U0FNTDoyLjA6YXNzZXJ0aW9uIj5odHRwOi8vYWRmczAxLmRldi5jb3Zlby5jb20vYWRmcy9zZXJ2aWNlcy90cnVzdDwvSXNzdWVyPjxzYW1scDpTdGF0dXM+PHNhbWxwOlN0YXR1c0NvZGUgVmFsdWU9InVybjpvYXNpczpuYW1lczp0YzpTQU1MOjIuMDpzdGF0dXM6U3VjY2VzcyIgLz48L3NhbWxwOlN0YXR1cz48QXNzZXJ0aW9uIElEPSJfYTg4MGU1M2QtMTVhMC00ZDNiLTk5NDEtZWExMWY4MTBhODhkIiBJc3N1ZUluc3RhbnQ9IjIwMTYtMDMtMjFUMTY6NTA6NDcuMzk5WiIgVmVyc2lvbj0iMi4wIiB4bWxucz0idXJuOm9hc2lzOm5hbWVzOnRjOlNBTUw6Mi4wOmFzc2VydGlvbiI+PElzc3Vlcj5odHRwOi8vYWRmczAxLmRldi5jb3Zlby5jb20vYWRmcy9zZXJ2aWNlcy90cnVzdDwvSXNzdWVyPjxkczpTaWduYXR1cmUgeG1sbnM6ZHM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvMDkveG1sZHNpZyMiPjxkczpTaWduZWRJbmZvPjxkczpDYW5vbmljYWxpemF0aW9uTWV0aG9kIEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvMjAwMS8xMC94bWwtZXhjLWMxNG4jIiAvPjxkczpTaWduYXR1cmVNZXRob2QgQWxnb3JpdGhtPSJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGRzaWctbW9yZSNyc2Etc2hhMjU2IiAvPjxkczpSZWZlcmVuY2UgVVJJPSIjX2E4ODBlNTNkLTE1YTAtNGQzYi05OTQxLWVhMTFmODEwYTg4ZCI+PGRzOlRyYW5zZm9ybXM+PGRzOlRyYW5zZm9ybSBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvMDkveG1sZHNpZyNlbnZlbG9wZWQtc2lnbmF0dXJlIiAvPjxkczpUcmFuc2Zvcm0gQWxnb3JpdGhtPSJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzEwL3htbC1leGMtYzE0biMiIC8+PC9kczpUcmFuc2Zvcm1zPjxkczpEaWdlc3RNZXRob2QgQWxnb3JpdGhtPSJodHRwOi8vd3d3LnczLm9yZy8yMDAxLzA0L3htbGVuYyNzaGEyNTYiIC8+PGRzOkRpZ2VzdFZhbHVlPlRlbzBFdk5kU1BLUVZsV0R4bVJ1RlBPU3pFS0ROYU5TMzllejIybGJDdVU9PC9kczpEaWdlc3RWYWx1ZT48L2RzOlJlZmVyZW5jZT48L2RzOlNpZ25lZEluZm8+PGRzOlNpZ25hdHVyZVZhbHVlPnFXOW1wK2tPNTdvK2k3cUJ5RXhsQmZUYnlnTHVENjU2N3RibWlodXFOQ3lxNnZQbFp4WW9XQkIybHpYR2VmaDh6cTRYOStHcWtxMXhSVElDemNNUmhjYTZPaVF2eWd3NWQzZ2NtLzh3bG9remFZQmJDeHdzTUFpNUMwMk4xb3hqTXZsU2xOdkUzN0piMXI5cDdyOGZNeEJreVBwUFFDa3RRYnFLUXk3TTBvWmhQaVpjMVRpMXZ3c0xvbWJVc3hCVzl0RzJ5WTlKVU9QK2dKak82SStUV2IrS0lzWTBGS21pN1hXK3dmSDNpaTI0RTFUVkh5LzYvandtUzlhVjJrZ2RjVXNvN3FYZVpQZ2JsTy9JM2VaQzBHQUp1bFErcEtjS2V2ZEd2c2JWM25HQmY0M3BZcnVzRTM1ZXo1WTRBdFNiNjRUaE1mT1I1c3lER0lpTkEzL29IZz09PC9kczpTaWduYXR1cmVWYWx1ZT48S2V5SW5mbyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC8wOS94bWxkc2lnIyI+PGRzOlg1MDlEYXRhPjxkczpYNTA5Q2VydGlmaWNhdGU+TUlJQzVqQ0NBYzZnQXdJQkFnSVFjd0Y4ektkZ2hMRkRKWUtNdW5heGpqQU5CZ2txaGtpRzl3MEJBUXNGQURBdU1Td3dLZ1lEVlFRREV5TkJSRVpUSUZOcFoyNXBibWNnTFNCaFpHWnpNREV1WkdWMkxtTnZkbVZ2TG1OdmJUQWdGdzB4TkRBME1UUXhOVEF6TkRaYUdBOHlNVEUwTURNeU1URTFNRE0wTmxvd0xqRXNNQ29HQTFVRUF4TWpRVVJHVXlCVGFXZHVhVzVuSUMwZ1lXUm1jekF4TG1SbGRpNWpiM1psYnk1amIyMHdnZ0VpTUEwR0NTcUdTSWIzRFFFQkFRVUFBNElCRHdBd2dnRUtBb0lCQVFDenJidEhBMklMcnpUTmsrU2ZEd1dVaG42Rk1uVDFFZUFianNYaDVwd3NCZmUwOGhobDJXTWZIWktGZlNVNk1wRk0xVDdlNERjSDNINldibmY2WTNUeG82aVI2ZWpRaExxWVdPQlNTSFM0T0hXeE1hY3o2MUViOFc1MXhwOW9DZnpocmFJSnJJeFhKcXJFVzhZVkZObmtrUTg0UUxYZVpPT3RWUnE0UTJ5azNOUE56RUF6aVlUazRoK01WQlJ5SUwvaFFjcTcrRGVhTE0weDRUZnY4c1VHVU9QQThjMEVybXNFVURrS3pxM242dENCZG05SEFielVWcU5FenBQcEs0T0ovR01zdHFyeXF0dStPYzJ4ZERMMVZZTVhZU1ZzbHJIRFc1b2ZWTGlML3kyQS9BMXpBNmRHbExOZm1WV1JwOGJIS0ZpVlJabTFrKzlmYzNicHdnSVJBZ01CQUFFd0RRWUpLb1pJaHZjTkFRRUxCUUFEZ2dFQkFGSWN1M09FQ1JEY1paT3BWaUNFRy9vRWU2UDJaWUZBSlJOUVNiS3cvUWhQOWlJVDJwbGJod3p0S0ZzckFoSTZmOXI4a2VDNnhmVitnMzdRWHJyL2dWVTR5SGIyUFQ4YjllYStuWStWM2FNeCt5RlF3K1djd3A0U1k3cTRMTnc0RVA4aHR6ejEzZnRiTTh0SUN1bytneGpLQ2FjZkhVZmFIOUZqUWRTUExrejNWZGZiSTVrbUdFc1RCVzEvQzBNR2cwc2o1MnkwM1BFYWxQQ09oRmNla01nU1hPdmh2enN0WkhFaENBaEtlbkdaME9iQ0I5RHZhUHFzN3ZiUlBtTUdFVjJwbUU0MHVqRlRORHBzNUVTaCs5MFk5Slh1U2lUVEpLTnB2K1ZhRmIyQnAyOWZuWXR3SGVXQXBWeXppdENsQlZqbFN5Z3l0dGliTjl0d2xMOXFNVnc9PC9kczpYNTA5Q2VydGlmaWNhdGU+PC9kczpYNTA5RGF0YT48L0tleUluZm8+PC9kczpTaWduYXR1cmU+PFN1YmplY3Q+PE5hbWVJRD5tbGFwb3J0ZUBjb3Zlby5jb208L05hbWVJRD48U3ViamVjdENvbmZpcm1hdGlvbiBNZXRob2Q9InVybjpvYXNpczpuYW1lczp0YzpTQU1MOjIuMDpjbTpiZWFyZXIiPjxTdWJqZWN0Q29uZmlybWF0aW9uRGF0YSBJblJlc3BvbnNlVG89InpmMTcwOTI0Yi1mNWVjLTRjYjUtYTlhZS0yYWIyY2ZkNzE0ZDMiIE5vdE9uT3JBZnRlcj0iMjAxNi0wMy0yMVQxNjo1NTo0Ny4zOTlaIiBSZWNpcGllbnQ9Imh0dHBzOi8vbG9jYWxob3N0Ojg0NDMvcmVzdC9zZWFyY2gvbG9naW4vYWRmcyIgLz48L1N1YmplY3RDb25maXJtYXRpb24+PC9TdWJqZWN0PjxDb25kaXRpb25zIE5vdEJlZm9yZT0iMjAxNi0wMy0yMVQxNjo1MDo0Ny4zODNaIiBOb3RPbk9yQWZ0ZXI9IjIwMTYtMDMtMjFUMTc6NTA6NDcuMzgzWiI+PEF1ZGllbmNlUmVzdHJpY3Rpb24+PEF1ZGllbmNlPmh0dHBzOi8vbG9jYWxob3N0Ojg0NDM8L0F1ZGllbmNlPjwvQXVkaWVuY2VSZXN0cmljdGlvbj48L0NvbmRpdGlvbnM+PEF0dHJpYnV0ZVN0YXRlbWVudD48QXR0cmlidXRlIE5hbWU9Imh0dHA6Ly9zY2hlbWFzLnhtbHNvYXAub3JnL3dzLzIwMDUvMDUvaWRlbnRpdHkvY2xhaW1zL3VwbiI+PEF0dHJpYnV0ZVZhbHVlPm1sYXBvcnRlQGNvdmVvLmNvbTwvQXR0cmlidXRlVmFsdWU+PC9BdHRyaWJ1dGU+PC9BdHRyaWJ1dGVTdGF0ZW1lbnQ+PEF1dGhuU3RhdGVtZW50IEF1dGhuSW5zdGFudD0iMjAxNi0wMy0yMVQwOTo0NjoxNy4yMzFaIiBTZXNzaW9uSW5kZXg9Il9hODgwZTUzZC0xNWEwLTRkM2ItOTk0MS1lYTExZjgxMGE4OGQiPjxBdXRobkNvbnRleHQ+PEF1dGhuQ29udGV4dENsYXNzUmVmPnVybjpvYXNpczpuYW1lczp0YzpTQU1MOjIuMDphYzpjbGFzc2VzOlBhc3N3b3JkUHJvdGVjdGVkVHJhbnNwb3J0PC9BdXRobkNvbnRleHRDbGFzc1JlZj48L0F1dGhuQ29udGV4dD48L0F1dGhuU3RhdGVtZW50PjwvQXNzZXJ0aW9uPjwvc2FtbHA6UmVzcG9uc2U+";
    private static final String AN_RESPONSE = "<samlp:Response ID=\"_11329af4-a7d0-4090-877d-a2d5ceadeee4\" Version=\"2.0\" IssueInstant=\"2016-03-21T16:50:47.399Z\" Destination=\"https://localhost:8443/rest/search/login/adfs\" Consent=\"urn:oasis:names:tc:SAML:2.0:consent:unspecified\" InResponseTo=\"zf170924b-f5ec-4cb5-a9ae-2ab2cfd714d3\" xmlns:samlp=\"urn:oasis:names:tc:SAML:2.0:protocol\"><Issuer xmlns=\"urn:oasis:names:tc:SAML:2.0:assertion\">http://adfs01.dev.coveo.com/adfs/services/trust</Issuer><samlp:Status><samlp:StatusCode Value=\"urn:oasis:names:tc:SAML:2.0:status:Success\" /></samlp:Status><Assertion ID=\"_a880e53d-15a0-4d3b-9941-ea11f810a88d\" IssueInstant=\"2016-03-21T16:50:47.399Z\" Version=\"2.0\" xmlns=\"urn:oasis:names:tc:SAML:2.0:assertion\"><Issuer>http://adfs01.dev.coveo.com/adfs/services/trust</Issuer><ds:Signature xmlns:ds=\"http://www.w3.org/2000/09/xmldsig#\"><ds:SignedInfo><ds:CanonicalizationMethod Algorithm=\"http://www.w3.org/2001/10/xml-exc-c14n#\" /><ds:SignatureMethod Algorithm=\"http://www.w3.org/2001/04/xmldsig-more#rsa-sha256\" /><ds:Reference URI=\"#_a880e53d-15a0-4d3b-9941-ea11f810a88d\"><ds:Transforms><ds:Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\" /><ds:Transform Algorithm=\"http://www.w3.org/2001/10/xml-exc-c14n#\" /></ds:Transforms><ds:DigestMethod Algorithm=\"http://www.w3.org/2001/04/xmlenc#sha256\" /><ds:DigestValue>Teo0EvNdSPKQVlWDxmRuFPOSzEKDNaNS39ez22lbCuU=</ds:DigestValue></ds:Reference></ds:SignedInfo><ds:SignatureValue>qW9mp+kO57o+i7qByExlBfTbygLuD6567tbmihuqNCyq6vPlZxYoWBB2lzXGefh8zq4X9+Gqkq1xRTICzcMRhca6OiQvygw5d3gcm/8wlokzaYBbCxwsMAi5C02N1oxjMvlSlNvE37Jb1r9p7r8fMxBkyPpPQCktQbqKQy7M0oZhPiZc1Ti1vwsLombUsxBW9tG2yY9JUOP+gJjO6I+TWb+KIsY0FKmi7XW+wfH3ii24E1TVHy/6/jwmS9aV2kgdcUso7qXeZPgblO/I3eZC0GAJulQ+pKcKevdGvsbV3nGBf43pYrusE35ez5Y4AtSb64ThMfOR5syDGIiNA3/oHg==</ds:SignatureValue><KeyInfo xmlns=\"http://www.w3.org/2000/09/xmldsig#\"><ds:X509Data><ds:X509Certificate>MIIC5jCCAc6gAwIBAgIQcwF8zKdghLFDJYKMunaxjjANBgkqhkiG9w0BAQsFADAuMSwwKgYDVQQDEyNBREZTIFNpZ25pbmcgLSBhZGZzMDEuZGV2LmNvdmVvLmNvbTAgFw0xNDA0MTQxNTAzNDZaGA8yMTE0MDMyMTE1MDM0NlowLjEsMCoGA1UEAxMjQURGUyBTaWduaW5nIC0gYWRmczAxLmRldi5jb3Zlby5jb20wggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCzrbtHA2ILrzTNk+SfDwWUhn6FMnT1EeAbjsXh5pwsBfe08hhl2WMfHZKFfSU6MpFM1T7e4DcH3H6Wbnf6Y3Txo6iR6ejQhLqYWOBSSHS4OHWxMacz61Eb8W51xp9oCfzhraIJrIxXJqrEW8YVFNnkkQ84QLXeZOOtVRq4Q2yk3NPNzEAziYTk4h+MVBRyIL/hQcq7+DeaLM0x4Tfv8sUGUOPA8c0ErmsEUDkKzq3n6tCBdm9HAbzUVqNEzpPpK4OJ/GMstqryqtu+Oc2xdDL1VYMXYSVslrHDW5ofVLiL/y2A/A1zA6dGlLNfmVWRp8bHKFiVRZm1k+9fc3bpwgIRAgMBAAEwDQYJKoZIhvcNAQELBQADggEBAFIcu3OECRDcZZOpViCEG/oEe6P2ZYFAJRNQSbKw/QhP9iIT2plbhwztKFsrAhI6f9r8keC6xfV+g37QXrr/gVU4yHb2PT8b9ea+nY+V3aMx+yFQw+Wcwp4SY7q4LNw4EP8htzz13ftbM8tICuo+gxjKCacfHUfaH9FjQdSPLkz3VdfbI5kmGEsTBW1/C0MGg0sj52y03PEalPCOhFcekMgSXOvhvzstZHEhCAhKenGZ0ObCB9DvaPqs7vbRPmMGEV2pmE40ujFTNDps5ESh+90Y9JXuSiTTJKNpv+VaFb2Bp29fnYtwHeWApVyzitClBVjlSygyttibN9twlL9qMVw=</ds:X509Certificate></ds:X509Data></KeyInfo></ds:Signature><Subject><NameID>mlaporte@coveo.com</NameID><SubjectConfirmation Method=\"urn:oasis:names:tc:SAML:2.0:cm:bearer\"><SubjectConfirmationData InResponseTo=\"zf170924b-f5ec-4cb5-a9ae-2ab2cfd714d3\" NotOnOrAfter=\"2016-03-21T16:55:47.399Z\" Recipient=\"https://localhost:8443/rest/search/login/adfs\" /></SubjectConfirmation></Subject><Conditions NotBefore=\"2016-03-21T16:50:47.383Z\" NotOnOrAfter=\"2016-03-21T17:50:47.383Z\"><AudienceRestriction><Audience>https://localhost:8443</Audience></AudienceRestriction></Conditions><AttributeStatement><Attribute Name=\"http://schemas.xmlsoap.org/ws/2005/05/identity/claims/upn\"><AttributeValue>mlaporte@coveo.com</AttributeValue></Attribute></AttributeStatement><AuthnStatement AuthnInstant=\"2016-03-21T09:46:17.231Z\" SessionIndex=\"_a880e53d-15a0-4d3b-9941-ea11f810a88d\"><AuthnContext><AuthnContextClassRef>urn:oasis:names:tc:SAML:2.0:ac:classes:PasswordProtectedTransport</AuthnContextClassRef></AuthnContext></AuthnStatement></Assertion></samlp:Response>";

    @Before
    public void init() throws ComponentInitializationException, InitializationException {
        domParser = new BasicParserPool();
        domParser.initialize();
        // InitializationService.initialize();
    }

    @Test
    public void base64Decode() {
        String decodedString = new String(Base64.getDecoder().decode(AN_ENCODED_RESPONSE));
        assertEquals(AN_RESPONSE, decodedString);
    }

    @Test
    public void parseToStructuredXML() throws XMLParserException {
        byte[] decodedBytes = Base64.getDecoder().decode(AN_ENCODED_RESPONSE);
        Document responseDocument = domParser.parse(new ByteArrayInputStream(decodedBytes));
        Element responseElement = responseDocument.getDocumentElement();

        assertEquals("https://localhost:8443/rest/search/login/adfs", responseElement.getAttribute("Destination"));

        assertEquals("urn:oasis:names:tc:SAML:2.0:consent:unspecified", responseElement.getAttribute("Consent"));
    }

    @Test
    public void parseToStructuredSAML() throws XMLParserException, UnmarshallingException {
        byte[] decodedBytes = Base64.getDecoder().decode(AN_ENCODED_RESPONSE);
        // Document responseDocument = domParser.parse(new ByteArrayInputStream(decodedBytes));
        // Element responseElement = responseDocument.getDocumentElement();

        Response rsp = (Response) XMLObjectSupport.unmarshallFromInputStream(
                XMLObjectProviderRegistrySupport.getParserPool(), new ByteArrayInputStream(decodedBytes));

        // Response rsp = (Response) (XMLObject) XMLObjectProviderRegistrySupport.getUnmarshallerFactory()
        //         .getUnmarshaller(responseDocument.getDocumentElement()).unmarshall(responseElement);
        
        rsp.getAssertions().get(0);
    }
}
