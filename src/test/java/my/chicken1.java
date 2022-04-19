package my;
//haha
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import java.lang.*;



public class chicken1 {

    

    @Test
    public void chicken11() {
        //if (System.currentTimeMillis()%3==1){
        //}
        //else {
           System.out.print("##teamcity[setParameter name='ddd' value='fff']");
          System.out.print("teamcity[setParameter name='ddd' value='fff']");
         try 
            {
                //Thread.sleep(9);
            Thread.sleep(1000);
            } 
            catch(InterruptedException e)
            {
            // this part is executed when an exception (in this example InterruptedException) occurs
            }
            //Assert.fail("fai ");

        //};

    };
    @Test
    public void chiсken12() {
        try 
            {
                //Thread.sleep(1800);
            Thread.sleep(1000);
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
    public void chicken13() {
                 try 
            {
                //Thread.sleep(90000);
            Thread.sleep(1000);
            } 
            catch(InterruptedException e)
            {
            // this part is executed when an exception (in this example InterruptedException) occurs
            }
        if (System.currentTimeMillis()%1==1){
        }
        else {
            //Assert.fail("fail messajge5");
            

        };

    };

}
