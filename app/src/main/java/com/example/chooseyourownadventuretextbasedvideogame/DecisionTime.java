package com.example.chooseyourownadventuretextbasedvideogame;

public class DecisionTime {

    //res id
    int decisionBtn1;
    int decisionBtn2;

   // what method it is: should this be left to the MainActivity....I'd prefer if this was in the DecisionTime class..ask Mr. Kordi or go see Stack Exchange
//    String methodName = "";
//
//
//    public String getMethodName() {
//        return methodName;
//    }
//
//    public void setMethodName(String methodName) {
//        this.methodName = methodName;
//    }


    public void setDecisionBtn1(int decisionBtn1) {
        this.decisionBtn1 = decisionBtn1;
    }
    public void setDecisionBtn2(int decisionBtn2) {
        this.decisionBtn2 = decisionBtn2;
    }

    public int getDecisionBtn1() {
        return decisionBtn1;
    }
    public int getDecisionBtn2() {
        return decisionBtn2;
    }

}
