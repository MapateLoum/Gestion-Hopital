import moncoin.*;
import java.sql.SQLException;
import java.util.Scanner;


public class App 
{
  public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("");
	

    System.out.println("                                +-----------+----------------------------+");
    System.out.println("                                |Options    |   RAYON                    |");
    System.out.println("                                +-----------+----------------------------+");
    System.out.println("                                |  1        |  Patient                   |");
    System.out.println("                                +-----------+----------------------------+");
    System.out.println("                                |  2        |  Médecin                   |");
    System.out.println("                                +-----------+----------------------------+");
    System.out.println("                                |  3        |  Service                   |");
    System.out.println("                                +-----------+----------------------------+");
    System.out.println("                                |  4        |  Facture                   |");
    System.out.println("                                +-----------+----------------------------+");
    System.out.println("                                |  5        |  Rendez-vous               |");
    System.out.println("                                +-----------+----------------------------+");

    System.out.println("");
    try 
		{
			System.out.println("Veuiller faire votre choix :");
			int choix = scanner.nextInt();
			System.out.println("");
      switch (choix) 
		 {
			  case 1:
				gestion.Patient();
				break;

        case 2:
				gestion.Medecin();
				break;

        case 3:
				gestion.Service();
				break;

        case 4:
				gestion.Facture();
				break;

        case 5:
				gestion.Rendez_vous();
				break;
			
        default:
        System.out.println("Veuiller faire un choix parmi ceux qui sont donnés.");
        break;
		  }

    } 
    catch (SQLException e) 
    {
      e.printStackTrace();
    }
		scanner.close();
	}
    
}
