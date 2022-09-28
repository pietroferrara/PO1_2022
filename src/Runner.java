public class Runner {

    int x;

    public static void main(String[] args) {
        //String name = args[0];
        //System.out.println("Hello "+name);
    }
    public int foo() {
        return increment(x);
    }

    int increment(int i) {
        return i+1;
    }
}
