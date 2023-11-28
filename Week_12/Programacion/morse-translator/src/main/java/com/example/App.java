package com.example;

public class App {

    public static void main(String[] args) {
        System.out.println(MorseTranslator.latinToMorse("hola amigo"));
        System.out.println(MorseTranslator.morseToLatin(".... --- .-.. .-/.- -- .. --. ---"));
        System.out.println(MorseTranslator.morseToLatin("..- -./.--. . .-. .-. .. - ---/.--. .. .-.. --- - --- .-.-."));
        System.out.println(MorseTranslator.latinToMorse("Omae wa mo shindeiru"));
        System.out.println(MorseTranslator.morseToLatin("--- -- .- ./.-- .-/-- ---/... .... .. -. -.. . .. .-. ..-"));
    }
}
