package Beans;

/**
 * @author Marine V
 */
public class Tchat {

    private Integer id_tchat;
    private String userName;
    private String message;

    public Integer getId_tchat() {
        return id_tchat;
    }

    public void setId_tchat(Integer id_tchat) {
        this.id_tchat = id_tchat;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Tchat(Integer id_tchat, String userName, String message) {
        this.id_tchat = id_tchat;
        this.userName = userName;
        this.message = message;
    }

    public Tchat() {
    }


}
