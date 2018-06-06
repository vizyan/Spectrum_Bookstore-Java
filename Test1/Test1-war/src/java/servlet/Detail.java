/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Bean.Home.HomeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Vizyan
 */
@WebServlet(name = "detail", urlPatterns = {"/detail"})
public class Detail extends HttpServlet {

    @EJB
    private HomeLocal home;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String header = "<head>\n" +
"           <title>Detail Buku</title>\n" +
"           <meta charset=\"utf-8\">\n" +
"           <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
"           <meta name=\"description\" content=\"Colo Shop Template\">\n" +
"           <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
"           <link rel=\"stylesheet\" type=\"text/css\" href=\"styles/bootstrap4/bootstrap.min.css\">\n" +
"           <link href=\"plugins/font-awesome-4.7.0/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\">\n" +
"           <link rel=\"stylesheet\" type=\"text/css\" href=\"plugins/OwlCarousel2-2.2.1/owl.carousel.css\">\n" +
"           <link rel=\"stylesheet\" type=\"text/css\" href=\"plugins/OwlCarousel2-2.2.1/owl.theme.default.css\">\n" +
"           <link rel=\"stylesheet\" type=\"text/css\" href=\"plugins/OwlCarousel2-2.2.1/animate.css\">\n" +
"           <link rel=\"stylesheet\" href=\"plugins/themify-icons/themify-icons.css\">\n" +
"           <link rel=\"stylesheet\" type=\"text/css\" href=\"plugins/jquery-ui-1.12.1.custom/jquery-ui.css\">\n" +
"           <link rel=\"stylesheet\" type=\"text/css\" href=\"styles/single_styles.css\">\n" +
"           <link rel=\"stylesheet\" type=\"text/css\" href=\"styles/single_responsive.css\">\n" +
"    </head>";
        
        String navbar = "";
        
        
        
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
"<script src=\"js/jquery-3.2.1.min.js\"></script>\n" +
"<script src=\"styles/bootstrap4/popper.js\"></script>\n" +
"<script src=\"styles/bootstrap4/bootstrap.min.js\"></script>\n" +
"<script src=\"plugins/Isotope/isotope.pkgd.min.js\"></script>\n" +
"<script src=\"plugins/OwlCarousel2-2.2.1/owl.carousel.js\"></script>\n" +
"<script src=\"plugins/easing/easing.js\"></script>\n" +
"<script src=\"plugins/jquery-ui-1.12.1.custom/jquery-ui.js\"></script>\n" +
"<script src=\"js/single_custom.js\"></script>"+
"    </body>";
        
        String contentBottom ="</div>\n" +
                            "</div>\n" +
                            "</div>\n" +
                            "</div>";
        
        String popup = "";
        
        String contentTop;
        String setStock;
        String contentMid;
        
        String id = request.getQueryString();
        JSONObject object = home.getBookById(Integer.parseInt(id));
        JSONObject data = new JSONObject();
        PrintWriter out = response.getWriter();
        Date time = new Date();
        Date now = new Date();;
        
