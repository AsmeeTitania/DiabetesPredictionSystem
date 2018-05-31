package com.prediction.diabetes.nb;

import java.util.ArrayList;
import java.util.Map;
import java.net.Authenticator;

import com.prediction.diabetes.Datasets;
import com.prediction.diabetes.QuestionType;
import com.prediction.diabetes.Util;
import com.prediction.diabetes.entities.Investigation;

import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;

public class NaiveBayesClassifier {

	public static NaiveBayes train(String dataFile, String modelFile) throws NoClassDefFoundError{
		try {
			System.out.println("Train");
			Instances data = Datasets.getDataFromFile(dataFile);
			
			data.setClassIndex(data.numAttributes() - 1); // setting last attribute column as class
			System.out.println("Class Attributes: " + data.classAttribute());
			System.out.println("Num attributes: " + data.numAttributes());
          
			NaiveBayes bayes = new NaiveBayes();
			bayes.buildClassifier(data);

			System.out.println("Save");
			Util.save(modelFile, bayes);
         
			System.out.println("Evaluation");
			Evaluation eval = new Evaluation(data);
			eval.evaluateModel(bayes, data);
			System.out.println(eval.toSummaryString("\nResults\n", false));
			System.out.println("Confusion Matrix");
			double[][] cmMatrix = eval.confusionMatrix();
			for (double[] aCmMatrix : cmMatrix) {
				for (int col_i = 0; col_i < cmMatrix.length; col_i++) {
					System.out.print(aCmMatrix[col_i]);
					System.out.print("|");
				}
				System.out.println();
			}

			System.out.println("Test");
			for (int i = 0; i < 30; i++) {
				Instance instance = data.instance(i);
				instance.setClassMissing();
				double c = bayes.classifyInstance(instance);
				System.out.println(instance + " Class: " + c);
			} 
			return bayes;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public static String medicalBot(String modelFile, Map<QuestionType, Double> parameters) {
		try {
			NaiveBayes model = (NaiveBayes) Util.load(modelFile);
			int numAttributes = 9;
			Attribute numPregAttr = new Attribute("numPreg");
			Attribute glucoseAttr = new Attribute("glucose");
			Attribute diastolicBPAttr = new Attribute("diastolicBP");
			Attribute tricepThicknessAttr = new Attribute("tricepThickness");
			Attribute twoHrSerumAttr = new Attribute("twoHrSerum");
			Attribute bmiAttr = new Attribute("bmi");
			Attribute pedigreeAttr = new Attribute("pedigree");
			Attribute ageAttr = new Attribute("age");

			ArrayList<String> fvClassVal = new ArrayList<>(2);
			fvClassVal.add("0");
			fvClassVal.add("1");
			Attribute classAttribute = new Attribute("class", fvClassVal);

			ArrayList<Attribute> fvAttributes = new ArrayList<>(numAttributes);
			fvAttributes.add(numPregAttr);
			fvAttributes.add(glucoseAttr);
			fvAttributes.add(diastolicBPAttr);
			fvAttributes.add(tricepThicknessAttr);
			fvAttributes.add(twoHrSerumAttr);
			fvAttributes.add(bmiAttr);
			fvAttributes.add(pedigreeAttr);
			fvAttributes.add(ageAttr);
			fvAttributes.add(classAttribute);

			Instances instances = new Instances("Rel", fvAttributes, 1);
			instances.setClassIndex(numAttributes - 1);

			Instance instance = new DenseInstance(numAttributes);
			Investigation investigation = new Investigation();
			for (Map.Entry<QuestionType, Double> entry : parameters.entrySet()) {
				investigation.setValue(entry.getKey(), entry.getValue());
				
				instance.setValue(fvAttributes.get(0), investigation.getNumPreg());
				instance.setValue(fvAttributes.get(1), investigation.getGlucose());
				instance.setValue(fvAttributes.get(2), investigation.getDiastolicBP());
				instance.setValue(fvAttributes.get(3), investigation.getTricepThickness());
				instance.setValue(fvAttributes.get(4), investigation.getTwoHrSerum());
				instance.setValue(fvAttributes.get(5), investigation.getBmi());
				instance.setValue(fvAttributes.get(6), investigation.getPedigree());
				instance.setValue(fvAttributes.get(7), investigation.getAge());
				instance.setValue(fvAttributes.get(8), investigation.getCv());
				instances.add(instance);
			}
			double[] prob = model.distributionForInstance(instances.get(0));
			double index = model.classifyInstance(instances.get(0));
			double score = prob[(int) index] * 100;
			return "\nDiabetes possibility: " + (index == 0 ? "Negative" : "Positive") + " " + score + "%\n";
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
}
