// En src/vista/AuthViewMock.java
package vista;

public class AuthViewMock extends AuthView {
    private String[] nextCredentials;
    
    public void setNextCredentials(String[] creds) {
        this.nextCredentials = creds;
    }
    
    @Override
    public String[] mostrarLogin() {
        return nextCredentials;
    }
}