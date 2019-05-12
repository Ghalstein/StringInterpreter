package com.basics1;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    public static int vowelCount(String str){ // counts vowels in a string
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u')
                count++;
        }
        return count;
    }

    public static int nonVowelCount(String str){ // counts how many non-vowels in a string
        return str.length() - vowelCount(str);
    }

    public static int findPos(String str, char ch){ // finds the position of a character in a string
        int i = 0;
        while(i < str.length()){
            if(str.charAt(i) == ch){
                return i;
            }
            i++;
        }
        return -1;
    }

    public static boolean isSame(String str1, String str2){ // checks if two strings are exactly the same, case sensitive
        if(str1.length() != str2.length())return false;
        for(int i = 0; i < str1.length(); i++){
            if(str1.charAt(i) != str2.charAt(i)) return false;
        }
        return true;
    }

    public static String monthToStr(String str){ // converts the number of a month to a string
        int month = Integer.parseInt(str);
        for(int i = 1; i < 13; i++ ){
            if(month == 1) return "January";
            if(month == 2) return "February";
            if(month == 3) return "March";
            if(month == 4) return "April";
            if(month == 5) return "May";
            if(month == 6) return "June";
            if(month == 7) return "July";
            if(month == 8) return "August";
            if(month == 9) return "September";
            if(month == 10) return "October";
            if(month == 11) return "November";
            if(month == 12) return "December";

        }
        return null;
    }

    public static void dateFormat(){ // creates a printout of the date and time formatted in a specific way
        String date = "" + LocalDateTime.now();
        int i = 0;
        String year = "";
        String month = "";
        String day = "";
        String time1= "";
        String time2 = "";
        boolean pm = false;
        String m = "am";
        while(i < 4){
            year += date.charAt(i);
            i++;
        }
        while(i < 7){
            if(date.charAt(i) != '-')
                month += date.charAt(i);
            i++;
        }
        while(i < 10){
            if(date.charAt(i) != '-')
                day += date.charAt(i);
            i++;
        }
        i = 11;
        while(i < 13){
            time1 += date.charAt(i);
            i++;
        }
        while(i < 16){
            time2 += date.charAt(i);
            i++;
        }
        int time = Integer.parseInt(time1);
        if(time > 12){
            time = time -12;
            pm = true;
        }
        if(time == 0){
            time = 12;
        }
        if(pm){
            m = "pm";
        }
        System.out.println("Current Date and Time :\n" +
                monthToStr(month) + " " + day + ", " + year +
                "\n" + time + time2 + " " + m);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please type your first name: \n>");
        String fName = sc.nextLine();
        System.out.print("Please type your last name: \n>");
        String lName = sc.nextLine();
        String UserFullName = fName + " " + lName;
        int nameLength = UserFullName.length() - 1;
        System.out.println("Hello " + UserFullName + "\nYour name is " + nameLength + " letters long");
        String CAPSName = UserFullName.toUpperCase();
        String lowName = UserFullName.toLowerCase();
        System.out.println("This is your name in all caps: " +
                CAPSName + ".\nThis is your name in all lowercase: " + lowName + ".");
        System.out.println("Here is the vowel count for your name: " + vowelCount(UserFullName));
        System.out.println("Here is the consonant count for your name: " + nonVowelCount(UserFullName));
        String iAVGS = "I am a very good student who works hard";
        System.out.println("The 10th character in " + iAVGS + " is \'" + iAVGS.charAt(10) + "\'.");
        System.out.println("\"good\" starts at position " + findPos(iAVGS, 'g') +" and ends at position " + findPos(iAVGS, 'd') + ".");
        System.out.print("Now enter the word \"Excellent\": \n>");
        String exInput = sc.nextLine();
        while(true) {
            if (isSame(exInput, "Excellent")) {
                System.out.println("Good job, your input, \"" + exInput + "\" matches \"Excellent\".");
                break;
            } else {
                System.out.print("Your input, \"" + exInput + "\" does not match \"Excellent\"." +
                        "\nPlease try again: \n>");
                exInput = sc.nextLine();
            }
        }

    dateFormat();
    }
}
