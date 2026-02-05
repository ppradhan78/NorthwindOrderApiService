package org.pkp.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor   // REQUIRED by JPA
@AllArgsConstructor  // <-- THIS fixes your error
@EqualsAndHashCode
public class OrderDetailId implements Serializable {

    private Integer orderId;

    private Integer productId;
}
