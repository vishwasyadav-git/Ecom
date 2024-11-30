CREATE TABLE category
(
    id               BIGINT AUTO_INCREMENT      NOT NULL,
    is_created_at    datetime NULL,
    last_updated_at  datetime NULL,
    is_deleted       BIT(1)       NOT NULL,
    name             VARCHAR(255) NOT NULL,
    `description`    VARCHAR(255) NULL,
    subcategories_id BIGINT NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE category_featuredproducts
(
    category_id         BIGINT  NOT NULL,
    featuredproducts_id BIGINT NOT NULL
);

CREATE TABLE category_products
(
    category_id BIGINT  NOT NULL,
    products_id BIGINT NOT NULL
);

CREATE TABLE product
(
    id              BIGINT AUTO_INCREMENT NOT NULL,
    is_created_at   datetime NULL,
    last_updated_at datetime NULL,
    is_deleted      BIT(1) NOT NULL,
    title           VARCHAR(255) NULL,
    `description`   VARCHAR(255) NULL,
    price DOUBLE NULL,
    image_url       VARCHAR(255) NULL,
    category_id     BIGINT NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE subcategory
(
    id              BIGINT AUTO_INCREMENT NOT NULL,
    is_created_at   datetime NULL,
    last_updated_at datetime NULL,
    is_deleted      BIT(1) NOT NULL,
    surname         VARCHAR(255) NULL,
    CONSTRAINT pk_subcategory PRIMARY KEY (id)
);

ALTER TABLE category_featuredproducts
    ADD CONSTRAINT uc_category_featuredproducts_featuredproducts UNIQUE (featuredproducts_id);

ALTER TABLE category
    ADD CONSTRAINT uc_category_name UNIQUE (name);

ALTER TABLE category_products
    ADD CONSTRAINT uc_category_products_products UNIQUE (products_id);

ALTER TABLE category
    ADD CONSTRAINT FK_CATEGORY_ON_SUBCATEGORIES FOREIGN KEY (subcategories_id) REFERENCES subcategory (id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);

ALTER TABLE category_featuredproducts
    ADD CONSTRAINT fk_catfea_on_category FOREIGN KEY (category_id) REFERENCES category (id);

ALTER TABLE category_featuredproducts
    ADD CONSTRAINT fk_catfea_on_product FOREIGN KEY (featuredproducts_id) REFERENCES product (id);

ALTER TABLE category_products
    ADD CONSTRAINT fk_catpro_on_category FOREIGN KEY (category_id) REFERENCES category (id);

ALTER TABLE category_products
    ADD CONSTRAINT fk_catpro_on_product FOREIGN KEY (products_id) REFERENCES product (id);