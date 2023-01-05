import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String path = "/home//foo/";
        System.out.println("Task1 result: " + simplifyPath(path));
    }

    private static String simplifyPath(String path) {
        String[] temp = path.split("/");
        ArrayDeque<String> ad = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < temp.length; i++) {
            if (!ad.isEmpty() && temp[i].equals("..")) {
                ad.pop();
            } else if (!temp[i].equals("..") && !temp[i].equals(".") && !temp[i].equals("")) {
                ad.push(temp[i]);
            }
        }

        if (ad.isEmpty()) {
            return "/";
        }

        while (!ad.isEmpty()) {
            sb.insert(0, ad.pop()).insert(0, "/");
        }

        return sb.toString();
    }


}