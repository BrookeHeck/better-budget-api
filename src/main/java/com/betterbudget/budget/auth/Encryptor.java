package com.betterbudget.budget.auth;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.SerializationUtils;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Configuration
@Converter
public class Encryptor implements AttributeConverter<Object, String> {

    @Value("${ENCRYPTION_KEY}")
    private String encryptionKey;
    private final String encryptionCipher = "AES";
    private Key key;
    private Cipher cipher;

    @SneakyThrows
    @Override
    public String convertToDatabaseColumn(Object attribute) {
        if(attribute == null) return null;
        initCipher(Cipher.ENCRYPT_MODE);
        byte[] bytes = SerializationUtils.serialize(attribute);
        if(bytes == null) return null;
        return Base64.getEncoder().encodeToString(getCipher().doFinal(bytes));
    }

    @SneakyThrows
    @Override
    public Object convertToEntityAttribute(String dbData) {
        if(dbData == null) return null;
        initCipher(Cipher.DECRYPT_MODE);
        byte[] bytes = getCipher().doFinal(Base64.getDecoder().decode(dbData));
        if(bytes == null) return null;
        return SerializationUtils.serialize(bytes);
    }

    private void initCipher(int encryptMode) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        getCipher().init(encryptMode, getKey());
    }

    private Key getKey() {
        if(key == null) {
            key = new SecretKeySpec(encryptionKey.getBytes(), encryptionCipher);
        }
        return key;
    }

    private Cipher getCipher() throws NoSuchPaddingException, NoSuchAlgorithmException {
        if(cipher == null) {
            cipher = Cipher.getInstance(encryptionCipher);
        }
        return cipher;
    }
}
