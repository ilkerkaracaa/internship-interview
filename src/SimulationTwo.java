import java.util.ArrayList;
import java.util.Random;
import java.util.ListIterator;

abstract class Canli {
    String Ad;
    int X;
    int Y;
    char cinsiyet;
    int YurumeMesafesi;

    public Canli(String Ad, int X, int Y, char cinsiyet, int YurumeMesafesi) {
        this.Ad = Ad;   
        this.X = X;
        this.Y = Y;
        this.cinsiyet = cinsiyet;
        this.YurumeMesafesi = YurumeMesafesi;
    }
}

class Av extends Canli {
    public Av(String Ad, int X, int Y, char cinsiyet, int YurumeMesafesi) {
        super(Ad, X, Y, cinsiyet, YurumeMesafesi);
    }

}

class Avci extends Canli {
    int AvMesafesi;
    public Avci(String Ad, int X, int Y, char cinsiyet, int YurumeMesafesi, int AvMesafesi) {
        super(Ad, X, Y, cinsiyet, YurumeMesafesi);
        this.AvMesafesi = AvMesafesi;
    }
}

class SimulationTwo {
    public static void main(String[] args) {
        int maxSize = 100;
        ArrayList<Canli> canlilar = new ArrayList<Canli>();
        Random random = new Random();
        for (int i = 0; i < 15; i++) {
            canlilar.add(new Av("Koyun",(int)random.nextInt(maxSize), (int)random.nextInt(maxSize), 'E', 2));
            canlilar.add(new Av("Koyun",(int)random.nextInt(maxSize), (int)random.nextInt(maxSize), 'D', 2));
        }

        for (int i = 0; i < 5; i++) {
            canlilar.add(new Avci("Kurt",(int)random.nextInt(maxSize), (int)random.nextInt(maxSize), 'E', 3,4));
            canlilar.add(new Avci("Kurt",(int)random.nextInt(maxSize), (int)random.nextInt(maxSize), 'D', 3,4));
        }

        for (int i = 0; i < 5; i++) {
            canlilar.add(new Av("Inek",(int)random.nextInt(maxSize), (int)random.nextInt(maxSize), 'E', 2));
            canlilar.add(new Av("Inek",(int)random.nextInt(maxSize), (int)random.nextInt(maxSize), 'D', 2));
        }

        for (int i = 0; i < 10; i++) {
            canlilar.add(new Av("Tavuk",(int)random.nextInt(maxSize), (int)random.nextInt(maxSize), 'D', 1));
        }

        for (int i = 0; i < 10; i++) {
            canlilar.add(new Av("Horoz",(int)random.nextInt(maxSize), (int)random.nextInt(maxSize), 'E', 1));
        }
        
        for (int i = 0; i < 4; i++) {
            canlilar.add(new Avci("Aslan",(int)random.nextInt(maxSize), (int)random.nextInt(maxSize), 'E', 4, 5));
            canlilar.add(new Avci("Aslan",(int)random.nextInt(maxSize), (int)random.nextInt(maxSize), 'D', 4, 5));
        }
        canlilar.add(new Avci("Avci",(int)random.nextInt(maxSize), (int)random.nextInt(maxSize), 'E', 3, 8));
        System.out.println("*****************************************************");
        System.out.println("Toplam Canli Sayisi: " + canlilar.size());
        for (int i = 0; i < 1; i++) {
            ListIterator<Canli> iterator = canlilar.listIterator();
            while (iterator.hasNext()) {
                Canli canli = iterator.next();
                for (int j = 0 ; j < canli.YurumeMesafesi; j++) {
                    if(random.nextInt(2) == 0) {
                        if(canli.X <= 0) {
                            // if(random.nextInt(2) == 1) {
                            //     canli.X += 1;
                            // }
                            canli.X += 1;
                        } else if(canli.X >= 500) {
                            // if(random.nextInt(2) == 0) {
                            //     canli.X -= 1;
                            // }
                            canli.X -= 1;
                        } else {
                            if(random.nextInt(2) == 0){
                                canli.X -= 1;
                            } else {
                                canli.X += 1;
                            }
                        }
                    } else {
                        if(canli.Y <= 0) {
                            // if(random.nextInt(2) == 1) {
                            //     canli.Y += 1;
                            // }
                            canli.Y += 1;
                        } else if(canli.Y >= 500) {
                            // if(random.nextInt(2) == -1) {
                            //     canli.Y -= 1;
                            // }
                            canli.Y -= 1;
                        } else {
                            if(random.nextInt(2) == 0){
                                canli.Y -= 1;
                            } else {
                                canli.Y += 1;
                            }
                        }
                    }
                }
            }
            
            iterator = canlilar.listIterator();
            while (iterator.hasNext()) {
                Canli av = iterator.next();
                if(av.Ad.equals("Koyun") || av.Ad.equals("Tavuk") || av.Ad.equals("Horoz")) {
                    for (Canli avci : canlilar) {
                        if(avci.Ad.equals("Kurt")) {
                            if(Math.sqrt(Math.pow(avci.X - av.X, 2) + Math.pow(avci.Y - av.Y, 2)) <= 4) {
                                iterator.remove();
                                break;
                            }
                        }
                    }
                } else if(av.Ad.equals("Koyun") || av.Ad.equals("Inek")) {
                    for (Canli avci : canlilar) {
                        if(avci.Ad.equals("Aslan")) {
                            if(Math.sqrt(Math.pow(avci.X - av.X, 2) + Math.pow(avci.Y - av.Y, 2)) <= 5) {
                                iterator.remove();
                                break;
                            }
                        }
                    }
                } else if(!av.Ad.equals("Avci")){
                    for (Canli avci : canlilar) {
                        if(avci.Ad.equals("Avci")) {
                            if(Math.sqrt(Math.pow(avci.X - av.X, 2) + Math.pow(avci.Y - av.Y, 2)) <= 8) {
                                iterator.remove();
                                break;
                            }
                        }
                    }
                }
            }

            ListIterator<Canli> iteratorTwo = canlilar.listIterator();
            while (iteratorTwo.hasNext()) {
                Canli erkek = iteratorTwo.next();
                if (erkek.Ad.equals("Koyun") && erkek.cinsiyet == 'E') {
                   ListIterator<Canli> innerIterator = canlilar.listIterator();
                    while (innerIterator.hasNext()) {
                        Canli disi = innerIterator.next();
                        if (disi.Ad.equals("Koyun") && disi.cinsiyet == 'D') {
                            double distance = Math.sqrt(Math.pow(erkek.X - disi.X, 2) + Math.pow(erkek.Y - disi.Y, 2));
                            if (distance <= 3) {
                                System.out.println("Koyunlarin ciftlesmesi");
                                if (random.nextInt(2) == 0) {
                                    iteratorTwo.add(new Av("Koyun", random.nextInt(maxSize), random.nextInt(maxSize), 'E', 2));
                                } else {
                                    iteratorTwo.add(new Av("Koyun", random.nextInt(maxSize), random.nextInt(maxSize), 'D', 2));
                                }
                                break;
                            }
                        }
                    }
                }else if (erkek.Ad.equals("Kurt") && erkek.cinsiyet == 'E') {
                    ListIterator<Canli> innerIterator = canlilar.listIterator();
                    while (innerIterator.hasNext()) {
                        Canli disi = innerIterator.next();
                        if (disi.Ad.equals("Kurt") && disi.cinsiyet == 'D') {
                            double distance = Math.sqrt(Math.pow(erkek.X - disi.X, 2) + Math.pow(erkek.Y - disi.Y, 2));
                            if (distance <= 3) {
                                System.out.println("Kurtlarin ciftlesmesi");
                                if (random.nextInt(2) == 0) {
                                    iteratorTwo.add(new Avci("Kurt", random.nextInt(maxSize), random.nextInt(maxSize), 'E', 3,4));
                                } else {
                                    iteratorTwo.add(new Avci("Kurt", random.nextInt(maxSize), random.nextInt(maxSize), 'D', 3,4));
                                }
                                break;
                            }
                        }
                    }
                } else if (erkek.Ad.equals("Inek") && erkek.cinsiyet == 'E') {
                    ListIterator<Canli> innerIterator = canlilar.listIterator();
                    while (innerIterator.hasNext()) {
                        Canli disi = innerIterator.next();
                        if (disi.Ad.equals("Inek") && disi.cinsiyet == 'D') {
                            double distance = Math.sqrt(Math.pow(erkek.X - disi.X, 2) + Math.pow(erkek.Y - disi.Y, 2));
                            if (distance <= 3) {
                                System.out.println("Ineklerin ciftlesmesi");
                                if (random.nextInt(2) == 0) {
                                    iteratorTwo.add(new Av("Inek", random.nextInt(maxSize), random.nextInt(maxSize), 'E', 2));
                                } else {
                                    iteratorTwo.add(new Av("Inek", random.nextInt(maxSize), random.nextInt(maxSize), 'D', 2));
                                }
                                break;
                            }
                        }
                    }
                } else if (erkek.Ad.equals("Horoz") && erkek.cinsiyet == 'E') {
                    ListIterator<Canli> innerIterator = canlilar.listIterator();
                    while (innerIterator.hasNext()) {
                        Canli disi = innerIterator.next();
                        if (disi.Ad.equals("Tavuk") && disi.cinsiyet == 'D') {
                            double distance = Math.sqrt(Math.pow(erkek.X - disi.X, 2) + Math.pow(erkek.Y - disi.Y, 2));
                            if (distance <= 3) {
                                System.out.println("Tavuklarin ciftlesmesi");
                                if (random.nextInt(2) == 0) {
                                    iteratorTwo.add(new Av("Tavuk", random.nextInt(maxSize), random.nextInt(maxSize), 'D', 1));
                                } else {
                                    iteratorTwo.add(new Av("Horoz", random.nextInt(maxSize), random.nextInt(maxSize), 'E', 1));
                                }
                                break;
                            }
                        }
                    }
                } else if (erkek.Ad.equals("Aslan") && erkek.cinsiyet == 'E') {
                    ListIterator<Canli> innerIterator = canlilar.listIterator();
                    while (innerIterator.hasNext()) {
                        Canli disi = innerIterator.next();
                        if (disi.Ad.equals("Aslan") && disi.cinsiyet == 'D') {
                            double distance = Math.sqrt(Math.pow(erkek.X - disi.X, 2) + Math.pow(erkek.Y - disi.Y, 2));
                            if (distance <= 3) {
                                System.out.println("Aslanlarin ciftlesmesi");
                                if (random.nextInt(2) == 0) {
                                    iteratorTwo.add(new Avci("Aslan", random.nextInt(maxSize), random.nextInt(maxSize), 'E', 4, 5));
                                } else {
                                    iteratorTwo.add(new Avci("Aslan", random.nextInt(maxSize), random.nextInt(maxSize), 'D', 4, 5));
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }
        // Rapor
        System.out.println("Kalan Canli Sayisi: " + canlilar.size());
        System.out.println("*****************************************************");
        System.out.println("Hayvanlarin son durumu:");
        int koyunSayisi = 0, inekSayisi = 0, tavukSayisi = 0, horozSayisi = 0, kurtSayisi = 0, aslanSayisi = 0, avciSayisi = 0;
        for (Canli canli : canlilar) {
            if (canli.Ad.equals("Koyun")) koyunSayisi++;
            else if (canli.Ad.equals("Inek")) inekSayisi++;
            else if (canli.Ad.equals("Tavuk")) tavukSayisi++;
            else if (canli.Ad.equals("Horoz")) horozSayisi++;
            else if (canli.Ad.equals("Kurt")) kurtSayisi++;
            else if (canli.Ad.equals("Aslan")) aslanSayisi++;
            else if (canli.Ad.equals("Avci")) avciSayisi++;
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