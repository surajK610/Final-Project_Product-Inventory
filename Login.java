
/**
 * Write a description of interface Login here.
 * 
 * This implements a login 
 * @author (Suraj Anand) 
 * @version (908)
 */
public interface Login
{
    public boolean login(String user, String passwd);
    public boolean userManager(String user, String passwd);
    public void wrongLogin();
    public void logout();
}
