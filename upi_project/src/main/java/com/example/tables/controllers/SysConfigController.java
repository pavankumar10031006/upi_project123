package com.example.tables.controllers;

import com.example.tables.models.DataTablePayloadModel;
import com.example.tables.models.FilterModel;
import com.example.tables.models.ResponsePojo;
import com.example.tables.services.SysConfigService;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping()
public class SysConfigController {

    private static final Logger logger = LogManager.getLogger(SysConfigController.class);

    @Autowired
    private SysConfigService sysConfigService;

    @GetMapping()
    public String initialCallApi() {
        return "Hello developer Welcome";
    }

    @PostMapping("/tableData")
    public ResponseEntity<?> getTableData(@RequestBody DataTablePayloadModel payload) {
        logger.info("Received request for /tableData with payload: {}", payload);

        try {
            String tableCode = payload.getTableCode();
            int limit = payload.getLimit();
            int offset = payload.getOffset();   
            String sortColumn = payload.getSort() != null ? payload.getSort().getColumn() : null;
            String sortDirection = payload.getSort() != null ? payload.getSort().getDirection() : null;
            List<FilterModel> filters = payload.getFilters();

            logger.debug(
                    "Extracted Params - tableCode: {}, limit: {}, offset: {}, sortColumn: {}, sortDirection: {}, filters: {}",
                    tableCode, limit, offset, sortColumn, sortDirection, filters);

            ResponsePojo result = sysConfigService.getFilteredTableDataSYS(
                    tableCode, limit, offset, sortColumn, sortDirection, filters);

            logger.info("Successfully retrieved table data for tableCode: {}", tableCode);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            logger.error("Error occurred while processing /tableData request", e);
            return ResponseEntity.badRequest().body("Internal Server Error");
        }
    }
}
