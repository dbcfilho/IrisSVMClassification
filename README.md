# Análise e Classificação de Flores Iris com Support Vector Machine (SVM)

## Descrição do Projeto

Este projeto tem como objetivo realizar a classificação de flores Iris utilizando o algoritmo de Máquina de Vetores de Suporte (SVM). Inspirado em um estudo da Universidade Federal do Paraná, o projeto foi desenvolvido em Java com as bibliotecas Weka e JFreeChart. A análise inclui o carregamento de dados, treinamento do modelo, avaliação e visualização dos resultados.

## Funcionalidades

- **Carregamento dos Dados**: O projeto utiliza o conjunto de dados Iris em formato ARFF, que contém as características e os rótulos das flores.
  
- **Análise Inicial da Base de Dados**: 
  - Exibe os primeiros 5 indivíduos da base de dados.
  - Fornece estatísticas básicas, como médias, mínimos e máximos de cada coluna.
  - Apresenta informações detalhadas sobre os dados, incluindo o tipo de cada coluna.

- **Treinamento do Modelo SVM**: 
  - Importa o algoritmo SVC da biblioteca Weka.
  - Configura o modelo com um kernel automático.
  - Utiliza validação cruzada para avaliar a acurácia do modelo.

- **Avaliação do Modelo**: 
  - Exibe a acurácia média do modelo com validação cruzada.

- **Predição de Novas Instâncias**: 
  - Permite a predição da classe de uma nova flor com características específicas.

- **Visualização da Decisão do Modelo**: 
  - Cria gráficos de dispersão para visualizar como o modelo SVM separa as classes com base nas características de comprimento da sépala e largura da pétala.

## Estrutura do Projeto

/IrisClassificationProject
├── /src
│   ├── IrisClassifier.java
│   ├── IrisScatterPlot.java
│   ├── DataLoader.java
│   └── /utils
│       └── DataLoader.java
├── /resources
│   └── iris.arff
├── pom.xml
└── README.md



## Pré-requisitos

- Java 11 ou superior
- Apache Maven
- Bibliotecas:
  - Weka
  - JFreeChart

## Instalação

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu_usuario/IrisClassificationProject.git

```bash
	cd IrisClassificationProject

	mvn clean install

	java -cp "target/IrisClassificationProject-1.0.jar;lib/*" com.seu_pacote.IrisClassifier

	java -cp "target/IrisClassificationProject-1.0.jar;lib/*" com.seu_pacote.IrisScatterPlot
