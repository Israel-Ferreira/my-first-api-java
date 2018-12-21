package br.com.codekaffe.MyFirstApi;

import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PostoController {
    @Autowired
    private PostoRespository postoRespository;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public Greeting greeting() {
        return new Greeting();
    }


    @RequestMapping(method = RequestMethod.GET, value = "/api/postos")
    public List<Posto> getPostos() {
        return postoRespository.getAllPostos();
    }


    @RequestMapping(method = RequestMethod.GET, value = "/api/postos/{id}")
    public Posto getPostoById(@PathVariable String id) {
        return postoRespository.getPostoById(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/api/postos/{id}")
    public String deletePosto(@PathVariable String id) {
        Posto posto = postoRespository.getPostoById(id);
        postoRespository.delete(posto);

        return "Posto deletado com sucesso";
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/api/postos/{id}")
    public String updatePosto(@PathVariable String id, @Valid @RequestBody Posto posto){
        Posto posto1 = postoRespository.getPostoById(id);

        posto1.setNomeDoPosto(posto.getNomeDoPosto());
        posto1.setLatitude(posto.getLatitude());
        posto1.setLongitude(posto.getLongitude());
        posto1.setEndereco(posto.getEndereco());

        postoRespository.save(posto1);

        return "Posto Atualizado com sucesso";
    }

    @RequestMapping(method = RequestMethod.POST,value = "/api/postos/newPosto")
    public String addPosto(@Valid @RequestBody Posto posto){
        postoRespository.save(posto);
        return "Posto Criado com sucesso";
    }

}
