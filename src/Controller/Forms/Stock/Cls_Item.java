package Controller.Forms.Stock;

public class Cls_Item {
    public String ref;
    public String name;
    public int pvp;
    public int neto;
    public int units;
    public Cls_Item(String ref, String name, int pvp, int neto, int units) {
        this.ref = ref;
        this.name = name;
        this.pvp = pvp;
        this.neto = neto;
        this.units = units;
    }


}
