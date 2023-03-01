//https://leetcode.com/problems/longest-substring-without-repeating-characters/

public class LongestSubstringWithoutRepeats {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeats program = new LongestSubstringWithoutRepeats();

        String input0 = " ";
        int result0 = program.lengthOfLongestSubstring_withoutSkipping(input0);
        printAnswer(input0, result0);

        String input1 = "abcabcbb";
        int result1 = program.lengthOfLongestSubstring_withoutSkipping(input1);
        printAnswer(input1, result1);

        String input2 = "bbbb";
        int result2 = program.lengthOfLongestSubstring_withoutSkipping(input2);
        printAnswer(input2, result2);

        String input3 = "pwwkew";
        int result3 = program.lengthOfLongestSubstring_withoutSkipping(input3);
        printAnswer(input3, result3);
    }

    private static void printAnswer(String input, int result) {
        System.out.println("Answer for '" + input + "' is " + result);
    }

    /**
     * Then there should be an optimization to make. When a substring is broken, we should
     * be able to skip some of that substring, because we would have already found the 
     * longest substring. For example, if we have a string "abcdcxyz", we would first find the
     * substring "abcd", stopping at second c because it was repeated. Then, we can skip to the 
     * next letter after the first c and start searching there. Because we have already found the
     * longest substring that includes the first c. 
     * 
     * So, instead of storing "1" to represent a character has been used, we will store the index of 
     * that character in the string
     */
    public int lengthOfLongestSubstring(String s) {        
        int longestChainLength = 0;
        int longestChainStartingIndex = -1;

        int[] charactersUsed = new int[500];
        int chainLength = 0;
        int startingChainIndex = 0;
        
        //char previousChar = s.charAt(0);
        //markUsed(charactersUsed, previousChar);

        for (int i=0; i<s.length(); i++) {
            char currentChar = s.charAt(i);
            
            if (charactersUsed[Character.valueOf(currentChar)] != 1) {
                // chain is unbroken
                chainLength++;
                markUsed(charactersUsed, currentChar, i);

                if (chainLength > longestChainLength) {
                    longestChainLength = chainLength;
                    longestChainStartingIndex = startingChainIndex;
                }
            } else {
                // chain is broken

                // abcdcxyz: we are now processing the second c at index 4. we have already found the longest string that contains 
                // the first occurrence of the 'c' character. So start searching at that index + 1 on the next iteration.
                int priorIndex = charactersUsed[Character.valueOf(s.charAt(i))];

                // i gets incremented at the end of the beginning of the next loop as well, which is confusing
                i = priorIndex;
                startingChainIndex = i + 1;
                // reset the list of chars we have used
                charactersUsed = new int[500];
                chainLength = 0;
            }
        }

        printResult(s, longestChainLength, longestChainStartingIndex);
        return longestChainLength;
    }

    /**
     * 
     * First, we are going to check the length of substrings starting at every character 
     * in the string, and get that working first. 
     */
    public int lengthOfLongestSubstring_withoutSkipping(String s) {
        // ideally this should be an array of bits. I should investigate what is the best data type for this
        
        int longestChainLength = 0;
        int longestChainStartingIndex = -1;

        int[] charactersUsed = new int[500];
        int chainLength = 0;
        int startingChainIndex = 0;
        
        //char previousChar = s.charAt(0);
        //markUsed(charactersUsed, previousChar);

        for (int i=0; i<s.length(); i++) {
            char currentChar = s.charAt(i);
            
            if (charactersUsed[Character.valueOf(currentChar)] != 1) {
                // chain is unbroken
                chainLength++;
                markUsed(charactersUsed, currentChar);

                if (chainLength > longestChainLength) {
                    longestChainLength = chainLength;
                    longestChainStartingIndex = startingChainIndex;
                }
            } else {
                // chain is broken

                // next iteration, start at the next character
                i = startingChainIndex;
                startingChainIndex = i + 1;
                // reset the list of chars we have used
                charactersUsed = new int[500];
                chainLength = 0;
            }
        }

        printResult(s, longestChainLength, longestChainStartingIndex);
        return longestChainLength;
    }

    void printResult(String s, int a, int b) {
        System.out.println("String '" + s + "' chain length " + a + " at index " + b);
    }

    private void markUsed(int[] charactersUsed, char c) {
        int characterValue = Character.valueOf(c);
        charactersUsed[characterValue] = 1;
    }
    
    private void markUsed(int[] charactersUsed, char c, int value) {
        int characterValue = Character.valueOf(c);
        charactersUsed[characterValue] = value;
    }
}
