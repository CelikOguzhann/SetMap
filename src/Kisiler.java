import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

public class Kisiler implements Comparable<Kisiler> {

    private String socialSecurityNumber;
    private String firstName;
    private String lastName;
    private String phoneNumber;


    public Kisiler(String socialSecurityNumber, String firstName, String lastName, String phoneNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static ArrayList<Kisiler> getirKisiler() throws IOException {
        String FILE_PATH = "/Users/Oguzhancelik/Desktop/contacts.txt";
        FileReader dosyaOku = new FileReader(FILE_PATH);
        String satir;

        BufferedReader br = new BufferedReader(dosyaOku);
        ArrayList<Kisiler> kisiler = new ArrayList<>();
        System.out.println("Kişiler listesi");
        while ((satir = br.readLine()) != null) {
            Kisiler k1 = new Kisiler("","","","");

            String[] list1 = satir.split(" ");

            for (int i = 0; i<list1.length;i ++){
                if(i == 0 ){
                    k1.socialSecurityNumber= list1[i];
                } else if (i == 1) {
                    k1.firstName= list1[i];
                }else if (i == 2) {
                    k1.lastName= list1[i];
                }else if (i == 3) {
                    k1.phoneNumber= list1[i];
                }
            }

            kisiler.add(k1);

        }

        for (Kisiler k:kisiler) {
            System.out.println(k);
        }

        br.close();

        return kisiler;
    }

    public static void contactArrayList(ArrayList<Kisiler> liste) throws IOException{
        String dosya_yolu = "/Users/Oguzhancelik/Desktop/contactArrayList.txt";
        File file = new File(dosya_yolu);
        FileWriter yazici = new FileWriter(dosya_yolu, true);
        BufferedWriter yaz = new BufferedWriter(yazici);

        for(int i=0;i<liste.size();i++){
            yaz.write(liste.get(i).socialSecurityNumber+ " " +liste.get(i).firstName+ " " +liste.get(i).lastName+ " " +liste.get(i).phoneNumber+"\n");
        }
        yaz.close();
    }


    @Override
    public String toString() {
        return "Kisiler{" +
                "socialSecurityNumber='" + socialSecurityNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    @Override
    public int compareTo(Kisiler k) {
        return 0;
    }
}
