package org.example.task14;

import java.util.List;

/**
 * Сервис расчета стоимости заказов.
 *
 * @author Горнак Олег
 * @version 2.0
 */
public class OrderService {

    private final DiscountService discountService;

    public OrderService(DiscountService discountService) {
        this.discountService = discountService;
    }

    /**
     * Вычисляет стоимость заказа с учетом типа клиента.
     * <p/>
     * Метод суммирует стоимость всех позиций, затем применяет скидку.
     * <ul>
     *     <li>Скидку 10% для клиентов со статусом "VIP".</li>
     *     <li>Скидку 5% для клиентов со статусом "NEW".</li>
     *     <li>Дополнительную скидку 50 единиц, если итоговая сумма превышает 1000.</li>
     * </ul>
     *
     * @param items список позиций в заказе
     * @param type  тип клиента ("VIP", "NEW" и "COMMON")
     * @return итоговая стоимость заказа
     */
    public double calc(List<Item> items, ClientType type) {
        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException("Список товаров не может быть пустым");
        }

        var summa = getSum(items);
        return discountService.apply(summa, type);
    }

    /**
     * Метод суммирует стоимость всех позиций
     *
     * @param items список позиций в заказе
     * @return стоимость заказа
     */
    private double getSum(List<Item> items) {
        double s = 0;
        for (Item i : items) {
            s += i.getPrice() * i.getQuantity();
        }
        return s;
    }
}
