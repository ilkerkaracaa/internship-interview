import java.util.ArrayList;
import java.util.Random;
import java.util.ListIterator;

/*
abstract class Canli {
    private String isim;
    private int xKoordinati;
    private int yKoordinati;
    private char cinsiyet;
    private int yurumeMesafesi;
    private  boolean dogurabilir = true;

    public Canli(String isim, int xKoordinati, int yKoordinati, char cinsiyet, int yurumeMesafesi) {
        this.isim = isim;
        this.xKoordinati = xKoordinati;
        this.yKoordinati = yKoordinati;
        this.cinsiyet = cinsiyet;
        this.yurumeMesafesi = yurumeMesafesi;
    }

    // Getter ve setter metotları
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

    public boolean getDogurabilir(){return this.dogurabilir;}

    public void setDogurabilir(boolean active){this.dogurabilir = active;}

    public abstract void hareketEt(Canli canli, Random random);


}

class Av extends Canli {

    public Av(String isim, int xKoordinati, int yKoordinati, char cinsiyet, int yurumeMesafesi) {
        super(isim, xKoordinati, yKoordinati, cinsiyet, yurumeMesafesi);
    }

    @Override
    public void hareketEt(Canli canli, Random random) {
        for (int j = 0 ; j < canli.getYurumeMesafesi(); j++) {
            if(random.nextInt(100) >= 50) {
                if(canli.getXKoordinati() <= 0) {
                    if(random.nextInt(100) >= 50) {
                        canli.setXKoordinati(1);
                    }
                } else if(canli.getXKoordinati() >= 500) {
                    if(random.nextInt(100) >= 50) {
                        canli.setXKoordinati(-1);
                    }
                } else {
                    if(random.nextInt(100) >= 50){
                        canli.setXKoordinati(-1);
                    } else {
                        canli.setXKoordinati(1);
                    }
                }
            } else {
                if(canli.getYKoordinati() <= 0) {
                    if(random.nextInt(100) >= 50) {
                        canli.setYKoordinati(1);
                    }
                } else if(canli.getYKoordinati() >= 500) {
                    if(random.nextInt(100) >= 50) {
                        canli.setYKoordinati(-1);
                    }
                } else {
                    if(random.nextInt(100) >= 50){
                        canli.setYKoordinati(-1);
                    } else {
                        canli.setYKoordinati(1);
                    }
                }
            }
        }
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
        for (int j = 0 ; j < canli.getYurumeMesafesi(); j++) {
            if(random.nextInt(100) >= 50) {
                if(canli.getXKoordinati() <= 0) {
                    if(random.nextInt(100) >= 50) {
                        canli.setXKoordinati(1);
                    }
                } else if(canli.getXKoordinati() >= 500) {
                    if(random.nextInt(100) >= 50) {
                        canli.setXKoordinati(-1);
                    }
                } else {
                    if(random.nextInt(100) >= 50){
                        canli.setXKoordinati(-1);
                    } else {
                        canli.setXKoordinati(1);
                    }
                }
            } else {
                if(canli.getYKoordinati() <= 0) {
                    if(random.nextInt(100) >= 50) {
                        canli.setYKoordinati(1);
                    }
                } else if(canli.getYKoordinati() >= 500) {
                    if(random.nextInt(100) >= 50) {
                        canli.setYKoordinati(-1);
                    }
                } else {
                    if(random.nextInt(100) >= 50){
                        canli.setYKoordinati(-1);
                    } else {
                        canli.setYKoordinati(1);
                    }
                }
            }
        }
    }
}

class Yavru extends Canli {

    public Yavru(String isim, int xKoordinati, int yKoordinati, char cinsiyet, int yurumeMesafesi) {
        super(isim, xKoordinati, yKoordinati, cinsiyet, yurumeMesafesi);
    }

    @Override
    public void hareketEt(Canli canli, Random random) {
        for (int j = 0 ; j < canli.getYurumeMesafesi(); j++) {
            if(random.nextInt(100) >= 50) {
                if(canli.getXKoordinati() <= 0) {
                    if(random.nextInt(100) >= 50) {
                        canli.setXKoordinati(1);
                    }
                } else if(canli.getXKoordinati() >= 500) {
                    if(random.nextInt(100) >= 50) {
                        canli.setXKoordinati(-1);
                    }
                } else {
                    if(random.nextInt(100) >= 50){
                        canli.setXKoordinati(-1);
                    } else {
                        canli.setXKoordinati(1);
                    }
                }
            } else {
                if(canli.getYKoordinati() <= 0) {
                    if(random.nextInt(100) >= 50) {
                        canli.setYKoordinati(1);
                    }
                } else if(canli.getYKoordinati() >= 500) {
                    if(random.nextInt(100) >= 50) {
                        canli.setYKoordinati(-1);
                    }
                } else {
                    if(random.nextInt(100) >= 50){
                        canli.setYKoordinati(-1);
                    } else {
                        canli.setYKoordinati(1);
                    }
                }
            }
        }
    }
}*/




