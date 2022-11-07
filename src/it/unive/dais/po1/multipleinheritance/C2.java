package it.unive.dais.po1.multipleinheritance;

public interface C2 {

    default int getRandomNumber() {
        return (int) (Math.random()*100.0);
    }
}
