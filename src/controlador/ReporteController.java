package controlador;

import vista.ReporteView;
import java.util.List;
import modelo.Database;
import modelo.Producto;

public class ReporteController {
    private Database db;
    private ReporteView view;
    
    public ReporteController(Database db, ReporteView view) {
        this.db = db;
        this.view = view;
    }
    
    public void mostrarReporte() {
        int totalProductos = db.getTotalProductos();
        double valorTotal = db.getValorTotalInventario();
        List<Producto> agotados = db.getProductosAgotados();
        
        view.mostrarReporte(totalProductos, valorTotal, agotados);
    }
}