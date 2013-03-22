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

    //ÊÊÅä¼Ó·¨ÔËËã
    public int add(int a,int b){
         return add.otherAdd(a,b);
    }

    //ÊÊÅä¼õ·¨ÔËËã
    public int minus(int a,int b){
        return minus.minus(a,b);
    }

    //ÊÊÅä³Ë·¨ÔËËã
    public int multiplied(int a,int b){
       return multiplied.multiplied(a,b);
    }
}
