package ch.sebooom.jsonlogsample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.MethodInvocationException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static net.logstash.logback.marker.Markers.appendEntries;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
@Component
public class WorkMock {

    Logger LOGGER = LoggerFactory.getLogger(WorkMock.class);

    //Executes each 500 ms
    @Scheduled(fixedRate=900)
    public void domain() {
        RandomDomainEventGenerator random = RandomDomainEventGenerator.generateEvent();
        Map suppFields = new HashMap();
        suppFields.put("log_type", "DOMAIN");
        suppFields.put("demande_id", random.demande().id());
        suppFields.put("affilie_id", random.demande().affilie().id());
        suppFields.put("gestionnaire_id",random.gestionnaire().id());
        //logger.info(appendEntries(myMap), "log message");
        log(suppFields,String.valueOf(random.event()));
    }

    //Executes each 500 ms
    @Scheduled(fixedRate=500)
    public void technical() {
        RandomDomainEventGenerator random = RandomDomainEventGenerator.generateEvent();
        Map suppFields = new HashMap();
        suppFields.put("log_type", "TECHNICAL");
        suppFields.put("demande_id", random.demande().id());
        suppFields.put("affilie_id", random.demande().affilie().id());
        suppFields.put("gestionnaire_id",random.gestionnaire().id());

        //logger.info(appendEntries(myMap), "log message");
        log(suppFields,String.valueOf(random.event()));
    }

    private void log(Map suppFields,String msg){
        int levelIdx = new Random().nextInt(10);

        switch (levelIdx){
            case 0:
            case 1:
            case 2:
            case 3:
            case 6:
            case 7:
            case 8:LOGGER.info(appendEntries(suppFields),msg);
            break;

            case 4:
            case 5:LOGGER.warn(appendEntries(suppFields),msg);
            break;

            case 9:{
                suppFields.put("exception class",getRandomException());
                LOGGER.error(appendEntries(suppFields),msg);
            }




        }
    }


    public String getRandomException() {

        int levelIdx = new Random().nextInt(5);

        switch (levelIdx) {
            case 0:
                return IllegalArgumentException.class.getName();
            case 1:
                return StackOverflowError.class.getName();
            case 2:
                return ArithmeticException.class.getName();
            case 3:
                return MethodInvocationException.class.getName();
        }

        return null;
    }
}
