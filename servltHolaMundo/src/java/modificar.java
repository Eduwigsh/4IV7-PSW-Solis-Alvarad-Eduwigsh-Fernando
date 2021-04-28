/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.servlet.ServletConfig;

/**
 *
 * @author eduwi
 */
@WebServlet(urlPatterns = {"/modificar"})
public class modificar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     private Connection con;
    private Statement set;
    private ResultSet rs;
    int id;
    public void init(ServletConfig cfc) throws ServletException{
    String url="jdbc:mysql://localhost/registro4IV7";
    
    String userName="root";
    String password="f0rmajuerrera";
    
    try{
        Class.forName("com.mysql.jdbc.Driver");
        con= DriverManager.getConnection(url, userName, password);
        set=con.createStatement();
        System.out.println("se a conectado");
        
    }catch(Exception e){
           System.out.println("no se ha conectado");
           System.out.println(e.getMessage());
           System.out.println(e.getStackTrace());
    }
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet modificar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet modificar at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
                response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
              out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Modificar</title>");            
            out.println("</head>");
            out.println("<body>");
               out.println("<h1>Modifica los datos que necesites cambiar</h1>");
            try{
               String nom, appat, appmat, correo,q;
                int edad,id ; 
                
                
            id = Integer.parseInt(request.getParameter("idModificar"));
          q = "select  nom_usu, appat_usu, apmat_usu,edad_usu, email_usu from mregistro where id_usu = "+id;
           set = con.createStatement();
            rs = set.executeQuery(q);     
while(rs.next()){      
                    nom = rs.getString("nom_usu");
                    appat = rs.getString("appat_usu");
                    appmat = rs.getString("apmat_usu");
                    edad = rs.getInt("edad_usu");
                    correo = rs.getString("email_usu");

               out.println( "<form name='formulario' method='post'"
                +   "action='modificar'>"
                + "<label>ID:</label>"
                + "<input type='text' name='idModificar' value="+id+">"
                        + "<br>"
                +"<label>Nombre:</label>"
                +"<input type='text' name='nombre' value="+ nom +">"
                + "<br>"              
                + "<label>apellido paterno</label>"
                +"<input type='text' name='appat' value="+ appat +">"
                +"<br> <label> apellido materno</label>"
                +"<input type='text' name='appmat'value="+ appmat +">"
                +"<br> <label>edad</label>"
                +"<input type='number' name='edad' min='01' max='99' "
                +      "size='2' value="+ edad +">"
                + "<br> "
                + "<label>correo</label>"
                + " <input type='email' name='email'value="+ correo +">"
                +" <br>"
                +"<input type='submit' value='Enviar datos del registro'>"
                + " </form>    "
                        );
                              
}
             
            }catch(Exception e){
                out.println("<h1>ID no encotrada </h1>");
                System.out.println("Id inexistente ");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
            
            }

            out.println("<a href='index.html'>Regresar al Formulario</a>"
                    + "<br>"
                    + "<a href='Consultar'>Consultar la Tabla General de Usuarios</a>");
            out.println("</body>");
            out.println("</html>");
        }
      
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
response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet modificar</title>");  
             out.println("</head>");
            out.println("<body>");
               out.println("<h1>datos cambiados con exito </h1>");
            try{
              String nom, appat, appmat, correo,q;
                int edad ;
                id = Integer.parseInt(request.getParameter("idModificar"));
            edad = Integer.parseInt(request.getParameter("edad")); 
                nom = request.getParameter("nombre");
                appat = request.getParameter("appat");
                appmat = request.getParameter("appmat");
                correo = request.getParameter("email");
         
                    q = "update mregistro set nom_usu='"+nom+"',appat_usu='"+appat+"',apmat_usu='"+appmat+"'"
                            + ",edad_usu='"+edad+"', email_usu='"+correo+"'  where id_usu='"+id+"' ";
                    
                     set.executeUpdate(q);
            }
            catch(Exception e){
                 out.println("<h1>cambios no realizados</h1>");
                System.out.println("no se realizaron los cambios ");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
            }
                    
            out.println("<a href='index.html'>Regresar al Formulario</a>"
                    + "<br>"
                    + "<a href='Consultar'>Consultar la Tabla General de Usuarios</a>");
         
            out.println("</body>");
            out.println("</html>");
        }
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
