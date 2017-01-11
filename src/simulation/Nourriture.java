package simulation;

import java.awt.geom.Point2D;

public class Nourriture{

//    TODO check Value or thouws Exepction

	// Attributs
	private float taille;
	private Point2D position;
	private float value = 100;
	private float tauxCroissance;
	
	// Constructeur

    public Nourriture(float p_taille, float p_positionX, float p_positionY, float p_tauxCroissance)
    {
        this.taille=p_taille;
        this.position= new Point2D.Float(p_positionX,p_positionY);
        this.tauxCroissance= p_tauxCroissance;
    }


	public void Croissance(){
	    value+=tauxCroissance;
	    if(value>1) value=1;
    }

    @Override
    public String toString() {
        return "Nourriture{" +
                "taille=" + taille +
                ", position=" + position +
                ", value=" + value +
                ", tauxCroissance=" + tauxCroissance +
                '}';
    }
}