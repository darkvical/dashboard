package com.vaadin.demo.dashboard.component;

import java.math.BigDecimal;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.PointClickEvent;
import com.vaadin.addon.charts.PointClickListener;
import com.vaadin.addon.charts.model.ChartType;
import com.vaadin.addon.charts.model.Cursor;
import com.vaadin.addon.charts.model.DataSeries;
import com.vaadin.addon.charts.model.DataSeriesItem;
import com.vaadin.addon.charts.model.Labels;
//import com.vaadin.addon.charts.model.DataLabels;
import com.vaadin.addon.charts.model.Options3d;
import com.vaadin.addon.charts.model.PlotOptionsPie;
import com.vaadin.addon.charts.model.style.Color;
import com.vaadin.addon.charts.model.style.SolidColor;

public class ExampleChart extends Chart implements PointClickListener{
	private static final long serialVersionUID = -3965746550336615471L;
	private String lenguajes[] = {"Java", "Rubi", "Python", "C#", "Otros"};
	private BigDecimal totales[] = {new BigDecimal(35.0), new BigDecimal(25.0), new BigDecimal(25.0), new BigDecimal(13.0), new BigDecimal(2.0)};
	private Color colores[] = new Color[] {new SolidColor("#3090F0"), new SolidColor("#18DDBB"), new SolidColor("#C84074"), 
										   new SolidColor("#D4D4D4"), new SolidColor("#F09042")};
	
	public ExampleChart() {
		 getConfiguration().setTitle("Ejemplo de vaadin chart");
		 getConfiguration().getChart().setType(ChartType.PIE);
		 setWidth("100%");
	     setHeight("450px");
		 construirPie();
	}
	
	private void construirPie(){
		//Para dar formato de porcentaje	
		PlotOptionsPie plotOptions = new PlotOptionsPie();
        plotOptions.setCursor(Cursor.POINTER);
        Labels labels = new Labels(true);
        labels.setFormatter("''+ this.point.name +': '+ this.percentage +' %'");
        plotOptions.setDataLabels(labels);
        plotOptions.setDepth(45);
        getConfiguration().setPlotOptions(plotOptions);		
		
		DataSeries series = new  DataSeries();
		for (int i = 0; i < lenguajes.length; i++) {
			DataSeriesItem item = new DataSeriesItem(lenguajes[i], totales[i]);
			item.setName(lenguajes[i]);
			item.setColor(colores[i]);
			series.add(item);
		}		
		getConfiguration().setSeries(series);
		
		//Para dar opciones de 3D
		Options3d options3d = new Options3d();
        options3d.setEnabled(true);
        options3d.setAlpha(60);
        getConfiguration().getChart().setOptions3d(options3d);
        addPointClickListener(this);
        drawChart(getConfiguration());
	}

	@Override
	public void onClick(PointClickEvent event) {
		abrirDetalle((DataSeries) event.getSeries(), event.getPointIndex()); 
	}

	private void abrirDetalle(DataSeries series, int index) {
		System.out.println(series.get(index).getName());
	}
}