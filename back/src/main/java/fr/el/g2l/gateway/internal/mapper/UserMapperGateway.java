package fr.el.g2l.gateway.internal.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import fr.el.g2l.common.dto.User;

@Mapper(componentModel = "spring")
public interface UserMapperGateway {

    @Mapping(target = "id", source = "id")
    User toGtwUser(fr.el.g2l.common.dto.User refUser);

    @Mapping(target = "id", source = "id")
    fr.el.g2l.common.dto.User toRefUser(User gtwUser);
}
