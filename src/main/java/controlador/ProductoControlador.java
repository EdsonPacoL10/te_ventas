package controlador;

import Modelo.Producto;
import dao.ProductoDAO;
import dao.ProductoDAOimpl;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
@WebServlet(name = "ProductoControlador", urlPatterns = {"/ProductoControlador"})
public class ProductoControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Producto pro = new Producto();
            int id;
            ProductoDAO dao = new ProductoDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    request.setAttribute("producto", pro);
                    request.getRequestDispatcher("frmproducto.jsp").forward(request, response);
                    break;
                case "edit":
                   id=Integer.parseInt(request.getParameter("id"));
                   pro=dao.getById(id);
                   request.setAttribute("producto", pro);
                    request.getRequestDispatcher("frmproducto.jsp").forward(request, response);
                    break;
                case "delete":
                    id=Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("ProductoControlador");
                    break;
                case "view":
                    List<Producto> lista = dao.getAll();
                    request.setAttribute("productos", lista);
                    request.getRequestDispatcher("productos.jsp").forward(request, response);
                    break;
            }

        } catch (Exception ex) {
            System.out.println("error" + ex.getMessage());

        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     int id=Integer.parseInt(request.getParameter("id"));
        String nombre =request.getParameter("nombre");
         String descripcion =request.getParameter("descripcion");
         String precio =request.getParameter("precio");
         ProductoDAO dao = new ProductoDAOimpl();
         Producto pro= new Producto();
         
         pro.setId(id);
         pro.setNombre(nombre);
         pro.setDescripcion(descripcion);
         pro.setPrecio(Float.parseFloat( precio));
         
         if (id==0) {
                        
            try {
                dao.insert(pro);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Error al insertar dato"+ex.getMessage());
            }
        }else{
            try {
                dao.update(pro);
            } catch (Exception ex) {
                          JOptionPane.showMessageDialog(null,"Error al editar"+ex.getMessage());
            }
         }
         response.sendRedirect("ProductoControlador");
         
         
        

    }
}
