////////////////////////////////////////////////////////////////
// SaveJpegChart.java
////////////////////////////////////////////////////////////////

package com.objectplanet.chart.examples;

import com.objectplanet.chart.*;
import com.objectplanet.image.*;
import java.awt.*;
import java.io.*;


/**
 * This class generates a chart and writes it as a png file.
 * @author Bjorn J. Kvande.
 */
public class SavePngChart {
	
	/**
	 * Creates a chart and writes it to the specified file.
	 */
	public static void main(String[] argv) {
		//create the chart
		BarChart chart = new BarChart(5);
		double[] values = new double[] {100, 200, 300, 400, 500};
		chart.setSampleValues(0, values);
		chart.setRange(0, 500);
		chart.set3DModeOn(true);
		chart.setTitle("Chart generated as a JPEG");
		chart.setTitleOn(true);
		chart.setValueLinesOn(true);

		// write the chart as a png to the specified file
		try {
			Image image = chart.getImage(300,200);
			String file = (argv.length > 0 ? argv[0] : "chart.png");
			FileOutputStream out = new FileOutputStream(file);
			PngEncoder encoder = new PngEncoder(PngEncoder.COLOR_TRUECOLOR);
			encoder.encode(image, out);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}
}