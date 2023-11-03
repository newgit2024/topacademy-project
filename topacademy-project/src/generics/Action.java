package generics;

import inheritance.Circle;

public class Action {
    public <T extends Number> Action(T num) {
        //
    }
    public <T> boolean check (T num){
        return true;
    }
}