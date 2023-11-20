package com.example.hospitalmanagementsystem.service.base;

public interface TokenGenerator <T> {

    String generate(T obj);

}
