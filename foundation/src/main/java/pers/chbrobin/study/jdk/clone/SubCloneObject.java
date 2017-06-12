package pers.chbrobin.study.jdk.clone;

import sun.util.calendar.BaseCalendar;

/**
 * Created by Administrator on 2017/6/5 0005.
 */
public class SubCloneObject implements Cloneable {
    private Long longVar;

    public SubCloneObject(Long longVar) {
        this.longVar = longVar;
    }

    public Long getLongVar() {
        return longVar;
    }

    public void setLongVar(Long longVar) {
        this.longVar = longVar;
    }

    @Override
    public Object clone() {
        SubCloneObject d = null;
        try {
            d = (SubCloneObject)super.clone();
        } catch (CloneNotSupportedException e) {} // Won't happen
        return d;
    }
}
