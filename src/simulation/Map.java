package simulation;

import java.util.*;

public class Map{

    private static List<Predateur> ListLoup = new ArrayList<Predateur>();
    private static List<Proies> ListChevre = new ArrayList<Proies>();
    private static Nourriture [][] NouritureTab;
    private boolean EnCourDeSimulation = false;
    private int DureeSimulation;
    private int PasTempsSimulation;

    private float TempsActuel=0;

    public Map(List<Predateur> loup, List<Proies> chevre, Nourriture[][] nouritureTab)
    {
        ListLoup = loup;
        ListChevre = chevre;
        NouritureTab = nouritureTab;
    }

    public Map (int nombrePatch, int nombreProie, int nombrePredateur,
                           int dureeSimulation, int pasTempsSimulation,
                           float tauxReproducitonLoup, float tauxdemortLoup, float consoEnergieMoveLoup, float zoneInfluenceLoup, float vitesseDeplacementLoup,
                           float tauxReproducitonChevre, float tauxdemortChevre, float consoEnergiMoveChevre, float tauxTransfertMangerChevre, float vitesseDeplacementChevre,
                           float tauxCroissance) {

        //Generer Map

        this.DureeSimulation=dureeSimulation;
        this.PasTempsSimulation=pasTempsSimulation;

        NouritureTab= GenererPatch(nombrePatch, tauxCroissance);

    }

    protected static Nourriture[][] GenererPatch(int nombrePatch, float tauxCroissance){


            Nourriture[][] nourritureTab = new Nourriture[nombrePatch][nombrePatch];


            for(int line=0; line<nombrePatch; line++){
                for(int colone=0; colone<nombrePatch; colone++){
                    Nourriture nourriture = new Nourriture(nombrePatch, nombrePatch*line, nombrePatch*colone, tauxCroissance);
                    nourritureTab[line][colone]=nourriture;
                }
            }
            return nourritureTab;

    }



    public void Simuler(){
        EnCourDeSimulation = true;

        ///Generate timer for update display
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                //Todo Simulation()
                TempsActuel+=PasTempsSimulation;
                if(TempsActuel>=DureeSimulation){
                    cancel();
                    EnCourDeSimulation=false;
                }
            }
        },PasTempsSimulation , PasTempsSimulation);
    }

    public boolean isEnCourDeSimulation() {
        return EnCourDeSimulation;
    }

    public static boolean AddLoup(Predateur loup){
        return ListLoup.add(loup);
    }

    public static boolean AddChevre(Proies chevre){
        return ListChevre.add(chevre);
    }

    public static boolean DeleteLoup(Predateur loup){
        return ListLoup.remove(loup);
    }

    public static boolean DeleteChevre(Proies chevre){
        return ListChevre.remove(chevre);
    }

    void DeplacerSystem(){
        //TODO DeplacerSystem()
    }

    void TirerEvenementSuivant(){
        //TODO TirerEvenementSuivant()
    }

    void JoueEvenementSuivant(){
        //TODO joueEvenmentSuivant()
    }

    @Override
    public String toString() {
        return "Etat de la map a "+ TempsActuel + "ms : " + "\nNb de proie: " + ListChevre.size() + "\nNombre de predateur: " + ListLoup.size() + "\n";
    }
}