package moncoin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class rendez_vous 
{
    public static void nouveauRV()
    
	throws SQLException 
	{
        Scanner scanner = new Scanner(System.in);
		
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_hopital?useUnicode=true&characterEncoding=utf8", "root", "Papaloum1613")) 
        {
          

                            Statement stmt = con.createStatement();
                    String liste = "select id_patient,prenom,nom,telephone,email,adresse,date_naissance from patients ORDER BY nom,prenom;";

                    ResultSet rs = stmt.executeQuery(liste);

                    System.out.println("+------------+----------------+------------+---------------+-------------------------------+---------------+---------------+");
                    System.out.println("| Patient ID | Prénom         | Nom        | Téléphone     | Email                         | Adresse       | Date Naissance|");
                    System.out.println("+------------+----------------+------------+---------------+-------------------------------+---------------+---------------+");
                
                    while (rs.next()) 
                    {
                    String id_patient = rs.getString("id_patient");
                    String prenom = rs.getString("prenom");
                    String nom = rs.getString("nom");
                    int telephone = rs.getInt("telephone");
                    String email = rs.getString("email");
                    String adresse = rs.getString("adresse");
                    String date_naissance = rs.getString("date_naissance");
                    
                    
                    String ligne = String.format("| %-10s |%-15s | %-10s |%-15s|%-30s |%-15s|%-15s|",id_patient, prenom, nom, telephone, email,adresse,date_naissance);
                    System.out.println(ligne);
                    
                    }
                    System.out.println("+------------+----------------+------------+---------------+-------------------------------+---------------+---------------+");
                    

            System.out.println("Veuillez donner le numéro ID du patient : ");
            String id_patient = scanner.nextLine();

                    Statement stmt1 = con.createStatement();
                    String listes = "select id_medecin,prenom,nom,telephone,email,id_service,specialite from medecins ORDER BY nom,prenom;";
                
                    ResultSet rs1 = stmt1.executeQuery(listes);
                
                    System.out.println("+------------+---------------------+------------+---------------+-------------------------------+---------------+---------------+");
                    System.out.println("| Médecin ID | Prénom              | Nom        | Téléphone     | Email                         | Service_ID    | Spécialité    |");
                    System.out.println("+------------+---------------------+------------+---------------+-------------------------------+---------------+---------------+");
                
                    while (rs1.next()) 
                    {
                    String id_medecin = rs1.getString("id_medecin");
                    String prenom = rs1.getString("prenom");
                    String nom = rs1.getString("nom");
                    int telephone = rs1.getInt("telephone");
                    String email = rs1.getString("email");
                    String adresse = rs1.getString("id_service");
                    String specialite = rs1.getString("specialite");
                    
                    
                    String ligne = String.format("| %-10s |%-15s    | %-10s |%-15s|%-30s |%-15s|%-15s|",id_medecin, prenom, nom, telephone, email,adresse,specialite);
                    System.out.println(ligne);
                    
                    }
                    System.out.println("+------------+---------------------+------------+---------------+-------------------------------+---------------+---------------+");
                    
                    System.out.println("Veuillez donner le numéro ID du médecin : ");
                    String id_medecin = scanner.nextLine(); 
                    
                    System.out.println("Veuillez donner la date du rendez-vous (format AAAA-MM-JJ) : ");
                    String date_rv = scanner.nextLine();

                    System.out.println("Veuillez donner l'heure du rendez-vous (format HH:MM): ");
                    String heure_rv = scanner.nextLine();

                    System.out.println("Veuillez donner le motif du rendez-vous : ");
                    String motif = scanner.nextLine();

            String sql = "INSERT INTO rendez_vous(id_medecin,id_patient,heure_rendez_vous,date_rendez_vous,motif_rendez_vous) VALUES(?,?,?,?,?)";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) 
            {
                
                pstmt.setString(1,id_medecin);
                pstmt.setString(2,id_patient);
                pstmt.setString(3,heure_rv);
                pstmt.setString(4,date_rv);
                pstmt.setString(5,motif);
                
                pstmt.executeUpdate();

                System.err.println("Rendez-vous créé avec succés.");
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            scanner.close();
        }
    }   


    public static void modifierRV()
    
	throws SQLException 
	{
        Scanner scanner = new Scanner(System.in);
		
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_hopital?useUnicode=true&characterEncoding=utf8", "root", "Papaloum1613")) 
        {


            Statement stmt = con.createStatement();
            String liste = "select id_rendez_vous,id_patient,id_medecin,heure_rendez_vous,date_rendez_vous,motif_rendez_vous from rendez_vous ORDER BY id_rendez_vous;";
        
            ResultSet rs = stmt.executeQuery(liste);
        
                        System.out.println("+------+---------------+------------+------------+-------------+-------------------------------+");
                        System.out.println("|ID RV | ID Patient    | ID Médecin | Date RV    | Heure RV    |Motif RV                       |");
                        System.out.println("+------+---------------+------------+------------+-------------+-------------------------------+");
                    
                        while (rs.next()) 
                        {
                        String id_rendez_vous = rs.getString("id_rendez_vous");
                        String id_patient = rs.getString("id_patient");
                        String id_medecin = rs.getString("id_medecin");
                        String date_rendez_vous = rs.getString("date_rendez_vous");
                        String heure_rendez_vous = rs.getString("heure_rendez_vous");
                        String motif_rendez_vous = rs.getString("motif_rendez_vous");
                        
                        
                        String ligne = String.format("| %-5s|    %-10s |      %-5s |%-10s  |%-10s   | %-25s     |",id_rendez_vous,id_patient, id_medecin, date_rendez_vous,heure_rendez_vous,motif_rendez_vous);
                        System.out.println(ligne);
                        
                        }
                        System.out.println("+------+---------------+------------+------------+-------------+-------------------------------+");
            System.out.println("Veuiller donner le numéro ID du Rendez vous à modifier : ");
            int numID = scanner.nextInt();
          

                    Statement stmt2 = con.createStatement();
                    String lister = "select id_patient,prenom,nom,telephone,email,adresse,date_naissance from patients ORDER BY nom,prenom;";

                    ResultSet rs2 = stmt2.executeQuery(lister);

                    System.out.println("+------------+----------------+------------+---------------+-------------------------------+---------------+---------------+");
                    System.out.println("| Patient ID | Prénom         | Nom        | Téléphone     | Email                         | Adresse       | Date Naissance|");
                    System.out.println("+------------+----------------+------------+---------------+-------------------------------+---------------+---------------+");
                
                    while (rs2.next()) 
                    {
                    String id_patient = rs2.getString("id_patient");
                    String prenom = rs2.getString("prenom");
                    String nom = rs2.getString("nom");
                    int telephone = rs2.getInt("telephone");
                    String email = rs2.getString("email");
                    String adresse = rs2.getString("adresse");
                    String date_naissance = rs2.getString("date_naissance");
                    
                    
                    String ligne = String.format("| %-10s |%-15s | %-10s |%-15s|%-30s |%-15s|%-15s|",id_patient, prenom, nom, telephone, email,adresse,date_naissance);
                    System.out.println(ligne);
                    
                    }
                    System.out.println("+------------+----------------+------------+---------------+-------------------------------+---------------+---------------+");
                    

            System.out.println("Veuillez donner le numéro ID du patient : ");
            int id_patient = scanner.nextInt();

                    Statement stmt1 = con.createStatement();
                    String listes = "select id_medecin,prenom,nom,telephone,email,id_service,specialite from medecins ORDER BY nom,prenom;";
                
                    ResultSet rs1 = stmt1.executeQuery(listes);
                
                    System.out.println("+------------+---------------------+------------+---------------+-------------------------------+---------------+---------------+");
                    System.out.println("| Médecin ID | Prénom              | Nom        | Téléphone     | Email                         | Service_ID    | Spécialité    |");
                    System.out.println("+------------+---------------------+------------+---------------+-------------------------------+---------------+---------------+");
                
                    while (rs1.next()) 
                    {
                    String id_medecin = rs1.getString("id_medecin");
                    String prenom = rs1.getString("prenom");
                    String nom = rs1.getString("nom");
                    int telephone = rs1.getInt("telephone");
                    String email = rs1.getString("email");
                    String adresse = rs1.getString("id_service");
                    String specialite = rs1.getString("specialite");
                    
                    
                    String ligne = String.format("| %-10s |%-15s    | %-10s |%-15s|%-30s |%-15s|%-15s|",id_medecin, prenom, nom, telephone, email,adresse,specialite);
                    System.out.println(ligne);
                    
                    }
                    System.out.println("+------------+---------------------+------------+---------------+-------------------------------+---------------+---------------+");
                    
                    System.out.println("Veuillez donner le numéro ID du médecin : ");
                    int id_medecin = scanner.nextInt(); 
                    scanner.nextLine();
                    
                    System.out.println("Veuillez donner la nouvelle date du rendez-vous (format AAAA-MM-JJ) : ");
                    String date_rv = scanner.nextLine();

                    System.out.println("Veuillez donner l'heure du rendez-vous (format HH:MM): ");
                    String heure_rv = scanner.nextLine();

                    System.out.println("Veuillez donner le nouveau motif du rendez-vous : ");
                    String motif = scanner.nextLine();

            String sql = "update rendez_vous set id_medecin=?,id_patient=?,heure_rendez_vous=?,date_rendez_vous=?,motif_rendez_vous=? where id_rendez_vous=?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) 
            {
                
                pstmt.setInt(1,id_medecin);
                pstmt.setInt(2,id_patient);
                pstmt.setString(3,heure_rv);
                pstmt.setString(4,date_rv);
                pstmt.setString(5,motif);
                pstmt.setInt(6,numID);

                
                pstmt.executeUpdate();

                System.err.println("Rendez-vous créé avec succés.");
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            scanner.close();
        }
    }   


    public static void AfficherRV()
    throws SQLException 
    {
        
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_hopital", "root", "Papaloum1613")) 
        {
        Statement stmt = con.createStatement();
        String liste = "select id_rendez_vous,id_patient,id_medecin,heure_rendez_vous,date_rendez_vous,motif_rendez_vous from rendez_vous ORDER BY id_rendez_vous;";
    
        ResultSet rs = stmt.executeQuery(liste);
    
        System.out.println("+------+---------------+------------+------------+-------------+-------------------------------+");
        System.out.println("|ID RV | ID Patient    | ID Médecin | Date RV    | Heure RV    |Motif RV                       |");
        System.out.println("+------+---------------+------------+------------+-------------+-------------------------------+");
      
        while (rs.next()) 
        {
         String id_rendez_vous = rs.getString("id_rendez_vous");
         String id_patient = rs.getString("id_patient");
         String id_medecin = rs.getString("id_medecin");
         String date_rendez_vous = rs.getString("date_rendez_vous");
         String heure_rendez_vous = rs.getString("heure_rendez_vous");
         String motif_rendez_vous = rs.getString("motif_rendez_vous");
         
        
          String ligne = String.format("| %-5s|    %-10s |      %-5s |%-10s  |%-10s   | %-25s     |",id_rendez_vous,id_patient, id_medecin, date_rendez_vous,heure_rendez_vous,motif_rendez_vous);
         System.out.println(ligne);
        
        }
        System.out.println("+------+---------------+------------+------------+-------------+-------------------------------+");
          
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        }
        
    } 


    public static void supprimerRV()
    
    throws SQLException 
    {
       Scanner scanner = new Scanner(System.in);
        
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_hopital?useUnicode=true&characterEncoding=utf8", "root", "Papaloum1613")) 
        {
    
            Statement stmt = con.createStatement();
            String liste = "select id_rendez_vous,id_patient,id_medecin,heure_rendez_vous,date_rendez_vous,motif_rendez_vous from rendez_vous ORDER BY id_rendez_vous;";
        
            ResultSet rs = stmt.executeQuery(liste);
        
            System.out.println("+------+---------------+------------+------------+-------------+-------------------------------+");
            System.out.println("|ID RV | ID Patient    | ID Médecin | Date RV    | Heure RV    |Motif RV                       |");
            System.out.println("+------+---------------+------------+------------+-------------+-------------------------------+");
          
            while (rs.next()) 
            {
             String id_rendez_vous = rs.getString("id_rendez_vous");
             String id_patient = rs.getString("id_patient");
             String id_medecin = rs.getString("id_medecin");
             String date_rendez_vous = rs.getString("date_rendez_vous");
             String heure_rendez_vous = rs.getString("heure_rendez_vous");
             String motif_rendez_vous = rs.getString("motif_rendez_vous");
             
            
              String ligne = String.format("| %-5s|    %-10s |      %-5s |%-10s  |%-10s   | %-25s     |",id_rendez_vous,id_patient, id_medecin, date_rendez_vous,heure_rendez_vous,motif_rendez_vous);
             System.out.println(ligne);
            
            }
            System.out.println("+------+---------------+------------+------------+-------------+-------------------------------+");
             
           
    
    
            System.out.print("Veuiller donner le numéro ID du rendez-vous à supprimer : ");
            int numID = scanner.nextInt();
            scanner.nextLine();
    
    
           String sql = "DELETE FROM rendez_vous where id_rendez_vous=? ;";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) 
            {
                
                pstmt.setInt(1,numID);
                
                pstmt.executeUpdate();
    
            }   System.err.print("Rendez-vous supprimé avec succés.");
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
    
        } 
        scanner.close();
    }
}
