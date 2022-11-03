import java.util.*;

public class Main {

    public static void removeAllDoubles(List<User> users) {
        Set<User> set = new HashSet<>(users);
        users.clear();
        users.addAll(set);
    }

    public static void sortedByAgeAndName(List<User> users) {
        users.sort(new ComparatorByAge().thenComparing(User::getName));
    }

    public static User getOldestUser(List<User> users) {
        User oldestUser = users.get(0);
        for (User user : users) {
            if (user.getAge() > oldestUser.getAge()) {
                oldestUser = user;
            }
        }
        System.out.println("Самый взрослый пользователь: ");
        return oldestUser;
    }

    public static void main(String[] args) {

        User nikolay = new User("Николай", 31);
        User vasiliy = new User("Василий", 37);
        User ekaterina = new User("Екатерина", 39);
        User anastasiya = new User("Анастасия", 33);

        List<User> users = new ArrayList<>();
        users.add(nikolay);
        users.add(vasiliy);
        users.add(ekaterina);
        users.add(vasiliy);
        users.add(vasiliy);
        users.add(vasiliy);
        users.add(ekaterina);
        users.add(ekaterina);
        users.add(ekaterina);
        users.add(anastasiya);
        users.add(anastasiya);
        users.add(anastasiya);
        users.add(anastasiya);

        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i));
        }

        removeAllDoubles(users);
        sortedByAgeAndName(users);

        System.out.println();
        for (User user : users) {
            System.out.println(user);
        }

        System.out.println(getOldestUser(users));
        System.out.println();

        String string = "Какая-то строка слова ищем слова конкретные строка слова";
        String[] words = string.split(" ");
        Map<String, Integer> findWords = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (findWords.containsKey(words[i])) {
                int count = findWords.get(words[i]);
                findWords.put(words[i], count+1);
            } else {
                findWords.put(words[i], 1);
            }
        }
        System.out.println(findWords);
    }
}