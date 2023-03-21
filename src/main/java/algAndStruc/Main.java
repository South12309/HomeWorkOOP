package algAndStruc;

public class Main {
    public static void main(String[] args) {
        ArrayListTest<String> list = new ArrayListTest<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        System.out.println(list);

        list.set(1, "20");
        System.out.println(list);

        list.remove(1);
        System.out.println(list);

        System.out.println(list.get(1));

        System.out.println("индекс четверки - " + list.find("4"));
    }
}
