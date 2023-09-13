package study.data.structures;

public class Minion {
    public String name;
    public Integer age;
    public Integer numberOfEyes;

    public Minion(String name, Integer age, Integer numberOfEyes) {
        this.name = name;
        this.age = age;
        this.numberOfEyes = numberOfEyes;
    }

    @Override
    public String toString() {
        return "Minion{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", numberOfEyes=" + numberOfEyes +
                '}';
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getNumberOfEyes() {
        return numberOfEyes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setNumberOfEyes(Integer numberOfEyes) {
        this.numberOfEyes = numberOfEyes;
    }
}
