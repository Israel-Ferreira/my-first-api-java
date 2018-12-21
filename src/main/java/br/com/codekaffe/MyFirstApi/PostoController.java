package br.com.codekaffe.MyFirstApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


}
