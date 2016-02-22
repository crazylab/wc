import java.io.FileNotFoundException;
import java.io.IOException;

public class WC {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        if(args.length==0){
            System.out.println("Please enter a file name");
            System.exit(1);
        }

        InputFile file = new InputFile(args[0]);
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
            default : System.out.println("Valid usage : WC file_name -l/-c/-w");
        }
    }
}
