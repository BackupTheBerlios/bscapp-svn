////////////////////////////////////////////////////////////////
// GifChartServlet.java
////////////////////////////////////////////////////////////////

import com.objectplanet.chart.*;
import Acme.JPM.Encoders.*;


/**
 * This servlet outputs the generated charts as a gif image.
 * 
 * @author Bjorn J. Kvande.
 */
public class GifChartServlet extends ChartServlet {
	public String encodeChartImage(Image image, OutputStream out) throws IOException {
		// create a gif image and send it to the client
		GifEncoder encoder = new GifEncoder(image, out);
		encoder.encode();
		out.flush();
		return "image/gif";
	}
}
