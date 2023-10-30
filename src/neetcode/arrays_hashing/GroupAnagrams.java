package neetcode.arrays_hashing;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * My first go at this had a similar approach to the optimal solution, but missed the key idea
 * of sorting the input word to use as a key in the map. Instead I used a heavy weight map
 * comparison technique.
 * 
 * Doing it again with another approach.
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        //Input: strs = ["eat","tea","tan","ate","nat","bat"]
        //Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
        String[] input = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = groupAnagrams(input);
        printResult(result);

        //Input: strs = [""]
        //Output: [[""]]
        String[] input2 = {};
        List<List<String>> result2 = groupAnagrams(input2);
        printResult(result2);

        //Input: strs = ["a"]
        //Output: [["a"]]
        String[] input3 = {"a"};
        List<List<String>> result3 = groupAnagrams(input3);
        printResult(result3);

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> solutions = new ArrayList<>();

        for (String str : strs) {
            boolean match = false;
            for (int i = 0; i < solutions.size(); i++) {
                if (areAnagrams(str, solutions.get(i).get(0))) {
                    solutions.get(i).add(str);
                    match = true;
                    break;
                }
            }
            if (!match) {
                List<String> entry = new ArrayList<>();
                entry.add(str);
                solutions.add(entry);
            }
        }

        return solutions;
    }

    private static void printResult(List<List<String>> result) {
        result.forEach(s -> System.out.println(s));
    }

    private static boolean areAnagrams(String w1, String w2) {
        if (w1 == null || w2 == null || w1.length() != w2.length()) {
            return false;
        }
        Map w1Map = buildMapFromString(w1);
        Map w2Map = buildMapFromString(w2);
        return w1Map.equals(w2Map);
    }

    private static Map buildMapFromString(String word) {
        Map<Integer, Integer> word1Map = new HashMap<>();
        for (char c : word.toCharArray()) {
            int i = (int) c;
            if (word1Map.containsKey(i)) {
                word1Map.put(i, word1Map.get(i) + 1);
            } else {
                word1Map.put(i, 1);
            }
        }
        return word1Map;
    }
}
