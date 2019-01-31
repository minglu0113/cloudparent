import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class AObserverImpl extends AbstractObserver {

    private Set<Person> personSets = new TreeSet<>();

    @Override
    public void notifyPerson() {
        for (Person person : this.getPersonSets()){
            person.say();
        }
    }

    @Override
    public void addPerson(Person person) {
        personSets.add(person);
    }

    @Override
    public void removePerson(Person person) {
        personSets.remove(person);
    }

    public Set<Person> getPersonSets() {
        return personSets;
    }

    public void setPersonSets(Set<Person> personSets) {
        this.personSets = personSets;
    }
}
