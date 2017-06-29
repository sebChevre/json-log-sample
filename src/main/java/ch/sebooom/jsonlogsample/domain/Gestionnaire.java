package ch.sebooom.jsonlogsample.domain;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
public class Gestionnaire {

    private int id;
    private String login;

    public Gestionnaire(int id,String login){
        this.id = id;
        this.login = login;
    }

    public int id() {
        return id;
    }

    public String login() {
        return login;
    }
}
