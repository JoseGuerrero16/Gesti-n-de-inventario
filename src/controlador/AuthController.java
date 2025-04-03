package controlador;

import modelo.Database;
import modelo.Usuario;
import vista.AuthView;

public class AuthController {
    private Database db;
    private AuthView view;
    
    public AuthController(Database db, AuthView view) {
        this.db = db;
        this.view = view;
    }
    
    public boolean autenticar() {
        String[] credenciales = view.mostrarLogin();
        String username = credenciales[0];
        String password = credenciales[1];
        
        Usuario usuario = db.buscarUsuario(username);
        if (usuario != null && usuario.verificarCredenciales(username, password)) {
            view.mostrarMensaje("Bienvenido! " + username);
            return true;
        } else {
            view.mostrarMensaje("Usuario incorrecto");
            return false;
        }
    }
}