package model;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Secteur {
	public int[] vie = new int[3];
	public int x;
	public int y;
	public int[][] direction = new int[3][4];
	public Monde world;
	public Monde ghost_world;

	public Secteur(int p, int a, int r) {
		vie[0] = a;
		vie[1] = p;
		vie[2] = r;
	}

	public Secteur(int x, int y, Monde m) {
		Random r = new Random();
		int nb_max = 5;
		vie[0] = r.nextInt(nb_max);
		vie[1] = r.nextInt(nb_max);
		vie[2] = r.nextInt(nb_max);
		this.x = x;
		this.y = y;
		this.world = m;
	}

	public void next() {

	}
	

	@Override
	public String toString() {
		return "[" + vie[0] + "," + vie[1]  + "," + vie[2] + "]";
	}
	
	public void predation_reproduction() 
	{
		if(this.vie[1]==0) //Aucune vie[1]
		{
			this.vie[0]=vie[2];
			this.vie[2]=0;
		}
		else { 
			int pModif =0;
			int aModif =0;
			int rModif =0;
			if(this.vie[2]!=4&&this.vie[1]>1) //Affamé(s) mange(nt)
			{
				int nb_changement = Math.min(4-this.vie[2], this.vie[0]);
				rModif+=nb_changement;
				pModif-=nb_changement;
				aModif-=nb_changement;
			}
			
			if(this.vie[0]+aModif<3&&this.vie[1]+pModif>1)//Reproduction des prédateurs
			{
				int nb_changement = Math.min(2-((this.vie[0]+1+aModif)/2), this.vie[2]+rModif);
				aModif+=nb_changement*2;
				rModif-=nb_changement;
				pModif-=nb_changement;
			}
			
			if(this.vie[1]>=2&&this.vie[1]<4)pModif++; //Reproduction des vie[1]s
			
			this.vie[1]+=pModif;
			this.vie[0]+=aModif;
			this.vie[2]+=rModif;
		}
		
	}
	
	public void deplacementsSecteur()
	{
		for(int i=0;i<3;i++)
		{
			this.vie[i]-=deplacementsEspece(direction[i],i);
		}
	}
	
	public int deplacementsEspece(int[] tab, int n) 
	{
		int res = 0;
		for(int i=0;i<4;i++)
		{
			if(tab[i]!=0)
			{
				switch(tab[i]) {
					case 1:
						//this.world.getSecteur()[x][(y-1+this.world.getHeigth())%this.world.getHeigth()].vie[n] = this.world.getSecteur()[x][(y-1+this.world.getHeigth())%this.world.getHeigth()].vie[n]+1;
						world.mf.secteur[x][(y-1+this.world.getHeigth())%this.world.getHeigth()][n]++;
						break;//Nord
					case 2:
						//this.world.getSecteur()[(x)%this.world.getWidth()][y].vie[n]++;
						//System.out.println(n + " => " + (x));
						world.mf.secteur[(x)%this.world.getWidth()][y][n]++;
						break;//Est
					case 3:
						//this.world.getSecteur()[x][(y+1)%this.world.getHeigth()].vie[n]++;
						world.mf.secteur[x][(y+1)%this.world.getHeigth()][n]++;
						break;//Sud
					case 4:
						//this.world.getSecteur()[(x-1+this.world.getWidth())%this.world.getWidth()][y].vie[n]++;
						world.mf.secteur[(x-1+this.world.getWidth())%this.world.getWidth()][y][n]++;
						break;//Ouest
				}
				res++;
			}
		}
		return res;
	}
	
	public void choisirDirectionsSecteur()
	{
		direction[1] = choisirDirectionsEspece(this.vie[1]);
		direction[0] = choisirDirectionsEspece(this.vie[0]);
		direction[2] = choisirDirectionsEspece(this.vie[2]);
	}
	
	public int[] choisirDirectionsEspece(int n)
	{
		int[] dir=new int[4];
		int compteur = 0;
		while(compteur<n)
		{
			Random r = new Random();
			int nb_max = 4;
			final int temp = r.nextInt(nb_max)+1;
			if(!(IntStream.of(dir).anyMatch(x -> x==temp)))
			{
				dir[compteur]=temp;
				compteur++;
			}
		}
		return dir;
	}

}
