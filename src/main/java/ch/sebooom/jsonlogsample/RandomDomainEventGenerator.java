package ch.sebooom.jsonlogsample;

import ch.sebooom.jsonlogsample.domain.Affilie;
import ch.sebooom.jsonlogsample.domain.Demande;
import ch.sebooom.jsonlogsample.domain.DomainEvents;
import ch.sebooom.jsonlogsample.domain.Gestionnaire;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
public class RandomDomainEventGenerator {

    private static final int maxDemandeId = 20;
    private static final int maxAffilieId = 20;
    private static List<Gestionnaire> gestionnaireList;
    private static List<Demande> demandesList;
    private static List<Affilie> affilieListList;

    static{
        gestionnaireList = new ArrayList<>();
        gestionnaireList.add(new Gestionnaire(312,"sdr"));
        gestionnaireList.add(new Gestionnaire(352,"srf"));
        gestionnaireList.add(new Gestionnaire(719,"dde"));
        gestionnaireList.add(new Gestionnaire(992,"xcd"));
        gestionnaireList.add(new Gestionnaire(792,"wwe"));
        gestionnaireList.add(new Gestionnaire(342,"dhi"));
        gestionnaireList.add(new Gestionnaire(116,"dma"));
        gestionnaireList.add(new Gestionnaire(565,"sce"));

        demandesList = new ArrayList<>();
        demandesList.add(new Demande(12,new Affilie(1)));
        demandesList.add(new Demande(345,new Affilie(2)));
        demandesList.add(new Demande(256,new Affilie(3)));
        demandesList.add(new Demande(67,new Affilie(4)));
        demandesList.add(new Demande(98,new Affilie(5)));
        demandesList.add(new Demande(89,new Affilie(6)));
        demandesList.add(new Demande(333,new Affilie(7)));
        demandesList.add(new Demande(531,new Affilie(8)));
        demandesList.add(new Demande(999,new Affilie(9)));
        demandesList.add(new Demande(888,new Affilie(10)));
        demandesList.add(new Demande(111,new Affilie(11)));
        demandesList.add(new Demande(222,new Affilie(12)));
        demandesList.add(new Demande(542,new Affilie(13)));
        demandesList.add(new Demande(674,new Affilie(14)));
        demandesList.add(new Demande(901,new Affilie(15)));
        demandesList.add(new Demande(121,new Affilie(16)));
        demandesList.add(new Demande(123,new Affilie(17)));
        demandesList.add(new Demande(124,new Affilie(19)));

        demandesList.add(new Demande(246,new Affilie(9)));
        demandesList.add(new Demande(333,new Affilie(10)));
        demandesList.add(new Demande(902,new Affilie(11)));
        demandesList.add(new Demande(903,new Affilie(12)));
        demandesList.add(new Demande(125,new Affilie(13)));
        demandesList.add(new Demande(126,new Affilie(14)));
        demandesList.add(new Demande(127,new Affilie(15)));
        demandesList.add(new Demande(128,new Affilie(16)));
        demandesList.add(new Demande(129,new Affilie(17)));
        demandesList.add(new Demande(130,new Affilie(19)));

    }

    private Demande demande;
    private Gestionnaire gestionnaire;
    private DomainEvents event;

    private RandomDomainEventGenerator(Demande demande, Gestionnaire gestionnaire,DomainEvents event){
        this.gestionnaire = gestionnaire;
        this.demande = demande;
        this.event = event;
    }

    public DomainEvents event(){
        return event;
    }

    public Demande demande(){
        return demande;
    }

    public Gestionnaire gestionnaire(){
        return gestionnaire;
    }



    public static RandomDomainEventGenerator generateEvent(){
        int gestIndex = new Random().nextInt(8);
        int demandeIndex = new Random().nextInt(28);
        int eventIndex = new Random().nextInt(10);


        return new RandomDomainEventGenerator(demandesList.get(demandeIndex),
                gestionnaireList.get(gestIndex),
                DomainEvents.values()[eventIndex]);
    }
}
