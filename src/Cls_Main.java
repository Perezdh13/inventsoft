import Database.Cls_Data;
import Controller.Cls_Start;

public class Cls_Main {
    public static void main(String[] args){
        Cls_Start start = new Cls_Start();
       start.start();

        Cls_Data data = new Cls_Data();
        data.folder();
        data.stock();





    }
}
