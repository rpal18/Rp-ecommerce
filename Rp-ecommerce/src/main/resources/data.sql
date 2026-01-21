-- =======================================================
-- 1. INSERT CATEGORIES
-- =======================================================
INSERT INTO category (category_id, name) VALUES (1, 'Electronics');
INSERT INTO category (category_id, name) VALUES (2, 'Books & Novels');
INSERT INTO category (category_id, name) VALUES (3, 'Fashion & Wear');
INSERT INTO category (category_id, name) VALUES (4, 'Home & Kitchen');

-- =======================================================
-- 2. INSERT PRODUCTS (One by one for safety)
-- =======================================================

-- --- ELECTRONICS ---
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (101, 'Smartphone Ultra', 'High-end smartphone with AI camera', 50, 999.00, 10.0, 899.10, 'phone1.jpg', 1);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (102, 'Laptop Pro 15', 'Professional laptop for developers', 30, 1500.00, 5.0, 1425.00, 'laptop1.jpg', 1);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (103, 'Wireless Earbuds', 'Noise cancelling wireless earbuds', 100, 199.00, 15.0, 169.15, 'buds.jpg', 1);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (104, '4K Smart TV', '55 inch 4K Ultra HD Smart TV', 20, 600.00, 10.0, 540.00, 'tv.jpg', 1);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (105, 'Gaming Console X', 'Next-gen gaming console 1TB', 45, 499.00, 0.0, 499.00, 'console.jpg', 1);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (106, 'Smart Watch Series 5', 'Fitness tracker and smartwatch', 60, 250.00, 20.0, 200.00, 'watch.jpg', 1);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (107, 'Bluetooth Speaker', 'Portable waterproof speaker', 80, 50.00, 5.0, 47.50, 'speaker.jpg', 1);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (108, 'Tablet Air', 'Lightweight tablet for creativity', 40, 399.00, 10.0, 359.10, 'tablet.jpg', 1);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (109, 'Gaming Mouse', 'RGB ergonomic gaming mouse', 150, 49.00, 10.0, 44.10, 'mouse.jpg', 1);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (110, 'Mechanical Keyboard', 'Clicky mechanical keyboard', 70, 89.00, 15.0, 75.65, 'kb.jpg', 1);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (111, 'External SSD 1TB', 'High speed portable storage', 90, 120.00, 8.0, 110.40, 'ssd.jpg', 1);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (112, 'Graphics Card 3060', 'Mid-range GPU for gaming', 15, 350.00, 0.0, 350.00, 'gpu.jpg', 1);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (113, 'Webcam 1080p', 'HD webcam for streaming', 65, 60.00, 5.0, 57.00, 'webcam.jpg', 1);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (114, 'Power Bank 20k', '20000mAh fast charging bank', 200, 40.00, 10.0, 36.00, 'pbank.jpg', 1);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (115, 'USB-C Hub', 'Multi-port adapter for laptops', 100, 35.00, 5.0, 33.25, 'hub.jpg', 1);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (116, 'Router WiFi 6', 'High speed internet router', 35, 130.00, 15.0, 110.50, 'router.jpg', 1);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (117, 'Monitor 27 inch', 'IPS display monitor 144Hz', 25, 220.00, 10.0, 198.00, 'monitor.jpg', 1);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (118, 'Drone Mini', 'Compact camera drone 4K', 15, 299.00, 10.0, 269.10, 'drone.jpg', 1);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (119, 'VR Headset', 'Virtual reality standalone headset', 20, 399.00, 5.0, 379.05, 'vr.jpg', 1);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (120, 'Smart Home Hub', 'Control all your devices voice', 50, 99.00, 20.0, 79.20, 'hub_home.jpg', 1);

