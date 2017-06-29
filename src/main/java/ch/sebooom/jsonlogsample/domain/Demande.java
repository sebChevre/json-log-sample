package ch.sebooom.jsonlogsample.domain;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
public class Demande {

    private int id;
    private Affilie affilie;


    public Demande(int id, Affilie affilie){
        this.id = id;
        this.affilie = affilie;
    }

    public int id(){
        return id;
    }

    public Affilie affilie(){
        return affilie;
    }

}
