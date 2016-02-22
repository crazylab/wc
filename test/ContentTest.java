import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class ContentTest {
    @Test
    public void charCount_gives_the_number_of_char_in_the_given_data() {
        Content data = new Content("Today is not a good day");
        assertEquals(data.charCount(), 23);
    }

    @Test
    public void charCount_gives_0_when_given_data_is_empty_string() {
        Content data = new Content("");
        assertEquals(data.charCount(), 0);
    }

    @Test
    public void lineCount_gives_the_number_of_lines_in_the_given_data() {
        String s = "Today is not a good day\r\nbut tomorrow will be better\r\n\r\nthis is the forth line of this file.\r\n";
        Content data = new Content(s);
        assertEquals(data.lineCount(), 4);
    }

    @Test
    public void wordCount_gives_the_number_of_words_in_the_given_data() {
        String s = "here i'm going to count words";
        Content data = new Content(s);
        assertEquals(data.wordCount(), 6);
    }
}
