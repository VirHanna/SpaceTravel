
INSERT INTO clients (name) VALUES
('Olena Petrenko'),
('Mykola Shevchenko'),
('Iryna Bondarenko'),
('Taras Kovalenko'),
('Svitlana Tkachenko'),
('Andriy Kravchenko'),
('Natalia Melnyk'),
('Volodymyr Boyko'),
('Oksana Moroz'),
('Yuriy Lysenko');


INSERT INTO planets (id, name) VALUES
('NEPTUNE', 'Neptune'),
('URANUS', 'Uranus'),
('PLUTO', 'Pluto'),
('CERES', 'Ceres'),
('ERIS', 'Eris');


INSERT INTO tickets (created_at, client_id, from_planet_id, to_planet_id) VALUES
(DATEADD('DAY', -10, CURRENT_TIMESTAMP), 1, 'NEPTUNE', 'PLUTO'),
(DATEADD('DAY', -9, CURRENT_TIMESTAMP), 2, 'URANUS', 'CERES'),
(DATEADD('DAY', -8, CURRENT_TIMESTAMP), 3, 'PLUTO', 'ERIS'),
(DATEADD('DAY', -7, CURRENT_TIMESTAMP), 4, 'CERES', 'NEPTUNE'),
(DATEADD('DAY', -6, CURRENT_TIMESTAMP), 5, 'ERIS', 'URANUS'),
(DATEADD('DAY', -5, CURRENT_TIMESTAMP), 6, 'NEPTUNE', 'CERES'),
(DATEADD('DAY', -4, CURRENT_TIMESTAMP), 7, 'URANUS', 'PLUTO'),
(DATEADD('DAY', -3, CURRENT_TIMESTAMP), 8, 'PLUTO', 'NEPTUNE'),
(DATEADD('DAY', -2, CURRENT_TIMESTAMP), 9, 'CERES', 'URANUS'),
(DATEADD('DAY', -1, CURRENT_TIMESTAMP), 10, 'ERIS', 'CERES');
