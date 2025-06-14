package practice;

import java.util.*;

public class StringClass {
    public static void main(String[] args) {
        System.out.println(isAnagram("listen", "silent"));
        System.out.println(capitalizeEachWord("hello world"));
        System.out.println(duplicateChars("programming"));
        System.out.println(nonRepeatedChar("programming"));
        System.out.println(palindrome("meghana"));
        palindromicSubstring("banana");
        System.out.println("panagram "+panagram("Abcdefghijklmnopqrstuvwxyz"));

    }

    public static boolean panagram(String s) {
       s= s.replaceAll("\\s+","").toLowerCase();
       Set<Character> set =new TreeSet<>();
       for(char ch:s.toCharArray()){
           set.add(ch);
       }
       return set.size()==26;
    }

    public static void palindromicSubstring(String s) {
        for (int i = 0; i < s.length(); i++) {
            isPalindrom(s, i, i);
            isPalindrom(s, i, i + 1);
        }
    }

    public static void isPalindrom(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
           if(Math.max(left,right)-Math.min(left,right)>1)
                System.out.println(s.substring(left, right + 1));
            left--;
            right++;
        }

    }

    public static StringBuilder palindrome(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            result.append(s.charAt(i));
        }
        return result;
    }


    public static boolean isAnagram(String s1, String s2) {
        char[] ch1 = s1.replaceAll("\\s+", "").toLowerCase().toCharArray();
        char[] ch2 = s2.replaceAll("\\s+", "").toLowerCase().toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        return Arrays.equals(ch1, ch2);
    }

    public static StringBuilder capitalizeEachWord(String s) {
        StringBuilder builder = new StringBuilder();
        for (String s1 : s.split(" ")) {
            builder = builder.append(Character.toUpperCase(s1.charAt(0))).append(s1.substring(1)).append(" ");
        }
        return builder;
    }

    public static Map<Character, Integer> duplicateChars(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> output = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                output.put(entry.getKey(), entry.getValue());
            }
        }
        return output;
    }

    public static List<Character> nonRepeatedChar(String s) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
                list.add(s.charAt(i));
            }
        }
        return list;
    }
}
