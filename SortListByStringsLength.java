package com.epam.task;

public class SortListByStringsLength {
    public static void main(String[] args) {
        String[] stringsArray = new String[] {"The Beatles", "Help!", "Help me if you can, I'm feeling down",
                "And I do appreciate you being 'round", "Help me get my feet back on the ground", "Won't you please, please help me"};
        for (int i = 0; i < stringsArray.length; i++) {
            for (int j = 0; j < stringsArray.length - 1 - i; j++) {
                if (stringsArray[j].length() > stringsArray[j + 1].length()) {
                    String temp = stringsArray[j];
                    stringsArray[j] = stringsArray[j + 1];
                    stringsArray[j + 1] = temp;
                }
            }
        }
        for (String string : stringsArray) {
            System.out.println(string);
        }
    }
}
