<%-- 
    Document   : tchatContent
    Created on : 23 mai 2019, 10:51:49
    Author     : Marine Veyssiere
--%>

<section>
    <%-- affichage du formulaire pour écrire un message --%>
    <h3>Bienvenu sur le Tchat!</h3>
    <s:form action="tchat" class="form-group">
        <s:textfield name="userName" label="%{getText('Nom')}" maxlength="25" class="form-control" />
        <s:textarea key="Message" maxlength="25" class="form-control" rows="3" />
        <s:submit value="%{getText('Poster')}" class="btn btn-primary col-md" />
    </s:form>
    
    <%--affichage des messages --%>
    <table class="table table-striped">
        <thead>            
        </thead>
        <tbody>
            <s:iterator value="list">
                <tr>
                    <td> <s:property value="date_message"/></td>
                    <td> <s:property value="userName"/> </td>
                    <td> <s:property value="message" /></td>
                </tr>
        </s:iterator>            
        </tbody>        
    </table>
</section>