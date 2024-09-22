package com.AlgoritimoSVMIris.utils;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class DataLoader {

    private String filePath;

    public DataLoader(String filePath) {
        this.filePath = filePath;
    }

    public Instances loadData() throws Exception {
        // Carregar a base de dados do arquivo ARFF
        DataSource source = new DataSource(filePath);
        Instances data = source.getDataSet();

        // Definir a última coluna como a classe de destino
        if (data.classIndex() == -1) {
            data.setClassIndex(data.numAttributes() - 1);
        }

        return data;
    }
}
