package pers.chbrobin.study.pattern.proxy;

/**
 * Created by chenhuibin on 2017/6/25 0025.
 */
public class ProxyTest {
    public static void main(String[] args) throws Exception {
        HttpPrinter httpPrinter = new HttpProxy();
        for(int i = 0; i < 20; i++) {
            httpPrinter.outputHtml();
            Thread.sleep(500);
            System.out.println("iii " + i);
        }
    }
}
