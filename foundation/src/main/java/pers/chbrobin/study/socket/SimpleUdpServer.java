package pers.chbrobin.study.socket;

import org.apache.commons.lang.StringUtils;

import java.net.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/9 0009.
 */
public class SimpleUdpServer implements Runnable {
    private DatagramSocket server;
    private Map<Long,UserInfo> userMap = new HashMap<Long, UserInfo>();

    public SimpleUdpServer(Integer port) throws SocketException {
        this.server = new DatagramSocket(port);
    }
    public void run() {
        while (true) {
            try {
                byte[] receives = new byte[100];
                DatagramPacket receivePacket = new DatagramPacket(receives, receives.length);
                server.receive(receivePacket);
                String receiveStr = new String(receivePacket.getData(),0, receives.length);
                if(receiveStr.startsWith("loading")) {
                    String[] receiveStrArr = StringUtils.split(receiveStr, " ");
                    Long loginUserId = Long.valueOf(receiveStrArr[1]);
                    UserInfo userInfo = new UserInfo();
                    InetAddress inetAddress = receivePacket.getAddress();
                    userInfo.setAddress(inetAddress.getHostAddress());
                    userInfo.setPort(receivePacket.getPort());
                    userInfo.setUserId(loginUserId);
                    userMap.put(loginUserId, userInfo);
                    System.out.println("loading userId " + loginUserId);
                } else {
                    System.out.println("client msg:" + receiveStr);
                    String[] receiveStrArr = StringUtils.split(receiveStr, "XXXX");
                    String[] userIds = StringUtils.split(receiveStrArr[0], "_");
                    Long toUserId = Long.valueOf(userIds[1]);
                    byte[] sendBuf;
                    sendBuf = receiveStr.getBytes();
                    UserInfo sendUser = userMap.get(toUserId);
                    InetAddress sendAddress = InetAddress.getByName(sendUser.getAddress());
                    DatagramPacket sendPacket = new DatagramPacket(sendBuf, sendBuf.length, sendAddress, sendUser.getPort());
                    server.send(sendPacket);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private class UserInfo {
        private Long userId;
        private Integer port;
        private String address;

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public Integer getPort() {
            return port;
        }

        public void setPort(Integer port) {
            this.port = port;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }

    public static void main(String[] args) {
        try {
            SimpleUdpServer simpleUdpServer = new SimpleUdpServer(5050);
            Thread serverThread = new Thread(simpleUdpServer);
            serverThread.start();
            System.out.println("udp server start working ...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
