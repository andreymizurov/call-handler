package by.avmiz;

/**
 * @author avmiz created 10.02.2016 at 11:53.
 */
public class Test {

    @org.junit.Test
    public void testName() throws Exception {


        String str = "12345678912345";
        System.out.println(str.replaceFirst("(\\d{5})(\\d{3})(\\d{3})(\\d{3})", "$1 $2 $3 $4"));

    }
}
