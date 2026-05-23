package org.example.task9;

public class Start {
    static void main(String[] args){
        var serviceLocator = new ServiceLocator(new DataReader(), new Printer());
        serviceLocator.add(new PlusOperation());
        serviceLocator.add(new MinusOperation());

        OperationMaker maker = new OperationMaker(serviceLocator);
        maker.make();
    }
}
