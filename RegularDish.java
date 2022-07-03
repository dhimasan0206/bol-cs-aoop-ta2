public class RegularDish extends Dish {
    @Override
    public void setCode(String code) throws Exception {
        if (code.length() != 4) {
            throw new Exception("kode harus 4 karakter");
        }
        char prefix = 'R';
        if (code.charAt(0) != prefix) {
            throw new Exception("kode harus diawali dengan huruf R");
        }
        this.code = code;
    }

    @Override
    public String print() {
        return this.code + " " + this.name + " " + this.price;
    }
}
