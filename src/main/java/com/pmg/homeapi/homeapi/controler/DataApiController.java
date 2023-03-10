package com.pmg.homeapi.homeapi.controler;

import com.pmg.homeapi.api.DataApi;
import com.pmg.homeapi.homeapi.model.DataDocument;
import com.pmg.homeapi.homeapi.repository.DataCrudRepository;
import com.pmg.homeapi.model.Data;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Slf4j
@Controller
public class DataApiController implements DataApi {

    @Autowired
    DataCrudRepository dataCrudRepository;

    @Override
    public ResponseEntity<Data> addData(@ApiParam(value = "Add a new data to the database" ,required=true )
                                            @Valid @RequestBody Data data) {
        dataCrudRepository.save(dataToDataDocument(data));
        writeLog(data);
        return ResponseEntity.ok(data);
    }

    private void writeLog(Data data) {
        log.info("Almacenado:");
        log.info(String.format("Fecha: %s", data.getDate()));
        log.info(String.format("Temperatura: %f", data.getTemperature()));
        log.info(String.format("Humedad: %f", data.getHumidity()));
        log.info(String.format("Location: %s", data.getLocation()));
    }

    private DataDocument dataToDataDocument(Data data) {
        DataDocument dataDocument = new DataDocument();
        dataDocument.setDate(data.getDate());
        dataDocument.setHumidity(data.getHumidity());
        dataDocument.setTemperature(data.getTemperature());
        dataDocument.setLocation(data.getLocation());
        return dataDocument;
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
