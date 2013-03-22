package com.iava.dp.behavioral.state.demo1;

public class ContextOriginal
{
     private String state;
 
     public String getState()
     {
         return state;
     }
 
     public void setState(String state)
     {
         this.state = state;
     }
 
     public void print(String msg)
     {
         System.out.println(msg);
     }
 
     public void printImplFirst()
     {
         this.print("printImplFirst: " + this.state);
     }
 
     public void printImplSecond()
     {
         this.print("printImplSecond: " + this.state);
     }
 
     public void printImplThird()
     {
         this.print("printImplFinal: " + this.state);
     }
 
     public void execute()
     {
         if(this.state != null)
         {
             if(this.state.equals("first"))
             {
                 this.printImplFirst();
             }
             else if(this.state.equals("second"))
             {
                 this.printImplSecond();
             }
             else if(this.state.equals("third"))
             {
                 this.printImplThird();
             }
             else
             {
                 throw new IllegalArgumentException(
                         "illegalArgumentException: this.state = " + this.state);
             }
         }
         else
         {
             throw new NullPointerException("this.state is null");
         }
     }
 } 

