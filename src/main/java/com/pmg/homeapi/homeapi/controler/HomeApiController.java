package com.pmg.homeapi.homeapi.controler;

import com.pmg.homeapi.api.DataApi;
import com.pmg.homeapi.homeapi.model.DataDocument;
import com.pmg.homeapi.homeapi.repository.DataCrudRepository;
import com.pmg.homeapi.model.Data;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeApiController implements DataApi {

    @Autowired
    DataCrudRepository dataCrudRepository;

    @Override
    public ResponseEntity<Data> addData(@ApiParam(value = "Add a new data to the database" ,required=true )  @Valid @RequestBody Data data) {
        DataDocument dataDocument = new DataDocument();
        dataDocument.setDate(data.getDate().toString());
        dataDocument.setHumidity(data.getHumidity());
        dataDocument.setTemperature(data.getTemperature());
        dataDocument.setLocation(data.getLocation());
        dataCrudRepository.save(dataDocument);
        System.out.println("Almacenado:");
        System.out.printf("Fecha: %s%n", data.getDate());
        System.out.printf("Temperatura: %f%n", data.getTemperature());
        System.out.printf("Humedad: %f%n", data.getHumidity());
        System.out.printf("Location: %s%n", data.getLocation());
        return ResponseEntity.ok(data);
    }




}
