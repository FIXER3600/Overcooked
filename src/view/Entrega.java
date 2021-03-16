package view;

import controller.Cozinha;
import model.Segundos;

public class Entrega {
    public static void main(String[] args) {
//        Cozinha c=new Cozinha(2);
//        c.start();
        long nano=System.nanoTime();
        Segundos s=new Segundos(nano);
        s.start();
    }
}
