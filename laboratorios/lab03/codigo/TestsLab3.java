
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

    /**
     * Test método nReinas(una solución)
     */
    @Test
    public void test1_1(){
        int [] res4=Lab03.nReinas(4);
        int [] esp4={1,3,0,2};
        assertArrayEquals (res4,esp4);

        int [] res8=Lab03.nReinas(8);
        int [] esp8={0,4,7,5,2,6,1,3};
        assertArrayEquals (res8,esp8);

        int [] res3=Lab03.nReinas(3);
        int [] esp3=null;
        assertArrayEquals (res3,esp3);
    }
}

