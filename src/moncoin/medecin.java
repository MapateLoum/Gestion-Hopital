package moncoin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class medecin {
     public static void Creermedecin()
    
	throws SQLException 
	{
        Scanner scanner = new Scanner(System.in);
		
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_hopital?useUnicode=true&characterEncoding=utf8", "root", "Papaloum1613")) 
        {


            System.out.println("Veuillez donner le prénom du medecin  : ");
            String prenom = scanner.nextLine();

            System.out.println("Veuillez donner le nom du medecin  : ");
            String nom = scanner.nextLine();

            System.out.println("Veuillez donner la spécialité du medecin  : ");
            String specialite = scanner.nextLine();

            System.out.print("Veuillez donner le numéro de téléphone du médecin  : ");
            int numero;
            while (!scanner.hasNextInt()) 
            {
                System.out.println("Le numéro doit être un entier !");
                scanner.next();
            }
            numero = scanner.nextInt();
            while (numero / 10000000 != 77 && numero / 10000000 != 78 && numero / 10000000 != 76 && numero / 10000000 != 70 && numero / 10000000 != 75) 
            {
                System.out.println("Le numéro doit commencer par 77, 78, 76, 70 ou 75 !");
                System.out.print("Veuillez entrer à nouveau le numéro de téléphone du médecin : ");
                while (!scanner.hasNextInt()) 
                {
                    System.out.println("Le numéro doit être un entier !");
                    scanner.next();
                }
                numero = scanner.nextInt();
            }
            scanner.nextLine();
            

        String mail;
        do 
        {
            System.out.print("Veuillez saisir votre adresse e-mail : ");
            mail = scanner.nextLine();

            if (mail.length() < 10 || !mail.substring(mail.length() - 10).equals("@gmail.com")) 
            {
                System.out.println("L'adresse e-mail n'est pas valide. Veuillez saisir une adresse e-mail valide.");
            }
        } while (mail.length() < 10 || !mail.substring(mail.length() - 10).equals("@gmail.com"));

            System.out.println("");
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
          
            System.out.println("Donnez le numéro ID du service ou vous voulez orienter ce médecin : ");
            String serviceID = scanner.nextLine();

            String sql = "INSERT INTO medecins(prenom,nom,specialite,telephone,email,id_service) VALUES(?,?,?,?,?,?)";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) 
            {
                
                pstmt.setString(1, prenom);
                pstmt.setString(2, nom);
                pstmt.setString(3,specialite);
                pstmt.setInt(4, numero);
                pstmt.setString(5, mail);
                pstmt.setString(6, serviceID);

                pstmt.executeUpdate();

                System.err.println("medecin  créé avec succés.");
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

   
    public static void affichagerMedecins()
throws SQLException 
{
    
    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_hopital", "root", "Papaloum1613")) 
    {
    Statement stmt = con.createStatement();
    String liste = "select id_medecin,prenom,nom,telephone,email,id_service,specialite from medecins ORDER BY nom,prenom;";

    ResultSet rs = stmt.executeQuery(liste);

    System.out.println("+------------+---------------------+------------+---------------+-------------------------------+---------------+---------------+");
    System.out.println("| Médecin ID | Prénom              | Nom        | Téléphone     | Email                         | Service_ID    | Spécialité    |");
    System.out.println("+------------+---------------------+------------+---------------+-------------------------------+---------------+---------------+");
  
    while (rs.next()) 
    {
     String id_medecin = rs.getString("id_medecin");
     String prenom = rs.getString("prenom");
     String nom = rs.getString("nom");
     int telephone = rs.getInt("telephone");
     String email = rs.getString("email");
     String adresse = rs.getString("id_service");
     String date_naissance = rs.getString("specialite");
     
    
      String ligne = String.format("| %-10s |%-15s | %-10s |%-15s|%-30s |%-15s|%-15s|",id_medecin, prenom, nom, telephone, email,adresse,date_naissance);
     System.out.println(ligne);
    
    }
    System.out.println("+------------+---------------------+------------+---------------+-------------------------------+---------------+---------------+");
      
    if (con != null) {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }
    
} 


    public static void supprimermedecin()
    
throws SQLException 
{
   Scanner scanner = new Scanner(System.in);
    
    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_hopital?useUnicode=true&characterEncoding=utf8", "root", "Papaloum1613")) 
    {

        Statement stmt = con.createStatement();
        String liste = "select id_medecin,prenom,nom,telephone,email,id_service,specialite from medecins ORDER BY nom,prenom;";
    
        ResultSet rs = stmt.executeQuery(liste);
    
        System.out.println("+------------+---------------------+------------+---------------+-------------------------------+---------------+---------------+");
        System.out.println("| Médecin ID | Prénom              | Nom        | Téléphone     | Email                         | Service_ID    | Spécialité    |");
        System.out.println("+------------+---------------------+------------+---------------+-------------------------------+---------------+---------------+");
      
        while (rs.next()) 
        {
         String id_medecin = rs.getString("id_medecin");
         String prenom = rs.getString("prenom");
         String nom = rs.getString("nom");
         int telephone = rs.getInt("telephone");
         String email = rs.getString("email");
         String adresse = rs.getString("id_service");
         String date_naissance = rs.getString("specialite");
         
        
          String ligne = String.format("| %-10s |%-15s | %-10s |%-15s|%-30s |%-15s|%-15s|",id_medecin, prenom, nom, telephone, email,adresse,date_naissance);
         System.out.println(ligne);
        
        }
        System.out.println("+------------+---------------------+------------+---------------+-------------------------------+---------------+---------------+");
        
       


        System.out.print("Veuiller donner le numéro ID du medecin à supprimer :");
        String numID = scanner.next();
        scanner.nextLine();


       String sql = "DELETE FROM medecins where id_medecin=? ;";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) 
        {
            
            pstmt.setString(1,numID);
            
            pstmt.executeUpdate();

        }   System.err.print("medecin supprimé avec succés.");
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


    public static void modifierModifier()
    
throws SQLException 
{
   Scanner scanner = new Scanner(System.in);
    
    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_hopital?useUnicode=true&characterEncoding=utf8", "root", "Papaloum1613")) 
    {

        
        Statement stmt = con.createStatement();
        String liste = "select id_medecin,prenom,nom,telephone,email,id_service,specialite from medecins ORDER BY nom,prenom;";
    
        ResultSet rs = stmt.executeQuery(liste);
    
        System.out.println("+------------+---------------------+------------+---------------+-------------------------------+---------------+---------------+");
        System.out.println("| Médecin ID | Prénom              | Nom        | Téléphone     | Email                         | Service_ID    | Spécialité    |");
        System.out.println("+------------+---------------------+------------+---------------+-------------------------------+---------------+---------------+");
      
        while (rs.next()) 
        {
         String id_medecin = rs.getString("id_medecin");
         String prenom = rs.getString("prenom");
         String nom = rs.getString("nom");
         int telephone = rs.getInt("telephone");
         String email = rs.getString("email");
         String adresse = rs.getString("id_service");
         String specialite = rs.getString("specialite");
         
        
          String ligne = String.format("| %-10s |%-15s | %-10s |%-15s|%-30s |%-15s|%-15s|",id_medecin, prenom, nom, telephone, email,adresse,specialite);
         System.out.println(ligne);
        
        }
        System.out.println("+------------+---------------------+------------+---------------+-------------------------------+---------------+---------------+");
           


        System.out.print("Veuillez donner le numéro ID du médecin à modifier : ");
        String numID = scanner.nextLine();

        System.out.print("Veuillez donner le prénom du médecin  : ");
        String prenom = scanner.nextLine();

        System.out.print("Veuillez donner le nom du médecin  : ");
        String nom = scanner.nextLine();

        System.out.print("Veuillez donner la spécialité du médecin : ");
        String specialite = scanner.nextLine();

        System.out.print("Veuillez donner le numéro de téléphone du médecin : ");
        int numero;
        while (!scanner.hasNextInt()) 
        {
            System.out.println("Le numéro doit être un entier !");
            scanner.next();
        }
        numero = scanner.nextInt();

        while (numero / 10000000 != 77 && numero / 10000000 != 78 && numero / 10000000 != 76 && numero / 10000000 != 70 && numero / 10000000 != 75) 
        {
            System.out.println("Le numéro doit commencer par 77, 78, 76, 70 ou 75 !");
            System.out.print("Veuillez entrer à nouveau le numéro de téléphone du médecin : ");
            while (!scanner.hasNextInt()) 
            {
                System.out.println("Le numéro doit être un entier !");
                scanner.next();
            }
            numero = scanner.nextInt();
        }
        scanner.nextLine();

        String mail;
        do 
        {
            System.out.print("Veuillez saisir l'adresse e-mail : ");
            mail = scanner.nextLine();

            if (mail.length() < 10 || !mail.substring(mail.length() - 10).equals("@gmail.com")) 
            {
                System.out.println("L'adresse e-mail n'est pas valide. Veuillez saisir une adresse e-mail valide.");
            }
        } while (mail.length() < 10 || !mail.substring(mail.length() - 10).equals("@gmail.com"));


        System.out.println("");
        Statement stmt1 = con.createStatement();
        String listes = "select id_service,nom_service from services ORDER BY id_service,nom_service;";
    
        ResultSet rs1 = stmt1.executeQuery(listes);
        System.out.println("+------------+-----------------+");
        System.out.println("| Service ID | Nom du Service  |");
        System.out.println("+------------+-----------------+");
        while (rs1.next()) 
        {
         String id_service = rs1.getString("id_service");
         String nom_service = rs1.getString("nom_service");
        
          String ligne = String.format("| %-10s |%-16s |",id_service, nom_service);
         System.out.println(ligne);
        }
        System.out.println("+------------+-----------------+");
      
        System.out.println("Donnez le numéro ID du service ou vous voulez orienter ce médecin : ");
        String serviceID = scanner.nextLine();



        String sql = "update medecins set prenom=?,nom=?,telephone=?,specialite=?,email=?,id_service=? where id_medecin=?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) 
        {
            
            pstmt.setString(1, prenom);
            pstmt.setString(2, nom);
            pstmt.setInt(3,numero);
            pstmt.setString(4, specialite);
            pstmt.setString(5, mail );
            pstmt.setString(6,  serviceID);
            pstmt.setString(7,  numID);


            pstmt.executeUpdate();

        }   System.err.print("medecin modifié avec succés.");
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
