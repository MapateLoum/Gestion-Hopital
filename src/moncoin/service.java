package moncoin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class service 
{
     public static void Creerservice()
    
	throws SQLException 
	{
        Scanner scanner = new Scanner(System.in);
		
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_hopital?useUnicode=true&characterEncoding=utf8", "root", "Papaloum1613")) 
        {
          
            System.out.println("Veuillez donner le nom du service : ");
            String nom_service = scanner.nextLine();

            String sql = "INSERT INTO services(nom_service) VALUES(?)";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) 
            {
                
                pstmt.setString(1, nom_service);

                pstmt.executeUpdate();

                System.err.println("Service créé avec succés.");
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



   public static void modifierservice()
    
	throws SQLException 
	{
       Scanner scanner = new Scanner(System.in);
		
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_hopital?useUnicode=true&characterEncoding=utf8", "root", "Papaloum1613")) 
        {
            Statement stmt = con.createStatement();
            String liste = "select id_service,nom_service from services ORDER BY id_service,nom_service;";
        
            ResultSet rs = stmt.executeQuery(liste);
            System.out.println("+------------+-----------------+");
            System.out.println("| Service ID | Nom du Service  |");
            System.out.println("+------------+-----------------+");
            while (rs.next()) 
            {
             String id_service = rs.getString("id_service");
             String nom_service = rs.getString("nom_service");
            
              String ligne = String.format("| %-10s |%-16s |",id_service, nom_service);
             System.out.println(ligne);
            }
            System.out.println("+------------+-----------------+");

          
            System.out.println("Veuillez donner le numéro ID du service à modifier : ");
            String numID = scanner.nextLine();

            System.out.println("Veuillez donner le nouveau nom du service  : ");
            String nom = scanner.nextLine();

            String sql = "update services set nom_service=? where id_service=?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) 
            {
                
                pstmt.setString(1, nom);
                pstmt.setString(2,numID);

                pstmt.executeUpdate();

            }   System.err.println("service modifié avec succés.");
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



    public static void supprimerservice()
    
	throws SQLException 
	{
       Scanner scanner = new Scanner(System.in);
		
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_hopital?useUnicode=true&characterEncoding=utf8", "root", "Papaloum1613")) 
        {
            Statement stmt = con.createStatement();
            String liste = "select id_service,nom_service from services ORDER BY id_service,nom_service;";
        
            ResultSet rs = stmt.executeQuery(liste);
            System.out.println("+------------+-----------------+");
            System.out.println("| Service ID | Nom du Service  |");
            System.out.println("+------------+-----------------+");
            while (rs.next()) 
            {
             String id_service = rs.getString("id_service");
             String nom_service = rs.getString("nom_service");
            
              String ligne = String.format("| %-10s |%-16s |",id_service, nom_service);
             System.out.println(ligne);
            }
            System.out.println("+------------+-----------------+");


            System.out.println("Veuiller donner le numéro ID du service à supprimer :");
            String numID = scanner.next();
            scanner.nextLine();


           String sql = "DELETE FROM services where id_service=? ;";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) 
            {
                
                pstmt.setString(1,numID);
                
                pstmt.executeUpdate();

            }   System.err.println("service supprimé avec succés.");
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


    
    public static void affichagerServices()
    throws SQLException
    {
       // Scanner scanner = new Scanner(System.in);
		
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_hopital?useUnicode=true&characterEncoding=utf8", "root", "Papaloum1613")) 
        {
    Statement stmt = con.createStatement();
    String liste = "select id_service,nom_service from services ORDER BY id_service,nom_service;";

    ResultSet rs = stmt.executeQuery(liste);
    System.out.println("+------------+-----------------+");
    System.out.println("| Service ID | Nom du Service  |");
    System.out.println("+------------+-----------------+");
    while (rs.next()) 
    {
     String id_service = rs.getString("id_service");
     String nom_service = rs.getString("nom_service");
    
      String ligne = String.format("| %-10s |%-16s |",id_service, nom_service);
     System.out.println(ligne);
    }
    System.out.println("+------------+-----------------+");
    }
}
}
