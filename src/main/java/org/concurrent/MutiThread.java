package org.concurrent;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * 类或接口的功能说明
 *
 * @author liwenliang
 * @Date: 2017年08月03日 上午11:53:00
 * @History :
 * @Date: 2017年08月03日 上午11:53:00
 * @author: berchina-liwenliang
 * @Desc: 修改目的和修改方法
 **/
public class MutiThread {
    public static void main(String args[]) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false,false);
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("["+threadInfo.getThreadId()+"]"+threadInfo.getThreadName());
        }
    }
}
