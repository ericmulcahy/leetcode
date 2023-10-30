package neetcode.arrays_hashing;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Arrays;
import java.util.HashMap;

public class GroupAnagrams2 {
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
        Map<String, List<String>> answer = new HashMap<>();

        for (String str : strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String mapKey = new String(c);
            
            if (answer.containsKey(mapKey)) {
                answer.get(mapKey).add(str);
            } else {
                List<String> anagrams = new ArrayList<>();
                anagrams.add(str);
                answer.put(mapKey, anagrams);
            }
        }

        List<List<String>> solutions = new ArrayList<>();
        for (Entry<String, List<String>> entry : answer.entrySet()) {
            List<String> a = new ArrayList<>();
            entry.getValue().forEach(item -> a.add(item));
            solutions.add(a);
        }

        return solutions;
    }

    private static void printResult(List<List<String>> result) {
        result.forEach(s -> System.out.println(s));
    }

}
