package com.senac.dei.service;

import com.senac.dei.dto.CreateUserDto;
import com.senac.dei.dto.LoginUserDto;
import com.senac.dei.dto.RecoveryJwtTokenDto;
import com.senac.dei.dto.request.UsuarioDTORequest;
import com.senac.dei.dto.response.UsuarioDTOResponse;
import com.senac.dei.entity.Role;
import com.senac.dei.entity.Usuario;
import com.senac.dei.config.SecurityConfiguration;
import com.senac.dei.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    private final AuthenticationManager authenticationManager;
    private final JwtTokenService jwtTokenService;
    private final SecurityConfiguration securityConfiguration;




    public UsuarioService(UsuarioRepository usuarioRepository, AuthenticationManager authenticationManager, JwtTokenService jwtTokenService, SecurityConfiguration securityConfiguration){
        this.usuarioRepository = usuarioRepository;
        this.authenticationManager = authenticationManager;
        this.jwtTokenService = jwtTokenService;
        this.securityConfiguration = securityConfiguration;
    }

    @Autowired
    private ModelMapper modelMapper;
    public List<Usuario> listarUsuarios(){
        return this.usuarioRepository.findAll();
    }




    public UsuarioDTOResponse criarUsuario(UsuarioDTORequest UsuarioDTORequest) {
        System.out.println("Input Email: " + UsuarioDTORequest.getUsuario_email());
        Usuario usuario =modelMapper.map(UsuarioDTORequest,Usuario.class);
        Usuario usuarioSave = this.usuarioRepository.save(usuario);
        UsuarioDTOResponse usuarioDTOResponse = modelMapper.map(usuarioSave, UsuarioDTOResponse.class);
        return usuarioDTOResponse;

    }

    public void apagarUsuario(Integer usuarioId) {
        usuarioRepository.apagarLogicoUsuario(usuarioId);
    }


    public void createUser(CreateUserDto createUserDto) {

        // Cria um novo usuário com os dados fornecidos
        Usuario newUser = new Usuario();
        newUser.setUsuario_email(createUserDto.email());
        // Codifica a senha do usuário com o algoritmo bcrypt
        newUser.setUsuario_senha(securityConfiguration.passwordEncoder().encode(createUserDto.password()));
        // Atribui ao usuário uma permissão específica
        Role role = new Role();
        role.setName(createUserDto.role());
        newUser.setRoles(List.of(role));


        // Salva o novo usuário no banco de dados
        usuarioRepository.save(newUser);
    }

    public RecoveryJwtTokenDto authenticateUser(LoginUserDto loginUserDto) {
        // Cria um objeto de autenticação com o email e a senha do usuário
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(loginUserDto.email(), loginUserDto.password());

        // Autentica o usuário com as credenciais fornecidas
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        // Obtém o objeto UserDetails do usuário autenticado
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        // Gera um token JWT para o usuário autenticado
        return new RecoveryJwtTokenDto(jwtTokenService.generateToken(userDetails));
    }


}