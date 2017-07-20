package pers.chbrobin.study.pattern.proxy;

import java.util.*;

/**
 * Created by chenhuibin on 2017/7/20 0020.
 */
public class HttpProxy implements HttpPrinter {
    HttpServer httpServer;

    Map<String, String> contentCache = new HashMap<>();

    public HttpProxy() {
        httpServer = new HttpServer();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                contentCache.clear();
            }
        }, 1000, 3000);
    }

    @Override
    public String outputHtml() {
        String key = "house_" + new Date().getHours();
        String content = contentCache.get(key);
        if(content != null) {
            System.out.println("outputHtml from HttpProxy");
            return content;
        }
        content = httpServer.outputHtml();
        contentCache.put(key, content);
        System.out.println("outputHtml from httpServer");
        return content;
    }
}
