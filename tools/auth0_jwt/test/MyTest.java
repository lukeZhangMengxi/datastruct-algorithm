package tools.auth0_jwt.test;

import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import org.junit.Test;

public class MyTest {

    String ISSUER = "mengxi", ATTRIBUTE = "attribute", VALUE = "attribute-value";
    Algorithm ALGORITHM = Algorithm.HMAC256("secret");

    JWTVerifier verifier = JWT.require(ALGORITHM).withIssuer(ISSUER).acceptLeeway(30).build();

    @Test
    public void createAndVerifyToken() {
        String out = JWT.create()
            .withIssuer(ISSUER)
            .withClaim(ATTRIBUTE, VALUE)
            .withExpiresAt(new Date(System.currentTimeMillis() + (long)0.5*60*60*1000))
            .sign(ALGORITHM);

        DecodedJWT jwt = verifier.verify(out);

        assert(jwt.getClaim("attribute").asString().equals(VALUE));
        System.out.println(jwt.getExpiresAt());
    }

    @Test(expected = JWTDecodeException.class)
    public void verifyBadFormatToken() { verifier.verify("wrong.token.part"); }

    @Test(expected = SignatureVerificationException.class)
    public void verifyBadToken() { verifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJtZW5neGkiLCJhdHRyaWJ1dGUiOiJhdHRyaWP9dGUtdmFsdWUifQ.G8lt4JgpbkJe8h6vRQCpl-LBFPjNUC_QKVOVYSc6yAk"); }

}
