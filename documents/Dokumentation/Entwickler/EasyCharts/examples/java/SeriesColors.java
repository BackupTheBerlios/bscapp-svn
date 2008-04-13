package com.objectplanet.chart.examples;
import com.objectplanet.chart.*;

import java.awt.*;


/**
 * This example shows how to set the colors of each data series.
 * @author Bjorn J. Kvande.
 */
public class SeriesColors {

	public static void main(String[] argv) {
		// create the chart
		int sampleCount = 3;
		int seriesCount = 8;
		BarChart chart = new BarChart();
		chart.setSampleCount(sampleCount);
		chart.setSeriesCount(seriesCount);
		for (int serie = 0; serie < seriesCount; serie++) {
			for (int sample = 0; sample < sampleCount; sample++) {
				chart.setSampleValue(serie, sample, Math.round(Math.random()*100));
			}
		}
		
		// set the colors, when you have multiple series, the sample colors
		// set will be the colors used per serie, not per sample
		chart.setSampleColor(0, new Color(0xCC0000));
		chart.setSampleColor(1, new Color(0xFF3333));
		chart.setSampleColor(2, new Color(0xFF9900));
		chart.setSampleColor(3, new Color(0xFFFF00));
		chart.setSampleColor(4, new Color(0x99FF00));
		chart.setSampleColor(5, new Color(0x66CC00));
		chart.setSampleColor(6, new Color(0x669999));
		chart.setSampleColor(7, new Color(0x3300FF));
		chart.setMultiColorOn(true);
		
		// other bar attributes
		chart.setBarWidth(0.7);
		chart.set3DModeOn(true);
		chart.setValueLinesOn(true);
		
		// display the chart
		Frame f = new Frame();
		f.add("Center", chart);
		f.setSize(500,300);
		f.show();
		
		/* some colors to use
		#CC0000,#FF3333,#FF9900,#FFFF00,#99FF00,#66CC00,#669999,
		#3300FF,#000099,#663399,#CC33CC,#CC6699,#CC9933,#996600,
		#CCCCCC,#999999 */
	}
}
