package controller;

import java.util.concurrent.Semaphore;

public class Cozinha extends Thread{
    private int idprato;
    private String prato;
    long nano=System.nanoTime();
    private Semaphore semaforo;
    public Cozinha(int idprato, Semaphore semaforo) {
        this.idprato=idprato;
        this.semaforo=semaforo;
    }

    @Override
    public void run() {
        try {
            semaforo.acquire();
            pratoInicia();
            semaforo.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pratoPronto();
    }

    private void pratoInicia() throws InterruptedException {
        if(idprato%2==0){
            prato="Lasanha a Bolonhesa";
            System.out.println("Prato #"+this.idprato+" de "+this.prato+" iniciou");
            sleep(800);


            }
        else{
            prato="Sopa de Cebola";
            System.out.println("Prato #"+this.idprato+" de "+this.prato+" iniciou");
            sleep(1200);
    
        }
    }

    private void pratoPronto() {

        System.out.println("Prato #"+this.idprato+" de "+this.prato+" está pronto!");
    }


}
