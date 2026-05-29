package org.example.task14;

import java.util.List;

/**
 * Сервис расчета стоимости заказов.
 *
 * @author Горнак Олег
 * @version 1.0
 */
public class OrderService {

    /**
     * Вычисляет стоимость заказа с учетом типа клиента.
     * <p/>
     * Метод суммирует стоимость всех позиций, затем применяет скидку:
     * <ul>
     *     <li>Скидку 10% для клиентов со статусом "VIP".</li>
     *     <li>Скидку 5% для клиентов со статусом "NEW".</li>
     *     <li>Дополнительную скидку 50 единиц, если итоговая сумма превышает 1000.</li>
     * </ul>
     *
     * @param items список позиций в заказе
     * @param type  тип клиента для определения персональной скидки ("VIP", "NEW" и др.)
     * @return итоговая стоимость заказа
     */
    public double calc(List<Item> items, String type) {
        double s = 0;
        for (Item i : items) {
            s += i.getPrice() * i.getQuantity();
        }

        if (type.equals("VIP")) {
            s = s * 0.9;
        }

        if (type.equals("NEW")) {
            s = s * 0.95;
        }

        if (s > 1000) {
            s = s - 50;
        }

        return s;
    }
}
