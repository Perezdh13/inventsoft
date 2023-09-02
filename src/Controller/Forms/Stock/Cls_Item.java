package Controller.Forms.Stock;

public class Cls_Item {
    public String ref;
    public String name;
    public double pvp;
    public double neto;
    public int units;
    public Cls_Item(String ref, String name, double pvp, double neto, int units) {
        this.ref = ref;
        this.name = name;
        this.pvp = pvp;
        this.neto = neto;
        this.units = units;
    }


}
