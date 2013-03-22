package com.iava.dp.composite.demo2;

/**4.����̨��
 * ��һ������ȫ��ʽ
 * */

public class Client {
    /**
     *@paramargs
     */
    public static void main(String[] args) {
        /**��֧ѩ��*/
        IRes singleRes = new SingleResImpl("ѩ��", 1.5f);
        /**��*/
        singleRes.pay();
 
        /**������ˣ������˸����ﳵ������㶫��*/
        IRes allRes = new MultiResImpl();              
        /**��һ¥���ʳ��*/
        IRes one = new MultiResImpl();
        ((MultiResImpl) allRes).addRes(one);//��һ¥�Ķ���װ�ڹ��ﳵ��
        /**��Ϊ�ǰ�ȫ��ʽ�����ģʽ����˲���͸����ֻ����ȷ������ת�ͣ�Ȼ���ټ��빺�ﳵ��*/
        ((MultiResImpl) one).addRes(new SingleResImpl("����", 28.5f));
        ((MultiResImpl) one).addRes(new SingleResImpl("�ǹ�", 38.0f));
        ((MultiResImpl) one).addRes(new SingleResImpl("����", 8.5f));
 
        /**��¥ȥ����·�������*/
        IRes two = new MultiResImpl();
        ((MultiResImpl) allRes).addRes(two);// �Ѷ�¥�Ķ���װҲװ�ڹ��ﳵ��
        ((MultiResImpl) two).addRes(new SingleResImpl("�·�", 130.5f));
        ((MultiResImpl) two).addRes(new SingleResImpl("����", 10f));       
        /**��¥�����˸��ֱ�,�ҷ���bao��*/
        IRes bao = new MultiResImpl();
        ((MultiResImpl) two).addRes(bao);//�ѹ���С��װ�ڶ�¥���ﳵ��
        ((MultiResImpl) bao).addRes(new SingleResImpl("�ֱ�", 100f));
       
        /**�ص�һ¥��������ƻ������*/
        ((MultiResImpl) one).addRes(new SingleResImpl("ƻ��", 10.0f));
        ((MultiResImpl) one).addRes(new SingleResImpl("��", 3.0f));
/**����֮ǰ�Ұѿ������ˣ���Ϊ���ﻹ�е���*/
        ((MultiResImpl) one).removeRes(new SingleResImpl("����", 8.5f));
        /**������̨һ���ԶԹ��ﳵ������Ʒ��*/
        allRes.pay();
    }
}
