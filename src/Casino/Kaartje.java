package Casino;
//hier gaan we de kaart maken, ik gebruik iets andere namen omdat het runnen misschien fout loopt doordat ik Kaart, Stok, e.d. al als namen heb gebruikt bij eerdere projectjes
//wat is een kaart? 2 soorten data zijn belangrijk
public class Kaartje
{
	
	private KaartFamilie deKaartFamilie;//private omdat deze enkel beschikbaar is in de methods van Kaartje
	private int hetNummer;//de waarde van de kaart
	//nu een constructor maken
	
	public Kaartje(KaartFamilie eenKaartFamilie, int eenNummer) //tussen haakjes zijn de parameters
	{
		this.deKaartFamilie = eenKaartFamilie;
		//side note van een tutorial: je wilt geen niet-realistische waardes zoals negtieven meegeven
		//dus blijf checken! ook de parameters
		if (eenNummer >= 1 && eenNummer <= 13)
		{
		this.hetNummer = eenNummer;
		//this om natuurlijk toegang te krijgen tot de private data boven
		}
		else
		{
			System.err.println(eenNummer + "is een ongeldig kaartnummer.");
			System.exit(1);//hiermee ga je uit het programma
		}
	}
	
	public int getNummer()
	{
		return hetNummer;
	}
	
	public String toString()//vaak gebruikt, dit is die overloading
	{
		String numStr = "Error";
		switch(this.hetNummer)//gaan het nu iets anders doen omdat we bij Oorlogje lang bezig waren met de array, dus FOK die array, nu op n andere manier indexeren
		{
		case 2:
			numStr = "2";
			break;
		case 3:
			numStr = "3";
			break;
		case 4:
			numStr = "4";
			break;
		case 5:
			numStr = "5";
			break;
		case 6:
			numStr = "6";
			break;
		case 7:
			numStr = "7";
			break;
		case 8:
			numStr = "8";
			break;
		case 9:
			numStr = "9";
			break;
		case 10:
			numStr = "10";
			break;
		case 11:
			numStr = "Boer";
			break;
		case 12:
			numStr = "Vrouw";
			break;
		case 13:
			numStr = "Koning";
			break;
		case 1:
			numStr = "Aas";
			break;
		}
		return deKaartFamilie.toString() + " " + numStr;
	}
}
