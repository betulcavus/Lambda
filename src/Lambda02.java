import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda02 {

    public static void main(String[] args) {

        List<Integer> sayi = new ArrayList<>(Arrays.asList(4, 2, 6, 11, -5, 7, 3, 15));

        ciftKarePrint(sayi); //16 4 36

        tekKupPrint(sayi); //1332 -124 344 28 3376

        ciftKokPrint(sayi); //2.0 1.4142135623730951 2.449489742783178

        maxElPrint(sayi); //Optional[15]

        structuredMaxElBul(sayi); //en büyük sayı : 15

        ciftKareMaxPrint(sayi); //Optional[36]

        elTopPrint(sayi); //toplam = 43

        ciftCarp(sayi); //Optional[48]

        minBul(sayi); //Optional[-5]

        besBuyMinTekPrint(sayi); //Optional[7]

        ciftElKareSiraPrint(sayi); //4 16 36

    }

    // Task-1 : Functional Programming ile listin cift elemanlarinin karelerini
    // ayni satirda aralarina bosluk bırakarak print ediniz.
    public static void ciftKarePrint(List<Integer> sayi){
        sayi.stream().filter(Lambda01::ciftBul).map(t-> t*t).forEach(Lambda01::yazdir);
    }

    // Task-2 : Functional Programming ile listin tek elemanlarinin  kuplerinin
    // bir fazlasini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void tekKupPrint (List<Integer> sayi){
        sayi.stream().filter(t-> t%2!=0).map(t-> (t*t*t)+1).forEach(Lambda01::yazdir);
    }

    // Task-3 : Functional Programming ile listin cift elemanlarinin
    // karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void ciftKokPrint (List<Integer> sayi){
        sayi.stream().filter(Lambda01::ciftBul).map(Math::sqrt).forEach(t-> System.out.print(t + " "));
    }

    // Task-4 : Functional Programming ile list'in en buyuk elemanini yazdiriniz
    public static void maxElPrint (List<Integer> sayi){
       Optional<Integer> maxSayi = sayi.stream().reduce(Math::max);
        System.out.println(maxSayi);
    }
    // Structured Programming ile list'in en buyuk elemanini yazdiriniz
    public static void structuredMaxElBul(List<Integer> sayi){
        int max = Integer.MIN_VALUE;
        System.out.println("max = " + max); // max.soutv yazarsan yandakini verir ugrastirmaz
        for(int i=0; i<sayi.size(); i++) {
            if(sayi.get(i)>max) max = sayi.get(i);
        }
        System.out.println("en büyük sayı : " + max);
    }

    // Task-5 : List'in cift elemanlarin karelerinin en buyugunu print ediniz
    public static void ciftKareMaxPrint(List<Integer> sayi){
        System.out.println(sayi.stream().filter(Lambda01::ciftBul).map(t-> t*t).reduce(Integer::max)); //Math classi buyuk oldugu icin Integer daha hizli calisir
    } //en sona nokta koyup sout yazarsan yukaridaki parantezi verir ugrastirmaz

    // Task-6: List'teki tum elemanlarin toplamini yazdiriniz. Lambda Expression...
    public static void elTopPrint(List<Integer> sayi){
        int toplam = sayi.stream().reduce(0, (a,b) -> a+b);
        System.out.println("toplam = " + toplam);
    }
    /*
     a ilk degerini her zaman atanan degerden (ilk parametre) alır, bu örnekte 0 oluyor
     b degerini her zamana stream()'den yani akısdan alır
     a ilk degerinden sonraki her değeri action(işlem)'dan alır
    */

    // Task-7 : List'teki cift elemanlarin carpimini  yazdiriniz.
    public static void ciftCarp(List<Integer> sayi){
        System.out.println(sayi.stream().filter(Lambda01::ciftBul).reduce(Math::multiplyExact));
    }

    // Task-8 : List'teki elemanlardan en kucugunu print ediniz.
    public static void minBul(List<Integer> sayi){
        System.out.println(sayi.stream().reduce(Integer::min));
    }

    // Task-9 : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.
    public static void besBuyMinTekPrint(List<Integer> sayi){
        System.out.println(sayi.stream().filter(t-> t>5 && t%2==1).reduce(Integer::min));
    }

    // Task-10 : list'in cift  elemanlarinin karelerini kucukten buyuge print ediniz.
    public static void ciftElKareSiraPrint(List<Integer> sayi){
        sayi.stream().filter(Lambda01::ciftBul).map(t-> t*t).sorted().forEach(Lambda01::yazdir);
    }

}
