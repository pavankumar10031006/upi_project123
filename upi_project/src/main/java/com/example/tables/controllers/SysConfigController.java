package com.example.tables.controllers;

import com.example.tables.models.DataTablePayloadModel;
import com.example.tables.models.FilterModel;
import com.example.tables.models.ResponsePojo;
import com.example.tables.models.SysConfigModel;
import com.example.tables.models.UpiHostModel;
import com.example.tables.models.UpiSmsModel;
import com.example.tables.services.SysConfigService;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        logger.info("Received request at root endpoint.");
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

    @PutMapping("/updateSysTable")
    public ResponseEntity<?> updateSysTable(@RequestBody SysConfigModel payload) {
        logger.debug("Received PUT request to updateSysTable with payload: {}", payload);
        try {
            sysConfigService.updateSysConfig(payload);
            logger.info("SysConfig updated successfully.");
            return ResponseEntity.ok("SysConfig updated successfully.");
        } catch (Exception e) {
            logger.error("Error occurred while updating SysConfig", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal Server Error: " + e.getMessage());
        }
    }

    @PutMapping("/updateUpiHostTable")
    public ResponseEntity<?> updateUpiHostTable(@RequestBody UpiHostModel payload) {
        logger.info("Received PUT request to updateUpiHostTable with payload: {}", payload);
        try {
            sysConfigService.updateUpiHostTable(payload);
            logger.info("UpiHostTable updated successfully.");
            return ResponseEntity.ok("Table updated successfully.");
        } catch (Exception e) {
            logger.error("Error occurred while updating UpiHostTable", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal Server Error: " + e.getMessage());
        }
    }

    @PutMapping("/updateUpiSmsTable")
    public ResponseEntity<?> updateUpiSmsTable(@RequestBody UpiSmsModel payload) {
        logger.info("Received PUT request to updateUpiSmsTable with payload: {}", payload);
        try {
            sysConfigService.updateUpiSmsTable(payload);
            logger.info("UpiSmsTable updated successfully.");
            return ResponseEntity.ok("Table updated successfully.");
        } catch (Exception e) {
            logger.error("Error occurred while updating UpiSmsTable", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal Server Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/sysConfig/{id}")
    public ResponseEntity<?> deleteConfig(@PathVariable String id) {
        logger.info("Delete request received for config ID: {}", id);

        try {
            boolean deleted = sysConfigService.deleteConfigById(id);
            if (deleted) {
                logger.info("Successfully deleted config with ID: {}", id);
                return ResponseEntity.ok("Record deleted successfully");
            } else {
                logger.warn("No record found with ID: {}", id);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record not found");
            }
        } catch (Exception e) {
            logger.error("Error deleting record with ID: {}", id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }

    @DeleteMapping("/upiHost/{id}")
    public ResponseEntity<?> deleteupiHost(@PathVariable Long id) {
        logger.info("Delete request received for upiHost ID: {}", id);

        try {
            boolean deleted = sysConfigService.deleteupiHostById(id);
            if (deleted) {
                logger.info("Successfully deleted UpiHost with ID: {}", id);
                return ResponseEntity.ok("Record deleted successfully");
            } else {
                logger.warn("No UpiHost record found with ID: {}", id);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record not found");
            }
        } catch (Exception e) {
            logger.error("Error deleting UpiHost with ID: {}", id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }

    @DeleteMapping("/upiSms/{id}")
    public ResponseEntity<?> deleteupiSms(@PathVariable Long id) {
        logger.info("Delete request received for upiSms ID: {}", id);

        try {
            boolean deleted = sysConfigService.deleteupiSmsById(id);
            if (deleted) {
                logger.info("Successfully deleted UpiSms with ID: {}", id);
                return ResponseEntity.ok("Record deleted successfully");
            } else {
                logger.warn("No UpiSms record found with ID: {}", id);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record not found");
            }
        } catch (Exception e) {
            logger.error("Error deleting UpiSms with ID: {}", id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }

    @PostMapping("/searchSysDataTable")
    public ResponseEntity<?> searchSysDataTable(@PathVariable Long id) {
        logger.info("SearchSysDataTable called with ID: {}", id);

        try {
            // Assuming this is a stubbed method for now
            logger.warn("Stub method hit for /searchSysDataTable. Returning NOT_FOUND.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record not found");
        } catch (Exception e) {
            logger.error("Error occurred while searching in /searchSysDataTable", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }
}
