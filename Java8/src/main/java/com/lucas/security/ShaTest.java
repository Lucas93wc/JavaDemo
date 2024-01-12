package com.lucas.security;

import javax.xml.bind.DatatypeConverter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Lucas
 * @Description TODO
 * @date 2021-12-15 15:26
 */
public class ShaTest {
    public static void main(String[] args) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            File file = new File("D:\\安装文件\\jdk-11.0.5\\jdk-11.0.5_windows-x64_bin.zip");
            digest.update(Files.readAllBytes(file.toPath()));
            byte[] bytes = digest.digest();
            String result = DatatypeConverter.printHexBinary(bytes).toLowerCase();
            System.out.println(result);
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }

    }
}
