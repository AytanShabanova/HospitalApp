package com.example.hospitalmanagementsystem;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class HospitalManagementSystemApplication  {

    public static void main(String[] args) {
        SpringApplication.run(HospitalManagementSystemApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
//        generator.initialize(2048);
//        KeyPair pair = generator.generateKeyPair();
//        PrivateKey privateKey = pair.getPrivate();
//        String s= Base64.getEncoder().encodeToString(privateKey.getEncoded());
//        System.out.println("private--"+s);
//        PublicKey publicKey = pair.getPublic();
//        String publicKey1=Base64.getEncoder().encodeToString(publicKey.getEncoded());
//        System.out.println("public__"+publicKey1);
//    }
}
