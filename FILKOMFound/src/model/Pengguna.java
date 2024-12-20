package model;

public class Pengguna {
    private int idPengguna;
    private String username;
    private String email;
    private String password1;
    private String password2;

    public Pengguna(int idPengguna, String username, String email, String password1, String password2){
        this.idPengguna = idPengguna;
        this.username = username;
        this.email = email;
        this.password1 = password1;
        this.password2 = password2;
    }

    public Pengguna(String username, String email, String password1, String password2){
        this.username = username;
        this.email = email;
        this.password1 = password1;
        this.password2 = password2;
    }

    public Pengguna(String username, String email, String password1){
        this.username = username;
        this.email = email;
        this.password1 = password1;
    }

    public Pengguna(String username, String password1){
        this.username = username;
        this.password1 = password1;
    }

    public int getIdPengguna() {
        return idPengguna;
    }

    public void setIdPengguna(int idPengguna) {
        this.idPengguna = idPengguna;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
}
