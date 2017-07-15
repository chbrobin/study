package pers.chbrobin.study.effectivejava;

/**
 * Created by chenhuibin on 2017/7/15 0015.
 * 第3条：通过私有构造函数强化不可实例化的能力
 *
 * 企图通过将一个类做成抽象类来强制该类不可被实例化，这是行不通的
 * 该类可以被子类实例化，并且该子类也可以被实例化
 *
 * 我们只要让这个类包含单个显式的私有构造函数，则它就不可被实例化了
 */
public class Createanddestroy3Test {
}
