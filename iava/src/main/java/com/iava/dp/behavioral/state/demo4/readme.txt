如果您不瞭解TCP的連線方式，在看Gof的書介紹狀態（State）模式時，大概會看得一頭霧水吧！TCP的連線狀態圖，光是要瞭解就要花點精神了，它的連線狀態很多，用來說明狀態模式確實很適合，但不適合教導初學模式的人。

我們由簡單的開始會比較好理解狀態模式的作用，先來看一個例子，如果您有一個只能順時針轉動的瓦斯開關，轉動一次的狀態為off、small fire、medium fire與large fire，您如何在程式中控制狀態的變化與行為呢？一個最簡單的方式就是用if..else或是switch流程來控制，例如：

public class State {
    private int _state;
                                                                                
    public State() {
        _state = 0;
    }
                                                                                
    public void switchFire() {
        if (_state == 0) {
            _state = 1;
            System.out.println( "small fire" );
        } else if (_state == 1) {
            _state = 2;
            System.out.println( "medium fire" );
        } else if (_state == 2) {
            _state = 3;
            System.out.println( "large fire" );
        } else {
            _state = 0;
            System.out.println( "turning off" );
        }
    }
}
 
public class Main {
     public static void main(String[] args) {
        State state = new State();
                                                                                
        state.switchFire();
        state.switchFire();
        state.switchFire();
        state.switchFire();
    }
}



執行結果：

small fire
medium fire
large fire
turning off



這個方法很簡單，每個人都會，但如果您的狀態變化並不是流水式的變化，而是像TCP連線狀態一樣，會是一個網絡圖的時候，用if...else或switch來寫的話，您的程式就會亂的不像話了；我們先來考慮如何讓物件控制自己的狀態轉換與所應表現的行為，這個程式我們可以這樣改寫：

public interface State {
    public void switchFire(FireSwitch sw);
}
 
public class OffState implements State {
    public void switchFire(FireSwitch sw) {
        sw.setState(new SmallState());
        System.out.println( "small fire" );
    }
}
 
public class SmallState implements State {
    public void switchFire(FireSwitch sw) {
        sw.setState(new MediumState());
        System.out.println( "medium fire" );
    }
}
 
public class MediumState implements State {
    public void switchFire(FireSwitch sw) {
        sw.setState(new LargeState());
        System.out.println( "large fire" );
    }
}
 
public class LargeState implements State {
    public void switchFire(FireSwitch sw) {
        sw.setState(new OffState());
        System.out.println( "off fire" );
    }
}
 
public class FireSwitch {
    private State _current;
                                                                                
    public FireSwitch() {
        _current = new OffState();
    }
                                                                                
    public void setState(State s) {
        _current = s;
    }
                                                                                
    public void switchFire() {
        _current.switchFire(this);
    }
}
 
public class Main {
    public static void main(String[] args) {
        FireSwitch fireSwitch = new FireSwitch();
                                                                                
        fireSwitch.switchFire();
        fireSwitch.switchFire();
        fireSwitch.switchFire();
        fireSwitch.switchFire();
    }
}



程式執行結果與上一個例子是一樣的，但這次我們並沒有用流程控制來進行狀態轉換，而由物件自行控制自己的狀態，與必須表現的行為，這個方式就是狀態模式，將這個例子的UML類別結構畫出就如下所示：


再進一步考慮開關可以順時針與逆時針轉動，這時如果您仍以if...else或switch來寫，就會讓流程顯示複雜，我們來看看如何使用狀態模式來撰寫：

public interface State {
    public void switchClockWise(FireSwitch sw);
    public void switchCountClock(FireSwitch sw);
}
 
public class OffState implements State {
    public void switchClockWise(FireSwitch sw) {
        sw.setState(new SmallState());
        System.out.println("small fire");
    }
                                                                                
    public void switchCountClock(FireSwitch sw) {
        sw.setState(new LargeState());
        System.out.println("large fire");
    }
}
 
public class SmallState implements State {
    public void switchClockWise(FireSwitch sw) {
        sw.setState(new MediumState());
        System.out.println("medium fire");
    }
                                                                                
    public void switchCountClock(FireSwitch sw) {
        sw.setState(new OffState());
        System.out.println("off fire");
    }
}
 
public class MediumState implements State {
    public void switchClockWise(FireSwitch sw) {
        sw.setState(new LargeState());
        System.out.println("large fire");
    }
                                                                                
    public void switchCountClock(FireSwitch sw) {
        sw.setState(new SmallState());
        System.out.println("small fire");
    }
}
 
public class LargeState implements State {
    public void switchClockWise(FireSwitch sw) {
        sw.setState(new OffState());
        System.out.println("off fire");
    }
                                                                                
    public void switchCountClock(FireSwitch sw) {
        sw.setState(new MediumState());
        System.out.println("medium fire");
    }
}
 
public class FireSwitch {
    private State _current;
                                                                                
    public FireSwitch() {
        _current = new OffState();
    }
                                                                                
    public void setState(State s) {
        _current = s;
    }
                                                                                
    public void switchClockWise() {
        _current.switchClockWise(this);
    }
                                                                                
    public void switchCountClock() {
       _current.switchCountClock(this);
    }
}
 
public class Main {
    public static void main(String[] args) {
        FireSwitch fireSwitch = new FireSwitch();
                                                                                
        fireSwitch.switchClockWise();
        fireSwitch.switchClockWise();
        fireSwitch.switchClockWise();
        fireSwitch.switchClockWise();
                                                                                
        System.out.println();
                                                                                
        fireSwitch.switchCountClock();
        fireSwitch.switchCountClock();
        fireSwitch.switchCountClock();
        fireSwitch.switchCountClock();
    }
}



接下來您可以任意的轉動開關了，無論是順時針轉動或是逆時針轉動，狀態的轉換都由物件自己來表現，這是雙向狀態轉換下的例子，如果一個狀態可能轉換至三個以上的狀態，使用狀態模式就更可以看出它的好處了，就像Gof的 TCP連線例子一樣，如果您瞭解TCP連線，可以看看原書是如何實現TCP連線之間的狀態轉換的。

狀態模式的UML結構圖如下：

於 2004-01-12 13:52 user profilesend a private message to userreply to postsearch all posts byselect and copy to clipboard. ie only, sorry for netscape users:-)add this post to my favorite list 舉這個例子的確清楚的多..Smile
但我覺得這個pattern應該擺在strategy之後才是
這個算是strategy pattern的一種特例n我想等到caterpillar兄講到strategy pattern時大家應該會更明瞭..Smile 

於 2004-01-12 16:34 user profilesend a private message to userreply to postsearch all posts byselect and copy to clipboard. ie only, sorry for netscape users:-)add this post to my favorite list

    popcorny wrote:
    舉這個例子的確清楚的多..Smile
    但我覺得這個pattern應該擺在strategy之後才是
    這個算是strategy pattern的一種特例n我想等到caterpillar兄講到strategy pattern時大家應該會更明瞭..Smile



這些話倒讓我想了一下呢！

從行為上來說，狀態模式與策略模式確實蠻相近的。

狀態模式：看當前是什麼狀態，就採取什麼動作。

策略模式：看需求（情境）是什麼，採用適當的策略。

一開始我並沒有意識到這兩者之間的相似，不過兩者雖相似，應用的場合稍有不同，狀態模式中有一個重點在於設定狀態變化，就像例子中舉的TCP連線；策略模式則是直接採用適當的策略的感覺，例如Gof中說的，採用適當的演算法來作正文換行。


良葛格學習筆記
