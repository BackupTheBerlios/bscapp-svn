package com.objectplanet.chart.examples;
import com.objectplanet.chart.*;

import java.awt.*;
import java.awt.event.*;


/**
 * This example catches mouse motion events.
 * @author Bjorn J. Kvande.
 */
public class MouseEventChart extends BarChart implements MouseMotionListener {

	public void mouseMoved(MouseEvent e) {
		Point pos = new Point(e.getX(), e.getY());
		ChartSample bar = checkSelection(pos);
		if (bar != null) {
			System.out.println("mouse over bar: " + bar);
		}
	}
	
	public void mouseDragged(MouseEvent e) {
		Point pos = new Point(e.getX(), e.getY());
		ChartSample bar = checkSelection(pos);
		if (bar != null) {
			System.out.println("mouse dragged over bar: " + bar);
		}
	}
	
	public static void main(String[] argv) {
		// create the chart
		double[] values = new double[10];
		for (int i = 0; i < values.length; i++) {
			values[i] = Math.round(Math.random()*100);
		}
		MouseEventChart chart = new MouseEventChart();
		chart.setSampleCount(values.length);
		chart.setSampleValues(0, values);
		chart.setValueLinesOn(true);
		chart.addMouseMotionListener(chart);
		
		// display the chart
		Frame f = new Frame();
		f.add("Center", chart);
		f.setSize(400,300);
		f.show();
	}
}