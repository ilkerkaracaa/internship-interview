import java.util.ArrayList;
import java.util.Random;

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

class Koyun extends Canli{
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

class Simulation {
    public static void main(String[] args) {
        ArrayList<Canli> canlilar = new ArrayList<Canli>();
        Random random = new Random();
        for (int i = 0; i < 15; i++) {
            canlilar.add(new Koyun("Koyun",(int)random.nextInt(500), (int)random.nextInt(500), 'E', 2));
            canlilar.add(new Koyun("Koyun",(int)random.nextInt(500), (int)random.nextInt(500), 'D', 2));
        }

        for (int i = 0; i < 5; i++) {
            canlilar.add(new Kurt("Kurt",(int)random.nextInt(500), (int)random.nextInt(500), 'E', 3,4));
            canlilar.add(new Kurt("Kurt",(int)random.nextInt(500), (int)random.nextInt(500), 'D', 3,4));
        }

        for (int i = 0; i < 5; i++) {
            canlilar.add(new Inek("Inek",(int)random.nextInt(500), (int)random.nextInt(500), 'E', 2));
            canlilar.add(new Inek("Inek",(int)random.nextInt(500), (int)random.nextInt(500), 'D', 2));
        }

        for (int i = 0; i < 10; i++) {
            canlilar.add(new Tavuk("Tavuk",(int)random.nextInt(500), (int)random.nextInt(500), 'D', 1));
        }

        for (int i = 0; i < 10; i++) {
            canlilar.add(new Tavuk("Horoz",(int)random.nextInt(500), (int)random.nextInt(500), 'E', 1));
        }
        
        for (int i = 0; i < 4; i++) {
            canlilar.add(new Aslan("Aslan",(int)random.nextInt(500), (int)random.nextInt(500), 'E', 4, 5));
            canlilar.add(new Aslan("Aslan",(int)random.nextInt(500), (int)random.nextInt(500), 'D', 4, 5));
        }

        canlilar.add(new Avci("Avci",(int)random.nextInt(500), (int)random.nextInt(500), 'E', 3, 8));

        for (Canli canli : canlilar) {
            System.out.println("Ad: " + canli.Ad + " X: " + canli.X + " Y: " + canli.Y + " Cinsiyet: " + canli.cinsiyet + " Mesafe: " + canli.YurumeMesafesi + " Av Mesafesi: " + ((canli instanceof Avci) ? ((Avci) canli).AvMesafesi : "Yok"));
        }

        System.out.println("*****************************************************");

        for (int i = 0; i < 1000; i++) {
            for (Canli canli : canlilar) {
                for (int j = 0 ; j < canli.YurumeMesafesi; j++) {
                    if(random.nextInt(2) == 0) {
                        if(canli.X <= 0) {
                            if(random.nextInt(2) == 1) {
                                canli.X += 1;
                            }
                        } else if(canli.X >= 500) {
                            if(random.nextInt(2) == -1) {
                                canli.X -= 1;
                            }
                        } else {
                            canli.X += random.nextInt(2) == 0 ? -1 : 1;
                        }
                    } else {
                        if(canli.Y <= 0) {
                            if(random.nextInt(2) == 1) {
                                canli.Y += 1;
                            }
                        } else if(canli.Y >= 500) {
                            if(random.nextInt(2) == -1) {
                                canli.Y -= 1;
                            }
                        } else {
                            canli.Y += random.nextInt(2) == 0 ? -1 : 1;
                        }
                    }
                }
            }

            for (Canli canli : canlilar) {
                if(canli instanceof Avci) {
                    for (Canli av : canlilar) {
                        if(av instanceof Koyun || av instanceof Tavuk || av instanceof Horoz) {
                            if(Math.abs(canli.X - av.X) <= ((Avci) canli).AvMesafesi && Math.abs(canli.Y - av.Y) <= ((Avci) canli).AvMesafesi) {
                                System.out.println(canli.Ad + " " + av.Ad + " avladı");
                                canlilar.remove(av);
                                break;
                            }
                        }
                    }
                }
            }




        }

        for (Canli canli : canlilar) {
            System.out.println("Ad: " + canli.Ad + " X: " + canli.X + " Y: " + canli.Y + " Cinsiyet: " + canli.cinsiyet + " Mesafe: " + canli.YurumeMesafesi + " Av Mesafesi: " + ((canli instanceof Avci) ? ((Avci) canli).AvMesafesi : "Yok"));
        }
    }
}