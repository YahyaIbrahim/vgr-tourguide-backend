INSERT INTO vgr.profiles (id, creation_time, update_time, locale, address, biography, city, country, currency, display_name, email_address, enabled, guideServiceTariff, is_tour_guide, is_tourist, mobile, native_language, password, tariff, total_reviews, guide_service_tariff, profile_image_id) VALUES (2, '2020-01-10 17:06:28', '2020-01-15 07:30:44', null, 'Cairo-Egypt', null, 'Cairo', 'Egypt', '$', 'Yahya1111111', 'yibrahim.py@gmail.com', 1, null, 1, 0, 12345666, 'Arabic', '123456789123', 0, null, 0, 1);
INSERT INTO vgr.profiles (id, creation_time, update_time, locale, address, biography, city, country, currency, display_name, email_address, enabled, guideServiceTariff, is_tour_guide, is_tourist, mobile, native_language, password, tariff, total_reviews, guide_service_tariff, profile_image_id) VALUES (3, '2020-01-10 20:26:09', '2020-01-15 12:12:25', null, 'Cairo-Egypt', '', 'Cairo', 'Egypt', '$', 'mariom', 'mariamyounes536@gmail.com', 1, null, 0, 1, 1100337582, 'Arabic', '1234567', 0, null, 0, 2);
INSERT INTO vgr.profiles (id, creation_time, update_time, locale, address, biography, city, country, currency, display_name, email_address, enabled, guideServiceTariff, is_tour_guide, is_tourist, mobile, native_language, password, tariff, total_reviews, guide_service_tariff, profile_image_id) VALUES (4, '2020-01-10 20:26:33', '2020-01-15 06:55:58', null, 'Cairo-Egypt', null, 'Cairo', 'Egypt', '$', 'Yahya1003', 'mariamyounes@gmail.com', 1, null, 0, 1, 123456987, 'Arabic', '1234567', 0, null, 0, null);
INSERT INTO vgr.profiles (id, creation_time, update_time, locale, address, biography, city, country, currency, display_name, email_address, enabled, guideServiceTariff, is_tour_guide, is_tourist, mobile, native_language, password, tariff, total_reviews, guide_service_tariff, profile_image_id) VALUES (5, '2020-01-15 07:42:47', '2020-01-15 11:21:37', null, null, null, null, null, null, 'semoha', 'mohamed@gmail.com', 1, null, 1, 0, 1100, null, '12345', 0, null, 0, null);


INSERT INTO vgr.languages (id, creation_time, update_time, code, name) VALUES (1, '2020-01-10 17:50:13', '2020-01-10 17:50:15', '1002', 'Arabic');
INSERT INTO vgr.languages (id, creation_time, update_time, code, name) VALUES (2, '2020-01-10 17:50:29', '2020-01-10 17:50:30', '1003', 'English');
INSERT INTO vgr.languages (id, creation_time, update_time, code, name) VALUES (3, '2020-01-10 17:50:41', '2020-01-10 17:50:42', '1004', 'French');
INSERT INTO vgr.languages (id, creation_time, update_time, code, name) VALUES (4, '2020-01-10 17:50:52', '2020-01-10 17:50:53', '1005', 'Germany');



INSERT INTO vgr.spoken_languages (id, profile_id, language_id, creation_time, update_time) VALUES (1, 2, 1, '2020-01-10 17:58:08', '2020-01-10 17:58:09');
INSERT INTO vgr.spoken_languages (id, profile_id, language_id, creation_time, update_time) VALUES (2, 2, 2, '2020-01-10 17:58:15', '2020-01-10 17:58:16');
INSERT INTO vgr.spoken_languages (id, profile_id, language_id, creation_time, update_time) VALUES (3, 2, 3, '2020-01-10 17:58:34', '2020-01-10 00:00:00');
INSERT INTO vgr.spoken_languages (id, profile_id, language_id, creation_time, update_time) VALUES (4, 2, 4, '2020-01-10 17:58:15', '2020-01-10 17:58:16');


INSERT INTO vgr.countries (id, country_code, country_name, image) VALUES (1, '02', 'Egypt', 'https://i.ytimg.com/vi/TWaReNkjTLk/maxresdefault.jpg');
INSERT INTO vgr.countries (id, country_code, country_name, image) VALUES (2, '01', 'Canada', 'https://pix10.agoda.net/geo/country/100/3_100_canada_02.jpg?s=1920x');
INSERT INTO vgr.countries (id, country_code, country_name, image) VALUES (3, '01', 'US', 'https://www.green-card.com/assets/Uploads/living-usa-states-florida-green-card.jpg');


