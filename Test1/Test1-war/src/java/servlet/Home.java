/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Bean.Home.HomeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Vizyan
 */
@WebServlet(name = "Home", urlPatterns = {""})
public class Home extends HttpServlet {

    @EJB
    private HomeLocal home;

    @EJB
    private User user;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        
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
        
        String navbar = "<body>\n" +
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
                    "<li><a href=\"chart\">Cart</a></li>\n" +
                    "<li class=\"account\">\n" +
                    "<a href=\"logout\">\n" +
                    "Logout\n" + //INI DIGANTI USERNAME
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
                    "<li><a href=\"#\"><i class=\"fa fa-sign-in\" aria-hidden=\"true\"></i>Login</a></li>\n" +
                    "<li><a href=\"#\"><i class=\"fa fa-user-plus\" aria-hidden=\"true\"></i>Register</a></li>\n" +
                    "</ul>\n" +
                    "</li>\n" +
                    "<li class=\"menu_item\"><a href=\"#\">Home</a></li>\n" +
                    "<li class=\"menu_item\"><a href=\"chart\">Cart</a></li>\n" +
                    "</ul>\n" +
                    "</div>\n" +
                    "</div>";
        
        String slider = "<div class=\"main_slider\" style=\"background-image:url(images/slider_1.jpg)\">\n" +
"                <div class=\"container fill_height\">\n" +
"                    <div class=\"row align-items-center fill_height\">\n" +
"                        <div class=\"col\">\n" +
"                            <div class=\"main_slider_content\">\n" +
"                                <h1>Welcome to Spectrum BookStore</h1>\n" +
"                                <div class=\"red_button shop_now_button\"><a href=\"#\">shop now</a></div>\n" +
"                            </div>\n" +
"                        </div>\n" +
"                    </div>\n" +
"                </div>\n" +
"            </div>";
        
        String contentTop = "<div class=\"new_arrivals\">\n" +
"                <div class=\"container\">\n" +
"                    <div class=\"row\">\n" +
"                        <div class=\"col text-center\">\n" +
"                            <div class=\"section_title new_arrivals_title\">\n" +
"                                <h2>New Arrivals</h2>\n" +
"                            </div>\n" +
"                        </div>\n" +
"                    </div>\n" +
"                    <div class=\"row align-items-center\">\n" +
"                        <div class=\"col text-center\">\n" +
"                            <div class=\"new_arrivals_sorting\">\n" +
"                                <ul class=\"arrivals_grid_sorting clearfix button-group filters-button-group\">\n" +
"                                    <li class=\"grid_sorting_button button d-flex flex-column justify-content-center align-items-center active is-checked\" data-filter=\"*\">All</li>\n" +
"                                    <li class=\"grid_sorting_button button d-flex flex-column justify-content-center align-items-center\" data-filter=\".non-fiksi\">Non-Fiksi</li>\n" +
"                                    <li class=\"grid_sorting_button button d-flex flex-column justify-content-center align-items-center\" data-filter=\".fiksi\">Fiksi</li>\n" +
"                                    <li class=\"grid_sorting_button button d-flex flex-column justify-content-center align-items-center\" data-filter=\".novel\">Novel</li>\n" +
"                                </ul>\n" +
"                            </div>\n" +
"                        </div>\n" +
"                    </div>\n" +
"                    <div class=\"row\">\n" +
"                        <div class=\"col\">\n" +
"                            <div class=\"product-grid\" data-isotope='{ \"itemSelector\": \".product-item\", \"layoutMode\": \"fitRows\" }'>";
        
        String contentBottom = "</div>\n" +
"                        </div>\n" +
"                    </div>\n" +
"                </div>\n" +
"            </div>";
        
