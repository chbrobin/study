package pers.chbrobin.study.effectivejava;

/**
 * Created by chenhuibin on 2017/7/15 0015.
 * 第6条：避免使用终结函数
 *
 * 时间关键的任务不应该由终结函数来完成
 * 我们不应该依赖一个终结函数来更新关键性的永久状态
 * 显式的终止方法通常与try-finally结构结合来使用，以确保及时终止
 * 终结函数与垃圾回收相关，但垃圾回收不是及时执行的
 *
 * finalize应用场景
 * 1、当对象的使用者忘记使用资源时，finalize 充当安全网角色，做最后一道防线
 * 2、释放本地方法申请的非关键资源
 * 3、记得重载父类finalize方法，系统并不会自动调用
 *
 * GC只回收new使用的内在，比如文件句柄、数据库连接，因此需要释放方法
 * 不能直接调用finaliz，因为垃圾回收会自动调用，这样会被执行两次，
 * 清理本地对象NI对象，作为确保某非内存资源补充
 */
public class Createanddestroy6Test {
}
