import java.io.File;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.io.IOException;
import java.util.Scanner;

public class Exercise2 {
    /*
    Пусть дан список сотрудников: Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина,
    Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов,
    Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова,
    Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов.
    Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
    Отсортировать по убыванию популярности. Для сортировки использовать TreeMap.
     */
    static Map<String, Integer> emplNames = new TreeMap<>();

    public static void main(String[] args) {
        String filePath = "src/employees.txt";


        readFile(filePath);
        System.out.println(emplNames);

        Map<String, Integer> sortedNames = valueSort(emplNames);

        for (Map.Entry<String, Integer> entry: sortedNames.entrySet()
             ) {
            String name = entry.getKey();
            Integer count = entry.getValue();
            System.out.printf("Имя %s встречается %d раз", name, count);
            System.out.println();
        }

    }
    public static void readFile(String filePath){
        File file = new File(filePath);
        try(Scanner scan = new Scanner(file)){
            while(scan.hasNext()){
                String string = scan.nextLine();
                String[] content = string.split(" ");
                if(emplNames.containsKey(content[0])){
                    int value = emplNames.get(content[0]);
                    value+=1;
                    emplNames.put(content[0], value);
                }else{
                    emplNames.put(content[0],1);
                }


            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static <K, V extends Comparable<V> > Map<K, V> valueSort(final Map<K, V> map)
    {
        Comparator<K> valueComparator = new Comparator<K>() {
            public int compare(K k1, K k2)
            {
                int comp = map.get(k2).compareTo(
                        map.get(k1));
                if (comp == 0)
                    return 1;
                else
                    return comp;
            }

        };
        Map<K, V> sorted = new TreeMap<K, V>(valueComparator);

        sorted.putAll(map);

        return sorted;
    }
}
