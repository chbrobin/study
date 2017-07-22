package pers.chbrobin.study.pattern.abstractFactory;

/**
 * Created by Administrator on 2017/7/22 0022.
 */
public abstract class PenFactory {
   public Pen createPen(String name){
      if("pencil".equals(name)) {
         return new Pencil();
      } else if("fountain".equals(name)) {
         return new FountainPen();
      }
      return null;
   }
}
