package study.data.structures;

public class Minion implements Comparable<Minion> {
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

    @Override
    public int compareTo(Minion other) {
        int eyesComparison = Integer.compare(this.numberOfEyes, other.getNumberOfEyes());
        int ageComparison = Integer.compare(this.age, other.getAge());
        if (eyesComparison != 0) {
            return eyesComparison;
        } else if (ageComparison != 0) {
            return ageComparison;
        } else return Integer.compare(0, this.getName().compareTo(other.getName()));
    }
}
