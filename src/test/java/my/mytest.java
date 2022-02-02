package my;

import org.junit.*;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import java.lang.*;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
 
import java.util.Arrays;
import java.util.Collection;



@RunWith(Parameterized.class)
 public class mytest {
    String a[] = new String[] { "A", "B", "C", "D" };
     @Parameters(name= "{index}: str{0}")
     public static Iterable<Object[]> data() {
         return Arrays.asList(a);
     }

     private String fInput;




     @Test
     public void test() {
         Assert.assertEquals("B", fInput);
     }
 }
