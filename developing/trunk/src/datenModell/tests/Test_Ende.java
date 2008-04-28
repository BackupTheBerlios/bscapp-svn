/**
 * 
 */
package datenModell.tests;



import junit.framework.TestCase;



/**
 * @author andre
 */
public class Test_Ende extends TestCase
{

  /*
   * (non-Javadoc)
   * 
   * @see junit.framework.TestCase#setUp()
   */
  protected void setUp() throws Exception
  {
    super.setUp();
  }


  /*
   * (non-Javadoc)
   * 
   * @see junit.framework.TestCase#tearDown()
   */
  protected void tearDown() throws Exception
  {
    super.tearDown();
  }


  /**
   * Test method for {@link java.lang.Object#getClass()}.
   */
  public void testGetClass()
  {
    Object o = new Object();
    assertNotNull(o);
    Bericht.ende();
  }

}
