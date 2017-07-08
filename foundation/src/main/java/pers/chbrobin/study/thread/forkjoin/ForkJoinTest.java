package pers.chbrobin.study.thread.forkjoin;

import java.util.concurrent.ForkJoinPool;

/**
 * Created by chenhuibin on 2017/7/8 0008.
 * Fork/Join并行方式是获取良好的并行计算性能的一种最简单同时也是最有效的设计技术。
 * Fork/Join并行算法是我们所熟悉的分治算法的并行版本
 * 主要应用场景：累加、归并排序
 */
public class ForkJoinTest {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
    }
}
