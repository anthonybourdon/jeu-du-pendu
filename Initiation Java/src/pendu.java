import java.util.*;
import java.lang.StringBuffer;

public class pendu {
	private String motATrouver;
	private StringBuffer motEnPartie;
	private int longueurMotATrouver;
	
	public pendu(String recherche)	//constructeur
	{
	this.motATrouver=recherche;	//mot caché
	this.motEnPartie= new StringBuffer(motATrouver);	//instantition du mot en partie à l'aide du mot à trouver
	this.longueurMotATrouver=this.motATrouver.length();	//nombre de caractères du mot à trouver

	for(int i=0; i<this.longueurMotATrouver; i++)	//mise en place des "_" pour le mot en partie
		motEnPartie.setCharAt(i, '_');
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	Scanner entree= new Scanner(System.in);	
	String saisie; //déclaration de la variable qui recevra l'entrée au clavier
	
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
		System.out.println("Tapez votre mot de " + mot.longueurMotATrouver + " caractères: ");
	else
		System.out.println("Tapez une lettre pour trouver le mot de " + mot.longueurMotATrouver + " caractères: ");
	System.out.println(mot.motEnPartie);
	
 	if(flag==1)
 		{
 		do
 			{	
 			saisie= entree.nextLine();
 			while(!(verifierMot(saisie))||!(mot.verifierLongueurMot(saisie)))
 				{
 				System.out.println("Erreur sur le mot entré");
 				System.out.println("Caractères non admis ou longueur du mot non correspondante");
 				System.out.println("Tapez votre mot de " + mot.longueurMotATrouver + " caractères: ");
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
 				System.out.println("Erreur sur le caractère entré");		
 				System.out.println("Tapez une lettre pour trouver le mot de " + mot.longueurMotATrouver + " caractères: ");
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
		
		if(!(motSaisi.matches("[a-zA-Zé'èçàïêù-]+")))
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
		{	//Vérification de chaque caratère du mot entré
		if(this.motATrouver.charAt(i)==motSaisi.charAt(i))  //Si un caractère se trouve on bon endroi
			this.motEnPartie.setCharAt(i, this.motATrouver.charAt(i));	//on le met dans motEnPartie
		}
	}
	
	public void comparerLettre(String lettre)
	{	
	for(int i=0; i<this.longueurMotATrouver; i++)
		{
		if(this.motATrouver.charAt(i)==lettre.charAt(0))  //Si un caractère se trouve dans le mot à trouver
			this.motEnPartie.setCharAt(i, lettre.charAt(0));	//on le met à sa place dans motEnPartie
		}
	}
}

