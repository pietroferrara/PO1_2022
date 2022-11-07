package it.unive.dais.po1.multipleinheritance;

public interface C1 {

    default int getRandomNumber() {
        return (int) (Math.random()*10.0);
    }
}