-- --- BOOKS ---
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (201, 'The Great Gatsby', 'Classic novel by F. Scott Fitzgerald', 200, 15.00, 5.0, 14.25, 'book1.jpg', 2);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (202, 'Clean Code', 'Handbook of Agile Software Craftsmanship', 100, 45.00, 10.0, 40.50, 'codebook.jpg', 2);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (203, 'Java Concurrency', 'Deep dive into Java threads', 80, 55.00, 5.0, 52.25, 'java.jpg', 2);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (204, 'Sci-Fi Galaxy', 'Space opera adventure part 1', 120, 20.00, 15.0, 17.00, 'scifi.jpg', 2);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (205, 'History of World', 'Comprehensive world history', 60, 30.00, 20.0, 24.00, 'history.jpg', 2);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (206, 'Cooking 101', 'Basic recipes for beginners', 90, 25.00, 10.0, 22.50, 'cook.jpg', 2);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (207, 'Learn Python', 'Python crash course for beginners', 110, 35.00, 5.0, 33.25, 'python.jpg', 2);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (208, 'Mystery of Orient', 'Detective thriller novel', 130, 12.00, 0.0, 12.00, 'mystery.jpg', 2);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (209, 'Business Strategy', 'MBA essentials guide', 50, 40.00, 10.0, 36.00, 'biz.jpg', 2);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (210, 'Comic Book Vol 1', 'Superhero origin story', 300, 10.00, 5.0, 9.50, 'comic.jpg', 2);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (211, 'Fantasy World', 'Dragons and dungeons epic', 140, 22.00, 10.0, 19.80, 'fantasy.jpg', 2);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (212, 'Self Help Guide', 'Improve your productivity', 150, 18.00, 15.0, 15.30, 'help.jpg', 2);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (213, 'Art History', 'Renaissance to Modern art', 40, 60.00, 10.0, 54.00, 'art.jpg', 2);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (214, 'Travel Guide', 'Best places to visit in Europe', 70, 28.00, 5.0, 26.60, 'travel.jpg', 2);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (215, 'Science Journal', 'Monthly science discoveries', 60, 15.00, 0.0, 15.00, 'science.jpg', 2);

-- --- FASHION ---
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (301, 'Men T-Shirt Blue', 'Cotton blue t-shirt basic', 500, 20.00, 10.0, 18.00, 'tshirt.jpg', 3);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (302, 'Denim Jeans', 'Classic blue denim jeans', 200, 60.00, 15.0, 51.00, 'jeans.jpg', 3);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (303, 'Running Shoes', 'Lightweight running sneakers', 150, 80.00, 20.0, 64.00, 'shoes.jpg', 3);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (304, 'Summer Dress', 'Floral pattern summer dress', 100, 45.00, 5.0, 42.75, 'dress.jpg', 3);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (305, 'Leather Jacket', 'Genuine leather black jacket', 40, 150.00, 10.0, 135.00, 'jacket.jpg', 3);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (306, 'Wristwatch Classic', 'Analog classic wristwatch', 80, 120.00, 5.0, 114.00, 'wrist.jpg', 3);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (307, 'Sunglasses', 'UV protection aviator sunglasses', 120, 30.00, 10.0, 27.00, 'sun.jpg', 3);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (308, 'Hoodie Grey', 'Warm fleece grey hoodie', 180, 50.00, 10.0, 45.00, 'hoodie.jpg', 3);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (309, 'Formal Shirt', 'White formal shirt office wear', 140, 35.00, 5.0, 33.25, 'shirt.jpg', 3);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (310, 'Sports Cap', 'Adjustable sports baseball cap', 300, 15.00, 0.0, 15.00, 'cap.jpg', 3);

-- --- HOME & KITCHEN ---
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (401, 'Blender 500W', 'Smoothie blender with glass jar', 60, 40.00, 10.0, 36.00, 'blender.jpg', 4);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (402, 'Coffee Maker', 'Drip coffee maker programmable', 50, 70.00, 15.0, 59.50, 'coffee.jpg', 4);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (403, 'Air Fryer', 'Digital air fryer oil free', 40, 120.00, 10.0, 108.00, 'fryer.jpg', 4);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (404, 'Microwave Oven', 'Solo microwave oven 20L', 30, 90.00, 5.0, 85.50, 'micro.jpg', 4);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (405, 'Knife Set', 'Stainless steel kitchen knife set', 100, 50.00, 20.0, 40.00, 'knife.jpg', 4);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (406, 'Vacuum Cleaner', 'Bagless vacuum cleaner powerful', 25, 150.00, 10.0, 135.00, 'vacuum.jpg', 4);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (407, 'Bed Sheets King', 'Cotton bed sheets king size', 80, 35.00, 5.0, 33.25, 'sheet.jpg', 4);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (408, 'Table Lamp', 'LED desk lamp adjustable', 120, 25.00, 10.0, 22.50, 'lamp.jpg', 4);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (409, 'Water Bottle', 'Insulated steel water bottle', 200, 15.00, 0.0, 15.00, 'bottle.jpg', 4);
INSERT INTO product (id, product_name, description, quantity, price, discount, special_price, image, category_category_id) VALUES (410, 'Curtains Set', 'Blackout curtains window set', 70, 45.00, 15.0, 38.25, 'curtains.jpg', 4);