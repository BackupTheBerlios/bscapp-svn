/**
 * 
 */
package testen;



import factories.DiagrammFactory;



/**
 * @author andre
 */
@ SuppressWarnings( "serial" )
public class TesteDiagrammFactory extends AndresJFrame
{

	/**
	 * @param sofortAnzeigen
	 */
	public TesteDiagrammFactory()
	{
		super( false );
		double[] values =
		{ 0.2, 4, 10, 0.4, 1, 6 };
		String[] labels =
		{ "afd", "sdg", "wet", "jhkl", "vn", "asdfasdf" };
		
		center.add( DiagrammFactory.erzeugSimpleBalken( values, labels ));
		zeigeMittig();
	}
	
	public static void main( String[] args )
    {
		new TesteDiagrammFactory();
    }

}
