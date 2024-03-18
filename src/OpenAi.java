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

class Koyun extends Canli {
    public Koyun(String Ad, int X, int Y, char cinsiyet, int YurumeMesafesi) {
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

class Kurt extends Avci {
    public Kurt(String Ad, int X, int Y, char cinsiyet, int YurumeMesafesi, int AvMesafesi) {
        super(Ad, X, Y, cinsiyet, YurumeMesafesi, AvMesafesi);
    }
}

class Inek extends Canli {
    public Inek(String Ad, int X, int Y, char cinsiyet, int YurumeMesafesi) {
        super(Ad, X, Y, cinsiyet, YurumeMesafesi);
    }
}

class Tavuk extends Canli {
    public Tavuk(String Ad, int X, int Y, char cinsiyet, int YurumeMesafesi) {
        super(Ad, X, Y, cinsiyet, YurumeMesafesi);
    }
}

class Horoz extends Canli {
    public Horoz(String Ad, int X, int Y, char cinsiyet, int YurumeMesafesi) {
        super(Ad, X, Y, cinsiyet, YurumeMesafesi);
    }
}

class Aslan extends Avci {
    public Aslan(String Ad, int X, int Y, char cinsiyet, int YurumeMesafesi, int AvMesafesi) {
        super(Ad, X, Y, cinsiyet, YurumeMesafesi, AvMesafesi);
    }
}

class OpenAi {
    public static void main(String[] args) {
        int maxSize = 500;
        ArrayList<Canli> canlilar = new ArrayList<Canli>();
        Random random = new Random();
        for (int i = 0; i < 15; i++) {
            canlilar.add(new Koyun("Koyun",(int)random.nextInt(maxSize), (int)random.nextInt(maxSize), 'E', 2));
            canlilar.add(new Koyun("Koyun",(int)random.nextInt(maxSize), (int)random.nextInt(maxSize), 'D', 2));
        }

        for (int i = 0; i < 5; i++) {
            canlilar.add(new Kurt("Kurt",(int)random.nextInt(maxSize), (int)random.nextInt(maxSize), 'E', 3,4));
            canlilar.add(new Kurt("Kurt",(int)random.nextInt(maxSize), (int)random.nextInt(maxSize), 'D', 3,4));
        }

        for (int i = 0; i < 5; i++) {
            canlilar.add(new Inek("Inek",(int)random.nextInt(maxSize), (int)random.nextInt(maxSize), 'E', 2));
            canlilar.add(new Inek("Inek",(int)random.nextInt(maxSize), (int)random.nextInt(maxSize), 'D', 2));
        }

        for (int i = 0; i < 10; i++) {
            canlilar.add(new Tavuk("Tavuk",(int)random.nextInt(maxSize), (int)random.nextInt(maxSize), 'D', 1));
        }

        for (int i = 0; i < 10; i++) {
            canlilar.add(new Horoz("Horoz",(int)random.nextInt(maxSize), (int)random.nextInt(maxSize), 'E', 1));
        }
        
        for (int i = 0; i < 4; i++) {
            canlilar.add(new Aslan("Aslan",(int)random.nextInt(maxSize), (int)random.nextInt(maxSize), 'E', 4, 5));
            canlilar.add(new Aslan("Aslan",(int)random.nextInt(maxSize), (int)random.nextInt(maxSize), 'D', 4, 5));
        }
        canlilar.add(new Avci("Avci",(int)random.nextInt(maxSize), (int)random.nextInt(maxSize), 'E', 3, 8));

        System.out.println(canlilar.size());
        System.out.println("*****************************************************");
        for (int i = 0; i < 1000; i++) {
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
                if(av instanceof Koyun || av instanceof Tavuk || av instanceof Horoz) {
                    for (Canli avci : canlilar) {
                        if(avci.Ad.equals("Kurt")) {
                            if(Math.sqrt(Math.pow(avci.X - av.X, 2) + Math.pow(avci.Y - av.Y, 2)) <= 4) {
                                System.out.println(avci.Ad + " " + av.Ad + " avladı");
                                iterator.remove();//problem burası
                                break;
                            }
                        }
                    }
                    
                } else if(av instanceof Koyun || av instanceof Inek) {
                    for (Canli avci : canlilar) {
                        if(avci.Ad.equals("Aslan")) {
                            if(Math.sqrt(Math.pow(avci.X - av.X, 2) + Math.pow(avci.Y - av.Y, 2)) <= 5) {
                                System.out.println(avci.Ad + " " + av.Ad + " avladı");
                                iterator.remove();
                                break;
                            }
                        }
                    }
                    
                } else if(av instanceof Koyun || av instanceof Inek || av instanceof Tavuk || av instanceof Horoz || av instanceof Kurt || av instanceof Aslan) {
                    for (Canli avci : canlilar) {
                        if(avci.Ad.equals("Avci")) {
                            if(Math.sqrt(Math.pow(avci.X - av.X, 2) + Math.pow(avci.Y - av.Y, 2)) <= 5) {
                                System.out.println(avci.Ad + " " + av.Ad + " avladı");
                                iterator.remove();
                                break;
                            }
                        }
                    }
                }
            }   
        }
        // Rapor
        System.out.println("Hayvanlarin son durumu:");
        int koyunSayisi = 0, inekSayisi = 0, tavukSayisi = 0, horozSayisi = 0, kurtSayisi = 0, aslanSayisi = 0, avciSayisi = 0;
        for (Canli canli : canlilar) {
            if (canli instanceof Koyun) koyunSayisi++;
            else if (canli instanceof Inek) inekSayisi++;
            else if (canli instanceof Tavuk) tavukSayisi++;
            else if (canli instanceof Horoz) horozSayisi++;
            else if (canli instanceof Kurt) kurtSayisi++;
            else if (canli instanceof Aslan) aslanSayisi++;
            else if (canli instanceof Avci) avciSayisi++;
        }
        System.out.println("Koyun sayısı: " + koyunSayisi);
        System.out.println("Inek sayısı: " + inekSayisi);
        System.out.println("Tavuk sayısı: " + tavukSayisi);
        System.out.println("Horoz sayısı: " + horozSayisi);
        System.out.println("Kurt sayısı: " + kurtSayisi);
        System.out.println("Aslan sayısı: " + aslanSayisi);
        System.out.println("Avci sayısı: " + avciSayisi);
        System.out.println(canlilar.size());
    }
}
