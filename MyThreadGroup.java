public class MyThreadGroup extends ThreadGroup
{

    public MyThreadGroup(String name)
    {
        super(name);
    }

    public MyThreadGroup(ThreadGroup parent, String name)
    {
        super(parent, name);
    }
}