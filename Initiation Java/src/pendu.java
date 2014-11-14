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
	System.out.println("Tapez votre mot de " + mot.longueurMotATrouver + " caract�res: ");
	Scanner entree= new Scanner(System.in);
	String saisie; //d�claration de la variable qui recevra l'entr�e au clavier
	
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
		//System.out.println("Tapez votre mot de " + mot.longueurMotATrouver + " caract�res: ");
		saisie= entree.nextLine();
		while(!(verifierMot(saisie)))
			{
			System.out.println("Tapez votre mot de " + mot.longueurMotATrouver + " caract�res: ");
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
		boolean ok= true;
		
		if(!(mot.matches("[a-zA-Z�'������-]+")))
			ok=false;
		return(ok);
	}
	
	
	public void comparerMot(String mot)
	{
	//int nbCaracteres=this.motATrouver.length(); 
	char[] temp= new char[this.longueurMotATrouver]; //tableau recevant les lettres bonnes au bon index
	
	if(mot.length()!=this.longueurMotATrouver) //v�rification que le mot entr� � le bon nombre de caract�res
		System.out.println("le nombre de lettres ne correspond pas");
	else
		{
		for(int i=0; i<this.longueurMotATrouver; i++)
			{	//V�rification de chaque carat�re du mot entr�
			if(this.motATrouver.charAt(i)==mot.charAt(i))  //Si un caract�re se trouve on bon endroi
				temp[i]=mot.charAt(i);	//on range ce caract�re dans un tableau au m�me index qu'il se trouve dans la chaine
			else	//sinon on range le caract�re '_' � cet index
				temp[i]='_';
			}
		for(int i=0; i<this.longueurMotATrouver; i++)
			{
			if(this.motEnPartie.charAt(i)!='_') //si des lettres ont �t� trouv�e au bon endroit sur des essais pr�c�dents
				temp[i]=this.motEnPartie.charAt(i); //on les remet � leur place dans le tableau.
			}
		this.motEnPartie=String.copyValueOf(temp);	//on copie le tableau de caract�res trouv�s dans l'attribut motEnPartie
		//System.out.println(this.motEnPartie);
		}
		//return(this.motEnPartie);		
	}
}
