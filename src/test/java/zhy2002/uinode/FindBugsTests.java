package zhy2002.uinode;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.testng.annotations.Test;

/**
 * Created by john.zhang on 10/12/2016.
 */
@Ignore
public class FindBugsTests {

    @Test
    public void findBugsTest() {

        int arg = (int)((Math.random() - 0.5) * 100);
        Object myObject = possibleNull(arg);
        System.out.println(myObject.hashCode());
    }

    @Test
    public void findBugsTest2() {
        Object myObject = possibleNull(33);
        System.out.println(myObject.hashCode());
    }

    @Test
    public void findBugsTest3() {
        Object myObject = possibleNull2(33);
        System.out.println(myObject.hashCode());
    }

    private Object possibleNull(int a) {
        return a > 0 ? new Object() : null;
    }

    private Object possibleNull2(int a) {
        if (a > 0)
            return new Object();
        return null;
    }
}
