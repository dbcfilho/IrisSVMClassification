package com.AlgoritimoSVMIris;

import weka.classifiers.functions.SMO;
import weka.core.Attribute;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.Evaluation;

import java.util.Enumeration;
import java.util.Random;

public class IrisClassifier {

    public static void main(String[] args) throws Exception {
        // Carregar a base de dados Iris do Weka
        DataSource source = new DataSource("resources/iris.arff");
        Instances irisData = source.getDataSet();

        // Definir a última coluna como a classe de destino
        if (irisData.classIndex() == -1)
            irisData.setClassIndex(irisData.numAttributes() - 1);

        // Criar o classificador SVM (chamado de SMO no Weka)
        SMO svm = new SMO();

        // Validar o modelo usando Cross-Validation (com 10 dobras)
        Evaluation eval = new Evaluation(irisData);
        eval.crossValidateModel(svm, irisData, 10, new Random(1));

        // Exibir os resultados de acurácia
        System.out.println("Acurácia com Cross Validation: " + eval.pctCorrect() + "%");

        // Treinar o modelo com todos os dados
        svm.buildClassifier(irisData);

        // Criar um novo exemplo para fazer predição (dados de uma nova flor)
        // Comprimento e largura da sépala e pétala
        Instance novaFlor = new Instance() {
            @Override
            public Object copy() {
                return null;
            }

            @Override
            public Attribute attribute(int i) {
                return null;
            }

            @Override
            public Attribute attributeSparse(int i) {
                return null;
            }

            @Override
            public Attribute classAttribute() {
                return null;
            }

            @Override
            public int classIndex() {
                return 0;
            }

            @Override
            public boolean classIsMissing() {
                return false;
            }

            @Override
            public double classValue() {
                return 0;
            }

            @Override
            public Instance copy(double[] doubles) {
                return null;
            }

            @Override
            public Instances dataset() {
                return null;
            }

            @Override
            public void deleteAttributeAt(int i) {

            }

            @Override
            public Enumeration<Attribute> enumerateAttributes() {
                return null;
            }

            @Override
            public boolean equalHeaders(Instance instance) {
                return false;
            }

            @Override
            public String equalHeadersMsg(Instance instance) {
                return "";
            }

            @Override
            public boolean hasMissingValue() {
                return false;
            }

            @Override
            public int index(int i) {
                return 0;
            }

            @Override
            public void insertAttributeAt(int i) {

            }

            @Override
            public boolean isMissing(int i) {
                return false;
            }

            @Override
            public boolean isMissingSparse(int i) {
                return false;
            }

            @Override
            public boolean isMissing(Attribute attribute) {
                return false;
            }

            @Override
            public Instance mergeInstance(Instance instance) {
                return null;
            }

            @Override
            public int numAttributes() {
                return 0;
            }

            @Override
            public int numClasses() {
                return 0;
            }

            @Override
            public int numValues() {
                return 0;
            }

            @Override
            public void replaceMissingValues(double[] doubles) {

            }

            @Override
            public void setClassMissing() {

            }

            @Override
            public void setClassValue(double v) {

            }

            @Override
            public void setClassValue(String s) {

            }

            @Override
            public void setDataset(Instances instances) {

            }

            @Override
            public void setMissing(int i) {

            }

            @Override
            public void setMissing(Attribute attribute) {

            }

            @Override
            public void setValue(int i, double v) {

            }

            @Override
            public void setValueSparse(int i, double v) {

            }

            @Override
            public void setValue(int i, String s) {

            }

            @Override
            public void setValue(Attribute attribute, double v) {

            }

            @Override
            public void setValue(Attribute attribute, String s) {

            }

            @Override
            public void setWeight(double v) {

            }

            @Override
            public Instances relationalValue(int i) {
                return null;
            }

            @Override
            public Instances relationalValue(Attribute attribute) {
                return null;
            }

            @Override
            public String stringValue(int i) {
                return "";
            }

            @Override
            public String stringValue(Attribute attribute) {
                return "";
            }

            @Override
            public double[] toDoubleArray() {
                return new double[0];
            }

            @Override
            public String toStringNoWeight(int i) {
                return "";
            }

            @Override
            public String toStringNoWeight() {
                return "";
            }

            @Override
            public String toStringMaxDecimalDigits(int i) {
                return "";
            }

            @Override
            public String toString(int i, int i1) {
                return "";
            }

            @Override
            public String toString(int i) {
                return "";
            }

            @Override
            public String toString(Attribute attribute, int i) {
                return "";
            }

            @Override
            public String toString(Attribute attribute) {
                return "";
            }

            @Override
            public double value(int i) {
                return 0;
            }

            @Override
            public double valueSparse(int i) {
                return 0;
            }

            @Override
            public double value(Attribute attribute) {
                return 0;
            }

            @Override
            public double weight() {
                return 0;
            }
        };
        novaFlor.setDataset(irisData); // Associar o exemplo ao dataset

        // Fazer a predição
        double classePrevista = svm.classifyInstance(novaFlor);
        System.out.println("Classe prevista: " + classePrevista);

        // Mostrar a classe prevista (interpretando o valor)
        System.out.println("Classe prevista (Virginica): " + irisData.classAttribute().value((int) classePrevista));
    }
}
