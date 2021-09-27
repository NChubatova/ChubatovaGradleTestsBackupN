package my;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import java.lang.Thread;

public class BeforeAndAfterAnnotationsUnitTest {

    // ...

    private List<String> list;

    @Before
    public void init() {
        LOG.info("startup");

    }

    @After
    public void teardown() {
        LOG.info("teardown");

    }
}

public class mytest {

    @Test
    public static void foo1() {
        if (1==1){
            try 
            {
                Thread.sleep(1);
                //Assert.fail("fail message2");
            } 
            catch(InterruptedException e)
            {
            // this part is executed when an exception (in this example InterruptedException) occurs
            }

        }
        else {
            System.out.println(System.currentTimeMillis());
            try 
            {
                Thread.sleep(2);
            } 
            catch(InterruptedException e)
            {
            // this part is executed when an exception (in this example InterruptedException) occurs
            }
            Assert.fail("fail message");
        };

    };
    
   


};
