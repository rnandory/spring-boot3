
INSERT INTO member (id, username, pwd, email, reg_date) VALUES (1, 'moomoo', '$2a$12$jC7lgW3vTnmsZcjFW8M3HuSy1qip8moe7zPT8r/ZERqQcu6Vu2vv6', 'moomoo@gmail.com', '2024-02-19 11:03:42');
INSERT INTO member (id, username, pwd, email, reg_date) VALUES (2, 'newlec', '$2a$12$pTjInX3OPxo3I4QqAO51wOEDqJFxMDEwEH9AQbHDR6LQQbGtsQrba', 'newlec@newlecture.com', '2024-02-28 10:11:00');

INSERT INTO role (id, name) VALUES (1, 'ROLE_MEMBER');
INSERT INTO role (id, name) VALUES (2, 'ROLE_TEACHER');
INSERT INTO role (id, name) VALUES (3, 'ROLE_ADMIN');

INSERT INTO member_role (id, member_id, role_id) VALUES (1, 2, 1);
INSERT INTO member_role (id, member_id, role_id) VALUES (2, 2, 3);
INSERT INTO member_role (id, member_id, role_id) VALUES (3, 1, 1);


INSERT INTO category (id, name, member_id) VALUES (1, '커피', 2);
INSERT INTO category (id, name, member_id) VALUES (2, '수제청', 2);
INSERT INTO category (id, name, member_id) VALUES (3, '샌드위치', 2);
INSERT INTO category (id, name, member_id) VALUES (4, '쿠키', 2);

INSERT INTO menu (id, kor_name, eng_name, price, reg_date, category_id, reg_member_id) VALUES (1, '아메리카노', 'Americano', 4500, '2024-02-19 11:11:59', 1, 1);
INSERT INTO menu (id, kor_name, eng_name, price, reg_date, category_id, reg_member_id) VALUES (2, '나이트로 바닐라 크림', 'Nitro Vanilla Cream', 5900, '2024-02-19 11:12:07', 1, 1);
INSERT INTO menu (id, kor_name, eng_name, price, reg_date, category_id, reg_member_id) VALUES (3, '하니딸리가떼', 'honeyStrawberryLatte', 6000, '2024-02-19 11:12:39', 1, 1);
INSERT INTO menu (id, kor_name, eng_name, price, reg_date, category_id, reg_member_id) VALUES (4, '시그니처 더 블랙 콜드 브루', 'Signature The Black Cold Brew', 19500, '2024-02-19 11:12:59', 1, 1);
INSERT INTO menu (id, kor_name, eng_name, price, reg_date, category_id, reg_member_id) VALUES (5, '제주 비자림 콜드 브루', 'Jeju Forest Cold Brew', 6800, '2024-02-19 11:14:10', 1, 1);
INSERT INTO menu (id, kor_name, eng_name, price, reg_date, category_id, reg_member_id) VALUES (6, '자몽아이스티', 'jamongicetee', 3000, '2024-02-19 11:14:18', 2, 1);
INSERT INTO menu (id, kor_name, eng_name, price, reg_date, category_id, reg_member_id) VALUES (7, '딸기 피지오', 'Strawberry Fizzio', 3000, '2024-02-19 11:15:12', 2, 1);
INSERT INTO menu (id, kor_name, eng_name, price, reg_date, category_id, reg_member_id) VALUES (8, '디카페인아메리카노', 'decafamericano', 5500, '2024-02-19 11:15:27', 1, 1);
INSERT INTO menu (id, kor_name, eng_name, price, reg_date, category_id, reg_member_id) VALUES (9, '카라멜 마끼아또', 'Caramel Macchiato', 4500, '2024-02-19 11:16:28', 1, 1);
INSERT INTO menu (id, kor_name, eng_name, price, reg_date, category_id, reg_member_id) VALUES (1649, '베이컨 샌드위치', 'bacon sandwich', 5000, '2024-09-29 01:54:06', 3, 1);
INSERT INTO menu (id, kor_name, eng_name, price, reg_date, category_id, reg_member_id) VALUES (1650, '바게트 샌드위치', 'baguette sandwich', 7000, '2024-09-29 01:54:06', 3, 1);
INSERT INTO menu (id, kor_name, eng_name, price, reg_date, category_id, reg_member_id) VALUES (1651, '치즈 샌드위치', 'cheese sandwich', 5000, '2024-09-29 01:54:06', 3, 1);

INSERT INTO menu_image (id, src, is_default, menu_id) VALUES (1, 'americano.svg', true, 1);
INSERT INTO menu_image (id, src, is_default, menu_id) VALUES (2, 'americano2.png', false, 1);
INSERT INTO menu_image (id, src, is_default, menu_id) VALUES (3, 'cafe-latte.svg', true, 2);
INSERT INTO menu_image (id, src, is_default, menu_id) VALUES (4, 'juice1.png', true, 3);


INSERT INTO rcmd_menu (id, menu_id, rcmd_menu_id, member_id) VALUES (2, 1, 3, 1);
INSERT INTO rcmd_menu (id, menu_id, rcmd_menu_id, member_id) VALUES (3, 2, 3, 1);
INSERT INTO rcmd_menu (id, menu_id, rcmd_menu_id, member_id) VALUES (4, 1, 4, 1);
INSERT INTO rcmd_menu (id, menu_id, rcmd_menu_id, member_id) VALUES (5, 3, 4, 1);
