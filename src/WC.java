import java.io.FileNotFoundException;
import java.io.IOException;

public class WC {
    static public boolean isCommand(String s){
        return s.matches("-(.*)");
    }
    public static void main(String[] args) throws FileNotFoundException, IOException{
        if(args.length==0){
            System.out.println("Please enter a file name");
            System.exit(1);
        }
        String fileName = new String(args[0]);
        String command = new String();
        if(isCommand(args[0])){
            command = new String(args[0]);
            fileName = new String(args[1]);
        }
        InputFile file = new InputFile(fileName);
        if(args.length == 1){
            file.printWordCount();
            file.printCharCount();
            file.printLineCount();
            System.exit(1);
        }

        switch (command) {
            case "-w" : file.printWordCount();
                        break;
            case "-c" : file.printCharCount();
                        break;
            case "-l" : file.printLineCount();
                        break;
            default : System.out.println("Valid usage : WC -l/-c/-w file_name");
        }
    }
}
