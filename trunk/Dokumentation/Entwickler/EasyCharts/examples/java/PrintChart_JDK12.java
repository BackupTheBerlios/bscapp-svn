package com.objectplanet.chart.examples;
import com.objectplanet.chart.*;

import java.awt.*;
import java.awt.print.*;

/**
 * This example prints a bar chart.
 * @author Bjorn J. Kvande.
 */
public class PrintChart_JDK12 implements Printable, Pageable {

	private LineChart chart;
	private PrinterJob printJob;
	
	public PrintChart_JDK12() {
		// create the chart
		printJob = PrinterJob.getPrinterJob();
		double[] values = new double[20];
		for (int i = 0; i < values.length; i++) {
			values[i] = Math.round(Math.random()*100);
		}
		chart = new LineChart();
		chart.setSampleCount(values.length);
		chart.setSampleValues(0, values);
		chart.setValueLinesOn(true);
		chart.setTitle("this chart will be printed");
		chart.setTitleOn(true);
		chart.setValueLabelsOn(true);
		
		// display the chart
		Frame f = new Frame();
		f.add("Center", chart);
		f.setSize(400,300);
		f.show();
	}
	
	public void printChart() {
		// try to print the chart
		printJob.setPrintable(this);
		printJob.setPageable(this);
		if (printJob.printDialog()) {
			try {
				printJob.print();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// Pageable interface
	public int getNumberOfPages() {
		return 1;
	}
	
	// Pageable interface
	public PageFormat getPageFormat(int index) {
		return printJob.defaultPage();
	}
	
	// Pageable interface
	public Printable getPrintable(int index) {
		return this;
	}
	
	// Printable interface
	public int print(Graphics g, PageFormat pageFormat, int pageIndex) {
		double image_x = pageFormat.getImageableX();
		double image_y = pageFormat.getImageableY();
		g.translate((int)image_x, (int)image_y);
		chart.print(g);
		return PAGE_EXISTS;
	}
	
	public static void main(String[] argv) {
		PrintChart_JDK12 p = new PrintChart_JDK12();
		p.printChart();
	}
}