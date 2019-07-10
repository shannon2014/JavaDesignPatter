package com.my.shannon.dp.business.observepattern.pattern;

public interface Subject {
    void registerObserver(Observer o);
    void unregisterObserver(Observer o);
    void notifyObserver();

}
