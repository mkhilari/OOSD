package Town;

public class Person {
    
    private String name;
    private int age;

    public Person(String name, int age) throws NoNameException {

        if (name.length() == 0) {

            throw new NoNameException();
        }

        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public void setName(String name) throws NoNameException {

        if (name.length() == 0) {

            throw new NoNameException();
        }

        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
