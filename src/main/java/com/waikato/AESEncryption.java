package main.java.com.waikato;

import main.java.com.waikato.domain.CBCEncryption;
import main.java.com.waikato.domain.CFBEncryption;
import main.java.com.waikato.domain.ECBEncryption;

/**
 * Entry point to run the AES encryption
 */
public class AESEncryption
{
    public static void main(String[] args) {
        ECBEncryption ecbEncryption = new ECBEncryption();
        ecbEncryption.encrypt();

        CBCEncryption cbcEncryption = new CBCEncryption();
        cbcEncryption.encrypt();

        CFBEncryption cfbEncryption = new CFBEncryption();
        cfbEncryption.encrypt();
    }
}
