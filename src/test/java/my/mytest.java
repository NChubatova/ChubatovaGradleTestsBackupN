package my;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class mytest {

    @Test
    public void foo1() {
        if (System.currentTimeMillis()%3==1){
           System.out.println(System.currentTimeMillis());
        }
        else {
            System.out.println(System.currentTimeMillis());
            Assert.fail("fail message");
        };

    };
    @Test
    public void foo2() {
        if (System.currentTimeMillis()%2==1){
            System.out.println(System.currentTimeMillis());
        }
        else {
            System.out.println(System.currentTimeMillis());
            Assert.fail("fail message");
        };

    };
    @Test
    public void foo3() {
        if (System.currentTimeMillis()%1==0){
        }
        else {
            Assert.fail("fail message");
        };

    };

}
