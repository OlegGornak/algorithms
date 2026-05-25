package org.example.task13;

public class Start {
    static void main(String[] args){
        CalculatorModel model = new CalculatorModel();
        var plus = new PlusOperation();
        var minus = new MinusOperation();
        model.registerOperation(plus.getType(), plus);
        model.registerOperation(minus.getType(), minus);
        CalculatorViewModel viewModel = new CalculatorViewModel(model);
        CalculatorView view = new CalculatorView(viewModel);
        view.start();
    }
}
