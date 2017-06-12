package pers.chbrobin.study.pattern.template;

/**
 * Created by Administrator on 2017/6/12 0012.
 */
public abstract class AbstractPerson {
    
    public abstract void dressing();

    
    public abstract void eating();

    
    public abstract void lodging();

    
    public abstract void walking();

    public void living() {
        dressing();
        eating();
        lodging();
        walking();
    }
}
