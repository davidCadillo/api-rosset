package com.rosettcompany.api.repository;

import java.sql.Timestamp;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import com.rosettcompany.api.entity.Usuario;

@Repository
@Transactional
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Procedure
	Integer registrar(String id_redsocial, String correo, String url_redsocial, String nombres, String apellidos, String sexo,
			String contrasena, String fec_nacimiento, String cod_ubigeo, Timestamp fec_registro, String nombre_colegio, 
			String ruta_foto_img, Integer ind_red_social);
	
	@Procedure
	Integer validar_correo_y_pass(String correo, String pass);
	
	Usuario findByEmail(String id_redsoc);
}
