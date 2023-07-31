package hw_3.isp;

public class Text {
    String text;
    public IPrint print;

    public Text(String text, IPrint print) {
        this.text = text;
        this.print = print;
    }

    public String getText() {
        return text;
    }
    public void setPrint(IPrint print){
        this.print = print;
    }

    public  void print(){
        print.print(text);
    }

}

