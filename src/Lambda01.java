import java.util.*;
import java.util.stream.Collectors;

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

}
