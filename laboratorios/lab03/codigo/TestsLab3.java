
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
/**
 * The test class TestsLab3.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TestsLab3
{
    /**
     * Default constructor for test class TestsLab3
     */
    public TestsLab3()
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

    //PUNTO 1.2
    /**
     * Test método nReinas(una solución)
     */
    @Test
    public void test1_1(){
        int [] res4=Lab03.nReinas(4);
        int [] esp4={1,3,0,2};
        assertArrayEquals (esp4,res4);

        int [] res8=Lab03.nReinas(8);
        int [] esp8={0,4,7,5,2,6,1,3};
        assertArrayEquals (esp8,res8);

        int [] res3=Lab03.nReinas(3);
        int [] esp3=null;
        assertArrayEquals (esp3,res3);
    }

    /**
     * Test recorrido BSF 
     */
    @Test
    public void test1_3(){
        Digraph g = new DigraphAL(4);
        g.addArc(0,1,1);
        g.addArc(1,3,1);
        g.addArc(0,2,1);
        g.addArc(3,0,1);
        ArrayList<Integer> esp = Lab03.bfsRetornador(g,0);
        ArrayList<Integer> res= new ArrayList<Integer>();
        res.add(0);
        res.add(1);
        res.add(2);
        res.add(3);

        assertEquals(esp,res);

        Digraph g2 = new DigraphAM(12);
        g2.addArc(5,11,1);
        g2.addArc(11,2,1);
        g2.addArc(7,11,1);
        g2.addArc(7,8,1);
        g2.addArc(11,9,1);
        g2.addArc(11,10,1);
        g2.addArc(3,8,1);
        g2.addArc(3,10,1);
        g2.addArc(8,9,1);
        ArrayList<Integer> esp2 = Lab03.bfsRetornador(g2,7);
        ArrayList<Integer> res2= new ArrayList<Integer>();
        res2.add(7);
        res2.add(8);
        res2.add(11);
        res2.add(9);
        res2.add(2);
        res2.add(10);

        assertEquals(esp2,res2);
    }
    
        @Test
    public void test1_6(){
    
    }
}

