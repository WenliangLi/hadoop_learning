package org;

import java.util.ArrayList;
import java.util.List;

/**
 * 类或接口的功能说明
 *
 * @author liwenliang
 * @Date: 2017年07月25日 下午6:08:00
 * @History :
 * @Date: 2017年07月25日 下午6:08:00
 * @author: berchina-liwenliang
 * @Desc: 修改目的和修改方法
 **/
public class jvm {
    static class OOMObject {

    }
    public static void main(String args[]) throws Exception {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
