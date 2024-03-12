package ma.zs.zyn.integration.core.inscription.inscription-state;

import com.intuit.karate.junit4.Karate;
import org.junit.runner.RunWith;

public class InscriptionStateIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("InscriptionStateHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