        String benefit = "<div class=\"benefit\">\n" +
"                <div class=\"container\">\n" +
"                    <div class=\"row benefit_row\">\n" +
"                        <div class=\"col-lg-3 benefit_col\">\n" +
"                            <div class=\"benefit_item d-flex flex-row align-items-center\">\n" +
"                                <div class=\"benefit_icon\"><i class=\"fa fa-truck\" aria-hidden=\"true\"></i></div>\n" +
"                                <div class=\"benefit_content\">\n" +
"                                    <h6>free shipping</h6>\n" +
"                                    <p>Suffered Alteration in Some Form</p>\n" +
"                                </div>\n" +
"                            </div>\n" +
"                        </div>\n" +
"                        <div class=\"col-lg-3 benefit_col\">\n" +
"                            <div class=\"benefit_item d-flex flex-row align-items-center\">\n" +
"                                <div class=\"benefit_icon\"><i class=\"fa fa-money\" aria-hidden=\"true\"></i></div>\n" +
"                                <div class=\"benefit_content\">\n" +
"                                    <h6>cach on delivery</h6>\n" +
"                                    <p>The Internet Tend To Repeat</p>\n" +
"                                </div>\n" +
"                            </div>\n" +
"                        </div>\n" +
"                        <div class=\"col-lg-3 benefit_col\">\n" +
"                            <div class=\"benefit_item d-flex flex-row align-items-center\">\n" +
"                                <div class=\"benefit_icon\"><i class=\"fa fa-undo\" aria-hidden=\"true\"></i></div>\n" +
"                                <div class=\"benefit_content\">\n" +
"                                    <h6>45 days return</h6>\n" +
"                                    <p>Making it Look Like Readable</p>\n" +
"                                </div>\n" +
"                            </div>\n" +
"                        </div>\n" +
"                        <div class=\"col-lg-3 benefit_col\">\n" +
"                            <div class=\"benefit_item d-flex flex-row align-items-center\">\n" +
"                                <div class=\"benefit_icon\"><i class=\"fa fa-clock-o\" aria-hidden=\"true\"></i></div>\n" +
"                                <div class=\"benefit_content\">\n" +
"                                    <h6>opening all week</h6>\n" +
"                                    <p>8AM - 09PM</p>\n" +
"                                </div>\n" +
"                            </div>\n" +
"                        </div>\n" +
"                    </div>\n" +
"                </div>\n" +
"            </div>";
        
        String footer = "<footer class=\"footer\">\n" +
"                <br />\n" +
"                <div class=\"container\">\n" +
"                    <div class=\"row\">\n" +
"                        <div class=\"col-lg-12\">\n" +
"                            <div class=\"footer_nav_container\">\n" +
"                                <div class=\"cr\">©2018 All Rights Reserverd <i class=\"fa fa-heart-o\" aria-hidden=\"true\"></i> Spectrum</div>\n" +
"                            </div>\n" +
"                        </div>\n" +
"                    </div>\n" +
"                </div>\n" +
"            </footer>\n" +
"\n" +
"        </div>\n" +
"\n" +
"        <script src=\"js/jquery-3.2.1.min.js\"></script>\n" +
"        <script src=\"styles/bootstrap4/popper.js\"></script>\n" +
"        <script src=\"styles/bootstrap4/bootstrap.min.js\"></script>\n" +
"        <script src=\"plugins/Isotope/isotope.pkgd.min.js\"></script>\n" +
"        <script src=\"plugins/OwlCarousel2-2.2.1/owl.carousel.js\"></script>\n" +
"        <script src=\"plugins/easing/easing.js\"></script>\n" +
"        <script src=\"js/custom.js\"></script>\n" +
"    </body>";
        
        PrintWriter out = response.getWriter();
        JSONObject dataSession = new JSONObject();
        JSONObject object;
        JSONArray array;
        
        HttpSession session = request.getSession(false);
        if(session==null){
            response.sendRedirect(request.getContextPath() + "/login");
        } 
        else {
            dataSession = (JSONObject) session.getAttribute("login");
            
            try {
                object = home.getAllBook();
                String message = object.get("message").toString();
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println(header);
                out.println(navbar);            
                out.println(contentTop);
                
                if(message.equals("success")){
                    try {
                    array = object.getJSONArray("data");
                        for(int i = 0; i <= array.length(); i++){
                            JSONObject book = array.getJSONObject(i);
                            out.println("<div class=\"product-item "+ book.get("category").toString().toLowerCase() +"\">\n" +
"                                    <div class=\"product discount product_filter\">\n" +
"                                            <center><p class=\"product_name\">"+ book.get("author").toString() +"</p></center>\n" +
"                                        <div class=\"product_image\">\n" +
"                                            <center><img src=\"images/book.png\" alt=\"\" style='width:80%'></center>\n" +
"                                        </div>\n" +
//"                                        <div class=\"favorite favorite_left\"></div>\n" +
"                                        <div class=\"product_info\">\n" +
"                                            <h6 class=\"product_name\"><a href=\"detail?"+ book.get("id").toString() +"\">"+ book.get("name").toString() +"</a></h6>\n" +
"                                            <div class=\"product_price\"> Rp "+ book.get("price").toString() +"</div>\n" +
"                                        </div>\n" +
"                                    </div>\n" +
"                                </div>");
                        }
                    } catch (JSONException ex) {}
                }
                
                out.println(contentBottom);
                out.println(benefit);
                out.println(footer);
                out.println("</html>");
            } catch (Exception ex){
                ex.printStackTrace();
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
