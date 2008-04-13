/**
 * 
 */
package testen;




/**
 * @author andre
 */
public class IrgendeineKlasse
{

	// einzige existierende instanz von IrgendeineKlasse:
	private static IrgendeineKlasse singleton;


	// der "getter" für diese instanz...
	public static IrgendeineKlasse getSingleton()
	{
		if( singleton == null )
		{
			singleton = new IrgendeineKlasse();
		}
		return singleton;
	}


	private IrgendeineKlasse()
	{
		// privater konstruktor...
	}
}
