package Database;

import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Cls_Data {


    public static void folder() {
        String folderPath = "D:\\FactoriaF5\\Java\\inventSoftData";
        Path dataInventSoft = Paths.get(folderPath);

        if (Files.notExists(dataInventSoft)) {
            try {
                Files.createDirectories(dataInventSoft);
                System.out.println("carpeta de archivos creada");
            } catch (IOException e) {
                System.out.println("no se pudo crear la carpeta: " + e.getMessage());
            }
        }else{
            System.out.println("la carpeta ya existe");
        }
    }

    public  static void stock(){
        String stockFile = "D:\\FactoriaF5\\Java\\inventSoftData\\stock.xml";
        Path dataStock = Paths.get(stockFile);

        if(Files.notExists(dataStock)){
            try{
                Files.createFile((dataStock));
                System.out.println("archivo de stock creado");
            }catch(IOException a){
                System.out.println(("no se pudo crear el archivo: "+a.getMessage()));
            }
        }else{
            System.out.println("ya existe el archivo dataStock");
        }
    }
}
