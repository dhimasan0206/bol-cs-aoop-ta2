public class Dish {
    String code = "";
    String name = "";
    int price = 0;
    int discount = 0;

    public void setCode(String code) throws Exception {
        this.code = code;
    }

    public void setName(String name) throws Exception {
        if (name.length() < 5 || name.length() > 20) {
            throw new Exception("nama harus 5-20 karakter");
        }
        this.name = name;
    }

    public void setPrice(int price) throws Exception {
        if (price < 10000 || price > 100000) {
            throw new Exception("harga harus antara 10000 - 100000");
        }
        this.price = price;
    }

    public void setDiscount(int discount) throws Exception {
        this.discount = discount;
    }

    public String print() {
        return this.code + " " + this.name + " " + this.price + " " + this.discount + "%";
    }
}
