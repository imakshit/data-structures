import java.util.*;
public class circle2{
    public static void main(String[] args){
        double pi=3.14;
        Scanner sc = new Scanner(System.in);
        double r = sc.nextInt();
        double area = pi*r*r;
        System.out.println("area: "+area);
    }
}