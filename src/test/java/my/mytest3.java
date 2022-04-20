package my;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.lang.*;

import org.junit.jupiter.api.Tag;

public class mytest3 {
    @Tag("slow")
    @Test
    public void test311c() {
                 try 
            {
                //Thread.sleep(1);
            Thread.sleep(15);
            } 
            catch(InterruptedException e)
            {
            // this part is executed when an exception (in this example InterruptedException) occurs
            }
        //if (System.currentTimeMillis()%3==1){
        //}
        //else {
            //Assert.fail("fail mkhg");
System.out.print("GfG1s");
        //};

    };
    @Test
    public void test312c() {
        try 
            {
                //Thread.sleep(90000);
            Thread.sleep(150);
            } 
            catch(InterruptedException e)
            {
            // this part is executed when an exception (in this example InterruptedException) occurs
            }
        if (System.currentTimeMillis()%3==1){
        }
        else {
          //
        };

    };
    @Tag("slow")
    @Test
    public void test313c() {
                 try 
            {
                //Thread.sleep(90000);
            Thread.sleep(150);
            } 
            catch(InterruptedException e)
            {
            // this part is executed when an exception (in this example InterruptedException) occurs
            }
        if (System.currentTimeMillis()%1==1){
        }
        else {
            //Assert.fail("fail messajge2");
            System.out.print("GfG1");
        };

    };

}
