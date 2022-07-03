import java.util.Scanner;

public class Restaurant {
    public static void main(String[] args) {
        Menu menu = new Menu();
        boolean exit = false;
        while (!exit) {
            printOption();
            int option = 0;
            while (option < 1 || option > 6) {
                option = scanOption();
            }
            switch (option) {
                case 1:
                    boolean ok = false;
                    while (!ok) {
                        try {
                            menu.addRegularMenu(scanRegularMenu());
                            ok = true;
                        } catch (Exception e) {
                            ok = false;
                        }
                    }
                    break;
                case 2:
                    ok = false;
                    while (!ok) {
                        try {
                            menu.addSpecialMenu(scanSpecialMenu());
                            ok = true;
                        } catch (Exception e) {
                            ok = false;
                        }
                    }
                    break;
                case 3:
                    menu.showAllMenu();
                    break;
                case 4:
                    ok = false;
                    while (!ok) {
                        try {
                            menu.deleteRegularMenu(scanDeleteRegularMenu());
                            ok = true;
                        } catch (Exception e) {
                            ok = false;
                        }
                    }
                    break;
                case 5:
                    ok = false;
                    while (!ok) {
                        try {
                            menu.deleteSpecialMenu(scanDeleteSpecialMenu());
                            ok = true;
                        } catch (Exception e) {
                            ok = false;
                        }
                    }
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    break;
            }
        }
    }

    public static void printOption() {
        System.out.println("Family Restaurant");
        System.out.println("=================");
        System.out.println("1. Add Regular Menu");
        System.out.println("2. Add Special Menu");
        System.out.println("3. Show All Menu");
        System.out.println("4. Delete Regular Menu");
        System.out.println("5. Delete Special Menu");
        System.out.println("6. Exit");
    }

    public static int scanOption() {
        int res = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("Choice [1-6]: ");
        if (input.hasNextInt()) {
            res = input.nextInt();
        } else {
            res = 0;
        }
        return res;
    }

    public static RegularDish scanRegularMenu() {
        RegularDish res = new RegularDish();
        Scanner input = new Scanner(System.in);

        System.out.println("Add Regular Menu");
        System.out.println("================");

        boolean ok = false;
        while (!ok) {
            try {
                System.out.print("input menu code [R...]:");
                res.setCode(input.nextLine());
                ok = true;
            } catch (Exception e) {
                ok = false;
            }
        }

        ok = false;
        while (!ok) {
            try {
                System.out.print("input menu name [5-20]:");
                res.setName(input.nextLine());
                ok = true;
            } catch (Exception e) {
                ok = false;
            }
        }

        ok = false;
        while (!ok) {
            try {
                System.out.print("input menu price [10000-100000]:");
                res.setPrice(input.nextInt());
                ok = true;
            } catch (Exception e) {
                ok = false;
            }
        }
        
        return res;
    }

    public static SpecialDish scanSpecialMenu() {
        SpecialDish res = new SpecialDish();
        Scanner input = new Scanner(System.in);

        System.out.println("Add Regular Menu");
        System.out.println("================");

        boolean ok = false;
        while (!ok) {
            try {
                System.out.print("input menu code [S...]:");
                res.setCode(input.nextLine());
                ok = true;
            } catch (Exception e) {
                ok = false;
            }
        }

        ok = false;
        while (!ok) {
            try {
                System.out.print("input menu name [5-20]:");
                res.setName(input.nextLine());
                ok = true;
            } catch (Exception e) {
                ok = false;
            }
        }

        ok = false;
        while (!ok) {
            try {
                System.out.print("input menu price [10000-100000]:");
                res.setPrice(input.nextInt());
                ok = true;
            } catch (Exception e) {
                ok = false;
            }
        }

        ok = false;
        while (!ok) {
            try {
                System.out.print("input menu discount [10% | 25% | 50%]:");
                res.setDiscount(input.nextInt());
                ok = true;
            } catch (Exception e) {
                ok = false;
            }
        }
        
        return res;
    }

    public static String scanDeleteRegularMenu() {
        String res;
        Scanner input = new Scanner(System.in);
        System.out.print("input menu code [R...]:");
        if (input.hasNextLine()) {
            res = input.nextLine();
        } else {
            res = "";
        }
        return res;
    }

    public static String scanDeleteSpecialMenu() {
        String res;
        Scanner input = new Scanner(System.in);
        System.out.print("input menu code [S...]:");
        if (input.hasNextLine()) {
            res = input.nextLine();
        } else {
            res = "";
        }
        return res;
    }
}
