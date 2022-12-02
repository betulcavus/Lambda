package lambda_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaPractice01 {

    public static void main(String[] args) {

    List<Integer> list = new ArrayList<>(Arrays.asList(-5, -8, -2, -12, 0, 1, 12, 5, 5, 6, 9, 15, 8));

    hepsiniyazDir(list); //-5 -8 -2 -12 0 1 12 5 5 6 9 15 8

    negatifYaz(list); //-5 -8 -2 -12 -8 -2

    ciftYaz(list); //-12 0 12 6 8

    pozVeCift(list); //12 6 8

    elKare(list); //25 64 4 144 0 1 144 25 25 36 81 225 64

    ciftKup(list); //-512 -8 -1728 0 1728 216 512

    kareTekrarsiz(list); //25 64 4 144 0 1 36 81 225

    sirala(list); //-12 -8 -5 -2 0 1 5 5 6 8 9 12 15

    tersSirala(list); //15 12 9 8 6 5 5 1 0 -2 -5 -8 -12

    System.out.println(kupBirBas(list)); //[125, 125, 3375]

    System.out.println(kareBirBas(list)); //[25, 25, 225]

    System.out.println(eltoplam(list)); //34

    pozElToplam(list); //61

    }


// S1:listi aralarinda bosluk birakarak yazdir

    public static void hepsiniyazDir(List<Integer> l){
        l.stream().forEach(t-> System.out.print(t + " "));
    }

//S2:sadece negatif olanlari yazdir

    public static void negatifYaz(List<Integer> l){
        l.stream().filter(t->t<0).forEach(t-> System.out.print(t + " "));
    }

//S3: cift olanlardan yeni bir liste olustur

    public static void ciftYaz(List<Integer> l){
        l.stream().filter(t->t%2==0).forEach(t-> System.out.print(t + " "));
    }

//S4:pozitif ve cift olanlari yazdir

    public static void pozVeCift(List<Integer> l){
        l.stream().filter(t->t%2==0 && t>0).forEach(t-> System.out.print(t + " "));
    }

//S6: list in elemanlarin karelerini aynı satırda bır bosluklu yazdır

    public static void elKare(List<Integer> l){
        l.stream().map(t-> t*t).forEach(t-> System.out.print(t + " "));
    }

//S7: Listin cift elemanlarının kuplerini  aynı satırda bır bosluklu yazdır

    public static void ciftKup(List<Integer> l){
        l.stream().filter(t-> t%2==0).map(t-> t*t*t).forEach(t-> System.out.print(t + " "));
    }

//S8 : list in elemanlarin karelerinden tekrarsiz yazdıralım

    public static void kareTekrarsiz(List<Integer> l){
        l.stream().map(t-> t*t).distinct().forEach(t-> System.out.print(t + " "));
    }

//S9: listin elemanlarini kucukten buyuge siralayalim

    public static void sirala(List<Integer> l){
        l.stream().sorted().forEach(t-> System.out.print(t + " "));
    }

//S10: listin elemanlarini buyukten kucuge siralayalim

    public static void tersSirala(List<Integer> l){
        l.stream().sorted(Comparator.reverseOrder()).forEach(t-> System.out.print(t + " "));
    }

// S11: list pozitif elemanlari icn kuplerini bulup birler basamagi 5 olanlardan yeni bir list olusturalim

    public static List<Integer> kupBirBas(List<Integer> l){
        return l.stream().filter(t-> t>0).map(t-> t*t*t).filter(t-> t%10==5).collect(Collectors.toList());
    }
    //2.yol
    public static void kupBirBas2(List<Integer>l){
        List<Integer>list=l.stream().filter(t->t>0).map(t->t*t*t).filter(t->t%10==5).collect(Collectors.toList());
        System.out.println(list);
    }

//S12: list pozitif elemanlari icn karelerini bulup birler basamagi 5 olmayanlardan yeni bir list olusturalim

    public static List<Integer> kareBirBas(List<Integer> l){
        l.stream().filter(t-> t>0).map(t-> t*t).filter(t-> t%10==5).collect(Collectors.toList());
        return l;
    }

//S13: list elemanlarinin toplamini bul

    public static int eltoplam(List<Integer> l){
        int i = l.stream().reduce(0, (x,y)-> x+y);
        return i;
    }
    //2.Yol
    public static int eltoplamReference(List<Integer> l){
        int i = l.stream().reduce(0, Math::addExact);
        return i;
    }
    //3.Yol
    public static int eltoplamReferenceInt(List<Integer> l){
        int i = l.stream().reduce(0, Integer::sum);
        return i;
    }

//S14 : Listin pozitif elemanları toplamını bulalım

    public static void pozElToplam(List<Integer> l){
        System.out.println(l.stream().filter(t -> t > 0).reduce(0, Math::addExact));
    }

}