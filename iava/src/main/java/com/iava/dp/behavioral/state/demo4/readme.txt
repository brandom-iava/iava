��������t��TCP���B����ʽ���ڿ�Gof�ĕ���B��B��State��ģʽ�r����ŕ�����һ�^�Fˮ�ɣ�TCP���B����B�D������Ҫ�t���Ҫ���c�����ˣ������B����B�ܶ࣬�Á��f����Bģʽ�_�����m�ϣ������m�Ͻ̌����Wģʽ���ˡ�

�҂��ɺ��ε��_ʼ�����^������Bģʽ�����ã��ȁ�һ�����ӣ��������һ��ֻ��형r��D�ӵ���˹�_�P���D��һ�εĠ�B��off��small fire��medium fire�clarge fire��������ڳ�ʽ�п��Ơ�B��׃���c�О��أ�һ����εķ�ʽ������if..else����switch���́���ƣ����磺

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



���нY����

small fire
medium fire
large fire
turning off



�@�������ܺ��Σ�ÿ���˶�������������Ġ�B׃���K������ˮʽ��׃����������TCP�B����Bһ�ӣ�����һ���W�j�D�ĕr����if...else��switch�팑��Ԓ�����ĳ�ʽ�͕��y�Ĳ���Ԓ�ˣ��҂��ȁ��]���׌��������Լ��Ġ�B�D�Q�c������F���О飬�@����ʽ�҂������@�ӸČ���

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



��ʽ���нY���c��һ��������һ�ӵģ����@���҂��K�]�������̿��Ɓ��M�Р�B�D�Q������������п����Լ��Ġ�B���c��횱�F���О飬�@����ʽ���Ǡ�Bģʽ�����@�����ӵ�UMLe�Y��������������ʾ��


���Mһ�����]�_�P����형r��c��r��D�ӣ��@�r���������if...else��switch�팑���͕�׌�����@ʾ�}�s���҂��������ʹ�à�Bģʽ��׫����

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



����������������D���_�P�ˣ��oՓ��형r��D�ӻ�����r��D�ӣ���B���D�Q��������Լ����F���@���p���B�D�Q�µ����ӣ����һ����B�����D�Q���������ϵĠ�B��ʹ�à�Bģʽ�͸����Կ������ĺ�̎�ˣ�����Gof�� TCP�B������һ�ӣ�������t��TCP�B�������Կ���ԭ������Ό��FTCP�B��֮�g�Ġ�B�D�Q�ġ�

��Bģʽ��UML�Y���D���£�

� 2004-01-12 13:52 user profilesend a private message to userreply to postsearch all posts byselect and copy to clipboard. ie only, sorry for netscape users:-)add this post to my favorite list �e�@�����ӵĴ_����Ķ�..Smile
�����X���@��pattern��ԓ�[��strategy֮�����
�@������strategy pattern��һ�N����n����ȵ�caterpillar���v��strategy pattern�r��ґ�ԓ�������t..Smile 

� 2004-01-12 16:34 user profilesend a private message to userreply to postsearch all posts byselect and copy to clipboard. ie only, sorry for netscape users:-)add this post to my favorite list

    popcorny wrote:
    �e�@�����ӵĴ_����Ķ�..Smile
    �����X���@��pattern��ԓ�[��strategy֮�����
    �@������strategy pattern��һ�N����n����ȵ�caterpillar���v��strategy pattern�r��ґ�ԓ�������t..Smile



�@ЩԒ��׌������һ���أ�

���О��ρ��f����Bģʽ�c����ģʽ�_���U����ġ�

��Bģʽ������ǰ��ʲ�N��B���͒�ȡʲ�N������

����ģʽ���������龳����ʲ�N�������m���Ĳ��ԡ�

һ�_ʼ�ҁK�]�����R���@����֮�g�����ƣ����^�����m���ƣ����õĈ������в�ͬ����Bģʽ����һ�����c����O����B׃���������������e��TCP�B��������ģʽ�t��ֱ�Ӓ����m���Ĳ��Եĸ��X������Gof���f�ģ������m�������㷨�������ēQ�С�


�����W���Pӛ
