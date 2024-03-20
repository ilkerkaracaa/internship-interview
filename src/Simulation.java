import java.util.ArrayList;
import java.util.Random;
import java.util.ListIterator;

//Soyut bir canli sinifi olusturuldu. Bu sinifin altinda av, avci ve yavru siniflari olusturuldu.
//Bu siniflarin hepsi Canli sinifindan turetilmistir. Canli sinifinda avlanma, dogum ve hareket etme metotlari soyut olarak tanimlandi.
//Bu metotlarin her biri alt siniflar tarafindan override edilerek kullanildi.
abstract class Canli {
    private final String isim;
    private int xKoordinati;
    private int yKoordinati;
    private final char cinsiyet;
    private final int yurumeMesafesi;
    private boolean dogurabilirMi = true;

    private boolean avlayabilirMi = true;

    public Canli(String isim, int xKoordinati, int yKoordinati, char cinsiyet, int yurumeMesafesi) {
        this.isim = isim;
        this.xKoordinati = xKoordinati;
        this.yKoordinati = yKoordinati;
        this.cinsiyet = cinsiyet;
        this.yurumeMesafesi = yurumeMesafesi;
    }

    public String getIsim() {
        return isim;
    }

    public int getXKoordinati() {
        return xKoordinati;
    }

    public void setXKoordinati(int xKoordinati) {
        this.xKoordinati += xKoordinati;
    }

    public int getYKoordinati() {
        return yKoordinati;
    }

    public void setYKoordinati(int yKoordinati) {
        this.yKoordinati += yKoordinati;
    }

    public char getCinsiyet() {
        return cinsiyet;
    }

    public int getYurumeMesafesi() {
        return yurumeMesafesi;
    }

    public boolean getDogurabilir() {
        return dogurabilirMi;
    }

    public void setDogurabilir(boolean durum) {
        this.dogurabilirMi = durum;
    }

    public boolean getAvlayabilir() {
        return avlayabilirMi;
    }

    public void setAvlayabilir(boolean durum) {
        this.avlayabilirMi = durum;
    }
    //Avlanma metodu, avcilarin avlarini avlamasi icin kullanildi. Dogum metodu, disi ve erkek canlilarin yavrularini dogurmasi icin kullanildi.
    public abstract void hareketEt(Canli canli, Random random);
    public abstract void Avlan(Canli canli, ListIterator<Canli> iterator, ArrayList<Canli> canlilar);
    public abstract void Dogum(Canli erkek, ListIterator<Canli> iterator, ArrayList<Canli> canlilar, Random random);


    protected void KoordinatlariDegistir(Canli canli, Random random) {
        // Canlinin yurume mesafesi kadar rastgele bir yone hareket etmesi saglandi.
        for (int i = 0; i < canli.getYurumeMesafesi(); i++) {
            // Rastgele bir yone hareket etmesi saglandi.
            // Eger rastgele bir sayi 50'den buyukse x koordinatlarini degistirir.
            // Eger rastgele bir sayi 50'den kucukse y koordinatlarini degistirir.
            if (random.nextInt(100) >= 50) {
                if (canli.getXKoordinati() <= 0) {
                    //if (random.nextInt(100) >= 50) {
                    //    canli.setXKoordinati(1);
                    //}
                    // Eger canlinin x koordinati 0'dan kucukse 1 arttirir.
                    canli.setXKoordinati(1);
                } else if (canli.getXKoordinati() >= 500) {
                    //if (random.nextInt(100) >= 50) {
                    //    canli.setXKoordinati(-1);
                    //}
                    // Eger canlinin x koordinati 500'den buyukse 1 azaltir.
                    canli.setXKoordinati(-1);
                } else {
                    // Sinir kosullarina takilmazsa rastgele bir yone hareket eder.
                    if (random.nextInt(100) >= 50) {
                        canli.setXKoordinati(-1);
                    } else {
                        canli.setXKoordinati(1);
                    }
                }
            } else {
                // Eger rastgele bir sayi 50'den kucukse y koordinatlarini degistirir.
                if (canli.getYKoordinati() <= 0) {
                    //if (random.nextInt(100) >= 50) {
                    //    canli.setYKoordinati(1);
                    //}
                    canli.setYKoordinati(1);
                } else if (canli.getYKoordinati() >= 500) {
                    //if (random.nextInt(100) >= 50) {
                    //    canli.setYKoordinati(-1);
                    //}
                    canli.setYKoordinati(-1);
                } else {
                    if (random.nextInt(100) >= 50) {
                        canli.setYKoordinati(-1);
                    } else {
                        canli.setYKoordinati(1);
                    }
                }
            }
        }
    }

