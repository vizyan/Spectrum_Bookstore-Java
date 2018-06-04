package servlet;

import Bean.Login.LoginLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        String header = "<head>\n" +
                        "<title>Spectrum Bookstore</title>\n" +
                        "<meta charset=\"utf-8\">\n" +
                        "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                        "<meta name=\"description\" content=\"Colo Shop Template\">\n" +
                        "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                        "<link rel=\"stylesheet\" type=\"text/css\" href=\"styles/bootstrap4/bootstrap.min.css\">\n" +
                        "<link href=\"plugins/font-awesome-4.7.0/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\">\n" +
                        "<link rel=\"stylesheet\" type=\"text/css\" href=\"plugins/OwlCarousel2-2.2.1/owl.carousel.css\">\n" +
                        "<link rel=\"stylesheet\" type=\"text/css\" href=\"plugins/OwlCarousel2-2.2.1/owl.theme.default.css\">\n" +
                        "<link rel=\"stylesheet\" type=\"text/css\" href=\"plugins/OwlCarousel2-2.2.1/animate.css\">\n" +
                        "<link rel=\"stylesheet\" type=\"text/css\" href=\"styles/main_styles.css\">\n" +
                        "<link rel=\"stylesheet\" type=\"text/css\" href=\"styles/responsive.css\">\n" +
                    "</head>";
        
        String navbar = "<body class=\"newsletter\" style=\"width: 100%; height: 100%\">\n" +
                    "<div class=\"super_container\">\n" +
                    "<header class=\"header trans_300\">\n" +
                    "<div class=\"top_nav\">\n" +
                    "</div>\n" +
                    "\n" +
                    "<!-- Main Navigation -->\n" +
                    "\n" +
                    "<div class=\"main_nav_container\">\n" +
                    "<div class=\"container\">\n" +
                    "<div class=\"row\">\n" +
                    "<div class=\"col-lg-12 text-right\">\n" +
                    "<div class=\"logo_container\">\n" +
                    "<a href=\"#\">Spectrum<span> Bookstore</span></a>\n" +
                    "</div>\n" +
                    "<nav class=\"navbar\">\n" +
                    "<ul class=\"navbar_menu\">\n" +
                    "<li><a href=\"#\">Home</a></li>\n" +
                    "<li><a href=\"#\">About</a></li>\n" +
                    "<li class=\"account\">\n" +
                    "<a href=\"#\">\n" +
                    "Account\n" +
                    "<i class=\"fa fa-angle-down\"></i>\n" +
                    "</a>\n" +
                    "<ul class=\"account_selection\">\n" +
                    "<li><a href=\"login\"><i class=\"fa fa-sign-in\" aria-hidden=\"true\"></i>Login</a></li>\n" +
                    "<li><a href=\"register\"><i class=\"fa fa-user-plus\" aria-hidden=\"true\"></i>Register</a></li>\n" +
                    "</ul>\n" +
                    "</li>\n" +
                    "</ul>\n" +
                    "<!--\n" +
                    "<ul class=\"navbar_user\">\n" +
                    "<li><a href=\"#\"><i class=\"fa fa-search\" aria-hidden=\"true\"></i></a></li>\n" +
                    "<li><a href=\"#\"><i class=\"fa fa-user\" aria-hidden=\"true\"></i></a></li>\n" +
                    "<li class=\"checkout\">\n" +
                    "<a href=\"#\">\n" +
                    "<i class=\"fa fa-shopping-cart\" aria-hidden=\"true\"></i>\n" +
                    "<span id=\"checkout_items\" class=\"checkout_items\">2</span>\n" +
                    "</a>\n" +
                    "</li>\n" +
                    "</ul>\n" +
                    "-->\n" +
                    "<div class=\"hamburger_container\">\n" +
                    "<i class=\"fa fa-bars\" aria-hidden=\"true\"></i>\n" +
                    "</div>\n" +
                    "</nav>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "\n" +
                    "</header>\n" +
                    "\n" +
                    "<div class=\"fs_menu_overlay\"></div>\n" +
                    "<div class=\"hamburger_menu\">\n" +
                    "<div class=\"hamburger_close\"><i class=\"fa fa-times\" aria-hidden=\"true\"></i></div>\n" +
                    "<div class=\"hamburger_menu_content text-right\">\n" +
                    "<ul class=\"menu_top_nav\">\n" +
                    "<li class=\"menu_item has-children\">\n" +
                    "<a href=\"#\">\n" +
                    "Account\n" +
                    "<i class=\"fa fa-angle-down\"></i>\n" +
                    "</a>\n" +
                    "<ul class=\"menu_selection\">\n" +
                    "<li><a href=\"login\"><i class=\"fa fa-sign-in\" aria-hidden=\"true\"></i>Login</a></li>\n" +
                    "<li><a href=\"register\"><i class=\"fa fa-user-plus\" aria-hidden=\"true\"></i>Register</a></li>\n" +
                    "</ul>\n" +
                    "</li>\n" +
                    "<li class=\"menu_item\"><a href=\"#\">Home</a></li>\n" +
                    "<li class=\"menu_item\"><a href=\"#\">About</a></li>\n" +
                    "</ul>\n" +
                    "</div>\n" +
                    "</div>";
        
        String contentTop = "<div class=\"newsletter\" style=\"padding-top: 10%\">\n" +
                    "<div class=\"container\">\n";
        
        String contentBottom = "<form action=\"login\" method=\"post\">\n" +
                    "<div class=\"newsletter_form d-flex flex-md-row flex-column flex-xs-column align-items-center justify-content-center\">\n" +
                    "<br>\n" +
                    "<input id=\"newsletter_email\" type=\"text\" placeholder=\"Username\" name=\"username\" required=\"required\" data-error=\"Valid email is required.\">\n" +
                    "</div>\n" +
                    "<div class=\"newsletter_form d-flex flex-md-row flex-column flex-xs-column align-items-center justify-content-center\">\n" +
                    "<br>\n" +
                    "<input id=\"newsletter_email\" type=\"password\" placeholder=\"Password\" name=\"password\" required=\"required\" data-error=\"Valid email is required.\">\n" +
                    "</div>\n" +
                    "<div class=\"newsletter_form d-flex flex-md-row flex-column flex-xs-column align-items-center justify-content-center\">\n" +
                    "<br>\n" +
                    "<input id=\"newsletter_submit\" type=\"submit\" class=\"button newsletter_submit_btn trans_300\" name=\"login\" value=\"Login\">\n" +
                    "</div>\n" +
                    "<div class=\"newsletter_form d-flex flex-md-row flex-column flex-xs-column align-items-center justify-content-center\">\n" +
                    "<br>\n" +
                    "<p><a href=\"register\">Belum memiliki memiliki account?</a></p>\n" +
                    "</div>\n" +
                    "</form>\n" +
                    "</div>\n" +
                    "</div>";
        
        String footer = "</div>\n" +
                    "\n" +
                    "<footer class=\"footer\" style=\"position: absolute;bottom: 0\">\n" +
                    "<br />\n" +
                    "<div class=\"container\">\n" +
                    "<div class=\"row\">\n" +
                    "<div class=\"col-lg-12\">\n" +
                    "<div class=\"footer_nav_container\">\n" +
                    "<div class=\"cr\">©2018 All Rights Reserverd <i class=\"fa fa-heart-o\" aria-hidden=\"true\"></i> Spectrum</div>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</footer>\n" +
                    "\n" +
                    "\n" +
                    "<script src=\"js/jquery-3.2.1.min.js\"></script>\n" +
                    "<script src=\"styles/bootstrap4/popper.js\"></script>\n" +
                    "<script src=\"styles/bootstrap4/bootstrap.min.js\"></script>\n" +
                    "<script src=\"plugins/Isotope/isotope.pkgd.min.js\"></script>\n" +
                    "<script src=\"plugins/OwlCarousel2-2.2.1/owl.carousel.js\"></script>\n" +
                    "<script src=\"plugins/easing/easing.js\"></script>\n" +
                    "<script src=\"js/custom.js\"></script>\n" +
                    "</body>";
        
        PrintWriter out = response.getWriter();
        
        HttpSession session = request.getSession(false);
        if(session!=null){
            response.sendRedirect(request.getContextPath() + "");
        } else {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println(header);
            out.println(navbar);
            out.println(contentTop);
            
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
                        HttpSession createSession = request.getSession();  
                        createSession.setAttribute("login", data); 

    //                    RequestDispatcher home = request.getRequestDispatcher("Home");
    //                    home.forward(request, response);

                        response.sendRedirect(request.getContextPath() + "");
                    } else {
                        out.println("<div class=\"d-flex flex-md-row flex-column flex-xs-column align-items-center justify-content-center\">\n" +
                                    "<h4 id=\"newsletter_submit\" class=\"btn button\" style=\"background-color: red\">Username atau Password yang anda masukkan salah</h4>\n" +
                                    "</div>");
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
            
            out.println(contentBottom);
            out.println(footer);
            out.println("<html>");
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
