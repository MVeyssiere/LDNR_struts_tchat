<%-- 
    Document   : tchatContent
    Created on : 23 mai 2019, 10:51:49
    Author     : Marine Veyssiere
--%>

<section>
    <%-- affichage du formulaire pour écrire un message --%>
    <s:form action="tchat">
        <s:textfield name="userName" label="%{getText('Nom')}" maxlength="25"/>
        <s:textarea key="Message" maxlength="25"/>
        <s:submit value="%{getText('Poster')}"/>
    </s:form>
    
    <%--affichage des messages --%>
    <s:iterator value="list">
        <s:property value="userName"/>  <br/>
        <s:property value="message"/>
    </s:iterator>
</section>