    protected void AvlanmaMetodu(Canli av, ListIterator<Canli> iterator, ArrayList<Canli> canlilar) {
        // Eger av koyun, tavuk veya horoz ise avcilarin avlarini avlamasi saglandi.
        if(av.getIsim().equals("Koyun") || av.getIsim().equals("Tavuk") || av.getIsim().equals("Horoz")) {
            for (Canli avci : canlilar) {
                // Eger avci kurt ise ve avlayabilir durumda ise avlarini avlar.
                if(avci.getIsim().equals("Kurt") && avci.getAvlayabilir()) {
                    // Eger avci ve av arasindaki mesafe 3'ten kucukse avlanir.
                    if(Math.sqrt(Math.pow(avci.getXKoordinati() - av.getXKoordinati(), 2) + Math.pow(avci.getYKoordinati() - av.getYKoordinati(), 2)) <= 4) {
                        System.out.println(avci.getIsim() + " " + av.getIsim() + " avladi");
                        // Avlanan listeden cikarilir.
                        iterator.remove();
                        break;
                    }
                    // Eger avci aslan ise ve avlayabilir durumda ise avlarini avlar.
                } else if(avci.getIsim().equals("Aslan") && av.getIsim().equals("Koyun") && avci.getAvlayabilir()) {
                    // Eger avci ve av arasindaki mesafe 5'ten kucukse avlanir.
                    if(Math.sqrt(Math.pow(avci.getXKoordinati() - av.getXKoordinati(), 2) + Math.pow(avci.getYKoordinati() - av.getYKoordinati(), 2)) <= 5) {
                        // Avlanan listeden cikarilir.
                        System.out.println(avci.getIsim() + " " + av.getIsim() + " avladi");
                        iterator.remove();
                        break;
                    }
                    // Eger avci ise ve avlayabilir durumda ise avlarini avlar.
                } else if(avci.getIsim().equals("Avci") && avci.getAvlayabilir()){
                    // Eger avci ve av arasindaki mesafe 8'den kucukse avlanir.
                    if(Math.sqrt(Math.pow(avci.getXKoordinati() - av.getXKoordinati(), 2) + Math.pow(avci.getYKoordinati() - av.getYKoordinati(), 2)) <= 8) {
                        System.out.println(avci.getIsim() + " " + av.getIsim() + " avladi");
                        iterator.remove();
                        break;
                    }
                }
            }
            // Eger av inek ise avcilarin avlarini avlamasi saglandi.
        } else if(av.getIsim().equals("Inek")) {
            for (Canli avci : canlilar) {
                // Eger avci Aslan ise ve avlayabilir durumda ise avlarini avlar.
                if(avci.getIsim().equals("Aslan") && avci.getAvlayabilir()) {
                    // Eger avci ve av arasindaki mesafe 5'ten kucukse avlanir.
                    if(Math.sqrt(Math.pow(avci.getXKoordinati() - av.getXKoordinati(), 2) + Math.pow(avci.getYKoordinati() - av.getYKoordinati(), 2)) <= 5) {
                        System.out.println(avci.getIsim() + " " + av.getIsim() + " avladi");
                        iterator.remove();
                        break;
                    }
                    // Eger avci ise ve avlayabilir durumda ise avlarini avlar.
                } else if(avci.getIsim().equals("Avci") && avci.getAvlayabilir()) {
                    if(Math.sqrt(Math.pow(avci.getXKoordinati() - av.getXKoordinati(), 2) + Math.pow(avci.getYKoordinati() - av.getYKoordinati(), 2)) <= 8) {
                        // Avlanan listeden cikarilir.
                        System.out.println(avci.getIsim() + " " + av.getIsim() + " avladi");
                        iterator.remove();
                        break;
                    }
                }
            }
        } else if(!av.getIsim().equals("Avci")){
            // Av asla avci olamaz
            // Eger avci ise ve avlayabilir durumda ise avlarini avlar.
            for (Canli avci : canlilar) {
                if(avci.getIsim().equals("Avci") && avci.getAvlayabilir()) {
                    if(Math.sqrt(Math.pow(avci.getXKoordinati() - av.getXKoordinati(), 2) + Math.pow(avci.getYKoordinati() - av.getYKoordinati(), 2)) <= 8) {
                        System.out.println(avci.getIsim() + " " + av.getIsim() + " avladi");
                        iterator.remove();
                        break;
                    }
                }
            }
        }

    }

