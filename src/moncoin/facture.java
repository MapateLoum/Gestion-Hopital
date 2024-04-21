package moncoin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class facture 
{
    public static void AfficherFactures()
    throws SQLException 
    {
        
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_hopital", "root", "Papaloum1613")) 
        {
        Statement stmt = con.createStatement();
        String liste = "select id_facture,id_patient,date_facture,montant_facture from factures ORDER BY id_facture;";
    
        ResultSet rs = stmt.executeQuery(liste);
    
        System.out.println("+-----------+---------------+--------------+------------------+");
        System.out.println("|ID Facture | ID Patient    | Date Facture | Montant          |");
        System.out.println("+-----------+---------------+--------------+------------------+");
      
        while (rs.next()) 
        {
         int id_facture = rs.getInt("id_facture");
         int id_patient = rs.getInt("id_patient");
         String date_facture = rs.getString("date_facture");
         String montant_facture= rs.getString("montant_facture");
         
        
          String ligne = String.format("| %-5s     |    %-10s | %-7s   |%-15s   |",id_facture,id_patient,date_facture,montant_facture);
         System.out.println(ligne);
        
        }
        System.out.println("+-----------+---------------+--------------+------------------+");
          
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        }
        
    } 


    public static void CreerFacture()
        
        throws SQLException 
        {
            Scanner scanner = new Scanner(System.in);
            
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_hopital?useUnicode=true&characterEncoding=utf8", "root", "Papaloum1613")) 
            {


                Statement stmt = con.createStatement();
                String liste = "select id_patient,prenom,nom,telephone,email,adresse,date_naissance from patients ORDER BY nom,prenom;";
            
                ResultSet rs = stmt.executeQuery(liste);
            
                System.out.println("+------------+---------------------+------------+---------------+-------------------------------+---------------+---------------+");
                System.out.println("| Patient ID | Prénom              | Nom        | Téléphone     | Email                         | Adresse       | Date Naissance|");
                System.out.println("+------------+---------------------+------------+---------------+-------------------------------+---------------+---------------+");
            
                while (rs.next()) 
                {
                String id_patient = rs.getString("id_patient");
                String prenom = rs.getString("prenom");
                String nom = rs.getString("nom");
                int telephone = rs.getInt("telephone");
                String email = rs.getString("email");
                String adresse = rs.getString("adresse");
                String date_naissance = rs.getString("date_naissance");
                
                
                String ligne = String.format("| %-10s |%-15s      | %-10s |%-15s|%-30s |%-15s|%-15s|",id_patient, prenom, nom, telephone, email,adresse,date_naissance);
                System.out.println(ligne);
                
                }
                System.out.println("+------------+---------------------+------------+---------------+-------------------------------+---------------+---------------+");
            

            
                System.out.println("Veuillez donner le numéro ID du patient à qui la facture appartient : ");
                int id_patient = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Veuillez donner la date du jour (format AAAA-MM-JJ): ");
                String date = scanner.nextLine();

                System.out.println("Veuillez donner le montant de la facture : ");
                int montant = scanner.nextInt();
                scanner.nextLine();

                String sql = "INSERT INTO factures(id_patient,date_facture,montant_facture) VALUES(?,?,?)";
                try (PreparedStatement pstmt = con.prepareStatement(sql)) 
                {
                    
                    pstmt.setInt(1, id_patient);
                    pstmt.setString(2, date);
                    pstmt.setInt(3, montant);

                    pstmt.executeUpdate();

                    System.err.println("Facture créé avec succés.");
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


    public static void ModifierFactures()
    throws SQLException 
    {
        Scanner scanner = new Scanner(System.in);
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_hopital", "root", "Papaloum1613")) 
        {
        Statement stmt = con.createStatement();
        String liste = "select id_facture,id_patient,date_facture,montant_facture from factures ORDER BY id_facture;";
    
        ResultSet rs = stmt.executeQuery(liste);
            
        System.out.println("");
        System.out.println("+-----------+---------------+--------------+------------------+");
        System.out.println("|ID Facture | ID Patient    | Date Facture | Montant          |");
        System.out.println("+-----------+---------------+--------------+------------------+");
      
        while (rs.next()) 
        {
         String id_facture = rs.getString("id_facture");
         int id_patient = rs.getInt("id_patient");
         String date_facture = rs.getString("date_facture");
         String montant_facture= rs.getString("montant_facture");
         
        
          String ligne = String.format("| %-5s     |    %-10s | %-7s   |%-15s   |",id_facture,id_patient,date_facture,montant_facture);
         System.out.println(ligne);
        
        }
        System.out.println("+-----------+---------------+--------------+------------------+");
         System.out.println(""); 
        System.out.print("Veuiller donner le numéro ID de le facture à modifier : ");
        int numID = scanner.nextInt();
        scanner.nextLine();


        Statement stmt1 = con.createStatement();
            String listes = "select id_patient,prenom,nom,telephone,email,adresse,date_naissance from patients ORDER BY nom,prenom;";
        
            ResultSet rs1 = stmt1.executeQuery(listes);
            System.out.println("");
            System.out.println("+------------+---------------------+------------+---------------+-------------------------------+---------------+---------------+");
            System.out.println("| Patient ID | Prénom              | Nom        | Téléphone     | Email                         | Adresse       | Date Naissance|");
            System.out.println("+------------+---------------------+------------+---------------+-------------------------------+---------------+---------------+");
          
            while (rs1.next()) 
            {
             String id_patient = rs1.getString("id_patient");
             String prenom = rs1.getString("prenom");
             String nom = rs1.getString("nom");
             int telephone = rs1.getInt("telephone");
             String email = rs1.getString("email");
             String adresse = rs1.getString("adresse");
             String date_naissance = rs1.getString("date_naissance");
             
            
              String ligne = String.format("| %-10s |%-15s      | %-10s |%-15s|%-30s |%-15s|%-15s|",id_patient, prenom, nom, telephone, email,adresse,date_naissance);
             System.out.println(ligne);
            
            }
            System.out.println("+------------+---------------------+------------+---------------+-------------------------------+---------------+---------------+");
            System.out.println("");
        


        System.out.print("Veuiller donner le nouveau numéro ID du patient concerné : ");
        int id_patient = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Veuiller donner le nouveau montant : ");
        int montant = scanner.nextInt();
        scanner.nextLine();

        String sql = "update factures set id_patient=?,montant_facture=? where id_facture=?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) 
        {
            
            pstmt.setInt(1, id_patient);
            pstmt.setInt(2,montant);
            pstmt.setInt(3,numID);

            pstmt.executeUpdate();
            System.err.println("Facture modifiée avec succés.");

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


    public static void supprimerFacture()
    
    throws SQLException 
    {
       Scanner scanner = new Scanner(System.in);
        
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_hopital?useUnicode=true&characterEncoding=utf8", "root", "Papaloum1613")) 
        {
    
          
            Statement stmt = con.createStatement();
            String liste = "select id_facture,id_patient,date_facture,montant_facture from factures ORDER BY id_facture;";
        
            ResultSet rs = stmt.executeQuery(liste);
        
            System.out.println("");
            System.out.println("+-----------+---------------+--------------+------------------+");
            System.out.println("|ID Facture | ID Patient    | Date Facture | Montant          |");
            System.out.println("+-----------+---------------+--------------+------------------+");
          
            while (rs.next()) 
            {
             String id_facture = rs.getString("id_facture");
             int id_patient = rs.getInt("id_patient");
             String date_facture = rs.getString("date_facture");
             String montant_facture= rs.getString("montant_facture");
             
            
              String ligne = String.format("| %-5s     |    %-10s | %-7s   |%-15s   |",id_facture,id_patient,date_facture,montant_facture);
             System.out.println(ligne);
            
            }
            System.out.println("+-----------+---------------+--------------+------------------+"); 
            System.out.println("");
    
            System.out.print("Veuiller donner le numéro ID de la facture à supprimer : ");
            int numID = scanner.nextInt();
            scanner.nextLine();
    
    
           String sql = "DELETE FROM factures where id_facture=?;";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) 
            {
                
                pstmt.setInt(1,numID);
                
                pstmt.executeUpdate();
    
            }   System.err.print("Facture supprimé avec succés.");
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
