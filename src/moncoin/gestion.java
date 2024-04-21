package moncoin;


import java.sql.SQLException;
import java.util.Scanner;

public class gestion 
{
    public static void Patient()
    throws SQLException 
    {

            Scanner scanner = new Scanner(System.in);
        System.out.println("");
        System.out.println("                                +-----------+---------------------------------+");
        System.out.println("                                |Options    |  Fonctionnalités pour Patient   |");
        System.out.println("                                +-----------+---------------------------------+");
        System.out.println("                                |  1        |  Afficher tous les patients     |");
        System.out.println("                                +-----------+---------------------------------+");
        System.out.println("                                |  2        |  Modifier un patient            |");
        System.out.println("                                +-----------+---------------------------------+");
        System.out.println("                                |  3        |  Créer un nouveau patient       |");
        System.out.println("                                +-----------+---------------------------------+");
        System.out.println("                                |  4        |  Supprimer un patient           |");
        System.out.println("                                +-----------+---------------------------------+");
        System.out.println("");
            
        try 
        {
            System.out.println("Veuiller faire votre choix :");
            int choix = scanner.nextInt();
            System.out.println("");
            switch (choix) 
            {
                case 1:
                    patient.affichagerpatients();
                    break;
                case 2: 
                    patient.modifierpatient();
                    break;
                case 3: 
                    patient.CreerPatient();
                    break;
                case 4: 
                    patient.supprimerpatient();
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

    public static void Medecin()
    throws SQLException 
    {

            Scanner scanner = new Scanner(System.in);
        System.out.println("");
        System.out.println("                                +-----------+---------------------------------+");
        System.out.println("                                |Options    |  Fonctionnalités pour Médecin   |");
        System.out.println("                                +-----------+---------------------------------+");
        System.out.println("                                |  1        |  Afficher tous les médecins     |");
        System.out.println("                                +-----------+---------------------------------+");
        System.out.println("                                |  2        |  Modifier un médecin            |");
        System.out.println("                                +-----------+---------------------------------+");
        System.out.println("                                |  3        |  Créer un nouveau médecin       |");
        System.out.println("                                +-----------+---------------------------------+");
        System.out.println("                                |  4        |  Supprimer un médecin           |");
        System.out.println("                                +-----------+---------------------------------+");
        System.out.println("");
            
        try 
        {
            System.out.println("Veuiller faire votre choix :");
            int choix = scanner.nextInt();
            System.out.println("");
            switch (choix) 
            {
                case 1:
                    medecin.affichagerMedecins();
                    break;
                case 2: 
                    medecin.modifierModifier();
                    break;
                case 3: 
                    medecin.Creermedecin();
                    break;
                case 4: 
                    medecin.Creermedecin();
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

    public static void Service()
    throws SQLException 
    {

            Scanner scanner = new Scanner(System.in);
        System.out.println("");
        System.out.println("                                +-----------+---------------------------------+");
        System.out.println("                                |Options    |  Fonctionnalités pour Service   |");
        System.out.println("                                +-----------+---------------------------------+");
        System.out.println("                                |  1        |  Afficher tous les services     |");
        System.out.println("                                +-----------+---------------------------------+");
        System.out.println("                                |  2        |  Modifier un service            |");
        System.out.println("                                +-----------+---------------------------------+");
        System.out.println("                                |  3        |  Créer un nouveau service       |");
        System.out.println("                                +-----------+---------------------------------+");
        System.out.println("                                |  4        |  Supprimer un service           |");
        System.out.println("                                +-----------+---------------------------------+");
        System.out.println("");
            
        try 
        {
            System.out.println("Veuiller faire votre choix :");
            int choix = scanner.nextInt();
            System.out.println("");
            switch (choix) 
            {
                case 1:
                    service.affichagerServices();
                    break;
                case 2: 
                    service.modifierservice();
                    break;
                case 3: 
                    service.Creerservice();
                    break;
                case 4: 
                    service.supprimerservice();
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

    public static void Rendez_vous()
    throws SQLException 
    {

            Scanner scanner = new Scanner(System.in);
        System.out.println("");
        System.out.println("                                +-----------+---------------------------------+");
        System.out.println("                                |Options    | Fonctionnalités pour Rendez-vous|");
        System.out.println("                                +-----------+---------------------------------+");
        System.out.println("                                |  1        |  Afficher tous les rendez-vous  |");
        System.out.println("                                +-----------+---------------------------------+");
        System.out.println("                                |  2        |  Modifier un rendez-vous        |");
        System.out.println("                                +-----------+---------------------------------+");
        System.out.println("                                |  3        |  Créer un nouveau rendez-vous   |");
        System.out.println("                                +-----------+---------------------------------+");
        System.out.println("                                |  4        |  Supprimer un rendez-vous       |");
        System.out.println("                                +-----------+---------------------------------+");
        System.out.println();
            
        try 
        {
            System.out.println("Veuiller faire votre choix :");
            int choix = scanner.nextInt();
            System.out.println("");
            switch (choix) 
            {
                case 1:
                    rendez_vous.AfficherRV();
                    break;
                case 2: 
                    rendez_vous.modifierRV();
                    break;
                case 3: 
                    rendez_vous.nouveauRV();
                    break;
                case 4: 
                    rendez_vous.supprimerRV();
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

    public static void Facture()
    throws SQLException 
    {

            Scanner scanner = new Scanner(System.in);
        System.out.println("");
        System.out.println("                                +-----------+---------------------------------+");
        System.out.println("                                |Options    |  Fonctionnalités pour Facture   |");
        System.out.println("                                +-----------+---------------------------------+");
        System.out.println("                                |  1        |  Afficher toutes les factures   |");
        System.out.println("                                +-----------+---------------------------------+");
        System.out.println("                                |  2        |  Modifier une facture           |");
        System.out.println("                                +-----------+---------------------------------+");
        System.out.println("                                |  3        |  Créer une nouveau facture      |");
        System.out.println("                                +-----------+---------------------------------+");
        System.out.println("                                |  4        |  Supprimer une facture          |");
        System.out.println("                                +-----------+---------------------------------+");
        System.out.println("");
            
        try 
        {
            System.out.println("Veuiller faire votre choix :");
            int choix = scanner.nextInt();
            System.out.println("");
            switch (choix) 
            {
                case 1:
                    facture.AfficherFactures();
                    break;
                case 2: 
                    facture.ModifierFactures();
                    break;
                case 3: 
                    facture.CreerFacture();
                    break;
                case 4: 
                    facture.supprimerFacture();
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