    // Dogum metodu, disi ve erkek canlilarin yavrularini dogurmasi icin kullanildi.
    protected void DogumMetodu(Canli erkek, ListIterator<Canli> iterator, ArrayList<Canli> canlilar, Random random) {
        for (Canli disi : canlilar) {
            // Eger erkek ve disi ayni cinsiyette degilse ve dogurabilir durumda ise dogurur.
            if (erkek.getIsim().equals("Koyun") && erkek.getCinsiyet() == 'E' && disi.getIsim().equals("Koyun") && disi.getCinsiyet() == 'D' && erkek.getDogurabilir() && disi.getDogurabilir()) {
                // Eger erkek ve disi arasindaki mesafe 3'ten kucukse dogurur.
                if (Math.sqrt(Math.pow(erkek.getXKoordinati() - disi.getXKoordinati(), 2) + Math.pow(erkek.getYKoordinati() - disi.getYKoordinati(), 2)) <= 3) {
                    System.out.println("Koyun doğdu");
                    if (random.nextInt(100) >= 50) {
                        // Eger rastgele bir sayi 50'den buyukse erkek yavru dogar.
                        Yavru yavru = new Yavru("Koyun", disi.getXKoordinati() + 1, disi.getYKoordinati() + 1, 'E', 2);
                        yavru.setDogurabilir(false);
                        iterator.add(yavru);
                    } else {
                        // Eger rastgele bir sayi 50'den kucukse disi yavru dogar.
                        Yavru yavru = new Yavru("Koyun", disi.getXKoordinati() + 1, disi.getYKoordinati() + 1, 'D', 2);
                        // Yavru dogurduktan sonra dogurabilir durumu false yapilir.
                        yavru.setDogurabilir(false);
                        // Yavru listeye eklenir.
                        iterator.add(yavru);
                    }
                    break;
                }
            }
            if (erkek.getIsim().equals("Kurt") && erkek.getCinsiyet() == 'E' && disi.getIsim().equals("Kurt") && disi.getCinsiyet() == 'D' && erkek.getDogurabilir() && disi.getDogurabilir()) {
                if (Math.sqrt(Math.pow(erkek.getXKoordinati() - disi.getXKoordinati(), 2) + Math.pow(erkek.getYKoordinati() - disi.getYKoordinati(), 2)) <= 3) {
                    System.out.println("Kurt doğdu");
                    if (random.nextInt(100) >= 50) {
                        Yavru yavru = new Yavru("Kurt", disi.getXKoordinati() + 1, disi.getYKoordinati() + 1, 'E', 3);
                        yavru.setDogurabilir(false);
                        yavru.setAvlayabilir(false);
                        iterator.add(yavru);
                    } else {
                        Yavru yavru = new Yavru("Kurt", disi.getXKoordinati() + 1, disi.getYKoordinati() + 1, 'D', 3);
                        yavru.setDogurabilir(false);
                        yavru.setAvlayabilir(false);
                        iterator.add(yavru);
                    }
                    break;
                }
            }
            if (erkek.getIsim().equals("Inek") && erkek.getCinsiyet() == 'E' && disi.getIsim().equals("Inek") && disi.getCinsiyet() == 'D' && erkek.getDogurabilir() && disi.getDogurabilir()) {
                if (Math.sqrt(Math.pow(erkek.getXKoordinati() - disi.getXKoordinati(), 2) + Math.pow(erkek.getYKoordinati() - disi.getYKoordinati(), 2)) <= 3) {
                    System.out.println("Inek doğdu");
                    if (random.nextInt(100) >= 50) {
                        Yavru yavru = new Yavru("Inek", disi.getXKoordinati() + 1, disi.getYKoordinati() + 1, 'E', 2);
                        yavru.setDogurabilir(false);
                        iterator.add(yavru);
                    } else {
                        Yavru yavru = new Yavru("Inek", disi.getXKoordinati() + 1, disi.getYKoordinati() + 1, 'D', 2);
                        yavru.setDogurabilir(false);
                        iterator.add(yavru);
                    }
                    break;
                }
            }
            if (erkek.getIsim().equals("Horoz") && erkek.getCinsiyet() == 'E' && disi.getIsim().equals("Tavuk") && disi.getCinsiyet() == 'D' && erkek.getDogurabilir() && disi.getDogurabilir()) {
                if (Math.sqrt(Math.pow(erkek.getXKoordinati() - disi.getXKoordinati(), 2) + Math.pow(erkek.getYKoordinati() - disi.getYKoordinati(), 2)) <= 3) {
                    if (random.nextInt(100) >= 50) {
                        System.out.println("Horoz doğdu");
                        Yavru yavru = new Yavru("Horoz", disi.getXKoordinati() + 1, disi.getYKoordinati() + 1, 'E', 1);
                        yavru.setDogurabilir(false);
                        iterator.add(yavru);
                    } else {
                        System.out.println("Tavuk doğdu");
                        Yavru yavru = new Yavru("Tavuk", disi.getXKoordinati() + 1, disi.getYKoordinati() + 1, 'D', 1);
                        yavru.setDogurabilir(false);
                        iterator.add(yavru);
                    }
                    break;
                }
            }
            if (erkek.getIsim().equals("Aslan") && erkek.getCinsiyet() == 'E' && disi.getIsim().equals("Aslan") && disi.getCinsiyet() == 'D' && erkek.getDogurabilir() && disi.getDogurabilir()) {
                if (Math.sqrt(Math.pow(erkek.getXKoordinati() - disi.getXKoordinati(), 2) + Math.pow(erkek.getYKoordinati() - disi.getYKoordinati(), 2)) <= 3) {
                    System.out.println("Aslan doğdu");
                    if (random.nextInt(100) >= 50) {
                        Yavru yavru = new Yavru("Aslan", disi.getXKoordinati() + 1, disi.getYKoordinati() + 1, 'E', 4);
                        yavru.setDogurabilir(false);
                        yavru.setAvlayabilir(false);
                        iterator.add(yavru);
                    } else {
                        Yavru yavru = new Yavru("Aslan", disi.getXKoordinati() + 1, disi.getYKoordinati() + 1, 'D', 4);
                        yavru.setDogurabilir(false);
                        yavru.setAvlayabilir(false);
                        iterator.add(yavru);
                    }
                    break;
                }
            }
        }
    }
}