INSERT INTO vgr.cities (id, creation_time, update_time, name, image, country_id) VALUES (1, '2020-01-11 07:44:18', '2020-01-11 07:44:19', 'Cairo', 'https://cdn.egypttoursportal.com/uploads/2017/11/Cairo-City-Egypt-Tours-Portal-1-e1511901150793.jpg', 1);
INSERT INTO vgr.cities (id, creation_time, update_time, name, image, country_id) VALUES (2, '2020-01-11 07:44:23', '2020-01-11 07:44:24', 'Alex', 'https://cdn.egypttoursportal.com/uploads/2017/11/Stanly-Bridge-Alexandria-Egypt-Tours-Portal.jpg', 1);
INSERT INTO vgr.cities (id, creation_time, update_time, name, image, country_id) VALUES (3, '2020-01-11 07:44:23', '2020-01-11 07:44:24', 'Giza', 'https://www.olxgroup.com/assets/styles/hero/public/2018-06/Cairo%20final%20resized.jpg?itok=L08T8HA1', 1);

INSERT INTO vgr.places (id, creation_time, update_time, name, city_id, image) VALUES (1, '2020-01-11 07:45:11', '2020-01-11 07:45:12', 'Pyramids', 3, 'https://www.corinthiantravel.co.uk/blog/wp-content/uploads/2016/07/Everything-you-need-to-know-when-visiting-the-Pyramids-in-Cairo-Egypt.jpg');
INSERT INTO vgr.places (id, creation_time, update_time, name, city_id, image) VALUES (2, '2020-01-11 07:46:41', '2020-01-11 07:46:40', 'Sphinx', 3, 'https://upload.wikimedia.org/wikipedia/commons/f/f6/Great_Sphinx_of_Giza_-_20080716a.jpg');


INSERT INTO vgr.work_places (id, creation_time, update_time, profile_id, place_id) VALUES (1, '2020-01-11 07:59:11', '2020-01-11 07:59:14', 2, 1);
INSERT INTO vgr.work_places (id, creation_time, update_time, profile_id, place_id) VALUES (2, '2020-01-11 07:59:29', '2020-01-11 07:59:30', 2, 2);

INSERT INTO vgr.tariffs (id, creation_time, update_time, name) VALUES (1, '2020-01-11 10:22:58', '2020-01-11 10:22:57', 'Full Day');
INSERT INTO vgr.tariffs (id, creation_time, update_time, name) VALUES (2, '2020-01-11 10:23:19', '2020-01-11 10:23:18', 'Hour');
INSERT INTO vgr.tariffs (id, creation_time, update_time, name) VALUES (3, '2020-01-11 10:23:20', '2020-01-11 10:23:21', 'Trip');


INSERT INTO vgr.tariff_schemas (id, creation_time, update_time, cost, profile_id, tariff_id) VALUES (1, '2020-01-11 10:42:22', '2020-01-11 10:42:28', 10000, 2, 1);
INSERT INTO vgr.tariff_schemas (id, creation_time, update_time, cost, profile_id, tariff_id) VALUES (2, '2020-01-11 10:42:24', '2020-01-11 10:42:29', 100, 2, 2);
INSERT INTO vgr.tariff_schemas (id, creation_time, update_time, cost, profile_id, tariff_id) VALUES (3, '2020-01-11 10:42:26', '2020-01-11 10:42:30', 1000, 2, 3);


INSERT INTO vgr.profile_image (id, creation_time, update_time, path, user_id) VALUES (1, '2020-01-14 01:40:15', '2020-01-14 01:40:17', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT0zeQf36PX86b22C9NIfFgRHPTpGixEOJTJ21EXhcs0-aBFHzJ&s', 2);
INSERT INTO vgr.profile_image (id, creation_time, update_time, path, user_id) VALUES (2, '2020-01-14 01:41:12', '2020-01-14 01:41:11', 'https://c.stocksy.com/a/orJ600/z9/1506340.jpg?1574937662', 3);



INSERT INTO vgr.extra_services (id, creation_time, update_time, name) VALUES (1, '2020-01-14 03:39:15', '2020-01-14 03:39:17', 'Bus Rent');
INSERT INTO vgr.extra_services (id, creation_time, update_time, name) VALUES (2, '2020-01-14 03:40:07', '2020-01-14 03:40:02', 'Mini-Bus Rent');
INSERT INTO vgr.extra_services (id, creation_time, update_time, name) VALUES (3, '2020-01-14 03:40:05', '2020-01-14 03:40:03', 'Taxi');
INSERT INTO vgr.extra_services (id, creation_time, update_time, name) VALUES (4, '2020-01-14 03:40:06', '2020-01-14 03:40:04', 'Limousine');


INSERT INTO vgr.activities (id, creation_time, update_time, name, place_id, description, location, date) VALUES (1, '2020-01-18 11:35:36', '2020-01-18 11:35:38', 'Bikes', 1, 'Tour with bike in cairo ', 'Cairo', '2020-01-20 11:36:05');
INSERT INTO vgr.activities (id, creation_time, update_time, name, place_id, description, location, date) VALUES (2, '2020-01-19 00:50:02', '2020-01-19 00:50:00', 'Race', 2, 'Race with your car ', 'Alex', '2020-01-26 00:49:55');
INSERT INTO vgr.activities (id, creation_time, update_time, name, place_id, description, location, date) VALUES (3, '2020-01-19 00:53:08', '2020-01-19 00:53:06', 'Al-Azhar Park', 1, 'Al-Azhar Park', 'Cairo', '2020-01-23 00:53:20');

