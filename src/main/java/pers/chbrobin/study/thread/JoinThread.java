package pers.chbrobin.study.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/5 0005.
 */
public class JoinThread extends Thread {
    private List<String> result = new ArrayList<String>();

    private String selfName;

    public JoinThread(String selfName) {
        super();
        this.selfName = selfName;
    }

    public void run() {
        for(int i=0;i<3;i++){
            result.add(this.selfName + "-data" + i);
        }
    }

    public List<String> getResult() {
        return result;
    }

    public void setResult(List<String> result) {
        this.result = result;
    }

    public String getSelfName() {
        return selfName;
    }

    public void setSelfName(String selfName) {
        this.selfName = selfName;
    }
}
