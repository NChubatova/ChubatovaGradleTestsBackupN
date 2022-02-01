package my;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions;
import java.lang.*;

public class mytest {

    @Test
public void testAdd() {
    assertEquals(42, Integer.sum(19, 23));
};

}
