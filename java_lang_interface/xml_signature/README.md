## Sign XML envlope
```
$ javac GenEnveloped.java
$ java GenEnveloped envelope.xml envelopedSignature.xml
```
- Works when using `KeyPairGenerator.getInstance("RSA");`
- Getting error when using `KeyPairGenerator.getInstance("DSA");`:
    ```
    $ java GenEnveloped envelope.xml envelopedSignature.xml
    Exception in thread "main" javax.xml.crypto.dsig.XMLSignatureException: java.security.InvalidKeyException: No installed provider supports this key: sun.security.provider.DSAPrivateKey
        at java.xml.crypto/org.jcp.xml.dsig.internal.dom.DOMXMLSignature.sign(DOMXMLSignature.java:408)
        at GenEnveloped.main(GenEnveloped.java:130)
    Caused by: java.security.InvalidKeyException: No installed provider supports this key: sun.security.provider.DSAPrivateKey
        at java.base/java.security.Signature$Delegate.chooseProvider(Signature.java:1284)
        at java.base/java.security.Signature$Delegate.engineInitSign(Signature.java:1354)
        at java.base/java.security.Signature.initSign(Signature.java:636)
        at java.xml.crypto/org.jcp.xml.dsig.internal.dom.DOMSignatureMethod.sign(DOMSignatureMethod.java:335)
        at java.xml.crypto/org.jcp.xml.dsig.internal.dom.DOMXMLSignature.sign(DOMXMLSignature.java:405)
        ... 1 more
    java.security.InvalidKeyException: No installed provider supports this key: sun.security.provider.DSAPrivateKey
        at java.base/java.security.Signature$Delegate.chooseProvider(Signature.java:1284)
        at java.base/java.security.Signature$Delegate.engineInitSign(Signature.java:1354)
        at java.base/java.security.Signature.initSign(Signature.java:636)
        at java.xml.crypto/org.jcp.xml.dsig.internal.dom.DOMSignatureMethod.sign(DOMSignatureMethod.java:335)
        at java.xml.crypto/org.jcp.xml.dsig.internal.dom.DOMXMLSignature.sign(DOMXMLSignature.java:405)
        at GenEnveloped.main(GenEnveloped.java:130)
    ```
