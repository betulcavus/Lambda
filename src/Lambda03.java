import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Lambda03 {

    public static void main(String[] args) {

        List<String> menu = new ArrayList<>(Arrays.asList("trilece", "havucDilim", "guvec", "kokorec", "kusleme", "arabasi", "waffle", "kunefe", "guvec"));

        alfabetikBuyukTekrarsiz(menu); //ARABASİ GUVEC HAVUCDİLİM KOKOREC KUNEFE KUSLEME TRİLECE WAFFLE

        tersBuyukTekrarsiz(menu); //10 7 6 5

        kucBuyuge(menu); //guvec guvec waffle kunefe trilece kokorec kusleme arabasi havucDilim

        harfSayisi(menu); //List elemanlari 7 harften buyuk

        wHarfi(menu); //w ile yemek icat ettik

        xHarfi(menu); //x ile yemek ismi olmaz

        karakterSayisiMax(menu); //[havucDilim]

        sonHarfeGore(menu); //kokorec guvec trilece kusleme waffle kunefe arabasi havucDilim
    }

// Task -1 : List elemanlarini alafabetik buyuk harf ve tekrarsiz print ediniz.

    public static void alfabetikBuyukTekrarsiz(List<String> yemek){
        yemek.stream().map(String::toUpperCase).sorted().distinct().forEach(t-> System.out.print(t + " "));
    }

// Task -2 : list elemanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz

    public static void tersBuyukTekrarsiz(List<String> ikram){
        ikram.stream().map(String::length).sorted(Comparator.reverseOrder()).distinct().forEach(t-> System.out.print(t + " "));
    }

// Task-3 : List elemanlarini character sayisina gore kucukten buyuge gore print ediniz.

    public static void kucBuyuge(List<String> ikram){
        ikram.stream().sorted(Comparator.comparing(String::length)).forEach(t-> System.out.print(t + " "));
    }

//anyMatch() --> en az bir eleman sarti saglarsa true, aksi durumda false return eder
//allMatch() --> tum  elemanlar sarti saglarsa true, en az bir eleman sarti saglamazsa false return eder.
//noneMatch()--> hic bir sarti SAGLAMAZSA true, en az bir eleman sarti SAGLARSA false return eder.

// Task-4 : List elemanlarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.

    public static void harfSayisi(List<String> ikram){
        System.out.println(ikram.stream().allMatch(t-> t.length()<=7) ? "List elemanlari 7 veya daha az harften olusuyor" : "List elemanlari 7 harften buyuk");
    }

// Task-5 : List elemanlarinin hepsinin "w" ile baslamasını noneMatch() ile kontrol ediniz.

    public static void wHarfi(List<String> ikram){
        System.out.println(ikram.stream().noneMatch(t-> t.startsWith("w")) ? "w ile yemek ismi olmaz" : "w ile yemek icat ettik");
    }

// Task-6 : List elemanlarinin "x" ile biten en az bir elemanı var mi kontrol ediniz.

    public static void xHarfi(List<String> ikram){
        System.out.println(ikram.stream().anyMatch(t-> t.endsWith("x")) ? "x ile yemek icat ettik" : "x ile yemek ismi olmaz");
    }

// Task-7 : Karakter sayisi en buyuk elemani yazdiriniz.

    public static void karakterSayisiMax(List<String> ikram){
        Stream<String> sonIsim = ikram.stream().
                sorted(Comparator.comparing(t-> t.toString().length()).reversed()). //karakter sayisina gore tersten siraladi
                limit(1); //sadece ilk eleman cagirildi, limit metodunun donen degeri Stream<String> yapidadir
        System.out.println(Arrays.toString(sonIsim.toArray())); //sonIsim.toArray() stream olan akis array e cevrildi, Arrays.toString(sonIsim.toArray()) array i string yapiya cevirdi
    }

// Task-8 : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.

    public static void sonHarfeGore(List<String> ikram){
        ikram.stream().
                sorted(Comparator.comparing(t-> t.charAt(t.length()-1))). //son harfe gore alfabetik siralandi
                skip(1). //akistaki ilk eleman haric tutuldu
                forEach(Lambda01::yazdir);
    }



}