import java.util.Random;

abstract class Canli {
    private String isim;
    private int xKoordinati;
    private int yKoordinati;
    private char cinsiyet;
    private int yurumeMesafesi;
    private boolean dogurabilir = true;

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
        return dogurabilir;
    }

    public void setDogurabilir(boolean active) {
        this.dogurabilir = active;
    }

    public abstract void hareketEt(Canli canli, Random random);

    protected void hareketEtKoordinat(Canli canli, Random random, boolean isXKoordinati) {
        int koordinat = isXKoordinati ? canli.getXKoordinati() : canli.getYKoordinati();
        if (random.nextInt(100) >= 50) {
            if (koordinat <= 0) {
                if (random.nextInt(100) >= 50) {
                    if (isXKoordinati) {
                        canli.setXKoordinati(1);
                    } else {
                        canli.setYKoordinati(1);
                    }
                }
            } else if (koordinat >= 500) {
                if (random.nextInt(100) >= 50) {
                    if (isXKoordinati) {
                        canli.setXKoordinati(-1);
                    } else {
                        canli.setYKoordinati(-1);
                    }
                }
            } else {
                if (random.nextInt(100) >= 50) {
                    if (isXKoordinati) {
                        canli.setXKoordinati(-1);
                    } else {
                        canli.setYKoordinati(-1);
                    }
                } else {
                    if (isXKoordinati) {
                        canli.setXKoordinati(1);
                    } else {
                        canli.setYKoordinati(1);
                    }
                }
            }
        }
    }
}

class Av extends Canli {
    public Av(String isim, int xKoordinati, int yKoordinati, char cinsiyet, int yurumeMesafesi) {
        super(isim, xKoordinati, yKoordinati, cinsiyet, yurumeMesafesi);
    }

    @Override
    public void hareketEt(Canli canli, Random random) {
        for (int j = 0; j < canli.getYurumeMesafesi(); j++) {
            hareketEtKoordinat(canli, random, true); // X koordinatı için hareket
            hareketEtKoordinat(canli, random, false); // Y koordinatı için hareket
        }
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
        for (int j = 0; j < canli.getYurumeMesafesi(); j++) {
            hareketEtKoordinat(canli, random, true); // X koordinatı için hareket
            hareketEtKoordinat(canli, random, false); // Y koordinatı için hareket
        }
    }
}

class Yavru extends Canli {
    public Yavru(String isim, int xKoordinati, int yKoordinati, char cinsiyet, int yurumeMesafesi) {
        super(isim, xKoordinati, yKoordinati, cinsiyet, yurumeMesafesi);
    }

    @Override
    public void hareketEt(Canli canli, Random random) {
        for (int j = 0; j < canli.getYurumeMesafesi(); j++) {
            hareketEtKoordinat(canli, random, true); // X koordinatı için hareket
            hareketEtKoordinat(canli, random, false); // Y koordinatı için hareket
        }
    }
}



