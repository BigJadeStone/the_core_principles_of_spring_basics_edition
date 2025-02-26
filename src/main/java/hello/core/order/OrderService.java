package hello.core.order;

public interface OrderService {
    Order createOrder(Long membertId, String itemName, int itemPrice);
}
