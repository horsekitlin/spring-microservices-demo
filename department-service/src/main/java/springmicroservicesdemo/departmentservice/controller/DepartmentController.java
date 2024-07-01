package springmicroservicesdemo.departmentservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springmicroservicesdemo.departmentservice.dto.DepartmentDto;
import springmicroservicesdemo.departmentservice.service.DepartmentService;

@Tag(
        name="Department Service - DepartmentController",
        description = "Department Controller Exposes REST APIs for Department-Service"
)
@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {
    private DepartmentService departmentService;

    @Operation(
            summary = "Save Department REST API",
            description = "Save Department REST API is used to save department object in a database"
    )
    @ApiResponse(
            responseCode="201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
        DepartmentDto savedDepartmentDto = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<DepartmentDto>(savedDepartmentDto, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Department REST API",
            description = "Get Department REST API is used to get department object in a database"
    )
    @ApiResponse(
            responseCode="200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping("{departmentCode}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable String departmentCode) {
        DepartmentDto departmentDto = departmentService.getDepartmentByDepartmentCode(departmentCode);
        return new ResponseEntity<DepartmentDto>(departmentDto, HttpStatus.OK);
    }
}
