package functional.anonymous;

public abstract class TextField {

    protected String text;
     public void input (String text){
         this.text = text;
     }
     public void clear(){
         onBeforeClear();
         this.text = null;
     }

    public String getText() {
        return text;
    }

     public abstract void onAfterInput();
    public abstract void onBeforeClear();
}
