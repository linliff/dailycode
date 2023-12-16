package com.linlif;

import java.util.ArrayList;

public class StringRevert {


    public static void main(String[] arr) {

        revertString("hello world lin");
    }

    public static void revertString(String text) {

        if (text == null) {
            return;
        }

        char[] charArray = text.toCharArray();

        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> stringList = new ArrayList<>();
        for (int i = 0; i < charArray.length; i++) {

            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(charArray[i]);
            if (stringBuilder2.toString().equals(" ")) {
                stringList.add(stringBuilder.toString());
                stringList.add(stringBuilder2.toString());
                stringBuilder = new StringBuilder();
            } else if (i == charArray.length - 1) {
                stringBuilder.append(charArray[i]);
                stringList.add(stringBuilder.toString());
            } else {
                stringBuilder.append(charArray[i]);
            }


        }

        stringBuilder = new StringBuilder();
        for (int i = stringList.size() - 1; i >= 0; i--) {
            stringBuilder.append(stringList.get(i));
        }

        System.out.println(stringBuilder.toString());

    }

}
