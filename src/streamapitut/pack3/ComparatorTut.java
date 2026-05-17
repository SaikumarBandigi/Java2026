package streamapitut.pack3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Pupil {
    int id;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pupil(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Assistant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

public class ComparatorTut {
    public static void main(String[] args) {

        List<Pupil> list = new ArrayList<>();

        list.add(new Pupil(1, "A"));
        list.add(new Pupil(2, "C"));
        list.add(new Pupil(3, "D"));
        list.add(new Pupil(4, "B"));

        list.sort(Comparator.comparing(Pupil::getName));

        System.out.println(list);
    }
}

class CustomComparator implements Comparator<Pupil> {
    @Override
    public int compare(Pupil o1, Pupil o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
