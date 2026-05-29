package org.example.task14;

/**
 * Сервис для применения скидки.
 *
 * @author Горнак Олег
 * @version 1.0
 */
public class DiscountService {

    private static final double VIP_DISCOUNT = 0.90;
    private static final double NEW_CLIENT_DISCOUNT = 0.95;
    private static final double LARGE_ORDER = 1000.0;
    private static final double LARGE_ORDER_DISCOUNT = 50.0;

    /**
     * Применение скидки
     * <p/>
     * Логоика применения скидки:
     * <ul>
     *     <li>Скидку 10% для клиентов со статусом "VIP".</li>
     *     <li>Скидку 5% для клиентов со статусом "NEW".</li>
     *     <li>Дополнительную скидку 50 единиц, если итоговая сумма превышает 1000.</li>
     * </ul>
     *
     * @param summa стоимость заказае без учета скидки
     * @param type  тип клиента ("VIP", "NEW" и "COMMON")
     * @return итоговая стоимость заказа
     */
    public double apply(double summa, ClientType type) {
        if (ClientType.VIP.equals(type)) {
            summa = summa * VIP_DISCOUNT;
        }

        if (ClientType.NEW.equals(type)) {
            summa = summa * NEW_CLIENT_DISCOUNT;
        }

        if (summa > LARGE_ORDER) {
            summa = summa - LARGE_ORDER_DISCOUNT;
        }

        return summa;
    }
}
