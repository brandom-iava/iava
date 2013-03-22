package com.iava.dp.structure.adapter.explain1;

public class AdapterOperation extends OtherOperation implements Operation{
    public int add(int a,int b){
         return otherAdd(a,b);
    }
}
