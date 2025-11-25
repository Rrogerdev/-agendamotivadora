package com.senac.dei.controller;
import com.senac.dei.dto.LoginUserDto;
import com.senac.dei.dto.RecoveryJwtTokenDto;
import com.senac.dei.dto.request.UsuarioDTORequest;
import com.senac.dei.dto.response.UserInfoResponse;
import com.senac.dei.dto.response.UsuarioDTOResponse;
import com.senac.dei.entity.Usuario;
import com.senac.dei.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/usuario")
@Tag(name="Usuario", description = "API para gerenciamento de usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @CrossOrigin(origins="*")
    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> listarUsuarios(){
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }


    @CrossOrigin(origins="*")
    @GetMapping("/info/{usuarioId}")
    public ResponseEntity<UserInfoResponse> buscarUsuarioPorId(@PathVariable("usuarioId") int id){
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorId(id));
    }

    @CrossOrigin(origins="*")
    @PostMapping("/criar")
    @Operation(summary = "Criar novo usuário", description = "Endpoint para criar um novo usuário")
    public ResponseEntity<UsuarioDTOResponse> criarUsuario(@Valid @RequestBody UsuarioDTORequest usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.criarUsuario(usuario));
    }

    @CrossOrigin(origins="*")
    @DeleteMapping("/apagar/{usuarioId}")
    @Operation(summary = "Deletar usuario por id", description = "Endpoint para deletar um usuario pelo id")
    public ResponseEntity<Void> apagarUsuario(@PathVariable("usuarioId") Integer usuarioId) {
        usuarioService.apagarUsuario(usuarioId);
        return ResponseEntity.noContent().build();
    }








    @CrossOrigin(origins = "*")
    @PostMapping("/login")
    public ResponseEntity<RecoveryJwtTokenDto> authenticateUser(@RequestBody LoginUserDto loginUserDto) {
        RecoveryJwtTokenDto token = usuarioService.authenticateUser(loginUserDto);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }




}