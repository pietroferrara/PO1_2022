import it.unive.dais.po1.accessibility.A;
import it.unive.dais.po1.datastructures.List;
import it.unive.dais.po1.printing.Printable;
import it.unive.dais.po1.quadrilateral.Quadrilateral;
import it.unive.dais.po1.quadrilateral.Rectangle;
import it.unive.dais.po1.quadrilateral.Rhombus;
import it.unive.dais.po1.quadrilateral.Square;
import it.unive.dais.po1.vehicle.*;
import it.unive.dais.po1.vehicle.animalCarts.HorseCart;
import it.unive.dais.po1.vehicle.animalCarts.HorseWeddingCart;
import it.unive.dais.po1.vehicle.bicycle.Bicycle;
import it.unive.dais.po1.vehicle.car.*;

import java.util.*;

public class Runner {


    static public void foo(Collection<Vehicle> v) {
        for(Vehicle vehicle : v) {
            System.out.println(vehicle);
        }
    }


    static public void foo2() {
        double d = 1.0;
        float f = (float) 2.3;
    }

    public static void main(String[] args) throws NegativeSpeedException, ImpossibleAccelerationException {
        String s = "abc";
        String s1 = s + "def";

        FuelType ft = new FuelType("diesel", 0.017, 1.7);
        FuelType ft1 = new FuelType("diesel", 0.017, 1.7);
        Car myCar1 = new Car(0, ft, 0);
        Car myCar2 = new Car(0, ft, 0);
        Truck myTruck = new Truck(0, ft, 0);

        Vehicle v1 = myCar1;
        Vehicle v2 = myCar2;
        AbstractSet<Vehicle> v;

        FuelTank tank = new FuelTank(10.0, ft1);
        String s3 = tank.toString();
        myCar1.refuel(tank);

        myCar1.accelerate(100000);

        /*boolean result = ft.equals(null);


        Object[] o = new Object[4];
        o[1] = v1;
        o[2] = myCar2;
        o[3] = new Object();
        o[0] = new String("abc");


        Car[] arrayCars = new Car[3];
        arrayCars[0] = myCar1;
        arrayCars[1] = myTruck;

        Collection<Vehicle> it = new HashSet<Vehicle>();
        it.add(arrayCars[0]);
        it.add(arrayCars[1]);
        it.add(new Car(100, ft1));
        foo(it);


        boolean b = true, c = false;
        int d = 1;
        char e = 'a';
        double f = 1.0;
        float i = 2.0F;
        byte g = 1;
        short h = 12;
        e = (char) d;
        i = (float) f;
        d = h;
        f = i;

        int[] array_int = new int[10];
        ArrayList<Integer> list_integer_wrapper = new ArrayList<Integer>();
        Integer wi = Integer.valueOf(10), wi2 = 12;
        Double wd = Double.valueOf(10);
        wi.byteValue();

        wi = wi+wi2;*/

    }

    public static int fattoriale(int i) {
        if(i<= 0)
            return 1;
        else return i * fattoriale(i-1);
    }

}
