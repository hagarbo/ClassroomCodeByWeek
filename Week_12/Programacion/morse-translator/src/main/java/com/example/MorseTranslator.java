package com.example;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

public class MorseTranslator {
    public static final BidiMap<String, String> diccionario;
    static {
        diccionario = new DualHashBidiMap<>();
        diccionario.put("A", ".-");
        diccionario.put("B", "-...");
        diccionario.put("C", "-.-.");
        diccionario.put("D", "-..");
        diccionario.put("E", ".");
        diccionario.put("F", "..-.");
        diccionario.put("G", "--.");
        diccionario.put("H", "....");
        diccionario.put("I", "..");
        diccionario.put("J", ".---");
        diccionario.put("K", "-.-");
        diccionario.put("L", ".-..");
        diccionario.put("M", "--");
        diccionario.put("N", "-.");
        diccionario.put("Ñ", "--.--");
        diccionario.put("O", "---");
        diccionario.put("P", ".--.");
        diccionario.put("Q", "--.-");
        diccionario.put("R", ".-.");
        diccionario.put("S", "...");
        diccionario.put("T", "-");
        diccionario.put("U", "..-");
        diccionario.put("V", "...-");
        diccionario.put("W", ".--");
        diccionario.put("X", "-..-");
        diccionario.put("Y", "-.--");
        diccionario.put("Z", "--..");
        diccionario.put("0", "-----");
        diccionario.put("1", ".----");
        diccionario.put("2", "..---");
        diccionario.put("3", "...--");
        diccionario.put("4", "....-");
        diccionario.put("5", ".....");
        diccionario.put("6", "-....");
        diccionario.put("7", "--...");
        diccionario.put("8", "---..");
        diccionario.put("9", "----.");
        diccionario.put(".", ".-.-.-");
        diccionario.put(",", "--..--");
        diccionario.put("?", "..--..");
        diccionario.put("\"", ".-..-.");
        diccionario.put("/", "-..-.");
    }

    private static String morseCharToLatin(String morseChar) {
        return (diccionario.getKey(morseChar) != null) ? diccionario.getKey(morseChar) : "";
    }

    private static String latinCharToMorse(String character) {
        return (diccionario.get(character.toUpperCase()) != null) ? diccionario.get(character.toUpperCase()) : "";
    }

    private static String latinWordToMorse(String word) {
        String morseWord = "";
        for (String character : word.split("")) {
            morseWord += latinCharToMorse(character) + " ";
        }
        return morseWord.trim();
    }

    private static String morseWordToLatin(String morseWord) {
        String word = "";
        for (String morseChar : morseWord.split(" ")) {
            word += morseCharToLatin(morseChar);
        }
        return word;
    }

    public static String morseToLatin(String message) {
        String translation = "";
        for (String word : message.split("/")) {
            translation += morseWordToLatin(word) + " ";
        }
        return translation.trim();
    }

    public static String latinToMorse(String message) {
        String translation = "";
        for (String word : message.split(" ")) {
            translation += latinWordToMorse(word) + "/";
        }
        return (translation.length() > 0) ? translation.substring(0, translation.length() - 1) : "";
    }
}
