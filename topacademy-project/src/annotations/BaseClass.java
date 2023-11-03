package annotations;

@BaseAnnotation(level = 3, doThing = "something helpful")
public class BaseClass {
    public void log() {
        Class<BaseClass> clazz = BaseClass.class;
        BaseAnnotation annotation = clazz.getAnnotation(BaseAnnotation.class);
        System.out.println(annotation.level());
        System.out.println(annotation.doThing());
    }
}
