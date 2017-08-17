package pers.chbrobin.nosql.hadoop;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;

/**
 * 文件上传
 * Created by chenhuibin on 2017/8/16 0016.
 */
public class HdfsTest {
    public static void main(String[] args) throws Exception {
         mkDir();
//         delDir();
//         delFile();
//        upload();
//        upload2();
//        upload("/hbase/word.txt", "D:\\word.txt");

    }

    /**
     * 创建目录
     */
    private static void mkDir() throws Exception {
        FileSystem fs = FileSystem.get(new URI("hdfs://10.7.253.92:9000"), new Configuration());
        fs.mkdirs(new Path("/hbase"));
        fs.close();
    }

    /**
     * 删除test目录
     */
    private static void delDir() throws Exception {
        FileSystem fs = FileSystem.get(new URI("hdfs://10.7.253.92:9000"), new Configuration());
        fs.delete(new Path("/output"), true);
        fs.close();
    }

    private static void delFile() throws Exception {
        FileSystem fs = FileSystem.get(new URI("hdfs://10.7.253.92:9000"), new Configuration());
        fs.delete(new Path("/upload/svn1.txt"), true);
        fs.close();
    }

    //有问题
    private static void upload(String hdfsFile, String localFile) throws Exception {
        FileSystem fs = FileSystem.get(new URI("hdfs://10.7.253.92:9000"), new Configuration());
        FSDataOutputStream fsDataOutputStream = fs.create(new Path(hdfsFile));
        FileInputStream in = new FileInputStream(new File(localFile));
        IOUtils.copyBytes(in, fsDataOutputStream, 2048, true);
        fs.close();
    }
    //有问题
    private static void upload2() throws Exception {
        String localFileSrc = "D://IWAgentSale_6.9.3_Beta_1.2.war";
        String dst = "hdfs://10.7.253.92:9000/user/svn.txt";
        InputStream in = new BufferedInputStream(new FileInputStream(localFileSrc));
        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(dst),configuration);
        OutputStream out = fs.create(new Path(dst), new Progressable() {
            public void progress() {
                System.out.println(".");
            }
        });
        IOUtils.copyBytes(in, out, 2048,true);
        System.out.println("success");
    }
}