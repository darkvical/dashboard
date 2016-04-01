package com.vaadin.demo.dashboard.graphic;

import org.apache.commons.lang3.StringUtils;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.ChartType;
import com.vaadin.addon.charts.model.HorizontalAlign;
import com.vaadin.addon.charts.model.LayoutDirection;
import com.vaadin.addon.charts.model.Legend;
import com.vaadin.addon.charts.model.ListSeries;
import com.vaadin.addon.charts.model.PlotOptionsColumn;
import com.vaadin.addon.charts.model.Stacking;
import com.vaadin.addon.charts.model.Tooltip;
import com.vaadin.addon.charts.model.VerticalAlign;
import com.vaadin.addon.charts.model.XAxis;
import com.vaadin.addon.charts.model.YAxis;

public class BarGrupoChart extends Chart {
	private static final long serialVersionUID = 5779776319227403831L;
	
	public BarGrupoChart() {
		getConfiguration().setTitle(StringUtils.EMPTY);
		getConfiguration().setSubTitle(StringUtils.EMPTY);
		getConfiguration().getChart().setType(ChartType.COLUMN);
		configurarLegenda();
		configurarAxisX(new String[]{ "Abril - 2015", "Abril - 2016" });
		configurarAxisY("Monto");
		configurarFormato();
		cargarGrafico();
	}
	
	private void configurarLegenda() {
		Legend legend = getConfiguration().getLegend();
        legend.setLayout(LayoutDirection.VERTICAL);
        legend.setHorizontalAlign(HorizontalAlign.RIGHT);
        legend.setVerticalAlign(VerticalAlign.TOP);        
        legend.setX(-10d);
        legend.setY(5d);
        legend.setBorderWidth(0);
	}
	
	private void configurarAxisX(String[] axisX) {
		XAxis xAxis = new XAxis();
        xAxis.setCategories(axisX);
        getConfiguration().addxAxis(xAxis);
	}
	
	private void configurarAxisY(String titulo) {
		YAxis yAxis = new YAxis();        
		yAxis.setAllowDecimals(false);
        yAxis.setMin(0);        
//        yAxis.setMaxPadding(20);
        yAxis.setTitle(titulo);
        getConfiguration().addyAxis(yAxis);
	}
	
	private void configurarFormato() {
		Tooltip tooltip = new Tooltip();
        tooltip.setFormatter("function() { return '<b>'+ this.x +'</b><br/>'"
                + "+this.series.name +': '+ this.y +'<br/>'+'Total: '+ this.point.stackTotal; }");
        getConfiguration().setTooltip(tooltip);

        PlotOptionsColumn plotOptions = new PlotOptionsColumn();
        plotOptions.setStacking(Stacking.NORMAL);
        getConfiguration().setPlotOptions(plotOptions);
	}
	
	public void cargarGrafico() {
		ListSeries series = new ListSeries("Gastos", new Number[]{42, 20});
		series.setStack("male");
		getConfiguration().addSeries(series);		
		
		series = new ListSeries("Ingresos", new Number[]{25, 50});
		series.setStack("male");
		getConfiguration().addSeries(series);
	}
}