// Av, Canli sinifindan turetilmistir. Avlarin hareket etme, avlanma ve dogum metotlari override edilmistir.
class Av extends Canli {
    public Av(String isim, int xKoordinati, int yKoordinati, char cinsiyet, int yurumeMesafesi) {
        super(isim, xKoordinati, yKoordinati, cinsiyet, yurumeMesafesi);
    }

    @Override
    public void hareketEt(Canli canli, Random random) {
        KoordinatlariDegistir(canli, random);
    }

    @Override
    public void Avlan(Canli canli, ListIterator<Canli> iterator, ArrayList<Canli> canlilar) {
        AvlanmaMetodu(canli, iterator, canlilar);
    }

    @Override
    public void Dogum(Canli erkek, ListIterator<Canli> iterator, ArrayList<Canli> canlilar, Random random) {
        DogumMetodu(erkek, iterator, canlilar, random);
    }
}

class Avci extends Canli {
    int AvMesafesi;

    public Avci(String isim, int xKoordinati, int yKoordinati, char cinsiyet, int yurumeMesafesi, int AvMesafesi) {
        super(isim, xKoordinati, yKoordinati, cinsiyet, yurumeMesafesi);
        this.AvMesafesi = AvMesafesi;
    }

    @Override
    public void hareketEt(Canli canli, Random random) {
        KoordinatlariDegistir(canli, random);
    }

