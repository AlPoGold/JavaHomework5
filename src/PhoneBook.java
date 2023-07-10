import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private static int counterID;

    Map<Integer, String> phoneBook = new HashMap<>();



    public static Integer getID() {
        return counterID;
    }
    void addUser(String name, String phone, String comment){
        counterID++;
        StringBuilder st = new StringBuilder();


        st.append(name);
        st.append("|");
        st.append(phone);
        st.append("|");
        st.append(comment);

        phoneBook.put(PhoneBook.getID(), st.toString());

    }

    void findUserByName(String name){
        StringBuilder st = new StringBuilder();
        for(Map.Entry<Integer, String> entry: phoneBook.entrySet()){
            String id = entry.getKey().toString();
            String content = entry.getValue();
            if(content.contains(name)){
                st.append(id);
                st.append("|");
                st.append(content);
                st.append("\n");
            }

        }
        System.out.print(st);
    }

    void findUserByComment(String comment){
        StringBuilder st = new StringBuilder();
        for(Map.Entry<Integer, String> entry: phoneBook.entrySet()){
            String id = entry.getKey().toString();
            String content = entry.getValue();
            if(content.contains(comment)){
                st.append(id);
                st.append("|");
                st.append(content);
                st.append("\n");
            }

        }
        System.out.print(st);
    }

}
