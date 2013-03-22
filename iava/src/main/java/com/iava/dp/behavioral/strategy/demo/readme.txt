考慮您要設計一個更換各種符號的工具類TextCharChange，您是否會採用這樣的方式：

public void replace() {
   switch(getChangeType()) {
      case RN_TYPE:   replaceRN();
                          break;
      case N_TYPE: replaceN();
                          break;
      case OTHER_TYPE: replaceOTHER():
                          break;
      ...
   }
}



這麼作的缺點是，日後您要增加更換符號的策略時，會有幾個地方需要修改：增加TYPE常數、增加TextCharChange中的 replaceXXX()方法、增加 replace()方法中的switch case判斷。

像這種策略採用的情況，我們可以將策略加以封裝為一個物件，而不是將策略寫死在某個類中，如此一來，策略可以獨立於客戶端，隨時增加變化、增加或減少策略，即使是修改每個策略的內容，也不會對客戶端程式造成影響。

我們來舉個最簡單的例子，我們都知道Windows與Linux的文字檔案換行符號是不同的，Windows是 /r/n ，而Linux是 /n，今天您要設計一個文字編輯器，在適當的時候，您必須要能隨時轉換這兩種符號，如果不採用上面的策略採用流程的話，我們要如何設計：
	

public abstract class TextStrategy {
    protected String _text;
                                                                                
    public TextStrategy(String text) {
        _text = text;
    }
                                                                                
    public abstract String replace();
}
 
public class LinuxStrategy extends TextStrategy {
    public LinuxStrategy(String text) {
        super(text);
    }
                                                                                
    public String replace() {
        preOperation();
        System.out.println(_text = _text.replaceAll("@r@n", "@n"));
        postOperation();
                                                                                
        return _text;
    }
                                                                                
    private void preOperation() {
        System.out.println("LinuxStrategy preOperation");
    }
                                                                                
    private void postOperation() {
        System.out.println("LinuxStrategy postOperation");
    }
}
 
public class WindowsStrategy extends TextStrategy {
    public WindowsStrategy(String text) {
        super(text);
    }
                                                                                
    public String replace() {
        startOperation();
        System.out.println(_text = _text.replaceAll("@n", "@r@n"));
        endOperation();
                                                                                
        return _text;
    }
                                                                                
    private void startOperation() {
        System.out.println("WindowsStrategy startOperation");
    }
                                                                                
    private void endOperation() {
        System.out.println("WindowsStrategy endOperation");
    }
}
 
public class TextCharChange {
    public static void replace(TextStrategy strategy) {
        strategy.replace();
    }
}
 
public class Main {
    public static void main(String[] args) {
        String linuxText = "This is a test text!!@n Oh! Line Return!!@n";
        String windowsText = "This is a test text!!@r@n Oh! Line Return@r@n";
                                                                                
        // load file, suppose it's Linux's text file
        // take the WindowsStrategy
        // I want to change it to Windows' text file
        TextCharChange.replace(new WindowsStrategy(linuxText));
                                                                                
        // such-and-such operation.....
        System.out.println();
                                                                                
        // load file, suppose it's Windows' text file
        // take the LinuxStrategy
        // I want to change it to Linux's text file
        TextCharChange.replace(new LinuxStrategy(windowsText));
    }
}



為了明顯的秀出結果，我們使用@n來表示 '/n' ， @r 表示 '/r' 符號，Main中的流程是個假設的情況，何時採用何種策略是隨機的，程式的結果如下：
	

WindowsStrategy startOperation
This is a test text!!@r@n Oh! Line Return!!@r@n
WindowsStrategy endOperation
 
LinuxStrategy preOperation
This is a test text!!@n Oh! Line Return@n
LinuxStrategy postOperation



在策略模式中，我們使用一個公開的介面replace()，讓客戶端請求，而我們在實作replace()時，可以任意的組合我們的演算策略，程式中的preOperation()、postOperation()就是用以示意演算的組合概念，策略模式封裝了這些演算過程，使它們易於組合、修改、替換，上面這個例子的UML類別結構圖如下所示：


策略模式的UML類別結構圖如下：


在Swing組件中的邊框繪制，也是採用策略模式來設計，這方面有這邊提供一個文件的網址，上面有詳細的說明：
http://www.uml.org.cn/sjms/sjms13.htm

從行為上來說，狀態模式與策略模式是蠻相近的。

狀態模式：看當前是什麼狀態，就採取什麼動作。

策略模式：看需求（情境）是什麼，採用適當的策略。

不過兩者雖相似，應用的場合稍有不同，狀態模式中有一個重點在於設定狀態變化，就像例子中舉的TCP連線；策略模式則是直接採用適當的策略的感覺，例如Gof中說的，採用適當的演算法來作正文換行。 