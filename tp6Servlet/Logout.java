package tp6Servlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/** Classe pour logout syst�me de gestion de biblioth�que
 *  <P>
 * Syst�me de gestion de biblioth�que
 *  &copy; 2004 Marc Frappier, Universit� de Sherbrooke
 */

public class Logout extends HttpServlet
{
public void doGet(HttpServletRequest request,
                  HttpServletResponse response)
    throws ServletException, IOException
{
// invalider la session pour lib�rer les ressources associ�es � la session
request.getSession().invalidate();
RequestDispatcher dispatcher =
  request.getRequestDispatcher("/login.jsp");
dispatcher.forward(request, response);
}

public void doPost(HttpServletRequest request,
                   HttpServletResponse response)
    throws ServletException, IOException
{
doGet(request, response);
}
}
