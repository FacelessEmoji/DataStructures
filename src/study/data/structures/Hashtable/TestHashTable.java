package study.data.structures.Hashtable;


public class TestHashTable {
    public static void main(String[] args) {
        // Создание хеш-таблицы
        HashTable<String, Integer> hashTable = new HashTable<>();
        System.out.println("Хеш-таблица создана.");
        System.out.println("Начальная емкость: " + hashTable.capacity());

        // Добавление элементов
        System.out.println("\nДобавление элементов:");
        hashTable.add("apple", 1);
        hashTable.add("banana", 2);
        hashTable.add("orange", 3);
        hashTable.add("mango", 4);
        hashTable.add("grape", 5);

        // Проверка размера после добавления элементов
        System.out.println("Количество элементов после добавления: " + hashTable.size());

        // Добавление или замена элемента
        System.out.println("\nДобавление или замена элемента 'apple' с значением 10:");
        hashTable.addOrReplace("apple", 10);
        System.out.println("apple: " + hashTable.get("apple"));

        // Поиск элемента
        System.out.println("\nПоиск элемента 'mango':");
        KeyValue<String, Integer> mango = hashTable.find("mango");
        System.out.println(mango != null ? mango : "Элемент не найден.");

        // Проверка наличия ключа
        System.out.println("\nПроверка наличия ключа 'banana': " + hashTable.containsKey("banana"));
        System.out.println("Проверка наличия ключа 'kiwi': " + hashTable.containsKey("kiwi"));

        // Удаление элемента
        System.out.println("\nУдаление элемента 'orange':");
        boolean removed = hashTable.remove("orange");
        System.out.println("Элемент 'orange' удален: " + removed);
        System.out.println("Проверка наличия ключа 'orange': " + hashTable.containsKey("orange"));

        // Получение всех ключей
        System.out.println("\nСписок всех ключей:");
        for (String key : hashTable.keys()) {
            System.out.println(key);
        }

        // Получение всех значений
        System.out.println("\nСписок всех значений:");
        for (Integer value : hashTable.values()) {
            System.out.println(value);
        }

        // Очистка хеш-таблицы
        System.out.println("\nОчистка хеш-таблицы:");
        hashTable.clear();
        System.out.println("Количество элементов после очистки: " + hashTable.size());

        // Проверка увеличения емкости
        System.out.println("\nПроверка увеличения емкости:");
        for (int i = 0; i < 20; i++) {
            hashTable.add("fruit" + i, i);
        }
        System.out.println("Емкость после добавления 20 элементов: " + hashTable.capacity());

        // Итерация по элементам
        System.out.println("\nИтерация по элементам после добавления фруктов:");
        for (KeyValue<String, Integer> entry : hashTable) {
            System.out.println(entry);
        }
    }
}


