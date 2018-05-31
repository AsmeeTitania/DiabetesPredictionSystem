package com.prediction.diabetes;

import weka.core.Instances;
import weka.core.converters.ConverterUtils;
import weka.experiment.InstanceQuery;


public class Datasets {
    public static Instances getDataFromFile(String filename) throws Exception {
        ConverterUtils.DataSource source = new ConverterUtils.DataSource(filename);
        Instances data = source.getDataSet();
        // setting class attribute if the data format does not provide this information
        // For example, the XRFF format saves the class attribute information as well
//        if (data.classIndex() == -1)
//            data.setClassIndex(data.numAttributes() - 1);
        return data;
    }
}
