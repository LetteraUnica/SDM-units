import java.util.HashMap;

public class WordCounter {
    public int Count(String s) {
        String[] words = s.split(" ");
        return words.length;
    }

    public HashMap<String, Integer> GetTermFreqTable(String s) {
        var term_freq_table = new HashMap<String, Integer>();
        String[] words = s.split(" ");

        for (String word : words) {
            if (term_freq_table.containsKey(word)) {
                int old_value = term_freq_table.get(word);
                term_freq_table.replace(word, old_value + 1);
            }
            else {
                term_freq_table.put(word, 1);
            }
        }
        return term_freq_table;
    }

    public void PrintTermFreqTable(String s) {
        var term_freq_table = GetTermFreqTable(s);
        for (var entry : term_freq_table.entrySet()) {
            System.out.println("word: " + entry.getKey() + " freq: " + entry.getValue());
        }
    }


}