class SimulationTwo {
    public static void main(String[] args) {
        int maxSize = 500;
        ArrayList<Canli> canlilar = new ArrayList<Canli>();
        Random random = new Random();
        for (int i = 0; i < 15; i++) {
            canlilar.add(new Av("Koyun",random.nextInt(maxSize), random.nextInt(maxSize), 'E', 2));
            canlilar.add(new Av("Koyun", random.nextInt(maxSize), random.nextInt(maxSize), 'D', 2));
        }

        for (int i = 0; i < 5; i++) {
            canlilar.add(new Avci("Kurt", random.nextInt(maxSize), random.nextInt(maxSize), 'E', 3,4));
            canlilar.add(new Avci("Kurt", random.nextInt(maxSize), random.nextInt(maxSize), 'D', 3,4));
        }

        for (int i = 0; i < 5; i++) {
            canlilar.add(new Av("Inek", random.nextInt(maxSize), random.nextInt(maxSize), 'E', 2));
            canlilar.add(new Av("Inek", random.nextInt(maxSize), random.nextInt(maxSize), 'D', 2));
        }

        for (int i = 0; i < 10; i++) {
            canlilar.add(new Av("Tavuk", random.nextInt(maxSize), random.nextInt(maxSize), 'D', 1));
        }

        for (int i = 0; i < 10; i++) {
            canlilar.add(new Av("Horoz", random.nextInt(maxSize), random.nextInt(maxSize), 'E', 1));
        }

        for (int i = 0; i < 4; i++) {
            canlilar.add(new Avci("Aslan", random.nextInt(maxSize), random.nextInt(maxSize), 'E', 4, 5));
            canlilar.add(new Avci("Aslan", random.nextInt(maxSize), random.nextInt(maxSize), 'D', 4, 5));
        }
        canlilar.add(new Avci("Avci", random.nextInt(maxSize), random.nextInt(maxSize), 'E', 1, 8));
        System.out.println("*****************************************************");
        System.out.println("Toplam Canli Sayisi: " + canlilar.size());
        Simulate(canlilar, random);
        // Son durumun raporlanması
        ReportStatus(canlilar);
    }

