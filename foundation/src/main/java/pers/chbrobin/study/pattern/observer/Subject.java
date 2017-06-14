package pers.chbrobin.study.pattern.observer;

/**
 * Created by Administrator on 2017/6/12 0012.
 */
public interface Subject {
    public void attach(Observer observer);

    public void detach(Observer observer);

    void notifyObservers();
}
