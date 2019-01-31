import org.junit.Test;

public class TestObserver {

    @Test
    public void test(){
        Man person = new Man();
        person.setName("zhangluming");
        Man person1 = new Man();
        person1.setName("xiaoming");
        Man person2 = new Man();
        person2.setName("xiaowang");
        AbstractObserver observer = new AObserverImpl();
        observer.addPerson(person);
        observer.addPerson(person1);
        observer.addPerson(person2);
        observer.notifyPerson();
    }
}
