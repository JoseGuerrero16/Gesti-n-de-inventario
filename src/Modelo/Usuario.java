package modelo;

public class Usuario {
    private String username;
    private String password;
    
    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    // Getters
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    
    // Metodo verificar credenciales
    public boolean verificarCredenciales(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
}