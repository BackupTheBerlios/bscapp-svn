package com.objectplanet.chart.examples;
import com.objectplanet.chart.*;

import java.awt.*;
import java.awt.event.*;


/**
 * This example shows how to use the target value lines.
 * @author Bjorn J. Kvande.
 */
public class LineChartWithHole {

	public static void main(String[] argv) {
		// works with EasyCharts 2.1 prerelease 1, but not with 2.03
		LineChart chart = new LineChart();
		double[] values = new double[] {34,68,Double.NaN,56,75,Double.NaN,24,63,54};
		chart.setSampleCount(values.length);
		chart.setSampleValues(0, values);

		// display the chart
		Frame f = new Frame();
		f.add("Center", chart);
		f.setSize(400,300);
		f.show();
		
		// works with EasyCharts 2.03
		LineChart chart2 = new LineChart();
		values = new double[] {34,68,Double.NaN,56,75,Double.NaN,24,63,54};
		chart2.setSampleCount(values.length);
		chart2.setSampleValues(0, values);
		chart2.getSample(0, 2).clearValue();
		chart2.getSample(0, 5).clearValue();

		// display the chart
		Frame f2 = new Frame();
		f2.add("Center", chart2);
		f2.setSize(400,300);
		f2.setLocation(400,0);
		f2.show();
	}
}