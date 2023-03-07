package task1;

public class Task1 {

    private static String selectFrom(String ignore, String[] str) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length; i++) {
            if (i == 0)
                sb.append("" + str[i]);
            else if (!str[i].contains(ignore))
                sb.append(" AND" + str[i]);
        }

        String filtered = new String(sb)
        .replaceAll(":", "=")
        .replaceAll("'", "");


        return filtered;
    }

    public static void main(String[] args) {

        System.out.println("\033[H\033[2J");

        String original = "'name:Ivanov', 'country:Russia', 'city:Moscow', 'age:null'";
        String[] str = original.split(",");

        String filtered = selectFrom("null", str);

        System.out.println("The original line students: 'name:Ivanov', 'country:Russia', 'city:Moscow', 'age:null'");
        System.out.println();
        System.out.println("SELECT * FROM students WHERE column != NULL: " + filtered);
    }
}
