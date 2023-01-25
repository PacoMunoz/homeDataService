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
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Controller
public class DataApiController implements DataApi {

    @Autowired
    DataCrudRepository dataCrudRepository;

    @Override
    public ResponseEntity<Data> addData(@ApiParam(value = "Add a new data to the database" ,required=true )
                                            @Valid @RequestBody Data data) {
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

    @Override
    public ResponseEntity<Data> getLastTempByLoc(@NotNull @ApiParam(value = "the location you want retrieve data from",
            required = true) @Valid @RequestParam(value = "location", required = true) String location) {
        List<DataDocument> datos = dataCrudRepository.findAll();
        DataDocument dataDocument = datos.get(0);
        Data data = new Data();
        data.setTemperature(dataDocument.getTemperature());
        data.setHumidity(dataDocument.getHumidity());
        data.setLocation(dataDocument.getLocation());
        data.setDate(dataDocument.getDate());
        return ResponseEntity.ok(data);
    }
}
