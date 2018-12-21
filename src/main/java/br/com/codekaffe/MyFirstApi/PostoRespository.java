package br.com.codekaffe.MyFirstApi;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PostoRespository extends MongoRepository<Posto, String> {
    @Query("{}")
    List<Posto> getAllPostos();

    Posto getPostoById(String id);


}
