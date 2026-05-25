package org.example.task13;

import java.util.function.Consumer;

//ViewModel
public class CalculatorViewModel {
    private final CalculatorModel model;

    private String displayResult = "";
    private Consumer<String> onViewUpdateListener;

    public CalculatorViewModel(CalculatorModel model) {
        this.model = model;

        this.model.setOnResultChangedListener(result -> {
            this.displayResult = "Результат: " + result.toString();
            triggerViewUpdate();
        });
    }

    public void setOnViewUpdateListener(Consumer<String> listener) {
        this.onViewUpdateListener = listener;
    }

    public void processCalculation(Integer a, Integer b, String operation) {
        try {
            model.execute(a, b, operation);
        } catch (Exception e) {
            this.displayResult = "Ошибка: " + e.getMessage();
            triggerViewUpdate();
        }
    }

    private void triggerViewUpdate() {
        if (onViewUpdateListener != null) {
            onViewUpdateListener.accept(displayResult);
        }
    }
}
