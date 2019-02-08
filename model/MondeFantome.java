package model;

public class MondeFantome {
	int[][][] secteur = null;
	int width;
	int heigth;
	
	public MondeFantome(int a, int b)
	{
		width = a;
		heigth = b;
		secteur = new int[a][b][3];
		viderMondeFantome();
	}
	
	public void viderMondeFantome()
	{
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < heigth; j++) {
				secteur[i][j][0] = 0;
				secteur[i][j][1] = 0;
				secteur[i][j][2] = 0;
			}
		}
	}
}
