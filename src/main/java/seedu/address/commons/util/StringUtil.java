package seedu.address.commons.util;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;

/**
 * Helper functions for handling strings.
 */
public class StringUtil {

    /**
     * Returns true if the {@code sentence} contains the {@code word}.
     *   Ignores case, but a full word match is required.
     *   <br>examples:<pre>
     *       containsWordIgnoreCase("ABc def", "abc") == true
     *       containsWordIgnoreCase("ABc def", "DEF") == true
     *       containsWordIgnoreCase("ABc def", "AB") == false //not a full word match
     *       </pre>
     * @param sentence cannot be null
     * @param word cannot be null, cannot be empty, must be a single word
     */
    public static boolean containsWordIgnoreCase(String sentence, String word) {
        requireNonNull(sentence);
        requireNonNull(word);

        String preppedWord = word.trim();
        checkArgument(!preppedWord.isEmpty(), "Word parameter cannot be empty");
        checkArgument(preppedWord.split("\\s+").length == 1, "Word parameter should be a single word");

        String preppedSentence = sentence;
        String[] wordsInPreppedSentence = preppedSentence.split("\\s+");

        return Arrays.stream(wordsInPreppedSentence)
                .anyMatch(preppedWord::equalsIgnoreCase);
    }

    /**
     * Returns true if the {@code sentence} contains the {@code word}, ignoring case.
     * A full match is not required (i.e., it checks for substring matches).
     *
     * @param sentence The sentence to search in. Cannot be null.
     * @param word The word to search for. Cannot be null, must be a single word.
     * @return True if the sentence contains the word, ignoring case.
     */
    public static boolean containsIgnoreCase(String sentence, String word) {
        requireNonNull(sentence);
        requireNonNull(word);

        String preppedWord = word.trim();
        checkArgument(!preppedWord.isEmpty(), "Word parameter cannot be empty");

        return sentence.toLowerCase().contains(preppedWord.toLowerCase());
    }

    /**
     * Returns a detailed message of the t, including the stack trace.
     */
    public static String getDetails(Throwable t) {
        requireNonNull(t);
        StringWriter sw = new StringWriter();
        t.printStackTrace(new PrintWriter(sw));
        return t.getMessage() + "\n" + sw.toString();
    }

    /**
     * Returns true if {@code s} represents a non-zero unsigned integer
     * e.g. 1, 2, 3, ..., {@code Integer.MAX_VALUE} <br>
     * Will return false for any other non-null string input
     * e.g. empty string, "-1", "0", "+1", and " 2 " (untrimmed), "3 0" (contains whitespace), "1 a" (contains letters)
     * @throws NullPointerException if {@code s} is null.
     */
    public static boolean isNonZeroUnsignedInteger(String s) {
        requireNonNull(s);

        try {
            int value = Integer.parseInt(s);
            return value > 0 && !s.startsWith("+"); // "+1" is successfully parsed by Integer#parseInt(String)
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    /**
     * Returns true if all the {@code words} are present in the {@code sentence}.
     * Ignores case, and a full word match is required for each word.
     * <p>
     * Examples:
     * - containsAllWordsIgnoreCase("Alice Bob Charlie", Arrays.asList("Alice", "Charlie")) -> true
     * - containsAllWordsIgnoreCase("Alice Bob Charlie", Arrays.asList("Alice", "David")) -> false
     * - containsAllWordsIgnoreCase("Alice Bob Charlie", Arrays.asList("Ali")) -> false (partial match not allowed)
     * - containsAllWordsIgnoreCase("Alice Bob Charlie", Arrays.asList()) -> true (empty list matches everything)
     *
     * @param sentence Cannot be null.
     * @param words Cannot be null, but can be empty.
     * @return True if all words are present in the sentence, ignoring case.
     */
    public static boolean containsAllWordsIgnoreCase(String sentence, List<String> words) {
        requireNonNull(sentence);
        requireNonNull(words);

        String[] wordsInSentence = sentence.split("\\s+");
        return words.stream()
                .allMatch(word -> {
                    checkArgument(!word.trim().isEmpty(), "Word parameter cannot be empty");
                    return Arrays.stream(wordsInSentence)
                            .anyMatch(sentenceWord -> sentenceWord.equalsIgnoreCase(word.trim()));
                });
    }
}
