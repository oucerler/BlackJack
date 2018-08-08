package Casino;

public class Player
{
//spelers hebben verschillende elementen, een naam, een hand kaarten, en aantal kaarten
	private String naam;
	private Kaartje[] hand = new Kaartje[10];
	private Kaartje[] kaartje = new Kaartje[5];//OBJECT GEORIENTEERDE CONTEXT
	//eigenlijk weten we niet hoeveel kaarten een speler in zijn hand krijgt
	//casino regels zeggen dat je bij 5 kaarten wint, maar laten we hem op maximaal 10 zetten dat is real world
	private int numKaarten;
	//weer constructor!
	public Player (String eenNaam)
	{
		this.naam = eenNaam;
		
		//en natuurlijk begint de speler met een lege hand(DOELSTELLING 2), zie lijn 7 dan is ie authomatisch leeg
		//values op lijn 7 zijn dus initieel NULL! begrijp dit!
		this.legeHand();
		//dus een methode legeHand aanmaken
	}
	public void legeHand()
	{
		for (int k = 0; k < 10; k++)
		{
			this.hand[k] = null;
		}
		this.numKaarten = 0;
	}
	//nu een methode om een kaart te geven, vorige opdracht kon met boolean
	//boolean laat zien of de som van je hand <=21 m.a.w. of je nog in the game bent
	//als ie false is heb je dan authomatisch verloren
	public boolean voegtoeKaart(Kaartje eenKaartje)//eenKaartje is dus de kaart die wordt toegevoegd
	{
		//voor de zekerheid die maximaal 10 kaarten implementeren
		if (this.numKaarten == 10)//kan ook met een variabele ofzo maargoed
		{
			System.err.printf("%s zijn hand bevat al 10 kaarten!", this.naam);
			System.exit(1);
		}
		//hier voegen we de werkelijke kaart toe en incrementen we de kaarten stapel
		this.hand[this.numKaarten] = eenKaartje;
		this.numKaarten++;
		
		return (this.getHandSom() <= 21);
	}
	
	//ok nu getHandSom maken
	public int getHandSom()
	{
		//dus waardes toevoegen, en hierin zijn boer vrouw koning 10 en aas 1 of 11
		//variabelen maken
		int handSom = 0;
		int kaartNum;
		int numAas = 0;
		
		//bereken elke kaart zijn toevoeging bij de handSom
		for (int k = 0; k < this.numKaarten; k++)
		{
			//krijg de waarde van de huidigekaart
			kaartNum = this.hand[k].getNummer();//dus die getNummer methode
			if (kaartNum == 1)//als ik een Aas heb voor DOELSTELLING 3
			{
				numAas++;
				handSom +=11;//eigenlijk hetzelfde als in de broodjeszaak
				//maar die 11 moet dus een 1 kunnen worden indien nodig hoe ga ik dat doen? iets met loop of while
			}
			else if (kaartNum > 10)//hoger dan 10 zoals bij de switch gemaakt dus boer vrouw koning
			{
				handSom += 10;
			}
			else
			{
				handSom += kaartNum;
			}
		}
		//dus 11 moet 1 worden indien nodig, zolang (while) we Aas hebben en de som >21 wordt, gaan we de Aas aanpassen!
		while (handSom > 21 && numAas > 0)
		{
			handSom -=10; //dus weer toevoegen net als Kassa Broodjeszaak
			numAas--;
		}
		
		return handSom;
	}
	//methode hand van speler laten zien
	public void laatHandZien(boolean laatEersteKaartZien)//Udemy cursus for if loops
	{
		System.out.printf("%s zijn kaarten:\n", this.naam);
		for (int k = 0; k < this.numKaarten; k++)
		{
			if (k == 0 && !laatEersteKaartZien)
			{
				System.out.println(" [verborgen]");
			}
			else
			{
				System.out.printf(" %s\n", this.hand[k].toString());
			}
		}
	}
}
