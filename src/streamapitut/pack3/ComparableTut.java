package streamapitut.pack3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Assistant implements Comparable<Assistant> {
    int id;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Assistant(int id, String name) {
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
    public int compareTo(Assistant o) {
        return Integer.compare(this.id, o.id);
    }

    @Override
    public String toString() {
        return "Assistant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

public class ComparableTut {

    public static void main(String[] args) {
        List<Assistant> assistants = new ArrayList<>();

        assistants.add(new Assistant(1, "A"));
        assistants.add(new Assistant(2, "C"));
        assistants.add(new Assistant(3, "B"));
        assistants.add(new Assistant(4, "E"));
        assistants.add(new Assistant(5, "D"));

        Collections.sort(assistants);

        System.out.println(assistants);

    }
}
