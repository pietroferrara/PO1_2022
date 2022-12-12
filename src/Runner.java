import it.unive.dais.po1.accessibility.A;
import it.unive.dais.po1.accessibility.B;
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
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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

    public static void main(String[] args) throws IOException, SuspendedRaceException, JAXBException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String s = "abc";
        String s1 = s + "def";

        FuelType ft = new FuelType("diesel", 0.017, 1.7);
        FuelType ft1 = new FuelType("diesel", 0.017, 1.9);
        Car myCar1 = new Car(0, ft, 0);
        Car myCar2 = new Car(0, ft, 0);
        Truck myTruck = new Truck(0, ft, 0);



        Vehicle v1 = myCar1;
        Vehicle v2 = myCar2;
        AbstractSet<Vehicle> v;

        FuelTank tank = new FuelTank(10.0, ft1);
        String s3 = tank.toString();
        myCar1.refuel(tank);


        Racing r = new Racing(100);
        int winner = r.race(myCar1, myTruck);
        System.out.println("And the winner is : "+winner);

        myCar1.refuel(10.0);

        Runner.marshal(ft);

        Integer i = new Integer(10);

        FuelType ft2 = Runner.unmarshall();


        Class c = Vehicle.class;
        for(Field f : c.getDeclaredFields()) {
            if(f.getName().equals("speed")) {
                Annotation[] anns = f.getAnnotations();
                Speed annotation = (Speed) f.getAnnotation(Speed.class);
                System.out.println(anns.length);
            }
        }


    }

    public static int fattoriale(int i) {
        if(i<= 0)
            return 1;
        else return i * fattoriale(i-1);
    }

    static void marshal(FuelType fuelType)
            throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(FuelType.class);
        Marshaller mar= context.createMarshaller();
        mar.marshal(fuelType, new File("./fuelType.xml"));
    }


    static FuelType unmarshall()
            throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(FuelType.class);
        return (FuelType) context.createUnmarshaller()
                .unmarshal(new FileReader("./fuelType.xml"));
    }

}
