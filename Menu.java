import java.util.ArrayList;

public class Menu {
    ArrayList<RegularDish> regularMenu = new ArrayList<>();
    ArrayList<SpecialDish> specialMenu = new ArrayList<>();

    public void addRegularMenu(RegularDish dish) {
        regularMenu.add(dish);
        System.out.println("Add Success!");
    }

    public void addSpecialMenu(SpecialDish dish) {
        specialMenu.add(dish);
        System.out.println("Add Success!");
    }

    public void showAllMenu() {
        System.out.println("Regular Menu");
        System.out.println("=========================");
        System.out.println("No. | Kode | Nama | Harga");
        System.out.println("=========================");
        for (int i = 0; i < regularMenu.size(); i++) {
            System.out.println(i + " " + regularMenu.get(i).print());
        }

        System.out.println("");
        System.out.println("Special Menu");
        System.out.println("====================================");
        System.out.println("No. | Kode | Nama | Harga | Diskon |");
        System.out.println("====================================");
        for (int i = 0; i < specialMenu.size(); i++) {
            System.out.println(i + " " + specialMenu.get(i).print());
        }
    }

    public void deleteRegularMenu(String code) {
        boolean deleted = this.regularMenu.removeIf(e -> e.code.equals(code));
        if (!deleted) {
            System.out.println("Code is Wrong");
        } else {
            System.out.println("Delete Success!");
        }
    }

    public void deleteSpecialMenu(String code) {
        boolean deleted = this.regularMenu.removeIf(e -> e.code.equals(code));
        if (!deleted) {
            System.out.println("Code is Wrong");
        } else {
            System.out.println("Delete Success!");
        }
    }
}
