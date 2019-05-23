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
        tchat.setMessage(message);

        //lors de la soumission du formulaire, la methode create de la DAO sera appellée
        daoTchat.create(tchat);

        // une liste contenant tous le contenu du tchat sera affiché dans le tchatContent
//        list = daoTchat.findLastFiveMinutes();
        list = daoTchat.findLastFiveMinutes();

        return SUCCESS;
    }

}
