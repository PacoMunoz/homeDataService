package com.pmg.homeapi.homeapi.repository;

import com.pmg.homeapi.homeapi.model.DataDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface DataCrudRepository extends MongoRepository<DataDocument, String> {

    List<DataDocument> find

}
