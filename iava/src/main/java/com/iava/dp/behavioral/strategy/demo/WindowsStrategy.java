package com.iava.dp.behavioral.strategy.demo;

public class WindowsStrategy extends TextStrategy {
    public WindowsStrategy(String text) {
        super(text);
    }
                                                                                
    public String replace() {
        startOperation();
        System.out.println(_text = _text.replaceAll("@n", "@r@n"));
        endOperation();
                                                                                
        return _text;
    }
                                                                                
    private void startOperation() {
        System.out.println("WindowsStrategy startOperation");
    }
                                                                                
    private void endOperation() {
        System.out.println("WindowsStrategy endOperation");
    }
}

