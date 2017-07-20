package pers.chbrobin.study.pattern.proxy;

import java.util.Date;

/**
 * Created by chenhuibin on 2017/7/20 0020.
 */
public class HttpServer implements HttpPrinter {
    @Override
    public String outputHtml() {
        return "outputHtml";
    }
}
