import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda01 {

    /* TASK :

     * Input olarak verilen listteki isimlerden
     * icinde 'a' harfi bulunanlari silen bir code create ediniz.
     *
     * INPUT : list1={"Ali","Veli","Ayse","Fatma","Omer"}
     * OUTPUT : [Veli,Omer]
     */

    /*
     reduce()-->azaltmak ... bir cok datayi tek bir dataya(max min carp top vs islemlerde) cevirmek icin kullanilir.
kullanımı yaygındır pratiktir.
Bir Stream içerisindeki verilerin teker teker işlenmesidir. Teker teker işleme sürecinde, bir önceki adımda elde edilen sonuç
bir sonraki adıma girdi olarak sunulmaktadır. Bu sayede yığılmlı bir hesaplama süreci elde edilmiş olmaktadır.
reduce metodu ilk parametrede identity değeri, ikinci parametrede ise BinaryOperator türünden bir obj kullanılır.
reduce işleminde bir önceki hesaplanmış değer ile sıradaki değer bir işleme tabi tutulmaktadır.
İşleme başlarken bir önceki değer olmadığı için bu değer identity parametresinde tanımlanmaktadır.
     */


    static ArrayList<String> names = new ArrayList<>(Arrays.asList("Tulay", "Zekeriya", "Hasan", "Ismail", "Osman", "Fatih", "Ersin", "Mevlut" ));

    static List<Integer> numbers =new ArrayList<>(Arrays.asList(25,65,-56,55,98,-89,65,55,21,54,9,35,35,34));

    static List<String> menu = new ArrayList<>(Arrays.asList("kusleme", "adana", "trilice", "havucdilim", "buryan",
            "kokorec", "kuzutandir", "guvec"));

    public static void aHarfiOlanlariSil(ArrayList<String> str) {
       str.removeIf(t->t.contains("a") || t.contains("A"));
        System.out.println(str);
    }

    //En buyuk elemani bulun

    public static void enBuyukHarfiBul(List<Integer> num) {
        Optional<Integer> maxSayi=num.stream().distinct().reduce(Math ::max);
        System.out.println(maxSayi);
    }

    // Task : List'teki tum elemanlarin toplamini yazdiriniz.

    public static void tumElemanlarinToplaminiYazdiriniz(List<Integer> liste) {
      int sum=  liste.stream().reduce(Math::addExact).get();
        System.out.println("List elemanlarin toplami : "+sum);
    }

// Task : List'teki cift elemanlarin carpimini  yazdiriniz.
    public static void ciftElemanlarinCarpiminiYazdiriniz(List<Integer> liste) {
        int carpim= liste.stream().filter(MyMethods::ciftElemaniBul).reduce(Math::multiplyExact).get();
        System.out.println("List elemanlarin carpim : "+carpim);
    }

    //TODO task tek lerin karesini buyukten kucuge
    public static void teklerinKareBuyuktenKucuge(List<Integer> sayi) {
    sayi.stream().
            filter(t->t%2==1).
            map(t->t*t).
            sorted(Comparator.reverseOrder()).
            forEach(MyMethods::yazdir);

    }

    // Task : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.
    public static void alfabetikBuyukHarfTekrarsiz(List<String> yemek) {
        yemek.stream().
                distinct().map(t->t.toUpperCase()).
                forEach(MyMethods::yazdir);



    }
    // Task : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
    public static void strKarakterSayisiYazdir(List<String> yemek) {
    }
    // Task :TODO list elemanlarinin son harfine gore ters sirali print ediniz.
    public static void sonHarfeGoreTersSira(List<String> yemek) {
        yemek.stream().
        sorted(Comparator.comparing(MyMethods::sonKarakteriAl).
        reversed()).
        forEach(MyMethods::yazdir);
    }
    // Task : listin elemanlarin karakterlerinin cift sayili  karelerini hesaplayan,ve karelerini tekrarsiz
    // buyukten kucuge sirali  print ediniz..
    public static void karakterCiftKareBuyuktenKucuge(List<String> yemek) {
    }
    // TODO Task : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
    public static void karakterSayiYedidenBuyuk(List<String> yemek) {
        System.out.println(yemek.stream().
                allMatch(t -> t.length() <= 7) ?
                "List elemanlari 7 ve daha az harften olusmus" :
                "Tum elemanlar yediden kucuk degil");


    }
    //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
    //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
    //noneMatch() --> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.


    // Task : List elelmanlarinin "W" ile baslamasını kontrol ediniz.
    public static void basHarfiWIleBaslayan(List<String> yemek) {
    }
    // TODO Task : List elelmanlarinin "x" ile biten en az bir elemaı kontrol ediniz.
    public static void xIleBitenEleman(List<String> yemek) {
    }
    // TODO Task : Karakter sayisi en buyuk elemani yazdiriniz.
    public static void karkterEnFazla(List<String> yemek) {
        //limit(1) => Sınırlandırma demek. Bu akışın elemanlarından oluşan, uzunluğu maxSize'dan uzun olmayacak
        // şekilde kesilmiş bir akış return eder. Stream return eder.
        Stream<String> sonIsim= yemek.stream().
                sorted(Comparator.comparing(t-> t.toString().length()).
                   reversed()).limit(1);
        System.out.println(Arrays.toString(sonIsim.toArray()));

    }
    /*
TRİCK : •    Stream'ler ekrana direk yazdırılamaz. Stream'i toArray() ile Array'e çeviririz.
Array'i de Arrays.toString() 'in içine alıp yazdırabiliriz.
•  Ör; System.out.println(Arrays.toString(***.toArray())); veya System.out.println(Arrays.asList(***.toArray()));
kullanılabilir.
*/
    //TODO Task : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.
    public static void sonHarfeGoreSiralaIlkHaricElmanlariYaz(List<String> yemek) {
    yemek.stream().
            sorted(Comparator.comparing(MyMethods::sonKarakteriAl)).
            skip(1).forEach(MyMethods::yazdir);

    }


}
