package hw_3.isp;

public class Main {
    public static void main(String[] args) {
        IPrint print = new Printer();
        Text myText = new Text("Hello, world!", print);
        myText.print();
        IPrint print1 = new Printer1();
        myText.setPrint(print1);
        myText.print();

    }
}
