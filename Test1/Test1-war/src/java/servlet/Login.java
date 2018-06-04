package servlet;

import Bean.Login.LoginLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Vizyan
 */
@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

    @EJB
    private User user;

    @EJB
    private LoginLocal login;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String username, password;
        PrintWriter out = response.getWriter();
        
        if (request.getParameter("login") != null) {
            try {
                username = request.getParameter("username");
                password = request.getParameter("password");

                user.setUsername(username);
                user.setPassword(password);

                JSONObject json = login.loginUser(user);
                String message = json.get("message").toString();

                if(message.equals("success")){
                    JSONObject data = json.getJSONObject("data");
//                    RequestDispatcher home = request.getRequestDispatcher("Home");
//                    home.forward(request, response);
                    response.sendRedirect(request.getContextPath() + "/Home");
                } else {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet Login</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1> Failed </h1>");
                    out.println("</body>");
                    out.println("</html>");
                }
                
            } catch (JSONException ex) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Login</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1> " + ex.getMessage() +"</h1>");
                out.println("</body>");
                out.println("</html>");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
