package com.sts.VoiceAssistant;

import java.io.IOException;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

public class VoiceAssistant {

	public static void main(String[] st) {
		
		Configuration config = new Configuration();
		
		config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
		config.setDictionaryPath("src\\main\\resources\\4413.dic");
		config.setLanguageModelPath("src\\main\\resources\\4413.lm");
		
		try {
			LiveSpeechRecognizer speech = new LiveSpeechRecognizer(config);
			speech.startRecognition(true);
			
			SpeechResult speechResult = null;
			
			while ((speechResult = speech.getResult()) != null) {
				String voiceCommand = speechResult.getHypothesis();
				System.out.println("Voice Command is " + voiceCommand);
				
				if (voiceCommand.equalsIgnoreCase("Open Chrome")) {
					Runtime.getRuntime().exec("cmd.exe /c start chrome http://mrbikashbarik.blogspot.com");
				} else if (voiceCommand.equalsIgnoreCase("Close Chrome")) {
					Runtime.getRuntime().exec("cmd.exe /c TASKKILL /IM chrome.exe");
				}
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}