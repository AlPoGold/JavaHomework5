

public class Exercise1 {

    /*
    Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
     */

    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();
        pb.addUser("Olga Ivanova", "+9999", "work");
        pb.addUser("Petr Litvak", "+777", "relative");
        pb.addUser("Mother", "+999556669", "family");
        pb.addUser("Mother", "+1111111", "family");
        pb.addUser("Sam Porter Bridges", "00000", "work");
        pb.findUserByName("Litvak");
        pb.findUserByName("Moth");
        pb.findUserByComment("work");

    }
}
