package pers.chbrobin.study.socket;

import org.apache.commons.lang.StringUtils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by Administrator on 2017/6/9 0009.
 */
public class SimpleUdpClient implements Runnable {
    private DatagramSocket client;
    private String serverAddress;

    public SimpleUdpClient(DatagramSocket client, String serverAddress) {
        this.client = client;
        this.serverAddress = serverAddress;
    }
    public void run() {
        while (true) {
            try {
                byte[] recvBuf = new byte[100];
                DatagramPacket recvPacket  = new DatagramPacket(recvBuf , recvBuf.length);
                client.receive(recvPacket);
                String recvStr = new String(recvPacket.getData() , 0 ,recvPacket.getLength());
                String[] receiveStrArr = StringUtils.split(recvStr, "XXXX");
                String[] userIds = StringUtils.split(receiveStrArr[0], "_");
                Long fromUserId = Long.valueOf(userIds[0]);
                String msg = receiveStrArr[1];
                System.out.println("user " + fromUserId +" say:" + msg);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Long loginUserId = null;
        Long toUserId = null;
        DatagramSocket client = new DatagramSocket();
        Thread thread = new Thread(new SimpleUdpClient(client, "127.0.0.1"));
        thread.start();
        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");

        while (true) {
            String str = reader.readLine();
            if(str.startsWith("loading")) {
                String[] strArr = StringUtils.split(str, " ");
                loginUserId = Long.valueOf(strArr[1]);
                toUserId = Long.valueOf(strArr[2]);
                System.out.println("you are loading loginUserId " + loginUserId + " toUserId " + toUserId);

                String sendStr = "loading " + loginUserId + " ";
                byte[] sendBuf = sendStr.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendBuf,0, sendBuf.length, inetAddress, 5050);
                client.send(sendPacket);
            } else if("quit".equals(str)) {
                System.exit(1);
            } else {
                if(loginUserId == null || toUserId == null) {
                    System.out.println("please loading first, like this: loading 1 2");
                    continue;
                }

                String sendStr = loginUserId + "_" + toUserId + "XXXX" + str;
                byte[] sendBuf = sendStr.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendBuf,0, sendBuf.length, inetAddress, 5050);
                client.send(sendPacket);
            }
        }
    }
}
