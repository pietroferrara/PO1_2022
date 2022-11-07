package it.unive.dais.po1.multipleinheritance;

public class RealClass implements C1, C2{
    @Override
    public int getRandomNumber() {
        if(Math.random()>=0.5)
            return C2.super.getRandomNumber();
        else
            return C1.super.getRandomNumber();
    }
}