    @Override
    public void Avlan(Canli canli, ListIterator<Canli> iterator, ArrayList<Canli> canlilar) {
        AvlanmaMetodu(canli, iterator, canlilar);
    }

    @Override
    public void Dogum(Canli erkek, ListIterator<Canli> iterator, ArrayList<Canli> canlilar, Random random) {
        DogumMetodu(erkek, iterator, canlilar, random);
    }
}

class Yavru extends Canli {
    public Yavru(String isim, int xKoordinati, int yKoordinati, char cinsiyet, int yurumeMesafesi) {
        super(isim, xKoordinati, yKoordinati, cinsiyet, yurumeMesafesi);
    }

    @Override
    public void hareketEt(Canli canli, Random random) {
        KoordinatlariDegistir(canli, random);
    }

    @Override
    public void Avlan(Canli canli, ListIterator<Canli> iterator, ArrayList<Canli> canlilar) {
        AvlanmaMetodu(canli, iterator, canlilar);
    }

    @Override
    public void Dogum(Canli erkek, ListIterator<Canli> iterator, ArrayList<Canli> canlilar, Random random) {
        DogumMetodu(erkek, iterator, canlilar, random);
    }
}

class Simulasyon {
    public static void main(String[] args) {
        // Simulasyonun baslangicinda canlilarin olusturulmasi
        int maxSize = 500;
        // alan siniri belirlendi
        ArrayList<Canli> canlilar = new ArrayList<>();
        Random random = new Random();
        // Canlilarin olusturulmasi
        for (int i = 0; i < 15; i++) {
            Av erkek = new Av("Koyun", random.nextInt(maxSize), random.nextInt(maxSize), 'E', 2);
            erkek.setAvlayabilir(false);
            canlilar.add(erkek);
            Av disi = new Av("Koyun", random.nextInt(maxSize), random.nextInt(maxSize), 'D', 2);
            // Disi koyunlarin Avlayabilir durumu false yapilir.
            disi.setAvlayabilir(false);
            canlilar.add(disi);
        }

        for (int i = 0; i < 5; i++) {
            canlilar.add(new Avci("Kurt", random.nextInt(maxSize), random.nextInt(maxSize), 'E', 3,4));
            canlilar.add(new Avci("Kurt", random.nextInt(maxSize), random.nextInt(maxSize), 'D', 3,4));
        }

        for (int i = 0; i < 5; i++) {
            Av erkek = new Av("Inek", random.nextInt(maxSize), random.nextInt(maxSize), 'E', 2);
            erkek.setAvlayabilir(false);
            canlilar.add(erkek);
            Av disi = new Av("Inek", random.nextInt(maxSize), random.nextInt(maxSize), 'D', 2);
            disi.setAvlayabilir(false);
            canlilar.add(disi);
        }

        for (int i = 0; i < 10; i++) {
            Av disi = new Av("Tavuk", random.nextInt(maxSize), random.nextInt(maxSize), 'D', 1);
            disi.setAvlayabilir(false);
            canlilar.add(disi);
        }

        for (int i = 0; i < 10; i++) {
            Av erkek = new Av("Horoz", random.nextInt(maxSize), random.nextInt(maxSize), 'E', 1);
            erkek.setAvlayabilir(false);
            canlilar.add(erkek);
        }

        for (int i = 0; i < 4; i++) {
            canlilar.add(new Avci("Aslan", random.nextInt(maxSize), random.nextInt(maxSize), 'E', 4, 5));
            canlilar.add(new Avci("Aslan", random.nextInt(maxSize), random.nextInt(maxSize), 'D', 4, 5));
        }
        canlilar.add(new Avci("Avci", random.nextInt(maxSize), random.nextInt(maxSize), 'E', 1, 8));

        System.out.println("*****************************************************");
        System.out.println("Toplam Canli Sayisi: " + canlilar.size());
        SimulaEt(canlilar, random);
        // Son durumun raporlanması
        DurumuRaporla(canlilar);
    }

