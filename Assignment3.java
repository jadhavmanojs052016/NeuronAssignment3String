import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Assignment3 {

    public static void main(String[] args) {
        StringOperations s = new StringOperations();
        Scanner sc = new Scanner(System.in);

        //Question1
        System.out.println("*******************Question1***************************");
        System.out.println("Reverse of iNeuron is : " + s.reverseString("iNeuron"));
        System.out.print("Please enter word to reverse : ");
        String ins = sc.nextLine();
        System.out.println("Revers of '" + ins + "' is : " + s.reverseString(ins));

        //Question2
        System.out.println("*******************Question2***************************");
        System.out.println("Reverse of sentence 'Think Twice' is : " + s.reverseSentence("Think Twice"));
        System.out.print("Please enter sentence to reverse : ");
        ins = sc.nextLine();
        System.out.println("Revers of '" + ins + "' is : " + s.reverseSentence(ins));

        //Question3
        System.out.println("*******************Question3***************************");
        System.out.println("is silent and listen anagram : " + s.isAnagaram("silent", "listen"));
        System.out.println("is act and cat  anagram : " + s.isAnagaram("act", "cat"));
        System.out.println("is man and heman  anagram : " + s.isAnagaram("man", "heman"));

        //Question4
        System.out.println("*******************Question4***************************");
        System.out.println("'A quick brown fox jumps over the lazy dog' is Panagram : " + s.isPangram("A quick brown fox jumps over the lazy dog"));
        System.out.println("'manoj' isPanagram : " + s.isPangram("manoj"));
        System.out.println("'abcdefghijklmnopqrstuvwxyz' isPanagram : " + s.isPangram("abcdefghijklmnopqrstuvwxyz"));

        //Question5
        System.out.println("*******************Question5***************************");
        System.out.println("repeated characters in 'manojshivajijadhav' : " + s.repeatedChars("manojshivajijadhav"));
        System.out.println("repeated characters in 'iNeuron' : " + s.repeatedChars("iNeuron"));

        //Question6
        System.out.println("*******************Question6***************************");
        System.out.println("sort 'manojjadhav' : " + s.sortString("manojjadhav"));

        //Question7
        System.out.println("*******************Question7***************************");
        System.out.println("special characters count  in '*m@anojare$#*' : " + s.countSpecialChar("*m@anojare$#*"));
        System.out.println("special characters count  in 'JAVA' : " + s.countSpecialChar("JAVA"));

        //Question8
        System.out.println("*******************Question8***************************");
        System.out.println("count of Consonants and Vowels  in 'India' are as below ");
        s.countVoWCons("India");

    }

}

class StringOperations {
    String reverseString(String s) {
        String reversedString = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reversedString = reversedString + s.charAt(i);
        }
        return reversedString;
    }

    String reverseSentence(String s) {
        String[] splitSentences = s.split(" ");
        String reversedString = "";
        for (int i = 0; i < splitSentences.length; i++) {
            reversedString = reversedString + " " + reverseString(splitSentences[i]);
        }
        return reversedString;
    }

    boolean isAnagaram(String s1, String s2) {
        String str1 = s1.trim().toLowerCase();
        String str2 = s2.trim().toLowerCase();
        char[] str1Array = str1.toCharArray();

        if (str1.length() != str2.length()) {
            return false;
        } else {
            for (int i = 0; i < str1Array.length; i++) {
                if (str2.indexOf(str1Array[i]) < 0) {
                    return false;
                }

            }
        }

        return true;
    }

    boolean isPangram(String str) {
        String s = str.trim().toLowerCase();
        char[] source = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        for (int i = 0; i < source.length; i++) {
            if (s.indexOf(source[i]) < 0) {
                return false;
            }
        }
        return true;
    }

    String sortString(String str) {
        char[] chs = str.toCharArray();
        Arrays.sort(chs);
        String sorted = "";
        for (int i = 0; i < chs.length; i++) {
            sorted = sorted + chs[i];
        }
        return sorted;
    }

    String repeatedChars(String str) {
        String repeatedChar = "";
        Map < Character, Integer > map = new HashMap < Character, Integer > ();
        char[] chs = str.toLowerCase().toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (map.containsKey(chs[i])) {
                map.put(chs[i], map.get(chs[i]) + 1);
            } else {
                map.put(chs[i], 1);
            }

        }

        for (Map.Entry < Character, Integer > entry: map.entrySet()) {
            if (entry.getValue() > 1) {
                if (repeatedChar == "") {
                    repeatedChar = repeatedChar + entry.getKey();
                } else {
                    repeatedChar = repeatedChar + ", " + entry.getKey();
                }
            }
        }
        return repeatedChar;
    }

    int countSpecialChar(String str) {
        String s = str.toLowerCase();
        char[] c = s.toCharArray();
        String source = "abcdefghijklmnopqrstuvwxyz0123456789";
        int count = 0;
        for (int i = 0; i < c.length; i++) {
            if (source.indexOf(c[i]) == -1) {
                count++;
            }
        }
        return count;
    }

    void countVoWCons(String s) {
        char[] c = s.toCharArray();
        String source = "aeiouAEIOU";
        int countV = 0;
        int countC = 0;
        for (int i = 0; i < c.length; i++) {
            if (source.indexOf(c[i]) > -1) {
                countV++;
            } else {
                countC++;
            }
        }

        System.out.println("Count of Vowels : " + countV);
        System.out.println("Count of Consonants : " + countC);

    }

}