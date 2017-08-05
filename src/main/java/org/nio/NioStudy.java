package org.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 类或接口的功能说明
 *
 * @author liwenliang
 * @Date: 2017年07月27日 下午6:37:00
 * @History :
 * @Date: 2017年07月27日 下午6:37:00
 * @author: berchina-liwenliang
 * @Desc: 修改目的和修改方法
 **/
public class NioStudy {


    public static void method2(){
        InputStream in = null;
        try{
            in = new BufferedInputStream(new FileInputStream("/Users/liwenliang/Documents/GitHub/hadoop_learning/src/input/README.txt"));

            byte [] buf = new byte[1024];
            int bytesRead = in.read(buf);
            while(bytesRead != -1)
            {
                for(int i=0;i<bytesRead;i++)
                    System.out.print((char)buf[i]);
                bytesRead = in.read(buf);
            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }finally{
            try{
                if(in != null){
                    in.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void method1(){
        RandomAccessFile aFile = null;
        try{
            aFile = new RandomAccessFile("/Users/liwenliang/Documents/GitHub/hadoop_learning/src/input/README.txt","rw");
            FileChannel fileChannel = aFile.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(1024);

            int bytesRead = fileChannel.read(buf);
            System.out.println(bytesRead);

            while(bytesRead != -1)
            {
                buf.flip();
                while(buf.hasRemaining())
                {
                    System.out.print((char)buf.get());
                }

                buf.compact();
                bytesRead = fileChannel.read(buf);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(aFile != null){
                    aFile.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) throws Exception {
        method1();
    }
}
