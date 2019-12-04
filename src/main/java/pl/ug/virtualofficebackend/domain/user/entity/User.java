package pl.ug.virtualofficebackend.domain.user.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class User {

    @Id
    private UUID id;
}
