import Database.Cls_Data;
import Class.Cls_shift;
import Class.Cls_Start;
import javax.swing.*;

public class Cls_Main {
    public static void main(String[] args){
        Cls_Start start = new Cls_Start();
       start.start();

        Cls_Data data = new Cls_Data();
        data.folder();
        data.stock();

        Cls_shift shift = new Cls_shift();



    }
}
