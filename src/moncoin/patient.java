package moncoin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class patient 
{
    public static void CreerPatient()
    
	throws SQLException 
	{
        Scanner scanner = new Scanner(System.in);
		
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_hopital?useUnicode=true&characterEncoding=utf8", "root", "Papaloum1613")) 
        {

            System.out.print("Veuillez donner le prénom du patient : ");
            String prenom = scanner.nextLine();

            System.out.print("Veuillez donner le nom du patient :");
            String nom = scanner.nextLine();

            System.out.print("Veuillez donner le numéro ID du patient (Exemple CIN) :");
            String numID = scanner.nextLine();

            System.out.print("Veuillez donner la date de naissance du patient (format : AAAA-MM-JJ) : ");
            String date_naissance = scanner.nextLine();

            System.out.print("Veuillez donner l'adresse du patient  : ");
            String adresse = scanner.nextLine();

            System.out.print("Veuillez donner le numéro de téléphone du patient  : ");
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
                System.out.print("Veuillez entrer à nouveau le numéro de téléphone du patient : ");
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


            String sql = "INSERT INTO patients(nom,prenom,date_naissance,Numero_ID,adresse,telephone,email) VALUES(?,?,?,?,?,?,?)";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) 
            {
                
                pstmt.setString(1, nom);
                pstmt.setString(2, prenom);
                pstmt.setString(3,date_naissance);
                pstmt.setString(4,numID);
                pstmt.setString(5,  adresse);
                pstmt.setInt(6, numero);
                pstmt.setString(7, mail);
   
                pstmt.executeUpdate();

                System.err.print("patient  créé avec succés.");
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


    public static void modifierpatient()
    
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
             
            
              String ligne = String.format("| %-10s |%-18s   | %-10s |%-15s|%-30s |%-15s|%-15s|",id_patient, prenom, nom, telephone, email,adresse,date_naissance);
             System.out.println(ligne);
            
            }
            System.out.println("+------------+---------------------+------------+---------------+-------------------------------+---------------+---------------+");
             


            System.out.print("Veuillez donner le numéro ID du patient à modifier : ");
            String numID = scanner.nextLine();

            System.out.print("Veuillez donner le prénom du patient  : ");
            String prenom = scanner.nextLine();

            System.out.print("Veuillez donner le nom du patient  : ");
            String nom = scanner.nextLine();

            System.out.print("Veuillez donner la date de naissance du patient (format : AAAA-MM-JJ) : ");
            String date_naissance = scanner.nextLine();

            System.out.print("Veuillez donner l'adresse du patient  : ");
            String adresse = scanner.nextLine();

            System.out.print("Veuillez donner le numéro de téléphone du patient  : ");
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
                System.out.print("Veuillez entrer à nouveau le numéro de téléphone du patient : ");
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
    

            String sql = "update patients set prenom=?,nom=?,telephone=?,adresse=?,date_naissance=?,email=? where id_patient=?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) 
            {
                
                pstmt.setString(1, prenom);
                pstmt.setString(2, nom);
                pstmt.setInt(3,numero);
                pstmt.setString(4, adresse);
                pstmt.setString(5, date_naissance );
                pstmt.setString(6,  mail);
                pstmt.setString(7,  numID);


                pstmt.executeUpdate();

            }   System.err.print("patient modifié avec succés.");
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


    public static void supprimerpatient()
    
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
             
            
              String ligne = String.format("| %-10s |%-18s   | %-10s |%-15s|%-30s |%-15s|%-15s|",id_patient, prenom, nom, telephone, email,adresse,date_naissance);
             System.out.println(ligne);
            
            }
            System.out.println("+------------+---------------------+------------+---------------+-------------------------------+---------------+---------------+");
             


            System.out.print("Veuiller donner le numéro ID du patient à supprimer :");
            String numID = scanner.next();
            scanner.nextLine();


           String sql = "DELETE FROM patients where id_patient=? ;";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) 
            {
                
                pstmt.setString(1,numID);
                
                pstmt.executeUpdate();

            }   System.err.print("Patient supprimé avec succés.");
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


     public static void affichagerpatients()
throws SQLException 
{
    
    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_hopital", "root", "Papaloum1613")) 
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
     
    
      String ligne = String.format("| %-10s |%-18s   | %-10s |%-15s|%-30s |%-15s|%-15s|",id_patient, prenom, nom, telephone, email,adresse,date_naissance);
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
    
}
