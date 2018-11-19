package cn.ccut.observer;

import java.util.ArrayList;

/**
 * Subject
 * @author zhipeng_Tong
 */
public abstract class Subject {
    private ArrayList<Observer> observers = new ArrayList<>();

    // 添加观察者
    public void add(Observer observer) {
        observers.add(observer);
    }

    // 移除观察者
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    // 通知
    public void toNotify() {
        for (Observer observer : observers)
            observer.update();
    }
}
