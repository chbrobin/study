package pers.chbrobin.study.thread.forkjoin;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

/**
 * Created by Administrator on 2017/7/8 0008.
 */
public class RandomDataGenrator {
    public static void main(String[] args) {
        String filePath = RandomDataGenrator.class.getClassLoader().getResource("").getPath();
        filePath = filePath + "../" + "randomData.txt";
        File f = new File(filePath);
        FileWriter writer;
        try {
            writer = new FileWriter(f, false);

            Random random1 = new Random(10);

            for (int i = 0; i < 10000000; i++) {
                writer.write(String.valueOf(random1.nextInt(20000)));
                writer.write("\r\n");
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
