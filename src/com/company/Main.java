package com.company;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;


public class Main{
    public static void main(String[] args) throws Exception {


        Configuration configuration = new Configuration();

        configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
        configuration.setGrammarPath("file:/D:/Java_Project/SpeechControl/resources/grammars");
        configuration.setGrammarName("hello");
        configuration.setUseGrammar(true);

        LiveSpeechRecognizer recognizer = new LiveSpeechRecognizer(configuration);
        recognizer.startRecognition(true);
        SpeechResult result = recognizer.getResult();
        recognizer.stopRecognition();

        String strResult = result.getHypothesis();
        switch (strResult){
            case "start music":
                Runtime.getRuntime().exec("D:\\AIMP\\AIMP.exe");
                break;
            case "start epic":
                Runtime.getRuntime().exec("D:\\Epic Games\\Launcher\\Portal\\Binaries\\Win32\\EpicGamesLauncher.exe");
                break;
            case "start what message":
                Runtime.getRuntime().exec("C:\\Users\\Ghost_v2\\AppData\\Local\\WhatsApp\\WhatsApp.exe");
                break;
            case "start command":
                Runtime.getRuntime().exec("C:\\Windows\\System32\\cmd.exe");
                break;

            }

    }
}