import java.util.ArrayList;

public class SpecialDish extends Dish {
    ArrayList<Integer> discounts = new ArrayList<>();

    public SpecialDish() {
        ArrayList<Integer> discounts = new ArrayList<>();
        discounts.add(10);
        discounts.add(25);
        discounts.add(50);
        this.discounts = discounts;
    }

    @Override
    public void setCode(String code) throws Exception {
        if (code.length() != 4) {
            throw new Exception("kode harus 4 karakter");
        }
        char prefix = 'S';
        if (code.charAt(0) != prefix) {
            throw new Exception("kode harus diawali dengan huruf S");
        }
        this.code = code;
    }

    @Override
    public void setDiscount(int discount) throws Exception {
        if (!this.discounts.contains(discount)) {
            throw new Exception("diskon harus 10 atau 25 atau 50 persen");
        }
        this.discount = discount;
    }
}
