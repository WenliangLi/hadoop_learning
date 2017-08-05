package org.nio;

import java.nio.ByteBuffer;

/**
 * 类或接口的功能说明
 *
 * @author liwenliang
 * @Date: 2017年07月24日 下午1:18:00
 * @History :
 * @Date: 2017年07月24日 下午1:18:00
 * @author: berchina-liwenliang
 * @Desc: 修改目的和修改方法
 **/
public class TestBuffer {
    public static void main(String args[]) throws Exception {
        String str = "abc";
        ByteBuffer b = ByteBuffer.allocate(1024);
        b.put(str.getBytes());

        System.out.println(b.position());
        System.out.println(b.limit());
        System.out.println(b.capacity());


        System.out.println("##########");

        b.flip();
        System.out.println(b.position());
        System.out.println(b.limit());
        System.out.println(b.capacity());

        System.out.println("##########");

        byte[] dist = new byte[b.limit()];
        b.get(dist);
        System.out.println(new String(dist,"UTF-8"));
        System.out.println(b.position());
        System.out.println(b.limit());
        System.out.println(b.capacity());

        b.clear();
        System.out.println("##########");

        System.out.println(b.position());
        System.out.println(b.limit());
        System.out.println(b.capacity());
    }
}
