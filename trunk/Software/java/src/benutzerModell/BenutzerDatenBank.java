package benutzerModell;



import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class BenutzerDatenBank
{
	
	@ SuppressWarnings( "unused" )
	private Map< String, Byte[] > passw�rter;
	
	@ SuppressWarnings( "unused" )
	private List< Leser > benutzer;
	
	private static BenutzerDatenBank INSTANZ;
	
	
	public static BenutzerDatenBank getInstanz()
	{
		if( INSTANZ == null )
		{
			INSTANZ = new BenutzerDatenBank();
		}
		
		return INSTANZ;
	}
	

	private BenutzerDatenBank()
	{
		passw�rter = new HashMap< String, Byte[] >();
	}
	

	public void anmelden( String name, Byte[] passwort )
	{

	}
}
