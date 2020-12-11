package my;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class mytest {

    @Test
    public void foo1() {
        if (System.currentTimeMillis()%3==1){
        }
        else {
            Assert.fail("fail message");
        };

    };
    @Test
    public void foo2() {
        if (System.currentTimeMillis()%2==1){
        }
        else {
            Assert.fail("fail message");
        };

    };
    @Test
    public void foo3() {
        if (System.currentTimeMillis()%1==1){
        }
        else {
            Assert.fail("fail message");
        };

    };

}
