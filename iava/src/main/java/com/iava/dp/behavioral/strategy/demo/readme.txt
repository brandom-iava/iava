���]��Ҫ�OӋһ�����Q���N��̖�Ĺ����TextCharChange�����Ƿ�������@�ӵķ�ʽ��

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



�@�N����ȱ�c�ǣ�������Ҫ���Ӹ��Q��̖�Ĳ��ԕr�����Ўׂ��ط���Ҫ�޸ģ�����TYPE����������TextCharChange�е� replaceXXX()���������� replace()�����е�switch case�Дࡣ

���@�N���Ԓ��õ���r���҂����Ԍ����Լ��Է��b��һ������������ǌ����Ԍ�����ĳ����У����һ�����Կ��Ԫ���춿͑��ˣ��S�r����׃�������ӻ�p�ٲ��ԣ���ʹ���޸�ÿ�����Եă��ݣ�Ҳ�������͑��˳�ʽ���Ӱ푡�

�҂����e����ε����ӣ��҂���֪��Windows�cLinux�����֙n���Q�з�̖�ǲ�ͬ�ģ�Windows�� /r/n ����Linux�� /n��������Ҫ�OӋһ�����־�݋�������m���ĕr�������Ҫ���S�r�D�Q�@�ɷN��̖���������������Ĳ��Ԓ������̵�Ԓ���҂�Ҫ����OӋ��
	

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



�������@������Y�����҂�ʹ��@n���ʾ '/n' �� @r ��ʾ '/r' ��̖��Main�е������ǂ����O����r���Εr���úηN�������S�C�ģ���ʽ�ĽY�����£�
	

WindowsStrategy startOperation
This is a test text!!@r@n Oh! Line Return!!@r@n
WindowsStrategy endOperation
 
LinuxStrategy preOperation
This is a test text!!@n Oh! Line Return@n
LinuxStrategy postOperation



�ڲ���ģʽ�У��҂�ʹ��һ�����_�Ľ���replace()��׌�͑���Ո�󣬶��҂��ڌ���replace()�r����������ĽM���҂���������ԣ���ʽ�е�preOperation()��postOperation()��������ʾ������ĽM�ϸ������ģʽ���b���@Щ�����^�̣�ʹ������춽M�ϡ��޸ġ���Q�������@�����ӵ�UMLe�Y���D������ʾ��


����ģʽ��UMLe�Y���D���£�


��Swing�M���е�߅���L�ƣ�Ҳ�ǒ��ò���ģʽ���OӋ���@�������@߅�ṩһ���ļ��ľWַ��������Ԕ�����f����
http://www.uml.org.cn/sjms/sjms13.htm

���О��ρ��f����Bģʽ�c����ģʽ���U����ġ�

��Bģʽ������ǰ��ʲ�N��B���͒�ȡʲ�N������

����ģʽ���������龳����ʲ�N�������m���Ĳ��ԡ�

���^�����m���ƣ����õĈ������в�ͬ����Bģʽ����һ�����c����O����B׃���������������e��TCP�B��������ģʽ�t��ֱ�Ӓ����m���Ĳ��Եĸ��X������Gof���f�ģ������m�������㷨�������ēQ�С� 