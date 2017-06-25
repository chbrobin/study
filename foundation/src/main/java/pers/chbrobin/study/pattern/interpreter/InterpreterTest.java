package pers.chbrobin.study.pattern.interpreter;

/**
 * Created by Administrator on 2017/6/11 0011.
 * 给定一个语言，定义它的文法的一种表示，并定义一个解释器，
 * 这个解释器使用该表示来解 释语言中的句子
 *
 * 解释器模式需要解决的是，如果一种特定类型的问题发生的频率足够高，
 * 那么可能就值得将该问题的各个实例表述为一个简单语言中的句子]
 *
 * 可以将一个需要解释执行的语言中的句子表示为一个抽象语法树
 *  一些重复出现的问题可以用一种简单的语言来进行表达
 *  一个语言的文法较为简单
 *  执行效率不是关键问题。【注：高效的解释器通常不是通过直接解释抽象语法树来实现的，
 *  而是需要将它们转换成其他形式，使用解释器模式的执行效率并不高。】
 *
 *  JDK应用场景
 *  @see java.util.regex.Pattern
 *  @see java.text.Normalizer
 *  @see java.text.Format
 *
 *  开源项目 Expression4J、MESP（Math Expression    String Parser）、Jep
 */
public class InterpreterTest {
}
