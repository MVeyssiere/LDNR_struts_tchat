package Actions;

import Beans.Tchat;
import DAO.DAOTchat;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

/**
 * @author Marine V
 */
public class tchatAction extends ActionSupport {

    private String userName = "";
    private String message = "";
    List<Tchat> list = null;

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

    public List<Tchat> getList() {
        return list;
    }

    public void setList(List<Tchat> list) {
        this.list = list;
    }

    @Override
    public String execute() throws Exception {
        DAOTchat daoTchat = new DAOTchat();
        Tchat tchat = new Tchat();

        tchat.setUserName(userName);
        System.out.println(userName);
        tchat.setMessage(message);

        daoTchat.create(tchat);

        list = daoTchat.findAll();

        return SUCCESS;
    }

}
