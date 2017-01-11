package InterfaceGraphique;

import java.util.Timer;
import java.util.TimerTask;

import simulation.Map;



public class Main {

    //Variable Initialisation
    //Map
    private static int NombrePatch = 100; //10*10
    private static int NombreProie = 10;
    private static int NombrePredateur = 10;
    //temps
    private static int DureeSimulation = 20*1000;
    private static int PasTempsSimulation = 500;
    private static int IntervalleUpdateResultats = 1000;
    //Loup
    private static float TauxReproducitonLoup = 100;
    private static float TauxdemortLoup = 100 ;
    private static float ConsoEnergieMoveLoup = 100;
    private static float ZoneInfluenceLoup = 100;
    private static float VitesseDeplacementLoup = 100;
    //chevre
    private static float TauxReproducitonChevre = 100;
    private static float TauxdemortChevre = 100;
    private static float ConsoEnergiMoveChevre = 100;
    private static float TauxTransfertMangerChevre = 100 ;
    private static float VitesseDeplacementChevre = 100;
    //Nourriture
    private static float TauxCroissance = 100;

    public static void main (String[] args){

        Map map = new Map(NombrePatch, NombreProie, NombrePredateur, DureeSimulation, PasTempsSimulation,
        TauxReproducitonLoup, TauxdemortLoup, ConsoEnergieMoveLoup, ZoneInfluenceLoup, VitesseDeplacementLoup,
        TauxReproducitonChevre, TauxdemortChevre, ConsoEnergiMoveChevre, TauxTransfertMangerChevre, VitesseDeplacementChevre,
        TauxCroissance);

        map.Simuler();
        ///Generate timer for update display
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(map.isEnCourDeSimulation()){
                    System.out.println(map.toString());
                }
                else{
                    cancel();
                    System.out.print("Fin De la simulation");
                }

            }
        },IntervalleUpdateResultats , IntervalleUpdateResultats);
    }

}
