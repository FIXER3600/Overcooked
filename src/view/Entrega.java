package view;

import controller.Cozinha;

import java.util.concurrent.Semaphore;


public class Entrega {
    public static void main(String[] args) {
        Semaphore semaforo = new Semaphore(1);
        for (int i = 0; i < 5; i++) {
            Cozinha prato = new Cozinha(i, semaforo);
            prato.start();
        }
    }
}
