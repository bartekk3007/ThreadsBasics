import com.sun.security.jgss.GSSUtil;

public class Main
{
    public static void main(String[] args) throws InterruptedException
    {
        Runnable task1 = () ->
        {
            for(int i = 0; i < 10_000; i += 2)
            {
                try
                {
                    System.out.println("Podzielne przez 2 " + i);
                    Thread.sleep(1);
                }
                catch (InterruptedException e)
                {
                    Thread.currentThread().interrupt();
                }
            }
        };
        Runnable task2 = () ->
        {
            for(int i = 0; i < 10_000; i += 3)
            {
                System.out.println("Podzielne przez 3 " + i);
            }
        };
        Runnable task3 = () ->
        {
            throw new RuntimeException();
        };

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        Thread thread3 = new Thread(task3);
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        thread1.start();
        thread2.start();
        thread3.start();
        thread1.interrupt();
        System.out.println("Koniec wątków");
    }
}