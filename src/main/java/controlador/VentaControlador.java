package controlador;

import Modelo.Cliente;
import Modelo.Producto;
import Modelo.Venta;
import com.sun.org.slf4j.internal.Logger;
import dao.ClienteDAO;
import dao.ClienteDAOimpl;
import dao.ProductoDAO;
import dao.ProductoDAOimpl;
import dao.VentaDAO;
import dao.VentaDAOimpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

@WebServlet(name = "VentaControlador", urlPatterns = {"/VentaControlador"})
public class VentaControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            VentaDAO dao = new VentaDAOimpl();
            ProductoDAO daoProducto = new ProductoDAOimpl();
            ClienteDAO daoCliente = new ClienteDAOimpl();
            int id;
            List<Producto> lista_productos = null;
            List<Cliente> lista_clientes = null;
            Venta venta = new Venta();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    lista_productos = daoProducto.getAll();
                    lista_clientes = daoCliente.getAll();
                    request.setAttribute("lista_productos", lista_productos);
                    request.setAttribute("lista_clientes", lista_clientes);
                    request.setAttribute("venta", venta);
                    request.getRequestDispatcher("frmventa.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    venta = dao.getById(id);
                    lista_productos = daoProducto.getAll();
                    lista_clientes = daoCliente.getAll();
                    request.setAttribute("lista_productos", lista_productos);
                    request.setAttribute("lista_clientes", lista_clientes);
                    request.setAttribute("venta", venta);
                    request.getRequestDispatcher("frmventa.jsp").forward(request, response);
                    break;
                case "delete":
                     id=Integer.parseInt(request.getParameter("id"));
                      dao.delete(id);
                      response.sendRedirect("VentaControlador");
                    break;
                case "view":
                    List<Venta> lista = dao.getAll();
                    request.setAttribute("ventas", lista);
                    request.getRequestDispatcher("ventas.jsp").forward(request, response);
                    break;
            }

        } catch (Exception ex) {
            System.out.println("error" + ex.getMessage());

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        int cliente_id = Integer.parseInt(request.getParameter("cliente_id"));
        int producto_id = Integer.parseInt(request.getParameter("producto_id"));
        String fecha = request.getParameter("fecha");
        Venta venta = new Venta();

        venta.setId(id);
        venta.setProducto_id(producto_id);
        venta.setCliente_id(cliente_id);
        try {
            venta.setFecha(convierteFecha(fecha));
        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(VentaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (id == 0) {
            VentaDAO dao = new VentaDAOimpl();
            try {
                dao.insert(venta);
                response.sendRedirect("VentaControlador");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al insertar dato" + ex.getMessage());
            }
        } else {
            VentaDAO dao = new VentaDAOimpl();
            try {
                dao.update(venta);
                response.sendRedirect("VentaControlador");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al insertar dato" + ex.getMessage());
            }
        }

    }

    public Date convierteFecha(String fecha) throws ParseException {
        Date fechaBD = null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

        java.util.Date fechaTMP;
        try {
            fechaTMP = formato.parse(fecha);
            fechaBD = new Date(fechaTMP.getTime());
        } catch (ParseException ex) {

        }
        return fechaBD;
    }

}
