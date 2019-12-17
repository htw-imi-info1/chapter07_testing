
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DayTest.
 *
 * @author  Barne Kleinen
 */
public class DayTest1HFree020
{
    private Day day1;
    private Appointment info2;
    private Appointment lab;
    private Appointment gdm;
    private Appointment whatever;

  

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        day1 = new Day(1); // this is the sut - subject under test
        info2 = new Appointment("Info 1", 2);
        lab = new Appointment("Lab", 2);
        gdm = new Appointment("GDM", 2);
        whatever = new Appointment("whatever", 4);

    }

    private void dayWith1hBreak(){
        day1.makeAppointment(9, info2);
        day1.makeAppointment(12, lab);
    }

    @Test
    //own test method; should assert false
    public void testMakeApp25(){
        dayWith1hBreak();
        boolean actual = day1.makeAppointment(25, whatever);
        assertEquals(false, actual);
    }
    
    @Test
    //own test method; should assert true
    public void testMakeApp10(){
        boolean actual = day1.makeAppointment(10, whatever);
        assertEquals(true, actual);
    }
    
    
    @Test
    public void test2hSlotIsFound()
    {
        // given
        // day with 2h app on 9 and 12 hrs (setup)
        dayWith1hBreak();
        // when
        int actualValue = day1.findSpace(gdm);
        // then
        assertEquals("first slot with 2h available should be found",14, actualValue);
    }

    @Test
    public void testMakeApp15()
    {
        // given
        // day with 2h app on 9 and 12 hrs (setup)
        dayWith1hBreak();
        // when
        boolean actual = day1.makeAppointment(15, gdm);
        // then
        assertEquals(true, actual);
    }

    @Test
    public void testMakeApp16()
    {
        // given
        // day with 2h app on 9 and 12 hrs (setup)
        dayWith1hBreak();
        // when
        boolean actual = day1.makeAppointment(16, gdm);
        // then
        assertEquals(true, actual);
    }

    @Test
    public void testMakeApp17()
    {
        // given
        // day with 2h app on 9 and 12 hrs (setup)
         dayWith1hBreak();
       // when
        boolean actual = day1.makeAppointment(17, gdm);
        // then
        assertEquals(false, actual);
    }

    @Test
    public void testMakeApp18()
    {
        // given
         dayWith1hBreak();
       // day with 2h app on 9 and 12 hrs (setup)
        // when
        boolean actual = day1.makeAppointment(18, gdm);
        // then
        assertEquals(false, actual);
    }

    @Test
    public void testMakeApp9()
    {
        // given
       // empty day
        // when
        boolean actual = day1.makeAppointment(9, gdm);
        // then
        assertEquals(true, actual);
    }

    

    @Test
    public void testAppointmentWasActuallyScheduled()
    {
        // given empty day
        // when 
      day1.makeAppointment(14, info2);
      // then appointment is in schedule
        Appointment actual = day1.getAppointment(14);
        assertEquals(info2, actual);
    }
}

