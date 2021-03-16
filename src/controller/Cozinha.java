package controller;

import java.util.concurrent.Semaphore;

public class Cozinha extends Thread{
    private int idPrato;
    private Semaphore semaforo;
    private int tempoPreparo;

    public Cozinha(int idPrato, Semaphore semaforo) {
        this.idPrato = idPrato;
        this.semaforo = semaforo;
    }

    @Override
    public void run() {
        cozinhar();
        try {
            semaforo.acquire();
            entregar();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaforo.release();
        }
    }

    private void cozinhar() {
        if(idPrato%2==0) {
            tempoPreparo = (int) ((Math.random() * 601) + 600);
            int porcentual = tempoPreparo / 100;
            int total=0;
            System.out.println("Lasanha a Bolonhesa #"+idPrato+" iniciou preparo!");
            do {
                try {
                    sleep(100);
                    if(total+porcentual>=100) {
                        total = 100;
                    }else {
                        total+=porcentual;
                    }
                    System.out.println("Lasanha a Bolonhesa #"+idPrato+" em "+total+"% concluida");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }while(total <100);
        }else {
            tempoPreparo = (int) ((Math.random() * 301) + 500);
            int porcentual = tempoPreparo / 100;
            int total=0;
            System.out.println("Sopa de Cebola #"+idPrato+" iniciou preparo!");
            do {
                try {
                    sleep(100);
                    if(total+porcentual>100) {
                        total = 100;
                    }else {
                        total+=porcentual;
                    }
                    System.out.println("Sopa de Cebola #"+idPrato+" em "+total+"% concluida");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }while(total <100);
        }
    }

    private void entregar() {
        if(idPrato%2==0) {
            System.out.println("Entregando a Lasanha a Bolonhesa #"+idPrato+"...");
        }else {
            System.out.println("Entregando a Sopa de Cebola #"+idPrato+"...");
        }
        try {
            sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}