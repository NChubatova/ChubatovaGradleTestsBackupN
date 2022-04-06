package my;
//haha
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import java.lang.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;



public class mytest1 {
Logger log = LogManager.getLogger();
    
@Rule
public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
    
    @Test
    public void test11() {
        //if (System.currentTimeMillis()%3==1){
        //}
        //else {
           System.out.print("##teamcity[setParameter name='ddd' value='fff']");
          System.out.print("teamcity[setParameter name='ddd' value='fff']");
         try 
            {
                //Thread.sleep(9);
            Thread.sleep(1);
            } 
            catch(InterruptedException e)
            {
            // this part is executed when an exception (in this example InterruptedException) occurs
            }
            Assert.fail("fai ");

        //};

    };
    @Test
    public void test12() {
        try 
            {
                //Thread.sleep(1800);
            Thread.sleep(1500);
            } 
            catch(InterruptedException e)
            {
            // this part is executed when an exception (in this example InterruptedException) occurssss
            }
        if (System.currentTimeMillis()%3==1){
        }
        else {
          //
        };

    };
    @Test
    public void test13() {
                 try 
            {
                //Thread.sleep(90000);
            Thread.sleep(1500);
            } 
            catch(InterruptedException e)
            {
            // this part is executed when an exception (in this example InterruptedException) occurs
            }
        if (System.currentTimeMillis()%1==1){
        }
        else {
            Assert.fail("fail messajge5");
            

        };

    };

}
