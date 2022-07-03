public class Menu {
    private String code, name;
    private int price;

    Menu(String code, String name, int price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    String getCode() {
        return this.code;
    }

    String getName() {
        return this.name;
    }

    int getPrice() {
        return this.price;
    }
}