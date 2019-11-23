import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.math.BigInteger;

public class NumberTest {
    public static void sumAll(Integer ...values) {
        throw new NotImplementedException();
    }


    public static void main(String[] args) {
        int sum = 1 + 1;

        BigInteger integer = new BigInteger("1000");
        BigInteger integer1 = new BigInteger("1000");

        BigInteger add = integer
                .add(integer1);
                //.min();



        for (int i = 0; i < 10; i++) {
            if(i > 6){
                break;
            }
        }

        sumAll(1, 2, 3, 4, 5, 6);


        String.format("Move on: %s %s", "Luke", "Padman");

    }
}
