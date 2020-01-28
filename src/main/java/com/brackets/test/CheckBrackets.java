package com.brackets.test;

import org.apache.logging.log4j.util.Strings;

import java.util.ArrayList;
import java.util.List;

public class CheckBrackets {

    private String bracketsType1 = "()";
    private String bracketsType2 = "[]";
    private String bracketsType3 = "{}";
    private List<String> arrayOpen;
    private List<String> arrayClosed;
    private boolean valid;

     String checkIfbracketsIsValid(String brackets) {
        String bracketsInit = brackets;
        if (brackets.length() % 2 == 0){
            while (!Strings.isEmpty(brackets)){
                brackets = createArrayOpenAndClosedByBracketsType(brackets);
            }

            if (this.valid){
                return bracketsInit+" is valid";
            } else {
                return bracketsInit + " is not valid";
            }
        } else {
            return bracketsInit + " is not valid";

        }

    }

    private void checkIfIsValid(String brackets) {
        int numPairs = arrayOpen.size();
        int contPairsOk = 0;
        for (int i=0; i < numPairs ; i++ ) {
            if (arrayOpen.get(i) == arrayClosed.get(numPairs - 1 - i )){
                contPairsOk ++;
            }
        }

        if (contPairsOk == numPairs){
            valid=true;
        } else {
            valid = false;
        }
    }

    private String createArrayOpenAndClosedByBracketsType(String brackets) {
        arrayOpen = new ArrayList<>();
        arrayClosed = new ArrayList<>();
        int contPosition0 = 0;
        int contPosition1 = 0;
        int i=0;
        do {

            if (brackets.charAt(i) == bracketsType1.charAt(0)){
                arrayOpen.add(bracketsType1);
                contPosition0++;
            }else if (brackets.charAt(i) == bracketsType1.charAt(1)) {
                arrayClosed.add(bracketsType1);
                contPosition1++;
            } else if (brackets.charAt(i) == bracketsType2.charAt(0)){
                arrayOpen.add(bracketsType2);
                contPosition0++;
            }else if (brackets.charAt(i) == bracketsType2.charAt(1)) {
                arrayClosed.add(bracketsType2);
                contPosition1++;
            } else if (brackets.charAt(i) == bracketsType3.charAt(0)){
                arrayOpen.add(bracketsType3);
                contPosition0++;
            } else if (brackets.charAt(i) == bracketsType3.charAt(1)) {
                arrayClosed.add(bracketsType3);
                contPosition1++;
            }
            i++;
        } while (contPosition1 != contPosition0 && i < brackets.length());
        String sub = brackets.substring(0,contPosition1*2);
        if (arrayOpen.size()==arrayClosed.size()){
            checkIfIsValid(sub);
            if (brackets.length()!=2){
                return brackets.substring(contPosition1*2,brackets.length());
            } else {
                return "";
            }
        } else {
            return  "";
        }



    }

}
