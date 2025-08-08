package hexlet.code.mapper;

import hexlet.code.dto.UserCreateDTO;
import hexlet.code.dto.UserDTO;
import hexlet.code.dto.UserUpdateDTO;
import hexlet.code.model.User;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-08T20:49:12+0200",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.3.jar, environment: Java 21.0.3 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl extends UserMapper {

    @Autowired
    private JsonNullableMapper jsonNullableMapper;

    @Override
    public User map(UserCreateDTO model) {
        encryptPassword( model );

        if ( model == null ) {
            return null;
        }

        User user = new User();

        user.setPasswordDigest( model.getPassword() );
        user.setEmail( model.getEmail() );
        user.setFirstName( model.getFirstName() );
        user.setLastName( model.getLastName() );

        return user;
    }

    @Override
    public UserDTO map(User model) {
        if ( model == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        if ( model.getId() != null ) {
            userDTO.setId( model.getId() );
        }
        userDTO.setFirstName( model.getFirstName() );
        userDTO.setLastName( model.getLastName() );
        userDTO.setEmail( model.getEmail() );
        userDTO.setCreatedAt( model.getCreatedAt() );

        return userDTO;
    }

    @Override
    public void update(UserUpdateDTO userUpdateDTO, User user) {
        if ( userUpdateDTO == null ) {
            return;
        }

        encryptPasswordUpdate( userUpdateDTO, user );

        if ( jsonNullableMapper.isPresent( userUpdateDTO.getPassword() ) ) {
            user.setPasswordDigest( jsonNullableMapper.unwrap( userUpdateDTO.getPassword() ) );
        }
        if ( jsonNullableMapper.isPresent( userUpdateDTO.getEmail() ) ) {
            user.setEmail( jsonNullableMapper.unwrap( userUpdateDTO.getEmail() ) );
        }
        if ( jsonNullableMapper.isPresent( userUpdateDTO.getFirstName() ) ) {
            user.setFirstName( jsonNullableMapper.unwrap( userUpdateDTO.getFirstName() ) );
        }
        if ( jsonNullableMapper.isPresent( userUpdateDTO.getLastName() ) ) {
            user.setLastName( jsonNullableMapper.unwrap( userUpdateDTO.getLastName() ) );
        }
    }
}
