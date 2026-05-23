package org.example.task9;

class OperationMaker {

    ServiceLocator serviceLocator;

    public OperationMaker(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    public void make() {
        Model model = serviceLocator.getSupplier().get();
        model.res = serviceLocator.getOperation(model.op).apply(model.x, model.y);
        serviceLocator.getConsumer().accept(model);
    }
}
