package com.objectplanet.chart.examples;
import com.objectplanet.chart.*;

import java.awt.*;
import java.awt.event.*;


/**
 * This example shows how to use the floating value and bar labels.
 * @author Bjorn J. Kvande.
 */
public class BarChartTooltip {

	public static void main(String[] argv) {
		// create the chart
		double[] values = new double[10];
		String[] labels = new String[values.length];
		for (int i = 0; i < values.length; i++) {
			values[i] = Math.round(Math.random()*100);
			labels[i] = "bar" + i;
		}
		BarChart chart = new BarChart();
		chart.setSampleCount(values.length);
		chart.setSampleValues(0, values);
		chart.setSampleLabels(labels);
		chart.setRelativeRange(1.0, 100);
		
		// turn on the floating value labels
		chart.setValueLabelsOn(true);
		chart.setValueLabelStyle(BarChart.FLOATING);
		chart.setBarLabelsOn(true);
		chart.setSampleLabelStyle(BarChart.FLOATING);

		// display the chart
		NonFlickerPanel p = new NonFlickerPanel(new BorderLayout());
		p.add("Center", chart);
		Frame f = new Frame();
		f.add("Center", p);
		f.setSize(400,300);
		f.show();
	}
}