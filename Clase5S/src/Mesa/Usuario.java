package Mesa;

public class Usuario {

private Integer id;
private String esPremium;

    public Usuario(Integer id, String esPremium) {
        this.id = id;
        this.esPremium = esPremium;
    }

    public Integer getId() {
        return id;
    }

    public String EsPremium() {
        return esPremium;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEsPremium(String esPremium) {
        this.esPremium = esPremium;
    }
}
