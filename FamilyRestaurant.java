import java.util.Scanner;

public class FamilyRestaurant {

    public static void main(String[] args) {

        final char regularCodePrefix = 'R';
        final char specialCodePrefix = 'S';

        Scanner input = new Scanner(System.in);
        int choicesIndex = 0;

        final MenuBook menuBook = new MenuBook();

        do {
            try {
                printMenuIndex();
                System.out.print("Choice [1-6]:");
                choicesIndex = input.nextInt();

                switch(choicesIndex) {
                    case 1:
                        System.out.println("Add Regular Menu");
                        System.out.println("================================");
                        String regularMenuCode = getCodeFromInput(regularCodePrefix);
                        String regularMenuName = getNameFromInput();
                        int regularMenuPrice = getPriceFromInput();
                        RegularMenu regularMenu = new RegularMenu(regularMenuCode, regularMenuName, regularMenuPrice);
                        menuBook.addMenu(regularMenu);
                        System.out.println("Add Success!");
                        break;
                    case 2:
                        System.out.println("Add Special Menu");
                        System.out.println("================================");
                        String specialMenuCode = getCodeFromInput(specialCodePrefix);
                        String specialMenuName = getNameFromInput();
                        int specialMenuPrice = getPriceFromInput();
                        int specialMenuDiscount = getDiscountFromInput();
                        SpecialMenu specialMenu = new SpecialMenu(specialMenuCode, specialMenuName, specialMenuPrice, specialMenuDiscount);
                        menuBook.addMenu(specialMenu);
                        System.out.println("Add Success!");
                        break;
                    case 3:
                        menuBook.displayAllMenu();
                        break;
                    case 4:
                        System.out.println("Delete Regular Menu");
                        System.out.println("================================");
                        String deletedRegularCode = getCodeFromInput(regularCodePrefix);
                        menuBook.deleteRegularMenu(deletedRegularCode);
                        break;
                    case 5:
                        System.out.println("Delete Special Menu");
                        System.out.println("================================");
                        String deletedSpecialCode = getCodeFromInput(specialCodePrefix);
                        menuBook.deleteSpecialMenu(deletedSpecialCode);
                        break;
                    case 6:
                        System.out.println("Thank You");
                        break;
                    default:
                        System.out.println("Invalid choices");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                break;
            }
            System.out.println("\n\n\n");
            input.nextLine();
        } while (choicesIndex != 6);
    }

    private static void printMenuIndex() {
        System.out.println("Family Restaurant");
        System.out.println("================================");
        System.out.println("1. Add Regular Menu");
        System.out.println("2. Add Special Menu");
        System.out.println("3. Show All Menu");
        System.out.println("4. Delete Regular Menu");
        System.out.println("5. Delete Special Menu");
        System.out.println("6. Exit");
    }

    private static String getCodeFromInput(char prefixCode) {
        Scanner input = new Scanner(System.in);
        Boolean isError = false;
        String code = "";
        do {
            isError = false;
            try {
                System.out.print("Input menu code [" + prefixCode + "...]:");
                code = input.next();
                validateCode(prefixCode, code);
            } catch (Exception e) {
                isError = true;
            }
            input.nextLine();
        } while(isError);

        return code;
    }

    private static String getNameFromInput() {
        Scanner input = new Scanner(System.in);
        Boolean isError = false;
        String name = "";
        do {
            isError = false;
            try {
                System.out.print("Input menu name [5-20]:");
                name = input.nextLine();
                validateName(name);
            } catch (Exception e) {
                isError = true;
            }
            input.nextLine();
        } while(isError);

        return name;
    }

    private static int getPriceFromInput() {
        Scanner input = new Scanner(System.in);
        Boolean isError = false;
        int price = 0;
        do {
            isError = false;
            try {
                System.out.print("Input menu price [10000-100000]:");
                price = input.nextInt();
                validatePrice(price);
            } catch (Exception e) {
                isError = true;
            }
            input.nextLine();
        } while(isError);

        return price;
    }

    private static int getDiscountFromInput() {
        Scanner input = new Scanner(System.in);
        Boolean isError = false;
        int discount = 0;
        do {
            isError = false;
            try {
                System.out.print("Input menu discount [ 10% | 25% | 50% ]:");
                discount = input.nextInt();
                validateDiscount(discount);
            } catch (Exception e) {
                isError = true;
            }
            input.nextLine();
        } while(isError);

        return discount;
    }

    public static boolean validateCode(char prefix, String code) throws InvalidInputException {
        char codePrefix = code.charAt(0);
        if (codePrefix != prefix) {
            throw new InvalidInputException("Please input code with " + prefix + "prefix");
        } else if (code.length() != 4) {
            throw new InvalidInputException("Please input 4 characters");
        }
        return true;
    }

    public static boolean validateName(String name) throws InvalidInputException {
        if (name.length() < 5 || name.length() > 20) {
            throw new InvalidInputException("Please input name between 5 and 20 character");
        }
        return true;
    }

    public static boolean validatePrice(int price) throws InvalidInputException {
        if (price < 10000 || price > 100000) {
            throw new InvalidInputException("Please input price between 10.000 and 100.000");
        }
        return true;
    }

    public static boolean validateDiscount(int discount) throws InvalidInputException {
        if (!(discount == 10 || discount == 25 || discount == 50)) {
            throw new InvalidInputException("Please input discount 10%, 25% or 50%");
        }
        return true;
    }
}