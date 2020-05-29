import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PolynomialTest {

    private Polynomial polinomio;
    @Before
    public void setup(){

        polinomio = new Polynomial();
    }

    @Test
    public void testToStringEmptyList(){
        assertEquals("p(x)= 0", polinomio.toString());
    }

    @Test
    public void testNoEmptyList(){
        assertFalse(polinomio.size() == 0);
    }

    @Test
    public void testEmptyList(){
        assertTrue(polinomio.size() == 1);
    }

}