import java.util.*;
import java.util.stream.Collectors;

public class Lambda04 {
/*
TASK
fields --> Universite (String)
           bolum (String)
           ogrcSayisi (int)
           notOrt (int)
           olan POJO clas create edip main method içinde 5 farklı obje'den List create ediniz.
 */

    public static void main(String[] args) {

    Lambda04_Univercity u01 = new Lambda04_Univercity("bogazici", "mat", 571, 93);
    Lambda04_Univercity u02 = new Lambda04_Univercity("istanbul teknik", "mat", 600, 81);
    Lambda04_Univercity u03 = new Lambda04_Univercity("istanbul", "hukuk", 1400, 71);
    Lambda04_Univercity u04 = new Lambda04_Univercity("marmara", "bilgisayar muh", 1080, 77);
    Lambda04_Univercity u05 = new Lambda04_Univercity("odtu", "gemi muh", 333, 74);

    List<Lambda04_Univercity> unv = new ArrayList<>(Arrays.asList(u01, u02, u03, u04, u05));

    System.out.println(notOrt74denBuyuk(unv)); //false

    System.out.println(matVarmi(unv)); //false

    System.out.println(ogrSayisiSirala(unv)); //[Lambda04_Univercity{univercity='istanbul', bolum='hukuk', ogrSayisi=1400, notOrt=71},
                                              // Lambda04_Univercity{univercity='marmara', bolum='bilgisayar muh', ogrSayisi=1080, notOrt=77},
                                              // Lambda04_Univercity{univercity='istanbul teknik', bolum='mat', ogrSayisi=600, notOrt=81},
                                              // Lambda04_Univercity{univercity='bogazici', bolum='mat', ogrSayisi=571, notOrt=93},
                                              // Lambda04_Univercity{univercity='odtu', bolum='gemi muh', ogrSayisi=333, notOrt=74}]

    System.out.println(matBolumSayisi(unv)); //2

    System.out.println(ogrSayisi(unv)); //OptionalInt[93]

    System.out.println(ogrSayisiMin(unv)); //OptionalInt[74]

    }

//Task-1 : butun unilerin notOrt'larinin 74' den buyuk oldugunu kontrol eden program create ediniz.

    public static boolean notOrt74denBuyuk(List<Lambda04_Univercity> unv){
        return unv.stream().allMatch(t-> t.getNotOrt()>74);
    }

//task-2 : universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.

    public static boolean matVarmi(List<Lambda04_Univercity> unv){
        return unv.stream().anyMatch(t-> t.getBolum().toLowerCase().contains("Matematik"));
    }

//task-3 : universite'leri ogr sayilarina gore b->k siralayiniz.

    public static List<Lambda04_Univercity> ogrSayisiSirala(List<Lambda04_Univercity> unv){
        return unv.stream().
                sorted(Comparator.comparing(Lambda04_Univercity::getOgrSayisi).reversed()). //universiteler ogr sayisina gore tersten siralandi
                collect(Collectors.toList());
    }

//task 04-->"matematik" bolumlerinin sayisini  print ediniz.

    public static int matBolumSayisi(List<Lambda04_Univercity> unv){
        return (int) unv.
                stream(). //akış sağladım
                        filter(t->t.getBolum().contains("mat")). // matematik bölümü olan ünv. seçtim
                        count(); // seçilen unv. sayısını aldım
    }

//task 05-->Ogrenci sayilari 550'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz.

    public static OptionalInt ogrSayisi (List<Lambda04_Univercity> unv){
       return unv.stream().filter(t-> t.getOgrSayisi()>550).mapToInt(t->t.getNotOrt()).max();
    }

//task 06-->Ogrenci sayilari 1050'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.

    public static OptionalInt ogrSayisiMin(List<Lambda04_Univercity> unv){
        return unv.stream().filter(t-> t.getOgrSayisi()<1050).mapToInt(t-> t.getNotOrt()).min();
    }


}