        HttpSession session = request.getSession(false);
        if(session==null){
            response.sendRedirect(request.getContextPath() + "/login");
        } else {
        
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println(header);
            
            
            String message = object.get("message").toString();
            if(message.equals("success")){
                data = object.getJSONObject("data");
                
                navbar ="<body style=\"width: 100%; height: 100%\">\n" +
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
                    "<li><a href=\"login\">Home</a></li>\n" +
                    "<li><a href=\"chart\">Cart</a></li>\n" +
                    "<li class=\"account\">\n" +
                    "<a href=\"logout\">\n" +
                    "Logout\n" +
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
                    "<a href=\"logout\">\n" +
                    "Logout\n" +
                    "</li>\n" +
                    "<li class=\"menu_item\"><a href=\"login\">Home</a></li>\n" +
                    "<li class=\"menu_item\"><a href=\"chart\">Cart</a></li>\n" +
                    "</ul>\n" +
                    "</div>\n" +
                    "</div>";
                
                contentTop = "<div class=\"container single_product_container\" style='padding-top:3%' >\n" +
                                "                <div class=\"row\">\n" +
                                "                    <div class=\"col-lg-7\">\n" +
                                "                        <div class=\"single_product_pics\">\n" +
                                "                            <div class=\"row\">\n" +
                                "                                <div class=\"col-lg-3 thumbnails_col order-lg-1 order-2\">\n" +
                                "                                    <div class=\"single_product_thumbnails\">\n" +
                                "                                        <ul>\n" +
                                "                                            <li><img src=\"images/book.png\" alt=\"\" data-image=\"images/book.png\"></li>\n" +
                                "                                        </ul>\n" +
                                "                                    </div>\n" +
                                "                                </div>\n" +
                                "                                <div class=\"col-lg-9 image_col order-lg-2 order-1\">\n" +
                                "                                    <div class=\"single_product_image\">\n" +
                                "                                        <div class=\"single_product_image_background\" style=\"background-image:url(images/book.png)\"></div>\n" +
                                "                                    </div>\n" +
                                "                                </div>\n" +
                                "                            </div>\n" +
                                "                        </div>\n" +
                                "                    </div>\n" +
                                "                    <div class=\"col-lg-5\">\n" +
                                "                        <div class=\"product_details\">\n" +
                                "                            <div class=\"product_details_title\">\n" +
                                "                                <h2>"+ data.get("name").toString() +"</h2>\n" +
                                //"                                <p>Nam tempus turpis at metus scelerisque placerat nulla deumantos solicitud felis. Pellentesque diam dolor, elementum etos lobortis des mollis ut...</p>\n" +
                                "                            </div>\n" +
                                "                            <div class=\"free_delivery d-flex flex-row align-items-center justify-content-center\">\n" +
                                "                                <span> </span>Pengarang :\n" + data.get("author").toString() +
                                "                            </div>\n" +
                                "                            <div class=\"align-items-center justify-content-center\">\n" +
                                "                                <p></p>\n" +
                                "                                <h6>Kategori : " + data.get("category").toString() +"</h6>";
                
                setStock = "<h6>Stok : " + data.get("stock").toString() +"</h6>";
                
                contentMid =
                                "                            </div>\n" +
                                "                            <p></p>\n" +
                                "                            <div class=\"product_price\"> Rp " + data.get("price") +"</div>\n" +
                                "                            <form action='detail?"+id+"' method='post'>\n" +
                                "                                <div class=\"quantity d-flex flex-column flex-sm-row align-items-sm-center\">\n" +
                                "                                    <input id=\"newsletter_email\" type=\"number\" name='much' placeholder=\"Jumlah\" required=\"required\">\n" +
                                "                                    <div>&nbsp;&nbsp;</div>\n" +
                                "                                    <input id=\"newsletter_submit\" type=\"submit\" class=\"button newsletter_submit_btn trans_300\" name=\"cart\" value=\"Tambah ke chart\">\n" +
                                "                                </div>\n" +
                                "                            </form>\n";
                
                HttpSession checkChart = null;
                String exx = "";
                JSONArray chartBooks = new JSONArray();
                JSONObject objectBook = new JSONObject(); 
                JSONObject checkBook = new JSONObject(); 
                JSONObject chartBook = new JSONObject();
                
                if (request.getParameter("cart") != null) {
                    int much = Integer.parseInt(request.getParameter("much"));
                    int how = Integer.parseInt(data.get("stock").toString());
                    if(much>how){
                        popup = "<div class=\"free_delivery d-flex flex-row align-items-center justify-content-center\" style='background-color:red'>\n" +
                                "<center><p></p><p style='color:white'> Maaf pesanan melebihi stok</p></center>" +
                                "</div>\n";
                        
                    } else {
                        checkChart = request.getSession(false);
                        chartBook = new JSONObject();
                        checkBook = (JSONObject) checkChart.getAttribute("chart");
                        
                        if(checkBook!=null){
                           chartBooks = checkBook.getJSONArray("books");
                        }
                           
                        Date date = new Date();
                        int minute = date.getMinutes();
                        
                        chartBook.put("id", id);
                        chartBook.put("name", data.get("name").toString());
                        chartBook.put("author", data.get("author").toString());
                        chartBook.put("much", much);
                        chartBook.put("stock", data.get("stock"));
                        chartBook.put("price", data.get("price"));
                        
                        chartBooks.put(chartBook);
                        objectBook.put("books", chartBooks);
                        objectBook.put("time", minute);
                        
                        HttpSession createSession;
                        createSession = request.getSession();
                        createSession.setAttribute("chart", objectBook);
                                                
                        popup = "<div class=\"free_delivery d-flex flex-row align-items-center justify-content-center\" style='background-color:deepskyblue'>\n" +
                                "<center><p></p><p style='color:white'>Berhasil menambah chart </p></center>" +
                                "</div>\n";
                    }
                }
                
                out.println(navbar);
                out.println(contentTop);
                out.println(setStock);
                out.println(contentMid);
                out.println(popup);
                out.println(contentBottom);
                
            }
            
            out.println(benefit);
            out.println(footer);
            out.println("</html>");
        } catch (JSONException ex) {
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
