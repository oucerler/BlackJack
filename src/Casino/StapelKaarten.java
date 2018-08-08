package Casino;
//ok laten we eerst classes maken voor de kaarten en de stapel kaarten
//we hebben voorheen hier al wat methoden in gezet, dus gaan we dit weer doen
//net als bij oorlogje geefKaart krijgKaart e.d.
import java.util.Random;//voor het schudden

public class StapelKaarten
{
	private Kaartje[] mijnKaartjes;
	private int numKaartjes;//hoeveel kaarten er in de stapel resteren
	//constructor maken!
	//hou het dicht bij real life, casinos hebben meerdere stapels, maar kun je hier dus op 1 zetten
	
	public StapelKaarten()
	{//hier dus de andere constructor callen, en omdat we maar 1 stapel gebruiken, dit is die overloading!
		this(1, false);
		//we hebben dus de method StapelKaarten beneden geoverload kijkend naar die parameters
	}
	
	public StapelKaarten(int aantalStapels, boolean schudden)
	{
		this.numKaartjes = aantalStapels * 52;
		//voor de volledige stapel
		this.mijnKaartjes = new Kaartje[this.numKaartjes];
		int k = 0;
		
		//nu de stapel maken, kan via loops, nested Udemy noobs tutorial
		//voor elke stapel, kunnen we de loop gebruiken die we vorige x hadden gebruikt
		for (int s = 0; s < aantalStapels; s++)
		{
			//voor elke KaartFamilie
			for (int f = 0; f < 4; f++)
			{
				//voor elk nummer
				for (int n = 1; n <= 13; n++)
				{
					//nieuwe kaart aan de stapel toevoegen, deze is wat lastiger, schrijf het uit
					this.mijnKaartjes[k] = new Kaartje(KaartFamilie.values()[f], n);
					//zie aantekeningen bij for loops Felix en Stef
					//sowieso kaartjes indexeren met k = 0 boven de for loop
					//met Kaartje moeten we dus KaartFamilie, boven bij de f for loop, en de waarde meegeven
					//en de values returnt waarde uit de array, en we geven het een nummer mee 'n'
					k++; //moeten natuurlijk ook de kaart index laten toenemen 
					//dus de volgende keer dat hij erlangs loopt is de waarde +1
				}
			}
		}
		//nu we de kaarten eindelijk hebben gecreëerd, moeten we gaan schudden indien nodig
		if (schudden)
		{
			this.schudden();//laten we boven een zogenaamd default behaviour maken, methodes
		}
	}
	
	public void schudden()
	{//we hebben bij oorlogje willekeurige kaarten met elkaar verwisseld. never change a winning team
		Random randomNumber = new Random();
		
		Kaartje temp;
		int tweede;
		for (int eerste = 0; eerste < this.numKaartjes; eerste++)
		{
			tweede = randomNumber.nextInt(this.numKaartjes);
			//die nextInt gaat waardes creeren tussen 0 en numKaartjes-1, dit is de range van de valid indexes
			//nu kaartjes met elkaar verwisselen
			temp = this.mijnKaartjes[eerste];//eerste waarde in temp onthouden
			this.mijnKaartjes[eerste] = this.mijnKaartjes[tweede];//tweede in eerste waarden onthouden
			this.mijnKaartjes[tweede] = temp;
		}		
	}
	
	public Kaartje deelVolgendKaartje()
	{
		//get the bovenste kaart op positie 0
		//deel de volgende kaart van de stapel
		Kaartje bovenste = this.mijnKaartjes[0];
		//kaart moet dan dus wel van de stapel worden verwijderd, zie notes van Stef bij oorlogje
		//dat betekent dat de positie van de resterende kaarten eentje op wordt geschoven
		//dit was bij een ArrayList dus eigenlijk authomatish ingecalculeerd
		//maar niet van koers wijzigen
		for (int k = 1; k < this.numKaartjes; k++)
		{
			this.mijnKaartjes[k-1] = this.mijnKaartjes[k];
		}
		//nu wel die laatste kaart van de stapel leeg maken, dat is dan null geworden
		this.mijnKaartjes[this.numKaartjes-1] = null;
		//en de nummer vd kaartjes minder maken
		this.numKaartjes--;
		
		return bovenste;
	}
	
	public void laatStapelZien(int numLaatZien)
	{
		for (int k = 0; k < numLaatZien; k++)
		{
			System.out.printf("% 3d/%d %s\n", k+1, this.numKaartjes, this.mijnKaartjes[k].toString());
			//eerlijk deze print methode kende ik niet maar heb ik online gezien
			//het zegt in de call 'ok print een integer bij d, wiens weidreikte is 3, en de rest wordt links toegevoegd met een spatie'
			//de tweede zegt print een integer
			//de derde zegt print een String
			//dus die voeg je na de komma toe
		}
		
		System.out.printf("\t\t[%d other]\n", this.numKaartjes-numLaatZien);
		//we hebben zoveel kaarten over in de stapel
	}
}
