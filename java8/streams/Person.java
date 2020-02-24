package java8.streams;

public class Person {
    private String name;
    private String title;
    private int age;

    public Person(String name, String title, int age) {
        this.name = name;
        this.title = title;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
