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
     @Parameters(name= "{index}: fib[{0}]={1}")
     public static Iterable<Object[]> data() {
         return Arrays.asList(new Object[][] { { 0, 0 }, { 1, 1 }, { 2, 1 },
                 { 3, 2 }, { 4, 3 }, { 5, 5 }, { 6, 8 } });
     }

     private int fInput;

     private int fExpected;

     public mytest(int input, int expected) {
         fInput= input;
         fExpected= expected;
     }

     @Test
     public void test() {
         assertEquals(fExpected, Fibonacci.compute(fInput));
     }
 }
