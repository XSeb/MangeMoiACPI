package simulation.simulation;

import java.awt.geom.Point2D;
import java.util.Random;

public class Predateur implements I_Animal {
	
	// Attributs
    private float Energies = 100;
    private Point2D Position;
    private float TauxReproduction;
    private float TauxDeMort;
    private float ConsoEnergieMove;
    private float TauxTransfertManger;
    private float VitesseDeplacement;
	private float ZoneInfluence;

    public Predateur(Point2D position, float tauxReproduction, float tauxDeMort, float consoEnergieMove, float tauxTransfertManger, float vitesseDeplacement, float zoneInfluence) {
        this.Position = position;
        this.TauxReproduction = tauxReproduction;
        this.TauxDeMort = tauxDeMort;
        this.ConsoEnergieMove = consoEnergieMove;
        this.TauxTransfertManger = tauxTransfertManger;
        this.VitesseDeplacement = vitesseDeplacement;
        this.ZoneInfluence=zoneInfluence;
    }

    public Predateur(float positionX, float positionY, float tauxReproduction, float tauxDeMort, float consoEnergieMove, float tauxTransfertManger, float vitesseDeplacement, float zoneInfluence) {
        this.Position = new Point2D.Float(positionX,positionY);
		this.TauxReproduction = tauxReproduction;
		this.TauxDeMort = tauxDeMort;
		this.ConsoEnergieMove = consoEnergieMove;
		this.TauxTransfertManger = tauxTransfertManger;
		this.VitesseDeplacement = vitesseDeplacement;
        this.ZoneInfluence=zoneInfluence;
    }

    @Override
    public void SeReproduire() {
        Predateur loup = new Predateur(this.Position, this.TauxReproduction, this.TauxDeMort, this.ConsoEnergieMove, this.TauxTransfertManger, this.VitesseDeplacement, this.ZoneInfluence);
        Map.AddLoup(loup);
    }

    @Override
    public void MortNaturel() {
        Map.AddLoup(this);
    }

    @Override
    public void SeDeplacer() {
        Random rand = new Random();
        int randNumDirection = rand.nextInt(4) + 1;
        //Nombre dans le sens des aiguilles d'une montre
        switch (randNumDirection){
            case 1:
                this.Position.setLocation(this.Position.getX(),this.Position.getY()+VitesseDeplacement);
            case 2:
                this.Position.setLocation(this.Position.getX()+VitesseDeplacement,this.Position.getY());
            case 3:
                this.Position.setLocation(this.Position.getX(),this.Position.getY()-VitesseDeplacement);
            case 4:
                this.Position.setLocation(this.Position.getX()-VitesseDeplacement,this.Position.getY());
        }
    }

    void MangerProie(){


    }
}