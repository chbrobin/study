package pers.chbrobin.study.ssh;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

/**
 * Created by Administrator on 2017/6/7 0007.
 */
public class SshTest {
    public static void main(String[] args) {
        try {
            if(args == null || args.length < 1) {
                System.out.println("请输入跳转机密码");
            }
            JSch jsch = new JSch();
            Session session = jsch.getSession("iwjw", "112.124.115.87", 22);
            session.setPassword(args[0]);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            System.out.println(session.getServerVersion());//这里打印SSH服务器版本信息

            //ssh -L 192.168.0.102:5555:192.168.0.101:3306 yunshouhu@192.168.0.102  正向代理
            int assinged_port = session.setPortForwardingL("127.0.0.1",9999, "iwjw-oa-soa1", 80);//端口映射 转发
//            int assinged_port = session.setPortForwardingL("127.0.0.1",9999, "iwjw-oa-soa1", 80);//端口映射 转发
//            int assinged_port = session.setPortForwardingL("127.0.0.1",9999, "iwjw-oa-soa1", 80);//端口映射 转发

            System.out.println("127.0.0.1:" + assinged_port);

            //ssh -R 192.168.0.102:5555:192.168.0.101:3306 yunshouhu@192.168.0.102
            //session.setPortForwardingR("192.168.0.102",5555, "192.168.0.101", 3306);
            // System.out.println("localhost:  -> ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
