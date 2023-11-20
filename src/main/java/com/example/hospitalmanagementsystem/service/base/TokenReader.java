package com.example.hospitalmanagementsystem.service.base;

public interface TokenReader <T> {

    T read(String token);

}
