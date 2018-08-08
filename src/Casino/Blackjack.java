package Casino;

import java.util.Scanner;

public class Blackjack
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		//altijd blijven testen!
		StapelKaarten stapelKaarten = new StapelKaarten(1, true);//die parameters meegeven dus!
		//dus 1 is 1 stapel, true of false om te schudden
		Player speler1 = new Player("Speler 1"); //HIERDOOR IN OBJECT GEORIENTEERDE CONTEXT
		Player dealer = new Player("Dealer");
		//stapelKaarten.laatStapelZien(52);
		//nou viel aardig wat te fixen in mijn loops maar hij werkt, goed bezig
		speler1.voegtoeKaart(stapelKaarten.deelVolgendKaartje());//dus nu 2maal kaarten delen
		dealer.voegtoeKaart(stapelKaarten.deelVolgendKaartje());
		speler1.voegtoeKaart(stapelKaarten.deelVolgendKaartje());
		dealer.voegtoeKaart(stapelKaarten.deelVolgendKaartje());
		//nu dan eerste kaarten printen
		System.out.println("Kaarten zijn gedeeld");
		speler1.laatHandZien(true);
		dealer.laatHandZien(false);//dealer mogen we nog niet zien!
		System.out.println("\n");
		
		//variabelen maken om einde van spelen te laten zien kan weer met boolean
		boolean speler1Klaar = false;
		boolean dealerKlaar = false;
		String antwoord;
		
		//nu de hoofdloop van het spel, OF || we nog een kaart willen ja of nee
		while (!speler1Klaar || !dealerKlaar)
			//dus als beide bovenstaand true zijn dan wordt het false en dan wordt alles false en gaat ie uit de loop volgens mij
		{
			//doorgaan met loop
			if (!speler1Klaar)
			{
				System.out.println("Wilt u nog een kaart of passen? (type k of p)");
				antwoord = scanner.next();
				System.out.println();
				//als de speler nog een kaart wil
				if (antwoord.compareToIgnoreCase("k") == 0)
				{
					//nieuwe kaart in de stapel toevoegen
					//en natuurlijk checken of de speler door MAG gaan
					speler1Klaar = !speler1.voegtoeKaart(stapelKaarten.deelVolgendKaartje());
					speler1.laatHandZien(true);
				}
				else//dan zijn we ook klaar volgens mij...?
				{
					speler1Klaar = true;
				}
			}
			//PUNTEN dealer zijn beurt voor de regels van blackjack moet de dealer minder dan 17 zijn om te hitten
			if (!dealerKlaar)
			{
				if (dealer.getHandSom() < 17)
				{
					System.out.println("Dealer hit");
					dealerKlaar = !dealer.voegtoeKaart(stapelKaarten.deelVolgendKaartje());
					//dit is eigenlijk hetzelfde als bij de speler
					dealer.laatHandZien(false);
				}
				else
				{
					System.out.println("Dealer blijft");
					dealerKlaar = true;
				}
			}
			System.out.println();
		}
		speler1.laatHandZien(true);
		dealer.laatHandZien(true);
		
		int speler1Som = speler1.getHandSom();
		int dealerSom = dealer.getHandSom();
		
		//wie wint er nou? Natuurlijk wie meer heeft EN&& het dichtst of gelijk bij 21 zit of als de dealer bust gaat
		if (speler1Som > dealerSom && speler1Som <= 21 || dealerSom > 21)
		{
			System.out.println("Speler 1 heeft gewonnen!");	
		}
		else
			{
				System.out.println("Dealer wint");
			}
	}
}
