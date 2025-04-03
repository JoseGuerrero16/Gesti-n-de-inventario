import controlador.AuthController;
import controlador.ProductoController;
import controlador.ReporteController;
import modelo.Database;
import vista.AuthView;
import vista.MenuPrincipal;
import vista.ProductoView;
import vista.ReporteView;

public class Main {
    public static void main(String[] args) {
        Database db = new Database();
        AuthView authView = new AuthView();
        AuthController authController = new AuthController(db, authView);
        
        // Autenticacion
        boolean autenticado = authController.autenticar();
        if (!autenticado) {
            System.exit(0);
        }
        
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        ProductoView productoView = new ProductoView();
        ProductoController productoController = new ProductoController(db, productoView);
        ReporteView reporteView = new ReporteView();
        ReporteController reporteController = new ReporteController(db, reporteView);
        
        // Menu principal
        boolean salir = false;
        while (!salir) {
            int opcion = menuPrincipal.mostrarMenu();
            
            switch (opcion) {
                case 1: // Gestion de Productos
                    productoController.mostrarMenu();
                    break;
                case 2: // Reportes
                    reporteController.mostrarReporte();
                    break;
                case 0: // Salir
                    salir = true;
                    menuPrincipal.mostrarMensaje("Sesion finalizada");
                    break;
                default:
                    menuPrincipal.mostrarMensaje("Opcion no valida");
            }
        }
    }
}
