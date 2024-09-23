package org.example;

public abstract class ShowStrategy {
    public void show(){
        showName();
        showDescription();
    }

    public abstract void showName();
    public abstract void showDescription();
}

