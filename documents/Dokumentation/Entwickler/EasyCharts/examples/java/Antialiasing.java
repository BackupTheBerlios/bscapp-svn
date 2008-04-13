package com.objectplanet.chart.examples;
import com.objectplanet.chart.*;
import java.awt.*;

/**
 * This example shows how to use antialiasing in EasyCharts.
 * This example requires jdk1.2
 * @author Philipp A. Kolibaba.
 */
public class Antialiasing {
	
	public static void main(String[] argv) {
		// create the chart
		LineChart chart = new LineChart();
		chart.setSampleCount(20);
		chart.setSeriesCount(4);
		for (int serie = 0; serie < chart.getSeriesCount(); serie++) {
			double[] values = new double[chart.getSampleCount()];
			for (int i = 0; i < values.length; i++) {
				values[i] = Math.round(Math.random()*10 + (serie*10));
			}
			chart.setSampleValues(serie, values);
			chart.setSeriesLabel(serie, "series " + serie + "\n");
		}
		chart.setSampleScrollerOn(true);
		chart.setRangeAdjusterOn(0,true);
		chart.setRelativeRange(1,10);
		
		// create a graphics context to apply antialiasing for
		Image image = chart.createImage(1024, 768);
		Graphics2D g2D = (Graphics2D)image.getGraphics();
		g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		// provide the created graphics context to the chart
		chart.setExternalGraphics(g2D, image);

		// display the chart
		com.objectplanet.chart.NonFlickerPanel p = new com.objectplanet.chart.NonFlickerPanel(new BorderLayout());
		p.add("Center", chart);
		Frame f = new Frame();
		f.add("Center", p);
		f.setSize(400,280);
		f.show();
	}
}