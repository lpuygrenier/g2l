package fr.el.g2l.referentiel.internal.db.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import fr.el.g2l.referentiel.generated.api.model.User;
import fr.el.g2l.referentiel.internal.db.models.UserDb;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", source = "id")
    User toDto(UserDb customerDb);

    @Mapping(target = "id", source = "id")
    UserDb toEntity(User user);

    List<User> toDtoList(List<UserDb> userDbList);
    
    List<UserDb> toEntityList(List<User> userList);
}
