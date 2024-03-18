import java.util.ArrayList;
import java.util.Random;
import java.util.Iterator;

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

class Av extends Canli{
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

class NewSimulation {
    public static void main(String[] args) {
        ArrayList<Canli> canlilar = new ArrayList<Canli>();
        Random random = new Random();
        for (int i = 0; i < 15; i++) {
            canlilar.add(new Av("Koyun",(int)random.nextInt(500), (int)random.nextInt(500), 'E', 2));
            canlilar.add(new Av("Koyun",(int)random.nextInt(500), (int)random.nextInt(500), 'D', 2));
        }

        for (int i = 0; i < 5; i++) {
            canlilar.add(new Avci("Kurt",(int)random.nextInt(500), (int)random.nextInt(500), 'E', 3,4));
            canlilar.add(new Avci("Kurt",(int)random.nextInt(500), (int)random.nextInt(500), 'D', 3,4));
        }

        for (int i = 0; i < 5; i++) {
            canlilar.add(new Av("Inek",(int)random.nextInt(500), (int)random.nextInt(500), 'E', 2));
            canlilar.add(new Av("Inek",(int)random.nextInt(500), (int)random.nextInt(500), 'D', 2));
        }

        for (int i = 0; i < 10; i++) {
            canlilar.add(new Av("Tavuk",(int)random.nextInt(500), (int)random.nextInt(500), 'D', 1));
        }

        for (int i = 0; i < 10; i++) {
            canlilar.add(new Av("Horoz",(int)random.nextInt(500), (int)random.nextInt(500), 'E', 1));
        }
        
        for (int i = 0; i < 4; i++) {
            canlilar.add(new Avci("Aslan",(int)random.nextInt(500), (int)random.nextInt(500), 'E', 4, 5));
            canlilar.add(new Avci("Aslan",(int)random.nextInt(500), (int)random.nextInt(500), 'D', 4, 5));
        }

        canlilar.add(new Avci("Avci",(int)random.nextInt(500), (int)random.nextInt(500), 'E', 3, 8));

        for (int i = 0; i < 1; i++) {
            for (Canli canli : canlilar) {
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
        }
        System.out.println("*****************************************************");
        for (Canli canli : canlilar) {
            System.out.println("Ad: " + canli.Ad + " X: " + canli.X + " Y: " + canli.Y + " Cinsiyet: " + canli.cinsiyet + " Mesafe: " + canli.YurumeMesafesi + " Av Mesafesi: " + ((canli instanceof Avci) ? ((Avci) canli).AvMesafesi : "Yok"));
        }
    }
}