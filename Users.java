
/**
 * This class represents Users of the inventory system.
 * 
 * @author Suraj
 */
import java.util.*;
public class Users implements Login
{
    private String UserManagerName = "suraj";
    private String UserManagerPass = "pass123";
    
    private ArrayList <Users> logins = new ArrayList <Users>();
    
    String username;
    String passwd;
    
    boolean manager = false;
    boolean user = false;
    
    private int countWrong = 0;
    
    public Users()
    {
        populate();
    }
    
    public Users(String username, String passwd)
    {
        Scanner scan = new Scanner (System.in);
        if (manager)
        {
            this.username = username;
            this.passwd = passwd;
            System.out.println("A new account has been created: " + "\n" + "Username: " + username + "\n" + "Password: " + passwd);
        }
        else 
        {
            System.out.println("Sorry, you have not logged in as manager.");
            System.out.println("Would you like to log in as manager(y/n)?");
            String login = scan.next();
            if (login.equalsIgnoreCase("y"))
            {
                 userManager();
                 if (manager)
                     {
                     this.username = username;
                     this.passwd = passwd;
                     logins.add(this);
                     countWrong = 0;
                     System.out.println("A new account has been created: " + "\n" + "Username: " + username + "\n" + "Password: " + passwd);
                    }
            }
            else 
            {
                wrongLogin();
            }
        }
    }
    
     public Users(String username, String passwd, boolean t)
    {
        Scanner scan = new Scanner (System.in);
        if (t)
        {
            this.username = username;
            this.passwd = passwd;
        }
        else 
        {
            System.out.println("Sorry, you have not logged in as manager.");
            System.out.println("Would you like to log in as manager(y/n)?");
            String login = scan.next();
            login = scan.next();
            if (login.equalsIgnoreCase("y"))
            {
                 userManager();
                 if (manager)
                     {
                     this.username = username;
                     this.passwd = passwd;
                     logins.add(this);
                     countWrong = 0;
                     System.out.println("A new account has been created: " + "\n" + "Username: " + username + "\n" + "Password: " + passwd);
                    }
            }
            else 
            {
                wrongLogin();
            }
        }
    }
    
    public void populate()
    {
        manager = true;
        Users joe = new Users("Joe", "joejoe", true);
        Users sally = new Users("Sally", "sallysally", true);
        Users bob = new Users("Bob", "bobbob", true);
        
        logins.add(joe);
        logins.add(sally);
        logins.add(bob);
        
        manager = false;
    }
    
    public boolean userManager (String manUser, String manPass)
    {
        if (manUser.equals(UserManagerName) && manPass.equals(UserManagerPass))
        {
            manager = true;
            //System.out.println("Congratulations, you have successfully logged in as manager!");
        }
        else
        {
            wrongLogin();
        }
        return manager;
    }
    
    public boolean userManager ()
    {
        Scanner scan = new Scanner (System.in);
        String manUser, manPass;
        
        System.out.println("Please enter your manager username. ");
        manUser = scan.nextLine();
        
        System.out.println("Please enter your manager password. ");
        manPass = scan.nextLine();
       
        
        if (manUser.equals(UserManagerName) && manPass.equals(UserManagerPass))
        {
            manager = true;
            System.out.println("Congratulations, you have successfully logged in as manager!");
        }
        else
        {
            wrongLogin();
        }
        return manager;
    }
    
    public boolean login(String username, String passwd)
    {
       user = false;
       for (Users login: logins)
        {
            if (login.username.equals(username) && login.passwd.equals(passwd))
            {
                user = true;
                //System.out.println("Congratulations, you have successfully logged in!");
                countWrong = 0;
                break;
            }
        }
       if (!user)
       {
            wrongLogin();
        }
       return user;
    }
    
    public boolean login()
    {
       Scanner scan = new Scanner (System.in);
        
       user = false;
       String username, passwd;
       
       System.out.println("Please enter your username. ");
       username = scan.nextLine();
       
       System.out.println("Please enter your password. ");
       passwd = scan.nextLine();
       
       for (Users login: logins)
        {
            //System.out.println(login.getUsername() + "  " + login.getPasswd());
            if (login.getUsername().equals(username) && login.getPasswd().equals(passwd))
            {
                user = true;
                System.out.println("Congratulations, you have successfully logged in!");
                countWrong = 0;
                break;
            }
        }
       if (!user)
       {
            wrongLogin();
        }
       return user;
    }
    
    public void wrongLogin()
    {
        System.out.println("Sorry, wrong username or password.");
        countWrong ++;
        
        manager = false;
        user = false;
        
        if (countWrong >= 10)
        {
            System.out.println("Locked out");
            countWrong = 0;
        }
    }
    
    public void logout()
    {
        manager = false;
        user = false;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public String getPasswd()
    {
        return passwd;
    }
    
    public boolean getManager()
    {
        return manager;
    }
    
    public boolean getUser()
    {
        return user;
    }
    
    public String toString()
    {
        String users = "USERS: \n";
        if (!manager)
        {
            userManager();
        }
        else
        {
            for(Users user: logins)
            {
                users +="Username: " + user.getUsername() + "\n" + "Password: " + user.getPasswd() + "\n\n";
            }
        }
        return users;
    }
}
