INSERT INTO Address (street, postal_code, city, country)
values ('this street 15', 'NS B3E 1H3', 'Porters Lake', 'Canada'),
       ('that street 43', 'NS B3E 1H3', 'Porters Lake', 'Canada'),
       ('the other street 30', 'NS B3E 1H3', 'Porters Lake', 'Canada');

INSERT INTO User (user_name, first_name, last_name, address_id, email, phone, member_type)
values ('justin', 'Justin', 'Hall', 1, 'justin_hall@myblogg.com', '071 974 12 16', 'standard'),
       ('sven', 'Sven', 'Ohlsson', 3, 'sven@swl.nu', '070 123 19 97', 'standard'),
       ('trevor', 'Trevor', 'Page', 1, 'trevor_page@gmail.com', '070 123 20 12', 'enhanced'),
       ('jockiboi', 'Joakim', 'Lundell', 2, 'jocke@lundell.com', '073 123 19 85', 'premium'),
       ('jonna', 'Jonna', 'Lundell', 2, 'jonna@lundell.com', '073 123 19 94', 'premium');

INSERT INTO Post (post_title, post_text, date_for_post, user_id)
values ('Welcome to my first attempt at Hypertext',
        'Howdy, this is twenty-first century computing... (Is it worth our patience?) I''m publishing this, and I guess you''re readin'' this, in part to figure that out, huh?',
        '1994-01-23', 1),
       ('Sven tycker', 'Mitt första inlägg', '1997-04-04', 2),
       ('Spring Security',
        'Ever wondered how you could properly restrict access to certain parts of your web application?', '2013-10-16',
        3),
       ('CRUD Operations', 'Whats all this CRUD about', '2013-11-15', 3),
       ('Välkommen till min nya blogg!', 'Mitt första inlägg', '2013-11-26', 5);


