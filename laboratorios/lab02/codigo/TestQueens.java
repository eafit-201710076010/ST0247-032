
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestQueens.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TestQueens
{
    /**
     * Default constructor for test class TestQueens
     */
    public TestQueens()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    /**
     * Test método esValido
     */
    @Test
    public void testEsValido(){
        int[] tablero= {0,1,4,2,3};
        boolean esp=false;
        boolean res=Queens.esValido(tablero);
        assertEquals(esp,res);

        int[] tablero2= {0,2,4,1,3};
        boolean esp2=true;
        boolean res2=Queens.esValido(tablero2);
        assertEquals(esp,res);
    }
    
        /**
     * Test método queens
     */
    @Test
    public void testQueens(){
        int n =5;
        int esp=10;
        int res=Queens.queens(n);
        assertEquals(esp,res);

        int n2 =8;
        int esp2=92;
        int res2=Queens.queens(n2);
        assertEquals(esp2,res2);

    }

}
