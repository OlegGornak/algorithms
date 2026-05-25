package org.example.task13;

import java.util.Scanner;

//View
public class CalculatorView {
    private final CalculatorViewModel viewModel;

    public CalculatorView(CalculatorViewModel viewModel) {
        this.viewModel = viewModel;
        this.viewModel.setOnViewUpdateListener(this::render);
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        String operation = sc.next();
        Integer a = sc.nextInt();
        Integer b = sc.nextInt();

        viewModel.processCalculation(a, b, operation);
    }

    private void render(String state) {
        System.out.println(state);
    }
}