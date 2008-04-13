////////////////////////////////////////////////////////////////
// ServletExample.java
////////////////////////////////////////////////////////////////

package com.objectplanet.chart.examples;

import com.objectplanet.chart.*;
import java.awt.*;
import javax.servlet.*;
import Acme.JPM.Encoders.*;


/**
 * This class implements a servlet, not using the standard ChartServlet 
 * class found in chartServer.jar. If you have Tomcat installed and started 
 * and the ServletExample class in your CLASSPATH, access the servlet through 
 * http://localhost:8080/examples/servlet/com.objectplanet.chart.examples.ServletExample
 * 
 * @author Bjorn J. Kvande.
 */
public class ServletExample extends GenericServlet {

	/**
	 * The service.
	 */
	public void service(ServletRequest req, ServletResponse res) 
	throws ServletException, java.io.IOException 
	{
		//create the chart
		BarChart chart = new BarChart(5);
		double[] values1 = new double[] {100, 200, 300, 400, 500};
		double[] values2 = new double[] {400, 300, 100, 200, 200};
		chart.setSeriesCount(2);
		chart.setSampleValues(0, values1);
		chart.setSampleValues(1, values2);
		chart.setBarType(BarChart.STACKED_BARS);
		chart.setRange(0, 1000);
		chart.set3DModeOn(true);
		chart.setTitle("ServletExample");
		chart.setTitleOn(true);
		chart.setValueLinesOn(true);
		chart.setMultiColorOn(true);

		// produce the gif image
		Image image = chart.getImage(300,200);
		ServletOutputStream out = (ServletOutputStream)res.getOutputStream();
		GifEncoder gif = new GifEncoder (image, out);
		gif.encode();
		out.flush();
		res.setContentType("image/gif");

		return;
	}
}