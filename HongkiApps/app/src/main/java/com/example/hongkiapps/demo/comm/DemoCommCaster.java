package com.example.hongkiapps.demo.comm;

public interface DemoCommCaster {
    void requestToAction(String message, Object caller);
    void addCommunicateListener(DemoCommListener listener);
    void removeCommunicateListener(DemoCommListener listener);
}