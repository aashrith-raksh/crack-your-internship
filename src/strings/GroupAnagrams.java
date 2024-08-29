package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] inputArray) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : inputArray) {
            int[] charCount = new int[26];

            // Count occurrences of each character in the current string
            for (char ch : str.toCharArray()) {
                charCount[ch - 'a']++;
            }

            // Convert the character count array to a string representation
            String key = Arrays.toString(charCount);

            // Check if the key is already present in the map
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            // Add the current string to the list associated with the key
            map.get(key).add(str);
        }

        // Return a list of all values (lists) in the map
        return new ArrayList<>(map.values());

    }

}
