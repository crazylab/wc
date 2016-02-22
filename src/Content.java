public class Content{
    String data;

    Content(String data){
        this.data = data;
    }

    public int charCount(){
        return data.length();
    }

    public int lineCount(){
        return data.split("\r\n").length;
    }

    public int wordCount(){
        return data.split(" ").length;
    }
}
