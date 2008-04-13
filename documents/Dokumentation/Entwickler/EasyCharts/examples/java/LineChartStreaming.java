package com.objectplanet.chart.examples;
import com.objectplanet.chart.*;

import java.awt.*;
import java.awt.event.*;


/**
 * This example shows how to use streaming data with the linechart.
 * @author Bjorn J. Kvande.
 */
public class LineChartStreaming {

	public static void main(String[] argv) {
		// create the chart
		LineChart chart = new LineChart();
		chart.setSampleCount(50);

		// display the chart
		NonFlickerPanel p = new NonFlickerPanel(new BorderLayout());
		p.add("Center", chart);
		Frame f = new Frame();
		f.add("Center", p);
		f.setSize(400,200);
		f.show();
		
		// continously add data
		while (true) {
			try {
				Thread.sleep(100);
				double value = Math.random()*100;
				chart.appendSampleValue(0, value, false);
			} catch (InterruptedException e) {
				// do nothing
			}
		}
	}
}