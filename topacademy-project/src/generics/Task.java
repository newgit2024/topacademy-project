package generics;

public class Task <T extends Number>{
    private String name;
    private T mark;

    public Task(String name, T mark) {
        this.name = name;
        this.mark = mark;
    }

    public T getMark() {
        return mark;
    }
    /*
    public boolean equalsToMark (Task<T> task){
        return roundMark() == task.roundMark();
    }

     */

    public boolean equalsToMark (Task<?> task){
        return roundMark() == task.roundMark();
    }

    private int roundMark() {
        return Math.round(mark.floatValue());
    }
}
