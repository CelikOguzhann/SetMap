import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SoyadSirala implements Comparator<Kisiler> {

    @Override
    public int compare(Kisiler ilk, Kisiler son) {
        return ilk.getLastName().compareTo(son.getLastName());
    }

    public static ArrayList<Kisiler> sirala() throws Exception {
        ArrayList<Kisiler> liste = Kisiler.getirKisiler();
        Collections.sort(liste, new SoyadKarsilastir());
        return liste;
    }

    public static void yazdir(ArrayList<Kisiler> kisiler) throws IOException {
        File dosya = new File("/Users/Oguzhancelik/Desktop/ContactTreeSetOrderByLastName.txt");

        FileWriter yazici = new FileWriter(dosya, true);
        BufferedWriter yaz = new BufferedWriter(yazici);

        for (Kisiler k:kisiler) {
            yaz.write(k.getSocialSecurityNumber() +" "+ k.getFirstName() +" " + k.getLastName() +" "+ k.getPhoneNumber() +"\n");
        }
        yaz.close();
    }
}

