import java.util.*;

public class pendu {
	private String motATrouver;
	private String motEnPartie;
	private int longueurMotATrouver;
	
	public pendu(String recherche)	//constructeur
	{
	//int longueurMotATrouver;
	this.motATrouver=recherche;
	this.longueurMotATrouver=this.motATrouver.length();
	char[] temp= new char[this.longueurMotATrouver];
	
	for(int i=0; i<this.longueurMotATrouver; i++)
		temp[i]='_';
	this.motEnPartie=String.copyValueOf(temp);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	pendu mot= new pendu("bonjour");
	System.out.println("Tapez votre mot de " + mot.longueurMotATrouver + " caractères: ");
	Scanner entree= new Scanner(System.in);
	String saisie; //déclaration de la variable qui recevra l'entrée au clavier
	
/*		
	if(verifierMot(saisie))
		System.out.println(saisie);
	else
		System.out.println("le mot n'est pas correct");
*/	
	
/*	
	while(!(verifierMot(saisie)))
		{
		System.out.println("Tapez votre mot: ");
		saisie=entree.next();
		}
	System.out.println(saisie);
*/	
	
/*	
	String[] tableMots= new String[5];
	for(int i=0; i<5; i++)
		{
		saisie=entree.nextLine();
		while(!(verifierMot(saisie)))
			{
			System.out.println("Tapez votre mot: ");
			saisie=entree.next();
			}
		tableMots[i]=saisie;	
		}
	for(int i=0; i<5; i++)
		System.out.println(tableMots[i]);	
*/	
	do
		{	
		//System.out.println("Tapez votre mot de " + mot.longueurMotATrouver + " caractères: ");
		saisie= entree.nextLine();
		while(!(verifierMot(saisie)))
			{
			System.out.println("Tapez votre mot de " + mot.longueurMotATrouver + " caractères: ");
			saisie=entree.nextLine();
			}
		mot.comparerMot(saisie);
		System.out.println(mot.motEnPartie);
		}
	while(!(mot.motEnPartie.contentEquals(mot.motATrouver)));
		
	System.out.println("Bravo!");
	entree.close();
	}
	
	public static boolean verifierMot(String mot)
	{
		//int longueurMot=mot.length();
		boolean ok= true;
		
		if(!(mot.matches("[a-zA-Zé'èçàïêù-]+")))
			ok=false;
/*		for(int i=0; i<longueurMot; i++)
		{
		if(((int)(mot.charAt(i))<65)||((((int)(mot.charAt(i))<=90))&&(((int)(mot.charAt(i))<97)))||((((int)(mot.charAt(i))>122))&&(((int)(mot.charAt(i))<128)))||((int)(mot.charAt(i))>154))
			ok=false;		
		}
*/		return(ok);
	}
	
	
	public void comparerMot(String mot)
	{
	//int nbCaracteres=this.motATrouver.length(); 
	char[] temp= new char[this.longueurMotATrouver]; //tableau recevant les lettres bonnes au bon index
	
	if(mot.length()!=this.longueurMotATrouver) //vérification que le mot entré à le bon nombre de caractères
		System.out.println("le nombre de lettres ne correspond pas");
	else
		{
		for(int i=0; i<this.longueurMotATrouver; i++)
			{	//Vérification de chaque caratère du mot entré
			if(this.motATrouver.charAt(i)==mot.charAt(i))  //Si un caractère se trouve on bon endroi
				temp[i]=mot.charAt(i);	//on range ce caractère dans un tableau au même index qu'il se trouve dans la chaine
			else	//sinon on range le caractère '_' à cet index
				temp[i]='_';
			}
		for(int i=0; i<this.longueurMotATrouver; i++)
			{
			if(this.motEnPartie.charAt(i)!='_') //si des lettres ont été trouvée au bon endroit sur des essais précédents
				temp[i]=this.motEnPartie.charAt(i); //on les remet à leur place dans le tableau.
			}
		this.motEnPartie=String.copyValueOf(temp);	//on copie le tableau de caractères trouvés dans l'attribut motEnPartie
		//System.out.println(this.motEnPartie);
		}
		//return(this.motEnPartie);		
	}
}
