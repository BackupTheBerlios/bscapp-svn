package com.objectplanet.chart.examples;
import com.objectplanet.chart.*;

import java.awt.*;
import java.awt.event.*;


/**
 * This example shows how to use the target value lines.
 * @author Bjorn J. Kvande.
 */
public class BarChartTarget {

	public static void main(String[] argv) {
		// create the chart
		double[] values = new double[10];
		for (int i = 0; i < values.length; i++) {
			values[i] = Math.round(Math.random()*100);
		}
		BarChart chart = new BarChart();
		chart.setSampleCount(values.length);
		chart.setSampleValues(0, values);
		chart.setValueLinesOn(true);
		chart.setRange(0, 150);

		// set the target lines
		chart.setTargetValueLine("break even", 20, Color.red, BarChart.TARGET_LINE_ID_AND_VALUE_LABEL);
		chart.setTargetValueLine("budget", 100, Color.green.darker(), BarChart.TARGET_LINE_ID_AND_VALUE_LABEL);
		chart.setTargetValueLine("this is ok too", 50, Color.blue.darker(), BarChart.TARGET_LINE_ID_LABEL);
		
		// display the chart
		Frame f = new Frame();
		f.add("Center", chart);
		f.setSize(400,300);
		f.show();
	}
}