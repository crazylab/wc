import java.io.FileNotFoundException;
import java.io.IOException;

public class WC {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        InputFile file = new InputFile(args[0]);
        file.read();
        if(args.length == 1){
            file.printWordCount();
            file.printCharCount();
            file.printLineCount();
            return;
        }

        switch (args[1]) {
            case "-w" : file.printWordCount();
                        break;
            case "-c" : file.printCharCount();
                        break;
            case "-l" : file.printLineCount();
                        break;
        }
    }
}
