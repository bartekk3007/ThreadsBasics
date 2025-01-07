public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler
{

    @Override
    public void uncaughtException(Thread t, Throwable e)
    {
        System.out.println(t.getName() + " " + e.getMessage());
    }
}