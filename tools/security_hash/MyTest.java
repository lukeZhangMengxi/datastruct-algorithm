package tools.security_hash;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.security.NoSuchAlgorithmException;

import org.junit.Test;

public class MyTest {

    String MD5WithoutSalt    = "48503dfd58720bd5ff35c102065a52d7";
    String SHA512WithoutSalt = "8b5379d82d16e4c1fbe6aeb16b494da8bc11077571c994b47aafb8150abb4beeaa7ed43023edaebdfada54d003d402a1765a25e07f5b4009abbce83eb8acb19a";
    
    @Test
    public void md5() throws NoSuchAlgorithmException {
        
        assertEquals(MD5WithoutSalt, MyAPI.encode("MyPassword", "MD5", null));
        System.out.println(MyAPI.encode("MyPassword", "MD5", null));

        byte[] salt = MyAPI.getSalt();
        assertNotEquals(MD5WithoutSalt, MyAPI.encode("MyPassword", "MD5", salt));
        assertEquals(MyAPI.encode("MyPassword", "MD5", salt), MyAPI.encode("MyPassword", "MD5", salt));
        System.out.println(MyAPI.encode("MyPassword", "MD5", salt));
    }

    @Test
    public void sha512() throws NoSuchAlgorithmException {
        
        assertEquals(SHA512WithoutSalt, MyAPI.encode("MyPassword", "SHA-512", null));
        System.out.println(MyAPI.encode("MyPassword", "SHA-512", null));

        byte[] salt = MyAPI.getSalt();
        assertNotEquals(SHA512WithoutSalt, MyAPI.encode("MyPassword", "SHA-512", salt));
        assertEquals(MyAPI.encode("MyPassword", "SHA-512", salt), MyAPI.encode("MyPassword", "SHA-512", salt));
        System.out.println(MyAPI.encode("MyPassword", "SHA-512", salt));
    }
}
