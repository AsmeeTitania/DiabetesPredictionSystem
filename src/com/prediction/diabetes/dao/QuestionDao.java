package com.prediction.diabetes.dao;

import com.prediction.diabetes.QuestionType;
import com.prediction.diabetes.entities.Investigation;
import com.prediction.diabetes.entities.Question;


public class QuestionDao {

    public Question getQuestion(QuestionType type){
        Question question = new Question();
        question.setQuestion("What is "+type.toString()+"?");
        question.setType(type);
        return question;
    }

    public Question getQuestion(Investigation investigation){
        Question question = new Question();

        if(Double.isNaN(investigation.getAge())) {
            question.setQuestion("What is your age?");
            question.setType(QuestionType.AGE);
            return question;
        }

        if(Double.isNaN(investigation.getNumPreg())){
            question.setQuestion("How much time the patient is pregnant?");
            question.setType(QuestionType.NUM_PREGNENCY);
            return question;
        }
        if(Double.isNaN(investigation.getGlucose())){
            question.setQuestion("What is the level of glucose tolerance test?");
            question.setType(QuestionType.GlUCOSE_TOLERANCE);
            return question;
        }
        if(Double.isNaN(investigation.getDiastolicBP())){
            question.setQuestion("How much is the diastolic bp?");
            question.setType(QuestionType.DIASTOLIC_BP);
            return question;
        }
        if(Double.isNaN(investigation.getTricepThickness())){
            question.setQuestion("What is the value of Tricep Thickness?");
            question.setType(QuestionType.TRICEP_THICKNESS);
            return question;
        }
        if(Double.isNaN(investigation.getTwoHrSerum())){
            question.setQuestion("What is the level of two hour serum?");
            question.setType(QuestionType.TWO_HOUR);
            return question;
        }
        if(Double.isNaN(investigation.getBmi())){
            question.setQuestion("Enter the value of BMI?");
            question.setType(QuestionType.BMI);
            return question;
        }
        if(Double.isNaN(investigation.getPedigree())){
            question.setQuestion("Enter the value of pedigree?");
            question.setType(QuestionType.PEDIGREE);
            return question;
        }

        question.setQuestion("Anything else?");
        question.setType(QuestionType.GENERAL);
        return question;
    }
}
