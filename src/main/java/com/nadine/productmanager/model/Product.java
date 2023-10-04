    package com.nadine.productmanager.model;

    import com.nadine.productmanager.enums.ProductCategory;
    import com.nadine.productmanager.enums.ProductStatus;
    import jakarta.persistence.*;
    import lombok.EqualsAndHashCode;
    import lombok.Getter;
    import lombok.Setter;
    import lombok.ToString;

    @ToString
    @Getter
    @Setter
    @EqualsAndHashCode

    @Entity
    @Table(name = "products")
    public class Product {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false)
        private Long id;

        @Column(name = "name", nullable = false)
        private String name;

        @Enumerated(EnumType.STRING)
        @Column(name = "category", nullable = false)
        private ProductCategory category;

        @Column(name = "price", nullable = false)
        private Double price;

        @Column(name = "link", length = 500)
        private String link;

        @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        private ProductStatus status;

    }
