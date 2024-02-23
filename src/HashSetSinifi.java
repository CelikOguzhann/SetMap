import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;


public class HashSetSinifi {

    public static HashSet<Kisiler> getirKisiler() throws IOException {
        String dosyaYolu = "/Users/Oguzhancelik/Desktop/contacts.txt";
        FileReader dosyaOku = new FileReader(dosyaYolu);
        String satir;

        BufferedReader br = new BufferedReader(dosyaOku);

        HashSet<Kisiler> kisiler = new HashSet<>();
        while ((satir = br.readLine()) != null) {
            Kisiler k1 = new Kisiler("","","","");

            String[] list1 = satir.split(" ");

            for (int i = 0; i<list1.length;i ++){
                if(i == 0 ){
                    k1.setSocialSecurityNumber(list1[i]);
                } else if (i == 1) {
                    k1.setFirstName(list1[i]);
                }else if (i == 2) {
                    k1.setLastName(list1[i]);
                }else if (i == 3) {
                    k1.setPhoneNumber(list1[i]);
                }
            }
            kisiler.add(k1);
        }
        br.close();
        return kisiler;
    }

    public static void HashSetGonder(HashSet<Kisiler> liste) throws IOException{
        String dosya_yolu = "/Users/Oguzhancelik/Desktop/contactHashSet.txt";
        File file = new File(dosya_yolu);
        FileWriter yazici = new FileWriter(dosya_yolu, true);
        BufferedWriter yaz = new BufferedWriter(yazici);

        for (Kisiler kisi : liste) {
            yaz.write(kisi.getSocialSecurityNumber() +" "+ kisi.getFirstName() +" " + kisi.getLastName() +" "+ kisi.getPhoneNumber() +"\n");
        }
        yaz.close();
    }
}
