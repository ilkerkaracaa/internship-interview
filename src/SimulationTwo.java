import java.util.ArrayList;
import java.util.Random;
import java.util.ListIterator;

abstract class Canli {
    private String isim;
    private int xKoordinati;
    private int yKoordinati;
    private char cinsiyet;
    private int yurumeMesafesi;

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

    public abstract void hareketEt(Canli canli, Random random);


}

class Av extends Canli {
    public Av(String Ad, int X, int Y, char cinsiyet, int YurumeMesafesi) {
        super(Ad, X, Y, cinsiyet, YurumeMesafesi);
    }

    @Override
    public void hareketEt(Canli canli, Random random) {
        for (int j = 0 ; j < canli.getYurumeMesafesi(); j++) {
            if(random.nextInt(100) >= 50) {
                if(canli.getXKoordinati() <= 0) {
                    // if(random.nextInt(2) == 1) {
                    //     canli.X += 1;
                    // }
                    canli.setXKoordinati(1);
                } else if(canli.getXKoordinati() >= 500) {
                    // if(random.nextInt(2) == 0) {
                    //     canli.X -= 1;
                    // }
                    canli.setXKoordinati(-1);
                } else {
                    if(random.nextInt(100) >= 50){
                        canli.setXKoordinati(-1);
                    } else {
                        canli.setXKoordinati(1);
                    }
                }
            } else {
                if(canli.getYKoordinati() <= 0) {
                    // if(random.nextInt(2) == 1) {
                    //     canli.Y += 1;
                    // }
                    canli.setYKoordinati(1);
                } else if(canli.getYKoordinati() >= 500) {
                    // if(random.nextInt(2) == -1) {
                    //     canli.Y -= 1;
                    // }
                    canli.setYKoordinati(-1);
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
    public Avci(String Ad, int X, int Y, char cinsiyet, int YurumeMesafesi, int AvMesafesi) {
        super(Ad, X, Y, cinsiyet, YurumeMesafesi);
        this.AvMesafesi = AvMesafesi;
    }

    @Override
    public void hareketEt(Canli canli, Random random) {
        for (int j = 0 ; j < canli.getYurumeMesafesi(); j++) {
            if(random.nextInt(100) >= 50) {
                if(canli.getXKoordinati() <= 0) {
                    // if(random.nextInt(2) == 1) {
                    //     canli.X += 1;
                    // }
                    canli.setXKoordinati(1);
                } else if(canli.getXKoordinati() >= 500) {
                    // if(random.nextInt(2) == 0) {
                    //     canli.X -= 1;
                    // }
                    canli.setXKoordinati(-1);
                } else {
                    if(random.nextInt(100) >= 50){
                        canli.setXKoordinati(-1);
                    } else {
                        canli.setXKoordinati(1);
                    }
                }
            } else {
                if(canli.getYKoordinati() <= 0) {
                    // if(random.nextInt(2) == 1) {
                    //     canli.Y += 1;
                    // }
                    canli.setYKoordinati(1);
                } else if(canli.getYKoordinati() >= 500) {
                    // if(random.nextInt(2) == -1) {
                    //     canli.Y -= 1;
                    // }
                    canli.setYKoordinati(-1);
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
                    if (erkek.getIsim().equals("Koyun") && erkek.getCinsiyet() == 'E' && disi.getIsim().equals("Koyun") && disi.getCinsiyet() == 'D') {
                        if (Math.sqrt(Math.pow(erkek.getXKoordinati() - disi.getXKoordinati(), 2) + Math.pow(erkek.getYKoordinati() - disi.getYKoordinati(), 2)) <= 3) {
                            System.out.println("Koyun doğdu");
                            if (random.nextInt(100) >= 50) {
                                iterator.add(new Av("Koyun", random.nextInt(maxSize), random.nextInt(maxSize), 'E', 2));
                            } else {
                                iterator.add(new Av("Koyun", random.nextInt(maxSize), random.nextInt(maxSize), 'D', 2));
                            }
                            break;
                        }
                    }
                    if (erkek.getIsim().equals("Kurt") && erkek.getCinsiyet() == 'E' && disi.getIsim().equals("Kurt") && disi.getCinsiyet() == 'D') {
                        if (Math.sqrt(Math.pow(erkek.getXKoordinati() - disi.getXKoordinati(), 2) + Math.pow(erkek.getYKoordinati() - disi.getYKoordinati(), 2)) <= 3) {
                            System.out.println("Kurt doğdu");
                            if (random.nextInt(100) >= 50) {
                                iterator.add(new Avci("Kurt", random.nextInt(maxSize), random.nextInt(maxSize), 'E', 3,4));
                            } else {
                                iterator.add(new Avci("Kurt", random.nextInt(maxSize), random.nextInt(maxSize), 'D', 3,4));
                            }
                            break;
                        }
                    }
                    if (erkek.getIsim().equals("Inek") && erkek.getCinsiyet() == 'E' && disi.getIsim().equals("Inek") && disi.getCinsiyet() == 'D') {
                        if (Math.sqrt(Math.pow(erkek.getXKoordinati() - disi.getXKoordinati(), 2) + Math.pow(erkek.getYKoordinati() - disi.getYKoordinati(), 2)) <= 3) {
                            System.out.println("Inek doğdu");
                            if (random.nextInt(100) >= 50) {
                                iterator.add(new Av("Inek", random.nextInt(maxSize), random.nextInt(maxSize), 'E', 2));
                            } else {
                                iterator.add(new Av("Inek", random.nextInt(maxSize), random.nextInt(maxSize), 'D', 2));
                            }
                            break;
                        }
                    }
                    if (erkek.getIsim().equals("Horoz") && erkek.getCinsiyet() == 'E' && disi.getIsim().equals("Tavuk") && disi.getCinsiyet() == 'D') {
                        if (Math.sqrt(Math.pow(erkek.getXKoordinati() - disi.getXKoordinati(), 2) + Math.pow(erkek.getYKoordinati() - disi.getYKoordinati(), 2)) <= 3) {
                            if (random.nextInt(100) >= 50) {
                                iterator.add(new Av("Horoz", random.nextInt(maxSize), random.nextInt(maxSize), 'E', 1));
                                System.out.println("Horoz doğdu");
                            } else {
                                iterator.add(new Av("Tavuk", random.nextInt(maxSize), random.nextInt(maxSize), 'D', 1));
                                System.out.println("Tavuk doğdu");
                            }
                            break;
                        }
                    }
                    if (erkek.getIsim().equals("Aslan") && erkek.getCinsiyet() == 'E' && disi.getIsim().equals("Aslan") && disi.getCinsiyet() == 'D') {
                        if (Math.sqrt(Math.pow(erkek.getXKoordinati() - disi.getXKoordinati(), 2) + Math.pow(erkek.getYKoordinati() - disi.getYKoordinati(), 2)) <= 3) {
                            System.out.println("Aslan doğdu");
                            if (random.nextInt(100) >= 50) {
                                iterator.add(new Avci("Aslan", random.nextInt(maxSize), random.nextInt(maxSize), 'E', 4,5));
                            } else {
                                iterator.add(new Avci("Aslan", random.nextInt(maxSize), random.nextInt(maxSize), 'D', 4,5));
                            }
                            break;
                        }
                    }
                }
            }
        }

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