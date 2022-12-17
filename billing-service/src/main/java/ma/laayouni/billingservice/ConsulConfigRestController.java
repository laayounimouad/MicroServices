package ma.laayouni.billingservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ConsulConfigRestController {

    @Autowired
    private MyConsulConfig myConsulConfig;
    @Autowired
    private MyVaultConfig myVaultConfig;
    @GetMapping("/myConfig")
    public Map<String,Object> myConfig(){
        return Map.of("consul conf ",myConsulConfig,"vault conf",myVaultConfig);
    }

}
