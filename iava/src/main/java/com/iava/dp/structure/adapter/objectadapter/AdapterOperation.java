package com.iava.dp.structure.adapter.objectadapter;

public class AdapterOperation implements Operation{
    private OtherAdd add;
    private OtherMinus minus;
    private OtherMultiplied multiplied;

    public void setAdd(OtherAdd add){
          this.add = add;
    }

    public void setMinus(OtherMinus minus){
          this.minus = minus;
    }

    public void setMultiplied(OtherMultiplied multiplied){
          this.multiplied = multiplied;
    }

    //����ӷ�����
    public int add(int a,int b){
         return add.otherAdd(a,b);
    }

    //�����������
    public int minus(int a,int b){
        return minus.minus(a,b);
    }

    //����˷�����
    public int multiplied(int a,int b){
       return multiplied.multiplied(a,b);
    }
}
