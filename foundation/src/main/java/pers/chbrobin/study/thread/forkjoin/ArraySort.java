package pers.chbrobin.study.thread.forkjoin;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2017/7/8 0008.
 */
public class ArraySort {
    public static void main(String args[]) {
        String filePath = RandomDataGenrator.class.getClassLoader().getResource("").getPath();
        File f = new File(filePath + "../" + "randomData.txt");
        List arrayList = new ArrayList();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f));

            String str = null;
            while ((str = reader.readLine()) != null) {
                arrayList.add(Integer.valueOf(str));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        long startTime=System.currentTimeMillis();
        Collections.sort(arrayList);
        long endTime=System.currentTimeMillis();

        System.out.println("排序所花时间:"+(endTime-startTime)+"ms");

        File f2 = new File(filePath + "../" + "randomDataResult.txt");
        FileWriter writer2;
        try {
            writer2 = new FileWriter(f2, false);

            for (int i = 0; i < arrayList.size(); i++) {
                writer2.write(String.valueOf(arrayList.get(i)));
                writer2.write("\r\n");
            }

            writer2.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
