import java.util.Scanner;

@FunctionalInterface
interface Converter <T,N>{
    N convert (T t);
}
public class MyProgram {
    public static void main(String[] args){
        System.out.println("Введите 3 числа для решения примера a*b^c");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        FirstType first = new FirstType(a,b,c);
        Converter<FirstType,SecondType> converter = x -> new SecondType(x.a, x.b, x.c);
        SecondType second = converter.convert(first);
        second.calc();
    }
}
class FirstType{
    int a;
    int b;
    int c;
    FirstType(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public  void calc(){
        System.out.println("Ответ примера будет равен " + a * (Math.pow(b,c)));
    }
}
class SecondType{
    int a;
    int b;
    int c;
    SecondType(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public  void calc(){
        System.out.println("Ответ примера будет равен " + (int)(a * (Math.pow(b,c))));
    }
}
