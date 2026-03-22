package org.pkp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

//@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Getter
@Setter
@Table(name = "Categories", schema ="dbo" )
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name="CategoryID")
    private int categoryID;

    @NotBlank
    @Column(nullable = false, name = "CategoryName" ,length = 20)
    private String categoryName;

    @Column(nullable = true, name="Description",length = 10)
    private String description;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(nullable = true, name="Picture",length = 10)
    private byte[] picture;

}
