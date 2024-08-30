/**
 * @auther ken.ck
 * @date 2024/5/15 00:53
 */
public class ThreadDemo implements Runnable {
    @Override
    public void run() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        new Thread(new ThreadDemo()).start();
    }

}
