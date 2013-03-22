

 

BloggerAds 廣告
尋找甜蜜笑容
一起尋找歡喜、感心、疼惜的甜蜜笑容，喜憨兒「彎彎隨手杯」送給你!!
更多訊息..
Impr

	如果您寫過Java的Swing視窗程式，您可能使用過Command模式了，例如在您按下JMenuItem的「剪下」選項時，執行對JTextArea的選定文字之剪下動作，並將狀態列設定為文件已修改狀態。

在設計Swing時，設計人員是不可能知道使用Swing類別的人，在某個事件發生後所要執行的動作是什麼的，他們採用了Command模式，以上面的需求作為例子，一個實作的片段可能像是這個樣子：
menuCut.addActionListener(
    new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            // textArea 是 JTextArea的一個實例
            textArea.cut();  
         }
    });
 
上面個這片段採用的是Java的匿名類別（Anonymous class），一個不具名的類別實作了ActionListener介面，它只有一個方法actionPerformed()，使用 addActionListener()為JMenuItem加入這個類別的實例，一但這個JMenuItem被按下，它就會調用 actionPerformed()方法，以執行您所定義的工作， UML 類別圖如下所示：
Command
使用Command模式，您可以根據實際的需求來調用執行的物件，至於執行的細節封裝在事先定義好的方法（例如actionPerformed()方法，下面實際撰寫個程式作為示範：

    * Invoker.java

import java.util.*;

public class Invoker {
    private Map commands;
    
    public Invoker() {
        commands = new HashMap();
    }
    
    public void addCommand(String commName,
                           ICommand command) {
        commands.put(commName, command);
    }
    
    public void request(String commName) {
        ICommand command = (ICommand) commands.get(commName);
        command.execute();
    }
} 


    * ICommand.java

public interface ICommand {
    public void execute();
} 


    * UpperCaseHello.java

public class UpperCaseHello implements ICommand {
    private String name;
    
    public UpperCaseHello(String name) {
        this.name = name;    
    }
    
    public void execute() {
        System.out.println("HELLO, " + name.toUpperCase());
    }
} 


    * LowerCaseHello.java

public class LowerCaseHello implements ICommand {
    private String name;
    
    public LowerCaseHello(String name) {
        this.name = name;    
    }
    
    public void execute() {
        System.out.println("hello, " + name.toLowerCase());
    }
} 


Client模擬隨機的請求，Invoker事先並不知道Client會發出什麼需求，但它總是可以執行Client的請求：

    * Client.java

public class Client {
    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        invoker.addCommand("JUSTIN", 
                            new UpperCaseHello("Justin"));
        invoker.addCommand("momor", 
                            new LowerCaseHello("momor"));
        
        // simulate random request
        String[] req = {"JUSTIN", "momor"};
        while(true) {
            int i = (int) (Math.random() * 10) % 2;
            invoker.request(req[i]);
        }
    }
} 

像上面這種將請求封裝起來的模式，就是Command模式，它將請求後的實作部份留待使用者實作，Command模式的UML類別圖如下所示：

Command

Command模式是個相當常見的模式，除了先前談過的Swing視窗程式設計例子之外，現在許多Web MVC Framework 也都採用Command模式來設計Controller，在這樣的例子中，Container就好比Command模式中Client的角色，而前端 Controller（例如JSP技術中通常會採用的Dispatcher Servlet）就相當於Invoker，而Action則相當於ICommand的角色，至於Receiver角色就是您封裝在Action中執行的物件了。