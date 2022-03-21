package my;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import java.lang.*;

@RunWith(Suite.class)

@Suite.SuiteClasses({
   mytest3.class,
   mytest2.class
})

  public class JunitTestSuite {   
}  
