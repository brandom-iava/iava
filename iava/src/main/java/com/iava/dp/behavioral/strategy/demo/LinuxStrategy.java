package com.iava.dp.behavioral.strategy.demo;

public class LinuxStrategy extends TextStrategy {
    public LinuxStrategy(String text) {
        super(text);
    }
                                                                                
    public String replace() {
        preOperation();
        System.out.println(_text = _text.replaceAll("@r@n", "@n"));
        postOperation();
                                                                                
        return _text;
    }
                                                                                
    private void preOperation() {
        System.out.println("LinuxStrategy preOperation");
    }
                                                                                
    private void postOperation() {
        System.out.println("LinuxStrategy postOperation");
    }
}

