package com.iava.dp.composite.demo2;

/**2.单一物品(树叶构件)*/

public class SingleResImpl implements IRes {
    /**物品名称*/
    private String name;
    /**价钱*/
    private float money;
    public SingleResImpl(String name, float money) {
        this.name = name;
        this.money = money;
    }
    public void pay() {
        System.out.println("购买了一件物品["+getName()+"],价钱是[" + getMoney()+"]元");
    }
    public float getMoney() {
        // TODO 自动生成方法存根
        return this.money;
    }
    public String getName() {
        // TODO 自动生成方法存根
        return this.name;
    }  
    /**重写equals*/
    public boolean equals(Object obj){
        SingleResImpl res = (SingleResImpl)obj;    
        return res.getName().equals(getName()) && res.getMoney()==getMoney();
    }
}
