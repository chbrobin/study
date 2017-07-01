package pers.chbrobin.study.jdk.unsafe;

/**
 * Created by chenhuibin on 2017/7/1 0001.
 */
public class UnsafeObject {
    private String strObj;
    private Long longObj;
    private boolean booleanObj;

    public String getStrObj() {
        return strObj;
    }

    public void setStrObj(String strObj) {
        this.strObj = strObj;
    }

    public Long getLongObj() {
        return longObj;
    }

    public void setLongObj(Long longObj) {
        this.longObj = longObj;
    }

    public boolean isBooleanObj() {
        return booleanObj;
    }

    public void setBooleanObj(boolean booleanObj) {
        this.booleanObj = booleanObj;
    }

    @Override
    public String toString() {
        return strObj + " " + longObj + " " + booleanObj;
    }
}