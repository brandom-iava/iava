package com.iava.dp.composite.demo2;

/**3.�����Ʒ(��֦����)*/

import java.util.Iterator;
import java.util.Vector;
/*
 * �Զ����Ʒ�Ĺ���
 * */
public class MultiResImpl implements IRes {
    /**���ﳵ*/
    private Vector car = new Vector();
    private static float totle = 0.0f;
     
public void pay() {
        if(!car.isEmpty()){
        System.out.println("����        �۸�\n");
        shopping();
        System.out.println("\n�ܼ�:" + totle + "Ԫ");
        }else{
            System.out.println("���ã���û�й����κ���Ʒ�������򵥣�");       
        }
    }
    public void shopping() {      
        if (car != null || !car.isEmpty()) {
            Iterator it = car.iterator();
            SingleResImpl res = null;
            Object temp = null;// ��ʱ����
            while (it.hasNext()) {
                temp = it.next();
                if (temp instanceof MultiResImpl) {
                    ((MultiResImpl) temp).shopping();
                } else {
                    res = (SingleResImpl) temp;
                    synchronized (this) {
                        totle += res.getMoney();
                    }
                    System.out.println(res.getName() + "            " + res.getMoney()
                            + "Ԫ");
                }
            }
        }
    }
    /**�����µ���Ʒ*/
    public void addRes(IRes res) {
        car.add(res);
    }
 
    /**�Ż���Ʒ*/
    public void removeRes(IRes res) {
        car.remove(res);
    }
 
}