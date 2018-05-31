package com.prediction.diabetes.entities;

import com.prediction.diabetes.QuestionType;


public class Investigation {
    double numPreg = Double.NaN;
    double glucose = Double.NaN;
    double diastolicBP = Double.NaN;
    double tricepThickness = Double.NaN;
    double twoHrSerum = Double.NaN;
    double bmi = Double.NaN;
    double pedigree = Double.NaN;
    double age = Double.NaN;
    double cv = Double.NaN;
    double weight = Double.NaN;


    public void setValue(QuestionType type, double value){
        if(value != Double.NaN) {
            if (type == QuestionType.AGE) this.age = value;
            if (type == QuestionType.WEIGHT) this.weight = value;
            if (type == QuestionType.NUM_PREGNENCY) this.numPreg = value;
            if (type == QuestionType.GlUCOSE_TOLERANCE) this.glucose = value;
            if (type == QuestionType.DIASTOLIC_BP) this.diastolicBP = value;
            if (type == QuestionType.TRICEP_THICKNESS) this.tricepThickness = value;
            if (type == QuestionType.TWO_HOUR) this.twoHrSerum = value;
            if (type == QuestionType.BMI) this.bmi = value;
            if (type == QuestionType.PEDIGREE) this.pedigree = value;
        }
    }

    public double getNumPreg() {
        return numPreg;
    }

    public void setNumPreg(double numPreg) {
        this.numPreg = numPreg;
    }

    public double getGlucose() {
        return glucose;
    }

    public void setGlucose(double glucose) {
        this.glucose = glucose;
    }

    public double getDiastolicBP() {
        return diastolicBP;
    }

    public void setDiastolicBP(double diastolicBP) {
        this.diastolicBP = diastolicBP;
    }

    public double getTricepThickness() {
        return tricepThickness;
    }

    public void setTricepThickness(double tricepThickness) {
        this.tricepThickness = tricepThickness;
    }

    public double getTwoHrSerum() {
        return twoHrSerum;
    }

    public void setTwoHrSerum(double twoHrSerum) {
        this.twoHrSerum = twoHrSerum;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public double getPedigree() {
        return pedigree;
    }

    public void setPedigree(double pedigree) {
        this.pedigree = pedigree;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public double getCv() {
        return cv;
    }

    public void setCv(double cv) {
        this.cv = cv;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
