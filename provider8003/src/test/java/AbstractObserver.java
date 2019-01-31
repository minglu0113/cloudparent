import java.util.Set;

public abstract class AbstractObserver {
    public abstract void notifyPerson();
    public abstract void addPerson(Person person);
    public abstract void removePerson(Person person);
}
