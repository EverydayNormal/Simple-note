package by.shmarlouski.java.simplenote.model;


import java.util.ArrayList;

public class SimpleNote {

    private static SimpleNote simplenote;

    private SimpleNote() {
    }

    public static SimpleNote getInstance() {
        if (simplenote == null) {
            simplenote = new SimpleNote();
        }
        return simplenote;
    }

    private ArrayList<User> arrayList = new ArrayList<>();

    public ArrayList<User> getArrayList() {
        return arrayList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleNote that = (SimpleNote) o;

        return arrayList != null ? arrayList.equals(that.arrayList) : that.arrayList == null;
    }

    @Override
    public int hashCode() {
        return arrayList != null ? arrayList.hashCode() : 0;
    }

    @Override
    public String toString() {
    StringBuilder result = new StringBuilder();
        for (int i = 0; i < simplenote.getArrayList().size(); i++) {
            result.append(simplenote.getArrayList().get(i) + "\n");
        }
        return result.toString();
    }
}
