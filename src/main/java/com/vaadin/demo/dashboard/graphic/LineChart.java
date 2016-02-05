package com.vaadin.demo.dashboard.graphic;

import org.apache.commons.lang3.StringUtils;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.ChartType;
import com.vaadin.addon.charts.model.HorizontalAlign;
import com.vaadin.addon.charts.model.LayoutDirection;
import com.vaadin.addon.charts.model.Legend;
import com.vaadin.addon.charts.model.ListSeries;
import com.vaadin.addon.charts.model.VerticalAlign;
import com.vaadin.addon.charts.model.XAxis;
import com.vaadin.addon.charts.model.YAxis;

public class LineChart extends Chart {

	private static final long serialVersionUID = 2492699179557379712L;
	
	public LineChart() {
		 getConfiguration().setTitle(StringUtils.EMPTY);
		 getConfiguration().setSubTitle(StringUtils.EMPTY);
		 getConfiguration().getChart().setType(ChartType.LINE);
		 setWidth("100%");
	     setHeight("450px");
	     configurarAxisX(null);
	     configurarAxisY(null);
	     cargarChart();
	}
	
	@Override
	public void attach() {
		super.attach();
	}
	
	private void cargarChart() {
		ListSeries ls = new ListSeries();
        ls.setName("Tokyo");
        ls.setData(7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6);
        getConfiguration().addSeries(ls);
	}
	
	public void configurarLegend(){
		Legend legend = getConfiguration().getLegend();
        legend.setLayout(LayoutDirection.VERTICAL);
        legend.setHorizontalAlign(HorizontalAlign.RIGHT);
        legend.setVerticalAlign(VerticalAlign.TOP);
        
        legend.setX(-10d);
        legend.setY(100d);
        legend.setBorderWidth(0);
	}

	public void configurarAxisX(String titulo) {
		XAxis xAxis = getConfiguration().getxAxis();
		xAxis.setCategories("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio");
	}

	public void configurarAxisY(String titulo) {
		YAxis yAxis = getConfiguration().getyAxis();
        yAxis.setMin(-5d);
        yAxis.setTitle("Temperature (°C)");
        yAxis.getTitle().setVerticalAlign(VerticalAlign.MIDDLE);
	}
}