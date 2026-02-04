package org.pkp.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class OrderDetailId implements Serializable {

    private Integer orderId;

    private Integer productId;
}
