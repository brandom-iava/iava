package com.iava.dp.composite.demo2;

/**4.收银台买单
 * （一）、安全方式
 * */

public class Client {
    /**
     *@paramargs
     */
    public static void main(String[] args) {
        /**买支雪糕*/
        IRes singleRes = new SingleResImpl("雪糕", 1.5f);
        /**买单*/
        singleRes.pay();
 
        /**快过年了，我推了个购物车，多买点东西*/
        IRes allRes = new MultiResImpl();              
        /**在一楼买的食物*/
        IRes one = new MultiResImpl();
        ((MultiResImpl) allRes).addRes(one);//把一楼的东西装在购物车里
        /**因为是安全方式的组合模式，因此不够透明，只能明确的向下转型，然后再加入购物车了*/
        ((MultiResImpl) one).addRes(new SingleResImpl("旺旺", 28.5f));
        ((MultiResImpl) one).addRes(new SingleResImpl("糖果", 38.0f));
        ((MultiResImpl) one).addRes(new SingleResImpl("可乐", 8.5f));
 
        /**二楼去买的衣服和袜子*/
        IRes two = new MultiResImpl();
        ((MultiResImpl) allRes).addRes(two);// 把二楼的东西装也装在购物车里
        ((MultiResImpl) two).addRes(new SingleResImpl("衣服", 130.5f));
        ((MultiResImpl) two).addRes(new SingleResImpl("袜子", 10f));       
        /**二楼再买了个手表,我放在bao里*/
        IRes bao = new MultiResImpl();
        ((MultiResImpl) two).addRes(bao);//把购物小包装在二楼购物车里
        ((MultiResImpl) bao).addRes(new SingleResImpl("手表", 100f));
       
        /**回到一楼，又买了苹果和梨*/
        ((MultiResImpl) one).addRes(new SingleResImpl("苹果", 10.0f));
        ((MultiResImpl) one).addRes(new SingleResImpl("梨", 3.0f));
/**在买单之前我把可乐退了，因为家里还有的嘛*/
        ((MultiResImpl) one).removeRes(new SingleResImpl("可乐", 8.5f));
        /**在收银台一次性对购物车所有物品买单*/
        allRes.pay();
    }
}
