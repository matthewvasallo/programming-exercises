/**
 * Created by mvasallo on 10/20/16.
 */
public class ComputeFactorial {
    public static void main(String[] args){
        System.out.println("Factorial of 1 is " + ComputeFactorial(1));
        System.out.println("Factorial of 2 is " + ComputeFactorial(2));
        System.out.println("Factorial of 3 is " + ComputeFactorial(3));
        System.out.println("Factorial of 5 is " + ComputeFactorial(5));
        System.out.println("Factorial of -1 is " + ComputeFactorial(-1));
    }

    public static int ComputeFactorial(int number) {
        return (number <= 1) ? number : number * ComputeFactorial(number - 1);
    }
}
