package ru.netology.springauthorization.exceptions;


public class InvalidData extends RuntimeException {
    public InvalidData(String msg) {
        super(msg);
    }
}
