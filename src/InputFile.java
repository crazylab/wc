import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InputFile {
    final String fileName;

    Content fileDetails = null;

    InputFile(String fileName){
        this.fileName = fileName;
    }

    private void read() throws FileNotFoundException, IOException{
        File file = new File(this.fileName);
        int fileSize = (int) file.length();
        char[] s = new char[fileSize];
        FileReader fr = new FileReader(file);
        fr.read(s);
        String data = new String(s);
        fileDetails = new Content(data);
    }

    public void printWordCount() throws FileNotFoundException, IOException{
        if(fileDetails == null)
            read();
        System.out.println("Word : "+ fileDetails.wordCount());
    }

    public void printCharCount() throws FileNotFoundException, IOException{
        if(fileDetails == null)
            read();
        System.out.println("Char : "+ fileDetails.charCount());
    }

    public void printLineCount() throws FileNotFoundException, IOException{
        if(fileDetails == null)
            read();
        System.out.println("Line : "+ fileDetails.lineCount());
    }
}
