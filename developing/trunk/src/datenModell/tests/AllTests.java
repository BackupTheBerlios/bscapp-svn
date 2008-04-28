/**
 * 
 */
package datenModell.tests;



import junit.framework.Test;
import junit.framework.TestSuite;



/**
 * @author andre
 */
public class AllTests
{

  public static Test suite()
  {
    Bericht.start();

    TestSuite suite = new TestSuite("Test for datenModell.tests");
    // $JUnit-BEGIN$

    suite.addTestSuite(Test_Auswertung.class);

    suite.addTestSuite(Test_Tabelle.class);

    suite.addTestSuite(Test_TabelleBlatt.class);


    // hier neue testklassen einfügen!


    suite.addTestSuite(Test_Ende.class);

    // $JUnit-END$
    return suite;
  }
}
