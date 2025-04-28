import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Создание адресов
        Address address1 = new Address("Россия", "Москва");
        Address address2 = new Address("Россия", "Казань");
        Address address3 = new Address("США", "Нью-Йорк");
        Address address4 = new Address("Германия", "Берлин");

        // Мапа: адрес -> цена за кг
        Map<Address, Integer> costPerAddress = new HashMap<>();
        costPerAddress.put(address1, 200);
        costPerAddress.put(address2, 200);
        costPerAddress.put(address3, 500);
        costPerAddress.put(address4, 450);

        int totalCost = 0;
        Set<String> uniqueCountries = new HashSet<>();

        while (true) {
            System.out.println("\nЗаполнение нового заказа.");
            System.out.print("Введите страну (или end для завершения): ");
            String country = scanner.nextLine();
            if (country.equalsIgnoreCase("end")) {
                break;
            }

            System.out.print("Введите город: ");
            String city = scanner.nextLine();

            System.out.print("Введите вес (кг): ");
            int weight;
            try {
                weight = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод веса. Попробуйте снова.");
                continue;
            }

            Address orderAddress = new Address(country, city);
            Integer costPerKg = costPerAddress.get(orderAddress);

            if (costPerKg == null) {
                System.out.println("Доставки по этому адресу нет.");
            } else {
                int deliveryCost = costPerKg * weight;
                totalCost += deliveryCost;
                uniqueCountries.add(country);

                System.out.println("Стоимость доставки составит: " + deliveryCost + " руб.");
                System.out.println("Общая стоимость всех доставок: " + totalCost + " руб.");
                System.out.println("Количество уникальных стран с доставкой: " + uniqueCountries.size());
            }
        }

        System.out.println("\nРабота завершена.");
        System.out.println("Итоговая стоимость всех доставок: " + totalCost + " руб.");
        System.out.println("Итоговое количество уникальных стран: " + uniqueCountries.size());
    }
}