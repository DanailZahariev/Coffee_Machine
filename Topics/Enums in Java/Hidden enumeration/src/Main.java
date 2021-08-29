public class Main {

    public static void main(String[] args) {
        int count = 0;
        for (Secret status : Secret.values()) {
            if (status.toString().startsWith("STAR")) {
                count++;
            }
        }
        System.out.println(count);
    }
}

enum Secret {
    STAR, CRASH, START,
}
