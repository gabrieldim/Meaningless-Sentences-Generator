package com.example.demo.generator.service;

import org.springframework.stereotype.Service;

@Service
public class GenerateSentenceService {

    public  Integer sentenceLengthGenerator(){
        int min = 5;
        int max = 15;
        //Generate random int value from 5 to 15
        return (int)Math.floor(Math.random()*(max-min+1)+min);
    }

    public  Integer wordLengthGenerator(){
        int min = 2;
        int max = 17;
        //Generate random int value from 2 to 17
        return (int)Math.floor(Math.random()*(max-min+1)+min);
    }

    public  String randomCharacter(String characters){
        int n = characters.length();
        int r = (int) (n*Math.random());
        return characters.substring(r, r+1);
    }

    /**
     * The Service logic of the JSON object that we need to send.
     *
     * @return {@link String}
     */
    public String sentenceConstruction(){
        StringBuilder sb = new StringBuilder();
        int sentenceLength = sentenceLengthGenerator();

        for(int i=0; i<sentenceLength; i++) {
            String word = "";
            int wordLength = wordLengthGenerator();
            for (int j = 0; j < wordLength; j++) {
                if (i == 0 && j == 0) {
                    word = randomCharacter("ABCDEFGHIJKLMNOPQRSTUVXYZabcdefghijklmnopqrstuvwxyz").repeat(2);
                } else {
                    word = randomCharacter("ABCDEFGHIJKLMNOPQRSTUVXYZabcdefghijklmnopqrstuvwxyz");
                }
                sb.append(word);
            }
            if (i == sentenceLength - 1) {
                sb.append(".");
            } else {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    public String makeSentences(){
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<20; i++) {
            sb.append(sentenceConstruction());
            sb.append(" New Sentence: ");
        }
        return sb.toString();
    }


}


