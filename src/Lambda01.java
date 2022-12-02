import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda01 {

   /*
          1)  Lambda -> method create etme değil, mevcut method'ları(library) secip kullanmaktır.
              Lambda sayesinde daha az kod ve hızlı geliştirme sağlanir.
          2)  "Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
              "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur.
          3)  "Functional Programming" hiz, code kisaligi, code okunabilirligi
              ve hatasiz code yazma acilarindan cok faydalidir.
          4)  Lambda sadece for ve if yapilarinda, collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir
              ancak map'lerde kullanılmaz.
          5)  Lambda = Java 8 = Stream API
          6)  Lambda Expressions arrow(->) yapisi ile kullanilir. Method chain olusturur.
              variableName.stream().nonTerminalOperations().terminalOperation();
              Terminal operasyonlarindan biri kullanilana kadar akis devam eder.
          7)  Javada Lambda fonksiyonları sadece Fonksiyonel interface'ler ile kullanılabilir.
              Sadece bir adet abstract metodu olan interface'lere fonksiyonel interface denilir.
              Kullanıcı isterse kendi fonksiyonel interface'ini yazabilir. Ama Javada hali hazırda
              Consumer, Function, Supplier, Predicate gibi tanımlanmış interfaceler bulunmaktadır.
              Ayrıca bu interface'leri parametre olarak alabilen High Order Function (HOF)'lar da bulunmaktadır.
              forEach(), map(), filter(), reduce() gibi HOF'lar fonksiyonel interfaceler ile çalıştığı için
              içerisinde Lambda fonksiyonları yazmak mümkündür.
          7)  Stream Operation Types;
                i.Intermediate Operation; filter(), map(), sorted(), distinct(), limit(), skip(), flatMap, peek..
                ii.Terminal Operation; forEach(), collect(), reduce(), count(), toArray(), min(), max(),
                                       match(), anyMatch(), allMatch(), noneMatch(), findFirst(), findAny()..
filter: bizim belirteceğimiz koşullar doğrultusunda filtreleme işlemi yapmamıza yarayan bir yapıdır.
map: her bir eleman üzerinde işlem yapmamıza ve başka elemanlara dönüştürmemize imkan sağlar
distinct: tekrarlı elemanları sadece bir kere akısa sokup tekrarsiz hale getirir
sorted: veri setini belirli bir parametreye göre sıralar. 2 türü bulunmaktadır.
        Biri, parametre almaz küçükten büyüğe şekilde sıralar, digeri bizim belirlemiş olduğumuz parametreye göre sıralar.
limit: sınırlandıran bir metoddur. Parametre olarak vereceğimiz rakamla sen bize şu kadarını göster diyoruz.
forEach: veriyi tek tek tüketmek için oluşturulmuş bir yapıdır.
collect: nesneleri başka biçimdeki nesneye veri yapısına dönüştürmek için kullanılır.
reduce: Indirgeme demektir, elemanları teker teker işler. Bir önceki adımda elde edilen sonuç, bir sonraki elemanla işlemle tutulur
allMatch: Verilen şarta göre tüm elemanların bu şarta uyması durumunda true dönecektir.
anyMatch: Vereceğimiz şarta bağlı olarak Stream içerisinde gezinir ve herhangi bir elemanla eşleşme durumunda true döner.
noneMatch: Şarta göre Stream içindeki hiç bir elemanın şartı sağlamaması durumunda true döner.
count: Stream içerisinde bulunan toplam veri sayısını öğrenmemize yarar.
    */

    public static void main(String[] args) {

        List<Integer> sayi = new ArrayList<>(Arrays.asList(34, 22, 16, 11, 35, 20, 63, 21, 65, 44, 66, 64, 81, 38, 15));

        printElStructured(sayi); //34 22 16 11 35 20 63 21 65 44 66 64 81 38 15

        printElFunctional(sayi); //34 22 16 11 35 20 63 21 65 44 66 64 81 38 15

        printElFunctional1(sayi); //342216113520632165446664813815

        printElFunctional2(sayi); //34 22 16 11 35 20 63 21 65 44 66 64 81 38 15

        printCiftElStructured(sayi); //34 22 16 20 44 66 64 38

        printCiftElFunctional(sayi); //34 22 16 20 44 66 64 38

        printCiftOtKucFunctional(sayi); //22 16 20

        printCiftOtBuyFunctional(sayi); //34 22 16 35 20 63 65 44 66 64 81 38 

    }

    //TASK: "Structured Programming" kullanarak list elemanlarını aynı satirda aralarında bosluk olacak sekilde print ediniz.
    public static void printElStructured(List<Integer> sayi){
        for (Integer w : sayi) {
            System.out.print(w + " ");
        }
    }

    //TASK: "Functional Programming" kullanarak list elemanlarını aynı satirda aralarında bosluk olacak sekilde print ediniz.
    public static void printElFunctional(List<Integer> sayi){
        sayi.
                stream().
                forEach((t)-> System.out.print(t + " ")); //lambda expression
    }
    //daha iyi cozumu asagidaki
    public static void printElFunctional1(List<Integer> sayi){
        sayi.
                stream().
                forEach(System.out::print); //method reference
    }
    //fakat yukaridaki method sayilar arasinda bosluk birakmiyor o sebeple
    //Kendimiz method olusturalim
    public static void yazdir(int a){
        System.out.print(a + " ");
    }

    public static void printElFunctional2(List<Integer> sayi){
        sayi.
                stream().
                forEach(Lambda01::yazdir); //method reference
    }

    //TASK: Structured Programming ile list elemanlarinin cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void printCiftElStructured(List<Integer> sayi){
        for (Integer w : sayi) {
            if (w%2==0){
                System.out.print(w + " ");
            }
        }
    }

    //TASK: Functional Programming ile list elemanlarinin cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void printCiftElFunctional(List<Integer> sayi){
        sayi.
                stream().
                filter(t-> t%2==0).
                forEach(Lambda01::yazdir); //lambda expression
    }

    //yukaridaki task'in filter() kismini method reference ile yapalim
    public static boolean ciftBul(int a){
        return a%2==0;
    }

    public static void printCiftElFunctional1(List<Integer> sayi){
        sayi.
                stream().
                filter(Lambda01::ciftBul).
                forEach(Lambda01::yazdir); //method reference
    }
    //TASK: Functional Programming ile list elemanlarinin 34 den kucuk ve cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void printCiftOtKucFunctional(List<Integer> sayi){
        sayi.
                stream().
                filter(t-> t%2==0 && t<34).
                forEach(Lambda01::yazdir);
    }

    //Task: Functional Programming ile list elemanlarinin 34 den buyuk veya cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void printCiftOtBuyFunctional(List<Integer> sayi){
        sayi.
                stream().
                filter(t-> t%2==0 || t>34).
                forEach(Lambda01::yazdir);
    }

    public static void yazdir(String a){
        System.out.print(a + " ");
    }


}
