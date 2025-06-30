package mx.edu.utez.unidad3.modules.client;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import mx.edu.utez.unidad3.utils.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/client")
 @Tag( name = "Controlador de clientes ", description = "Operaciones relacionadas con cliente")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("")
    @Operation(summary = "Traer clientees", description = "Trae a todos los clientes registrados en el sistema")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Traer todos los clientes",
                            content = {
                                    @Content(mediaType = "application/json", schema = @Schema(implementation = APIResponse.class)),
                                    @Content(mediaType = "application/xml", schema = @Schema(implementation = APIResponse.class)),
                                    @Content(mediaType = "application/html", schema = @Schema(implementation = APIResponse.class))
                            })
            }
    )
    public ResponseEntity<APIResponse> findAll(){
        APIResponse response = clientService.findAll();
        return new ResponseEntity<>(response,response.getStatus());
    }
    @GetMapping("/{id}")
    @Operation(summary = "Traer un cliente", description = "Trae a un clientes registrados en el sistema")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Traer a un cliente solicitado",
                            content = {
                                    @Content(mediaType = "application/json", schema = @Schema(implementation = APIResponse.class)),
                            }),
                    @ApiResponse(
                            responseCode = "400",
                            description = "No se encontro el cliente",
                            content = {
                                    @Content(mediaType = "application/json", schema = @Schema(implementation = APIResponse.class)),
                            }),
                    @ApiResponse(
                            responseCode = "500",
                            description = "No se puedo consultar a un cliente",
                            content = {
                                    @Content(mediaType = "application/json", schema = @Schema(implementation = APIResponse.class)),
                            })
            }
    )
    public ResponseEntity<APIResponse> findById(@PathVariable("id") long id){
        APIResponse response = clientService.findById(id);
        return new ResponseEntity<>(response,response.getStatus());

    }

    @PostMapping("")
    @Operation(summary = "Guardar cliente", description = "Registrar la informacion de un cliente")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Registro exitoso del cliente",
                            content = {
                                    @Content(mediaType = "application/json", schema = @Schema(implementation = APIResponse.class)),
                            }),
                    @ApiResponse(
                            responseCode = "400",
                            description = "no se realizo el registro",
                            content = {
                                    @Content(mediaType = "application/json", schema = @Schema(implementation = APIResponse.class)),
                            }),
                    @ApiResponse(
                            responseCode = "500",
                            description = "No se puedo registrar a un cliente",
                            content = {
                                    @Content(mediaType = "application/json", schema = @Schema(implementation = APIResponse.class)),
                            })
            }
    )
    public ResponseEntity<APIResponse> save(@RequestBody Client payload){
        APIResponse response = clientService.save(payload);
        return new ResponseEntity<>(response,response.getStatus());
    }
}