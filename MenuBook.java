import java.util.ArrayList;

public class MenuBook {
    MenuBook() {}

    private ArrayList<RegularMenu> regularMenus = new ArrayList();
    private ArrayList<SpecialMenu> specialMenus = new ArrayList();

    void addMenu(RegularMenu regularMenu) {
        regularMenus.add(regularMenu);
    }

    void addMenu(SpecialMenu specialMenu) {
        specialMenus.add(specialMenu);
    }

    void deleteRegularMenu(String code) {
        RegularMenu menu = getSelectedRegularMenu(code);

        if (menu != null) {
            regularMenus.remove(menu);
            System.out.println("Deleted Success!");
        } else {
            System.out.println("Code is wrong");
        }
    }

    void deleteSpecialMenu(String code) {
        SpecialMenu menu = getSelectedSpecialMenu(code);

        if (menu != null) {
            specialMenus.remove(menu);
            System.out.println("Deleted Success!");
        } else {
            System.out.println("Code is wrong");
        }
    }

    void displayAllMenu() {
        displayRegulerMenu();
        System.out.println("\n");
        displaySpecialMenu();
    }

    private void displayRegulerMenu() {
        System.out.println("Reguler Menu");
        System.out.println("===================================================");
        System.out.println("No. | Kode |          Nama           |    Harga    |");
        System.out.println("===================================================");

        for (int i = 0; i < regularMenus.size(); i++) {
            RegularMenu menu = regularMenus.get(i);
            System.out.format("%4d %6s %25s %13d \n", (i+1), menu.getCode(), menu.getName(), menu.getPrice());
        }
    }

    private void displaySpecialMenu() {
        System.out.println("Special Menu");
        System.out.println("==============================================================");
        System.out.println("No. | Kode |          Nama           |    Harga    | Discount |");
        System.out.println("==============================================================");

        for (int i = 0; i < specialMenus.size(); i++) {
            SpecialMenu menu = specialMenus.get(i);
            System.out.format("%4d %6s %25s %13d %10d \n", (i+1), menu.getCode(), menu.getName(), menu.getPrice(), menu.getDiscount());
        }
    }

    private RegularMenu getSelectedRegularMenu(String code) {
        RegularMenu menu = regularMenus.stream()
            .filter(it -> code.equals(it.getCode()))
            .findAny()
            .orElse(null);

        return menu;
    }

    private SpecialMenu getSelectedSpecialMenu(String code) {
        SpecialMenu menu = specialMenus.stream()
            .filter(it -> code.equals(it.getCode()))
            .findAny()
            .orElse(null);

        return menu;
    }
}