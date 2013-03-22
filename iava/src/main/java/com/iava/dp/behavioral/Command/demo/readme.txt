

 

BloggerAds �V��
��������Ц��
һ�����Қgϲ�����ġ���ϧ������Ц�ݣ�ϲ�����������S�ֱ����ͽo��!!
����ӍϢ..
Impr

	��������^Java��Swingҕ����ʽ��������ʹ���^Commandģʽ�ˣ�������������JMenuItem�ġ����¡��x헕r�����Ќ�JTextArea���x������֮���������K����B���O�����ļ����޸Ġ�B��

���OӋSwing�r���OӋ�ˆT�ǲ�����֪��ʹ��Swinge���ˣ���ĳ���¼��l������Ҫ���еĄ�����ʲ�N�ģ�����������Commandģʽ��������������������ӣ�һ��������Ƭ�ο��������@�����ӣ�
menuCut.addActionListener(
    new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            // textArea �� JTextArea��һ������
            textArea.cut();  
         }
    });
 
���悀�@Ƭ�Β��õ���Java������e��Anonymous class����һ����������e������ActionListener���棬��ֻ��һ������actionPerformed()��ʹ�� addActionListener()��JMenuItem�����@��e�Č�����һ���@��JMenuItem�����£����͕��{�� actionPerformed()�������Ԉ����������x�Ĺ����� UML e�D������ʾ��
Command
ʹ��Commandģʽ�������Ը������H��������{�È��е��������춈��еļ������b�����ȶ��x�õķ���������actionPerformed()���������挍�H׫������ʽ����ʾ����

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


Clientģ�M�S�C��Ո��Invoker���ȁK��֪��Client���l��ʲ�N���󣬵������ǿ��Ԉ���Client��Ո��

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

�������@�N��Ո����b�����ģʽ������Commandģʽ������Ո����Č�����������ʹ���ߌ�����Commandģʽ��UMLe�D������ʾ��

Command

Commandģʽ�ǂ��ஔ��Ҋ��ģʽ��������ǰՄ�^��Swingҕ����ʽ�OӋ����֮�⣬�F���S��Web MVC Framework Ҳ������Commandģʽ���OӋController�����@�ӵ������У�Container�ͺñ�Commandģʽ��Client�Ľ�ɫ����ǰ�� Controller������JSP���g��ͨ�������õ�Dispatcher Servlet�����ஔ�Invoker����Action�t�ஔ�ICommand�Ľ�ɫ�����Receiver��ɫ���������b��Action�Ј��е�����ˡ