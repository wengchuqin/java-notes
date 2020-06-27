package notes.algorithm.lcci.c16;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 题目：设计一个方法，找出任意指定单词在一本书中的出现频率。
 *
 * @author: wengchuqin
 * @create: 2020-06-26 21:04
 */
public class WordsFrequency {
    private final Map<String, Long> wordsFrequencyMap;

    public WordsFrequency(String[] book) {
        wordsFrequencyMap = init(book);
    }

    private Map<String, Long> init(String[] book) {
        return Arrays.stream(book).collect(
                Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }


    public int get(String word) {
        return Math.toIntExact(wordsFrequencyMap.getOrDefault(word, 0L));
    }


//    class TestClass{
//        @Test
//        public void test() {
//            WordsFrequency obj = new WordsFrequency(new String[]{"i", "have", "an", "apple", "he", "have", "a", "pen"});
//            Assert.assertEquals(0, obj.get("you"));
//            Assert.assertEquals(2, obj.get("have"));
//        }
//    }


}
