package dev.jmfayard.spring;

import jakarta.websocket.server.PathParam;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends PagingAndSortingRepository<WebsiteUser, Long> {
    List<WebsiteUser> findByName(@Param("name") String name);

    WebsiteUser findById(@PathParam("id") Long id);

    WebsiteUser save(WebsiteUser user);
}