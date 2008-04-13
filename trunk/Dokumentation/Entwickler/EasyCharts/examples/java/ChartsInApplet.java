////////////////////////////////////////////////////////////////
// ChartsInApplet.java
////////////////////////////////////////////////////////////////

package com.objectplanet.chart.examples;

import com.objectplanet.chart.*;
import java.awt.*;
import java.applet.*;


/**
 * This demonstrates how to add charts in a java applet.
 * @author Bjorn J. Kvande.
 */
public class ChartsInApplet extends Applet {
	
	/**
	 * Creates the charts.
	 */
	public void init() {
		setLayout(new GridLayout(0,2));
		PieChart pieChart = new PieChart();
		pieChart.setSampleCount(5);
		pieChart.setSampleValues(0, new double[] {1,2,3,4,5});
		add(pieChart);
		LineChart lineChart = new LineChart();
		lineChart.setSampleCount(10);
		lineChart.setSampleValues(0, new double[] {79,87,65,43,56,43,23,67,67,89});
		add(lineChart);
	}
}