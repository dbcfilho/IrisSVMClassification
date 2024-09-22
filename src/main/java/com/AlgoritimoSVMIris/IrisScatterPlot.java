package com.AlgoritimoSVMIris;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

import javax.swing.*;
import java.awt.*;

public class IrisScatterPlot {

    public static void main(String[] args) throws Exception {
        // Carregar a base de dados Iris do Weka
        DataSource source = new DataSource("resources/iris.arff");
        Instances irisData = source.getDataSet();

        // Definir a última coluna como a classe de destino
        if (irisData.classIndex() == -1)
            irisData.setClassIndex(irisData.numAttributes() - 1);

        // Criar uma série de dados para o gráfico
        XYSeries series = new XYSeries("Iris");

        // Adicionar dados ao gráfico
        for (int i = 0; i < irisData.numInstances(); i++) {
            Instance instance = irisData.instance(i);
            double sepalLength = instance.value(0); // Comprimento da sépala
            double petalWidth = instance.value(3);   // Largura da pétala
            series.add(sepalLength, petalWidth);
        }

        // Criar um conjunto de dados para o gráfico
        XYSeriesCollection dataset = new XYSeriesCollection(series);

        // Criar o gráfico de dispersão
        JFreeChart scatterPlot = ChartFactory.createScatterPlot(
                "Iris Scatter Plot",
                "Sepal Length (cm)",
                "Petal Width (cm)",
                dataset
        );

        // Exibir o gráfico em uma janela
        JFrame frame = new JFrame("Iris Data Visualization");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ChartPanel(scatterPlot), BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}
