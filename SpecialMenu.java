public class SpecialMenu extends Menu {

    private int discount;

    SpecialMenu(String code, String name, int price, int discount) {
        super(code, name, price);
        this.discount = discount;
    }

    int getDiscount() {
        return this.discount;
    }
}