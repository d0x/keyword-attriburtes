public class Main
{
    public static final String foobar = "42";
    private final String tester = "23";

    public static void main(final String[] args)
    {
        final int test = 1;

        for (final int i = 1; i <= 5; i++)
        {
            System.out.println("i = " + i);
        }
    }

    public Main(final int test)
    {
        System.out.println(this.tester);
        System.out.println(this.toString());
    }
}