    private static void SimulaEt(ArrayList<Canli> canlilar, Random random) {
        // Simulasyonun baslatilmasi
        for (int i = 0; i < 1000; i++) {
            // Canlilarin hareket etmesi, avlanmasi ve dogum yapmasi
            ListIterator<Canli> iterator = canlilar.listIterator();
            // İterator ile canlilarin uzerinde gezinilir.
            while (iterator.hasNext()) {
                Canli av = iterator.next();
                // İterator ile bir sonraki canliya gecilir.
                av.Avlan(av, iterator, canlilar);
                // Canlinin avlanmasi saglanir.
            }
            iterator = canlilar.listIterator();
            while (iterator.hasNext()) {
                Canli canli = iterator.next();
                canli.hareketEt(canli, random);
            }
            iterator = canlilar.listIterator();
            while (iterator.hasNext()) {
                Canli erkek = iterator.next();
                erkek.Dogum(erkek, iterator, canlilar, random);

            }
        }
    }
    private static void DurumuRaporla(ArrayList<Canli> canlilar) {
        // Son durumun raporlanması burada yapılacak
        System.out.println("Hayvanlarin son durumu:");
        System.out.println("Kalan hayvan sayisi:" + canlilar.size());
        int koyunSayisi = 0, inekSayisi = 0, tavukSayisi = 0, horozSayisi = 0, kurtSayisi = 0, aslanSayisi = 0, avciSayisi = 0;
        for (Canli canli : canlilar) {
            switch (canli.getIsim()) {
                case "Koyun":
                    koyunSayisi++;
                    break;
                case "Inek":
                    inekSayisi++;
                    break;
                case "Tavuk":
                    tavukSayisi++;
                    break;
                case "Horoz":
                    horozSayisi++;
                    break;
                case "Kurt":
                    kurtSayisi++;
                    break;
                case "Aslan":
                    aslanSayisi++;
                    break;
                case "Avci":
                    avciSayisi++;
                    break;
            }
        }
        System.out.println("Koyun sayisi: " + koyunSayisi);
        System.out.println("Kurt sayisi: " + kurtSayisi);
        System.out.println("Inek sayisi: " + inekSayisi);
        System.out.println("Tavuk sayisi: " + tavukSayisi);
        System.out.println("Horoz sayisi: " + horozSayisi);
        System.out.println("Aslan sayisi: " + aslanSayisi);
        System.out.println("Avci sayisi: " + avciSayisi);
    }
}