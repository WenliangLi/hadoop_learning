package org.nio;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * 类或接口的功能说明
 *
 * @author liwenliang
 * @Date: 2017年07月24日 下午1:46:00
 * @History :
 * @Date: 2017年07月24日 下午1:46:00
 * @author: berchina-liwenliang
 * @Desc: 修改目的和修改方法
 **/
public class NioTest {

    public void startServer() throws Exception {
        int channels = 0;
        int nKeys = 0;
        int currentSelector = 0;

        Selector selector = Selector.open();
        ServerSocketChannel ssc = ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress(InetAddress.getLocalHost(),9999);
        ssc.socket().bind(address);
        ssc.configureBlocking(false);
        SelectionKey s = ssc.register(selector,SelectionKey.OP_ACCEPT);


    }

    public static void main(String args[]) throws Exception {
        NioTest test = new NioTest();
    }
}
