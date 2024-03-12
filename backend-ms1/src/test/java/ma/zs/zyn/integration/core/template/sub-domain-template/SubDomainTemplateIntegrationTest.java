package ma.zs.zyn.integration.core.template.sub-domain-template;

import com.intuit.karate.junit4.Karate;
import org.junit.runner.RunWith;

public class SubDomainTemplateIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("SubDomainTemplateHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
