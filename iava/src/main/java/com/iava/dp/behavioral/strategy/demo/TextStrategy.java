package com.iava.dp.behavioral.strategy.demo;

public abstract class TextStrategy {
    protected String _text;
                                                                                
    public TextStrategy(String text) {
        _text = text;
    }
                                                                                
    public abstract String replace();
}

