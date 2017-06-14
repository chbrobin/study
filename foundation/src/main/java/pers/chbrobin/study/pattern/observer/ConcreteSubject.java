package pers.chbrobin.study.pattern.observer;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by Administrator on 2017/6/12 0012.
 */
public class ConcreteSubject implements Subject {
    private Vector observersVector = new java.util.Vector();

    public void attach(Observer observer)
        {  //添加观察者
                observersVector.addElement(observer);
            }

        public void detach(Observer observer)
        { //删除该观察者
                observersVector.removeElement(observer);
            }

        public void notifyObservers()
        {  //遍历观察者向量，通知每个观察者
                Enumeration enumeration = observers();
                while (enumeration.hasMoreElements())
                {
                        ((Observer)enumeration.nextElement()).update();
                    }
            }

        public Enumeration observers()
        {
                return ((Vector) observersVector.clone()).elements();
        }
}