    private static void Simulate(ArrayList<Canli> canlilar, Random random) {
        for (int i = 0; i < 1000; i++) {
            ListIterator<Canli> iterator = canlilar.listIterator();
            while (iterator.hasNext()) {
                Canli av = iterator.next();
                if(av.getIsim().equals("Koyun") || av.getIsim().equals("Tavuk") || av.getIsim().equals("Horoz")) {
                    for (Canli avci : canlilar) {
                        if(avci.getIsim().equals("Kurt")) {
                            if(Math.sqrt(Math.pow(avci.getXKoordinati() - av.getXKoordinati(), 2) + Math.pow(avci.getYKoordinati() - av.getYKoordinati(), 2)) <= 4) {
                                System.out.println(avci.getIsim() + " " + av.getIsim() + " avladi");
                                iterator.remove();
                                break;
                            }
                        } else if(avci.getIsim().equals("Aslan") && av.getIsim().equals("Koyun")) {
                            if(Math.sqrt(Math.pow(avci.getXKoordinati() - av.getXKoordinati(), 2) + Math.pow(avci.getYKoordinati() - av.getYKoordinati(), 2)) <= 5) {
                                System.out.println(avci.getIsim() + " " + av.getIsim() + " avladi");
                                iterator.remove();
                                break;
                            }
                        } else if(avci.getIsim().equals("Avci")){
                            if(Math.sqrt(Math.pow(avci.getXKoordinati() - av.getXKoordinati(), 2) + Math.pow(avci.getYKoordinati() - av.getYKoordinati(), 2)) <= 8) {
                                System.out.println(avci.getIsim() + " " + av.getIsim() + " avladi");
                                iterator.remove();
                                break;
                            }
                        }
                    }
                } else if(av.getIsim().equals("Inek")) {
                    for (Canli avci : canlilar) {
                        if(avci.getIsim().equals("Aslan")) {
                            if(Math.sqrt(Math.pow(avci.getXKoordinati() - av.getXKoordinati(), 2) + Math.pow(avci.getYKoordinati() - av.getYKoordinati(), 2)) <= 5) {
                                System.out.println(avci.getIsim() + " " + av.getIsim() + " avladi");
                                iterator.remove();
                                break;
                            }
                        } else if(avci.getIsim().equals("Avci")) {
                            if(Math.sqrt(Math.pow(avci.getXKoordinati() - av.getXKoordinati(), 2) + Math.pow(avci.getYKoordinati() - av.getYKoordinati(), 2)) <= 8) {
                                System.out.println(avci.getIsim() + " " + av.getIsim() + " avladi");
                                iterator.remove();
                                break;
                            }
                        }
                    }
                } else if(!av.getIsim().equals("Avci")){
                    for (Canli avci : canlilar) {
                        if(avci.getIsim().equals("Avci")) {
                            if(Math.sqrt(Math.pow(avci.getXKoordinati() - av.getXKoordinati(), 2) + Math.pow(avci.getYKoordinati() - av.getYKoordinati(), 2)) <= 8) {
                                System.out.println(avci.getIsim() + " " + av.getIsim() + " avladi");
                                iterator.remove();
                                break;
                            }
                        }
                    }
                }
            }
            iterator = canlilar.listIterator();
            while (iterator.hasNext()) {
                Canli canli = iterator.next();
                canli.hareketEt(canli, random);
            }
            iterator = canlilar.listIterator();
            while (iterator.hasNext()) {
                Canli erkek = iterator.next();
                for (Canli disi : canlilar) {
                    if (erkek.getIsim().equals("Koyun") && erkek.getCinsiyet() == 'E' && disi.getIsim().equals("Koyun") && disi.getCinsiyet() == 'D' && erkek.getDogurabilir() && disi.getDogurabilir()) {
                        if (Math.sqrt(Math.pow(erkek.getXKoordinati() - disi.getXKoordinati(), 2) + Math.pow(erkek.getYKoordinati() - disi.getYKoordinati(), 2)) <= 3) {
                            System.out.println("Koyun doğdu");
                            if (random.nextInt(100) >= 50) {
                                Yavru yavru = new Yavru("Koyun", disi.getXKoordinati() + 1, disi.getYKoordinati() + 1, 'E', 2);
                                yavru.setDogurabilir(false);
                                iterator.add(yavru);
                            } else {
                                Yavru yavru = new Yavru("Koyun", disi.getXKoordinati() + 1, disi.getYKoordinati() + 1, 'E', 2);
                                yavru.setDogurabilir(false);
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
                                iterator.add(yavru);
                            } else {
                                Yavru yavru = new Yavru("Koyun", disi.getXKoordinati() + 1, disi.getYKoordinati() + 1, 'D', 3);
                                yavru.setDogurabilir(false);
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
                                iterator.add(yavru);
                            } else {
                                Yavru yavru = new Yavru("Aslan", disi.getXKoordinati() + 1, disi.getYKoordinati() + 1, 'D', 4);
                                yavru.setDogurabilir(false);
                                iterator.add(yavru);
                            }
                            break;
                        }
                    }
                }
            }
        }
    }
    private static void ReportStatus(ArrayList<Canli> canlilar) {
        // Son durumun raporlanması burada yapılacak
        System.out.println("Hayvanlarin son durumu:");
        System.out.println("Kalan hayvan sayisi:" + canlilar.size());
        int koyunSayisi = 0, inekSayisi = 0, tavukSayisi = 0, horozSayisi = 0, kurtSayisi = 0, aslanSayisi = 0, avciSayisi = 0;
        for (Canli canli : canlilar) {
            if (canli.getIsim().equals("Koyun")) koyunSayisi++;
            else if (canli.getIsim().equals("Inek")) inekSayisi++;
            else if (canli.getIsim().equals("Tavuk")) tavukSayisi++;
            else if (canli.getIsim().equals("Horoz")) horozSayisi++;
            else if (canli.getIsim().equals("Kurt")) kurtSayisi++;
            else if (canli.getIsim().equals("Aslan")) aslanSayisi++;
            else if (canli.getIsim().equals("Avci")) avciSayisi++;
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