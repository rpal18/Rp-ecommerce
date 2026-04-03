-- =======================================================
-- 1. INSERT CATEGORIES
-- =======================================================
INSERT INTO category (category_id, name) VALUES (1, 'Electronics');
INSERT INTO category (category_id, name) VALUES (2, 'Books & Novels');
INSERT INTO category (category_id, name) VALUES (3, 'Fashion & Wear');
INSERT INTO category (category_id, name) VALUES (4, 'Home & Kitchen');

-- =======================================================
-- 2. INSERT PRODUCTS
-- =======================================================
INSERT INTO product (id, product_name, description, quantity, image, price, discount, special_price, reserved_quantity, category_category_id, seller_id)
VALUES (101, 'Smartphone Ultra', 'High-end smartphone with AI camera', 50, 'phone1.jpg', 999.00, 10.0, 899.10, 0, 1, NULL);
INSERT INTO product (id, product_name, description, quantity, image, price, discount, special_price, reserved_quantity, category_category_id, seller_id)
VALUES (102, 'Laptop Pro 15', 'Professional laptop for developers', 30, 'laptop1.jpg', 1500.00, 5.0, 1425.00, 0, 1, NULL);
INSERT INTO product (id, product_name, description, quantity, image, price, discount, special_price, reserved_quantity, category_category_id, seller_id)
VALUES (103, 'Wireless Earbuds', 'Noise cancelling wireless earbuds', 100, 'buds.jpg', 199.00, 15.0, 169.15, 0, 1, NULL);
INSERT INTO product (id, product_name, description, quantity, image, price, discount, special_price, reserved_quantity, category_category_id, seller_id)
VALUES (104, '4K Smart TV', '55 inch 4K Ultra HD Smart TV', 20, 'tv.jpg', 600.00, 10.0, 540.00, 0, 1, NULL);
INSERT INTO product (id, product_name, description, quantity, image, price, discount, special_price, reserved_quantity, category_category_id, seller_id)
VALUES (105, 'Gaming Console X', 'Next-gen gaming console 1TB', 45, 'console.jpg', 499.00, 0.0, 499.00, 0, 1, NULL);
INSERT INTO product (id, product_name, description, quantity, image, price, discount, special_price, reserved_quantity, category_category_id, seller_id)
VALUES (106, 'Smart Watch Series 5', 'Fitness tracker and smartwatch', 60, 'watch.jpg', 250.00, 20.0, 200.00, 0, 1, NULL);
INSERT INTO product (id, product_name, description, quantity, image, price, discount, special_price, reserved_quantity, category_category_id, seller_id)
VALUES (107, 'Bluetooth Speaker', 'Portable waterproof speaker', 80, 'speaker.jpg', 50.00, 5.0, 47.50, 0, 1, NULL);
INSERT INTO product (id, product_name, description, quantity, image, price, discount, special_price, reserved_quantity, category_category_id, seller_id)
VALUES (108, 'Tablet Air', 'Lightweight tablet for creativity', 40, 'tablet.jpg', 399.00, 10.0, 359.10, 0, 1, NULL);
INSERT INTO product (id, product_name, description, quantity, image, price, discount, special_price, reserved_quantity, category_category_id, seller_id)
VALUES (109, 'Gaming Mouse', 'RGB ergonomic gaming mouse', 150, 'mouse.jpg', 49.00, 10.0, 44.10, 0, 1, NULL);
INSERT INTO product (id, product_name, description, quantity, image, price, discount, special_price, reserved_quantity, category_category_id, seller_id)
VALUES (110, 'Mechanical Keyboard', 'Clicky mechanical keyboard', 70, 'kb.jpg', 89.00, 15.0, 75.65, 0, 1, NULL);