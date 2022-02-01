package my;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.lang.*;

public class mytest2 {

    @Test
public void testAdd() {
    assertEquals(42, Integer.sum(19, 23));
};

}
