package com.example.szopa.poetry;

/**
 * Created by Szopa on 22/03/2016.
 */
public class Poem {
    private Source1 aSource1 = new Source1();
    private String source = aSource1.getSource();

    public java.lang.String writePoem(int numberOfWords, int numberOfLines, int numberOfParagraphs) {

        String[] sourceToWords = splitIntoWords(source);
        String[] uppercaseList = prepareUppercaseList(sourceToWords);
        String poem = "";

        // print (concatenate) a poem using random elements from the array sourceToWords[]
        for (int i = 0; i < numberOfParagraphs; i++) {
            for (int j = 0; j < numberOfLines; j++) {
                // first word is from the array of uppercase words
                if(numberOfWords > 0) {
                    int randomInitialWord = (int) (Math.random() * uppercaseList.length);
                    poem += uppercaseList[randomInitialWord] + " ";
                }
                for (int k = 0; k < numberOfWords - 1; k++) {
                    int randomWord = (int) (Math.random() * sourceToWords.length);
                    poem += sourceToWords[randomWord] + " ";
                }
                poem += "\n";
            }
            poem += "\n";
        }

        return poem;
    }

    private String [] splitIntoWords(String input){
        // split the big source string into an array of word-length strings
        // (one or more space marks the splitting boundary)
        String[] splitString = input.split("\\s+");

        // delete all non-word characters (. - , etc.)
        for (int i = 0; i < splitString.length; i++) {
            splitString[i] = splitString[i].replaceAll("[^\\w]", "");
        }

        return splitString;
    }


    private String[] prepareUppercaseList(String[] upperAndLowercaseList) {
        // count all uppercase words in array
        int l = 0;
        for (int j = 0; j < upperAndLowercaseList.length; j++) {
            if (Character.isUpperCase(upperAndLowercaseList[j].charAt(0))) {
                l++;
            }
        }

        String[] upperCaseList = new String [l];
        // search for all uppercase words and add them to a separate array
        int m = 0;
        for (int j = 0; j < upperAndLowercaseList.length; j++) {
            if (Character.isUpperCase(upperAndLowercaseList[j].charAt(0))) {
                upperCaseList[m] = upperAndLowercaseList[j];
                m++;
            }
        }

        return upperCaseList;
    }

}