import java.util.HashMap;

public class CounterMain {
    public static void main(String[] args) {
        String s = "asd asd sa asd asd asd ad ad sa";
        WordCounter counter = new WordCounter();
        int n_words = counter.Count(s);
        System.out.println(n_words);
        HashMap<String, Integer> words = counter.GetTermFreqTable(s);

        counter.PrintTermFreqTable(s);
    }
}
