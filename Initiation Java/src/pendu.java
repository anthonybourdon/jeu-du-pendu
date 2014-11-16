import java.util.*;
import java.lang.StringBuffer;

public class pendu {
	private String motATrouver;
	private StringBuffer motEnPartie;
	private int longueurMotATrouver;
	
	public pendu(String recherche)	//constructeur
	{
	this.motATrouver=recherche;	//mot cach�
	this.motEnPartie= new StringBuffer(motATrouver);	//instantition du mot en partie � l'aide du mot � trouver
	this.longueurMotATrouver=this.motATrouver.length();	//nombre de caract�res du mot � trouver

	for(int i=0; i<this.longueurMotATrouver; i++)	//mise en place des "_" pour le mot en partie
		motEnPartie.setCharAt(i, '_');
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	Scanner entree= new Scanner(System.in);	
	String saisie; //d�claration de la variable qui recevra l'entr�e au clavier
	
	System.out.println("A quoi voulez-vous jouer?");
	System.out.println("1 Motus     2 Pendu");
	int flag=entree.nextInt();
	entree.nextLine();
	
	System.out.println("Tapez votre mot : ");
	
	String[] tableMots= new String[5];
	
	for(int i=0; i<5; i++)
		{
		saisie=entree.nextLine();
		while(!(verifierMot(saisie)))
			{
			System.out.println("Tapez votre mot: ");
			saisie=entree.nextLine();
			}
		tableMots[i]=saisie;	
		}
	for(int i=0; i<5; i++)
		System.out.println(tableMots[i]);
	
	pendu mot= new pendu(tableMots[(int)(Math.random() * (5-0)) + 0]);
	if(flag==1)
		System.out.println("Tapez votre mot de " + mot.longueurMotATrouver + " caract�res: ");
	else
		System.out.println("Tapez une lettre pour trouver le mot de " + mot.longueurMotATrouver + " caract�res: ");
	System.out.println(mot.motEnPartie);
	
 	if(flag==1)
 		{
 		do
 			{	
 			saisie= entree.nextLine();
 			while(!(verifierMot(saisie))||!(mot.verifierLongueurMot(saisie)))
 				{
 				System.out.println("Erreur sur le mot entr�");
 				System.out.println("Caract�res non admis ou longueur du mot non correspondante");
 				System.out.println("Tapez votre mot de " + mot.longueurMotATrouver + " caract�res: ");
 				System.out.println(mot.motEnPartie);
 				saisie=entree.nextLine();
 				}
 			mot.comparerMot(saisie);
 			System.out.println(mot.motEnPartie);
 			}
 		while(!(mot.motATrouver.contentEquals(mot.motEnPartie)));
 		}
 	else
 		{
 		do
 			{	
 			saisie= entree.nextLine();
 			while(!(verifierMot(saisie)))
 				{
 				System.out.println("Erreur sur le caract�re entr�");		
 				System.out.println("Tapez une lettre pour trouver le mot de " + mot.longueurMotATrouver + " caract�res: ");
 				System.out.println(mot.motEnPartie);
 				saisie=entree.nextLine();
 				}
 			mot.comparerLettre(saisie);
 			System.out.println(mot.motEnPartie);
 			}
 		while(!(mot.motATrouver.contentEquals(mot.motEnPartie)));
 		}
 	
 	System.out.println("Bravo!");	 		
	entree.close();
	}
	
	
	public static boolean verifierMot(String motSaisi)
	{
		boolean ok= true;
		
		if(!(motSaisi.matches("[a-zA-Z�'������-]+")))
			ok=false;
		return(ok);
	}
	
	public boolean verifierLongueurMot(String motSaisi)
	{
	if(motSaisi.length() != this.longueurMotATrouver)
		return(false);
	else
		return(true);
		
	}
	
	public void comparerMot(String motSaisi)
	{	
	for(int i=0; i<this.longueurMotATrouver; i++)
		{	//V�rification de chaque carat�re du mot entr�
		if(this.motATrouver.charAt(i)==motSaisi.charAt(i))  //Si un caract�re se trouve on bon endroi
			this.motEnPartie.setCharAt(i, this.motATrouver.charAt(i));	//on le met dans motEnPartie
		}
	}
	
	public void comparerLettre(String lettre)
	{	
	for(int i=0; i<this.longueurMotATrouver; i++)
		{
		if(this.motATrouver.charAt(i)==lettre.charAt(0))  //Si un caract�re se trouve dans le mot � trouver
			this.motEnPartie.setCharAt(i, lettre.charAt(0));	//on le met � sa place dans motEnPartie
		}
	}
}

