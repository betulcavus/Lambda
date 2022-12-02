import java.util.stream.IntStream;

public class Lambda05 {

    public static void main(String[] args) {

        System.out.println(topla(5)); //15

        System.out.println(toplaCincix(5)); //15

        System.out.println(toplaCift(4)); //6

        System.out.println(toplaCiftIlk(4)); //16

        System.out.println(toplaTekIlk(3)); //9

        ilkXPrint(3); //2, 4, 8

        istenenX(3, 2); //3, 9

        istenilenSayininFaktoriyeli(5); //120
    }

//TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar (x dahil)
// tamsayilari toplayan bir program create ediniz.

//Structured
    public static int topla(int x) {
        int toplam =0;
        for(int i=0 ; i<=x ; i++ ) {
            toplam = toplam + i ;
        }
        return toplam;
    }

// Functional
    public static int toplaCincix(int x) {  // List<Integer> x ---> x.stream().
        return IntStream. // int değerlerde bir akış sağlar
                range(1,x+1). // range(a,b) --> a dan b'ye kadar ( b dahil değil) int değerler akısa alındı
                sum();// akışdan gelen değerler toplandı
    }

//TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.
    public static int toplaCift(int x){
       return IntStream.rangeClosed(1,x+1).filter(Lambda01::ciftBul).sum();
    }

//TASK 03 --> Ilk x pozitif cift sayiyi toplayan program create ediniz.
    public static int toplaCiftIlk(int x){
        return IntStream.iterate(1, t->t+2). //2den sonsuza kadar elemanlari 2 artirarak akisa alir
                limit(x). //x ile sinirla
                sum();
    }

//TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi create ediniz.
    public static int toplaTekIlk(int x){
        return IntStream.iterate(1, t->t+2). //1, 3, 5, 7..
                limit(x).sum();
    }

//TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void ilkXPrint(int x) {
        IntStream.iterate(2, t -> t * 2).limit(x).forEach(Lambda01::yazdir);
    }

//TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void istenenX(int istenen, int x){
        IntStream.iterate(istenen, t->t*istenen).limit(x).forEach(Lambda01::yazdir);
    }

//TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.
    public static int istenilenSayininFaktoriyeli(int x){
      return IntStream.rangeClosed(1, x).reduce(1, (t,u)->t*u);
    }

}
