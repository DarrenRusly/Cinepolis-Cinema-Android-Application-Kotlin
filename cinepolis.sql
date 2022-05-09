-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 09, 2022 at 04:16 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cinepolis`
--

-- --------------------------------------------------------

--
-- Table structure for table `movies`
--

CREATE TABLE `movies` (
  `movieId` int(11) NOT NULL,
  `about_movie` text NOT NULL,
  `banner_image_url` text NOT NULL,
  `cover_image_url` text NOT NULL,
  `languages` text NOT NULL,
  `movie_duration` text NOT NULL,
  `movie_name` text NOT NULL,
  `rating` text NOT NULL,
  `release_date` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `movies`
--

INSERT INTO `movies` (`movieId`, `about_movie`, `banner_image_url`, `cover_image_url`, `languages`, `movie_duration`, `movie_name`, `rating`, `release_date`) VALUES
(1, 'Set in the 1980s, Wonder Woman`s next big screen adventure finds her facing two all-new foes, Max Lord and The Cheetah, and the unexpected return of a face from her past.', 'https://i.imgur.com/CxvVAcK.jpg', 'https://in.bmscdn.com/iedb/movies/images/mobile/listing/xxlarge/wonder-woman-1984-et00077622-22-02-2021-07-00-29.jpg', 'English, Hindi, Tamil, Telugu', '2h 31m', 'Wonder Woman 1984', '7.5', '24 Dec, 2020'),
(2, 'Infamous frenemies Tom and Jerry move to the city to start life anew. When Jerry moves into New York`s finest hotel, the event manager Kayla teams up with Tom to evict the mouse so that the `wedding of the century` can go off without a hitch. The result is one of the most elaborate cat-and-mouse games ever!', 'https://cdn.cinematerial.com/p/297x/osu2gdkh/tom-and-jerry-movie-poster-md.jpg?v=1614079055', 'https://i.ytimg.com/vi/bWoObdDj_Gk/maxresdefault.jpg', 'English, Hindi, Tamil, Telugu', '1h 41m', 'Tom & Jerry', '8.9', '19 Feb, 2021'),
(3, 'In the not too distant future, Todd Hewitt discovers Viola, a mysterious girl who crash lands on his planet, where all the women have disappeared and the men are afflicted by \"the Noise\" - a force that puts all their thoughts on display. In this dangerous landscape, Viola`s life is threatened - and as Todd vows to protect her, he will have to discover his own inner power and unlock the planet`s dark secrets.', 'https://lsf.go.id/wp-content/uploads/2021/03/Chaos-Walking.jpg', 'https://in.bmscdn.com/iedb/movies/images/mobile/listing/xxlarge/chaos-walking-et00301090-02-03-2021-12-10-31.jpg', 'English', '1h 48m', 'Chaos Walking', '42', '05 Mar, 2021'),
(4, 'Tobey Marshall (Aaron Paul), a mechanic, races muscle cars in an underground circuit. Struggling to keep his business afloat, he reluctantly partners with wealthy but treacherous Dino Brewster (Dominic Cooper). However, Dino frames Tobey for a crime that sends him to prison. Two years later, Tobey is out and bent on revenge; his only chance to take down Dino is to beat him in a high-stakes race. But to get there in time, he must successfully evade an army of cops and bounty hunters.', 'https://flxt.tmsimg.com/assets/p10173171_p_v10_ab.jpg', 'https://cdn0-production-images-kly.akamaized.net/LsP6ZbFeiTm-9YK7oXB6Tjb0vKI=/1200x675/smart/filters:quality(75):strip_icc():format(jpeg)/kly-media-production/medias/847910/original/048564000_1428641920-Need-For-Speed-Car-Chase.jpg', 'English', '2h 21m', 'Need For Speed', '8.2', '1 May, 2022'),
(5, 'Chakra Ka Rakshak is a cyber-crime thriller where an officer is set on a mission to take down a bunch of goons who practise evil acts on the internet.', 'https://i.imgur.com/JRwyzlB.jpg', 'https://in.bmscdn.com/iedb/movies/images/mobile/listing/xxlarge/chakra-ka-rakshak-et00306685-18-02-2021-05-17-35.jpg', 'Hindi', '2h 10m', 'Chakra Ka Rakshak', '1.6', '19 Feb, 2021'),
(6, 'Retired U.S. Marine Jim Hanson, who lives by the Arizona-Mexico border, finds himself on a mission to protect a young Mexican boy who is on the run from a drug cartel and get him to his family in Chicago.', 'https://i.imgur.com/1Cj4czP.jpg', 'https://in.bmscdn.com/iedb/movies/images/mobile/listing/xxlarge/the-marksman-et00307138-24-02-2021-12-37-43.jpg', 'English, Hindi, Tamil, Telugu', '1h 58m', 'The Marksman', '73', '26 Feb, 2021'),
(7, 'Based on the life of Fred Hampton, the Chairman of the Illinois chapter of the Black Panther Party, the film talks about his inspiring a generation of black people to fight for their rights. However, a small-time thief named William O`Neal is coerced into providing intel from inside the party.', 'https://i.imgur.com/k2GdYd5.jpg', 'https://in.bmscdn.com/iedb/movies/images/mobile/listing/xxlarge/judas-and-the-black-messiah-et00136763-10-02-2021-06-34-19.jpg', 'English', '2h 07m', 'Judas And The Black Messiah', '12', '05 Mar, 2021'),
(8, 'When Lt. Artemis and her loyal soldiers are transported to a new world, they engage in a desperate battle for survival against enormous enemies with incredible powers.', 'https://i.imgur.com/GBT2Arh.jpg', 'https://in.bmscdn.com/iedb/movies/images/mobile/listing/xxlarge/monster-hunter-et00301892-05-03-2021-04-07-12.jpg', 'English, Hindi, Tamil, Telugu', '1h 41m', 'Monster Hunter', '7.5', '05 Feb, 2021'),
(9, 'Tuesdays & Fridays is a Hindi movie starring Anmol Dhillon, Zoa Morani and Niki Walia in prominent roles. It is a drama directed by Taranveer Singh with Ankit Balhara and Sanchit Balhara as musician, forming part of the crew.\nIf you are a representative of the production house, please share the details of the film with synopsis@bookmyshow.com', 'https://i.imgur.com/hEVn8dT.jpg', 'https://in.bmscdn.com/iedb/movies/images/mobile/listing/xxlarge/tuesdays-and-fridays-et00301898-05-02-2021-06-11-57.jpg', 'Hindi', '1h 47m', 'Tuesdays & Fridays', '43', '19 Feb, 2021'),
(10, 'Vijay The Master revolves around an alcoholic professor who is sent to a juvenile school, where he clashes with a gangster, who uses the children of the school for criminal activities.', 'https://i.imgur.com/eRiLhi5.jpg', 'https://in.bmscdn.com/iedb/movies/images/mobile/listing/xxlarge/vijay-the-master-et00303436-07-01-2021-05-40-30.jpg', 'Hindi', '2h 58m', 'Vijay The Master', '9', '14 Jan, 2021'),
(11, 'Raya, a lone warrior from the fantasy kingdom of Kumandra, teams up with a crew of misfits in her quest to find the Last Dragon, in order to bring light and unity back to their world.', 'https://i.imgur.com/ORqEpUO.jpg', 'https://in.bmscdn.com/iedb/movies/images/mobile/listing/xxlarge/raya-and-the-last-dragon-et00145984-02-03-2021-02-45-26.jpg', 'English, Hindi', '1h 54m', 'Raya and the Last Dragon', '13', '05 Mar, 2021'),
(12, 'Fighting for the survival of the world, the Protagonist journeys through a twilight world of international espionage on a mission that will unfold in something beyond real-time.', 'https://i.imgur.com/3NobWPT.jpg', 'https://in.bmscdn.com/iedb/movies/images/mobile/listing/xxlarge/tenet-et00121315-01-02-2021-11-11-05.jpg', 'English, Hindi, Tamil, Telugu', '2h 31m', 'Tenet', '7.5', '04 Dec, 2020'),
(13, 'A1 Express is a Telugu movie starring Sundeep Kishan in a prominent role. It is a drama directed by Dennis Jeevan Kanukolanu.\nIf you are a representative of the produ.ction house, please share the details of the film with synopsis@bookmyshow.com', 'https://i.imgur.com/JRwyzlB.jpg', 'https://in.bmscdn.com/iedb/movies/images/mobile/listing/xxlarge/a1-express-et00113853-02-03-2021-12-47-31.jpg', 'Telugu', '2h 18m', 'A1 Express', '11.1', '05 Mar, 2021'),
(14, 'A despondent young man reluctantly agrees to assume responsibility for an overnight shimmer and fulfill the Jewish practice of watching over the body of a deceased member of the Orthodox community. Until his vigil gradually transforms into a harrowing spiritual investigation of both his cursed surroundings and his pitiable past.', 'https://i.imgur.com/WqkKtrB.jpg', 'https://in.bmscdn.com/iedb/movies/images/mobile/listing/xxlarge/the-vigil-et00305794-03-02-2021-04-46-05.jpg', 'English', '1h 32m', 'The Vigil', '26', '26 Feb, 2021'),
(15, 'After Ramprasad\'s death, his family is forced to live together for 13 days until the Tehrvi is performed. Amidst all the drama they must come to terms with some crucial truths about life.', 'https://i.imgur.com/dM3IAE2.jpg', 'https://in.bmscdn.com/iedb/movies/images/mobile/listing/xxlarge/ramprasad-ki-tehrvi-et00117699-28-12-2020-11-41-57.jpg', 'Hindi', '1h 55m', 'Ramprasad Ki Tehrvi', '6.4', '01 Jan, 2021'),
(16, 'When hostile aliens called the Formics attack Earth, only the legendary heroics of Mazer Rackham (Ben Kingsley) manage to attain a victory. To prepare for the next attack, Col. Hyrum Graff (Harrison Ford) and his cohorts initiate a military program to find the next Mazer. Recruit Ender Wiggin (Asa Butterfield) exhibits an unusual gift for the training, easily mastering all of the challenges thrown at him. Mazer Rackham, himself, takes Ender as a protege to prepare him for the oncoming war.', 'https://flagig.com/wp-content/uploads/2013/11/enders_game_poster-724x1024.jpg', 'https://m.media-amazon.com/images/M/MV5BNjYwNDg3MDcwMl5BMl5BanBnXkFtZTgwNDc5OTg0MDE@._V1_.jpg', 'English', '2h 04m', 'Ender\'s Game', '8.5', '05 Mar, 2021'),
(17, 'Check is a Telugu movie starring Nithiin, Rakul Preet Singh and Priya Prakash Varrier in prominent roles. It is a drama directed by Chandra Sekhar Yeleti with V. Anand Prasad as producer, forming part of the crew.\nIf you are a representative of the production house, please share the details of the film with synopsis@bookmyshow.com', 'https://i.imgur.com/o73ojJz.jpg', 'https://in.bmscdn.com/iedb/movies/images/mobile/listing/xxlarge/check-et00305212-09-02-2021-10-22-35.jpg', 'Telugu', '2h 20m', 'Check', '20.4', '26 Feb, 2021'),
(18, 'This comedy-drama revolves around Indoo, a young, spirited girl from Ghaziabad who experiments with dating apps and often ends up in comical situations.', 'https://i.imgur.com/d102wLF.jpg', 'https://in.bmscdn.com/iedb/movies/images/mobile/listing/xxlarge/indoo-ki-jawani-et00122137-23-11-2020-06-52-31.jpg', 'Hindi', '1h 59m', 'Indoo Ki Jawani', '2.3', '11 Dec, 2020'),
(19, 'Tara, one feisty oddball fights patriarchy, caste oppression, brutal violence along with the usual betrayals of politics, to rise to the top with her head held high and affect change.', 'https://i.imgur.com/hvIn6Vk.jpg', 'https://in.bmscdn.com/iedb/movies/images/mobile/listing/xxlarge/madam-chief-minister-et00126626-05-01-2021-05-42-04.jpg', 'Hindi', '2h 04m', 'Madam Chief Minister', '87', '22 Jan, 2021'),
(20, 'A godly woman who takes up the job of a caretaker in a rich family decides to take revenge on her lustful employer.', 'https://i.imgur.com/so1KM84.jpg', 'https://in.bmscdn.com/iedb/movies/images/mobile/listing/xxlarge/nenjam-marappathillai-et00043136-17-04-2017-17-57-55.jpg', 'Tamil', '2h 30m', 'Nenjam Marappathillai', '3.2', '05 Mar, 2021'),
(21, 'Famed monster slayer Gabriel Van Helsing (Hugh Jackman) is dispatched to Transylvania to assist the last of the Valerious bloodline in defeating Count Dracula (Richard Roxburgh). Anna Valerious (Kate Beckinsale) reveals that Dracula has formed an unholy alliance with Dr. Frankenstein\'s monster (Shuler Hensley) and is hell-bent on exacting a centuries-old curse on her family. Together Anna and Van Helsing set out to destroy their common enemy, but uncover some unsettling secrets along the way.', 'https://m.media-amazon.com/images/M/MV5BODRmY2NhNDItOWViNi00OTIyLTk3YjYtYzY0YTFlMDg1YzQ0L2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_FMjpg_UX1000_.jpg', 'https://i.ytimg.com/vi/EZxY-bwp0hQ/maxresdefault.jpg', 'English', '2h 41m', 'Van Helsing', '9.4', '31 May, 2022'),
(22, 'Uppena is a love story between Panja Vaissnav Tej, a boy from the fisherman community and an upper-class girl, Krithi Shetty, who are willing to fight for their love amidst social stigma, political oppression and status difference between them.', 'https://i.imgur.com/VExqXUG.jpg', 'https://in.bmscdn.com/iedb/movies/images/mobile/listing/xxlarge/uppena-et00102429-08-05-2019-12-24-20.jpg', 'Telugu', '2h 28m', 'Uppena', '93', '12 Mar, 2021'),
(23, 'Forced to give up his room to his grandfather, a scheming boy devises a series of outrageous pranks in an attempt to make him move out.', 'https://i.imgur.com/6Sqy9qV.jpg', 'https://in.bmscdn.com/iedb/movies/images/mobile/listing/xxlarge/war-with-grandpa-et00137318-18-09-2020-11-23-08.jpg', 'English', '1h 38m', 'The War with Grandpa', '10', '20 Nov, 2020'),
(24, 'Sixteen year old Lise is accused of murdering her best friend. Her parents stand by her, but once in court, her secret life begins to unfold. Do we really know the ones we love?', 'https://i.imgur.com/hFwnmpf.jpg', 'https://in.bmscdn.com/iedb/movies/images/extra/horizontal_no_logo/mobile/listing/xxlarge/the-girl-with-a-bracelet-et00300231-20-02-2021-11-53-13.jpg', 'French', '1h 35m', 'The Girl With a Bracelet', '52', '12 Feb, 2020'),
(25, 'Sook-hee, a trained assassin, is asked for ten years of service to the government in return for freedom. But her past catches up with her and she takes matters into her own hands.', 'https://i.imgur.com/c3EcGCB.jpg', 'https://in.bmscdn.com/iedb/movies/images/extra/horizontal_no_logo/mobile/listing/xxlarge/the-villainess-et00303977-03-03-2021-04-07-54.jpg', 'Korean', '2h 03m', 'The Villainess', '65', '08 Jun, 2017'),
(26, 'Based on a true story, Ride Like A Girl revolves around Michelle Payne who is told she cannot be a world class jockey but fights for every opportunity to ride hard and race fast.', 'https://i.imgur.com/RD9tzXF.jpg', 'https://in.bmscdn.com/iedb/movies/images/extra/horizontal_no_logo/mobile/listing/xxlarge/ride-like-a-girl-et00302316-08-03-2021-07-47-14.jpg', 'English', '1h 38m', 'Ride Like A Girl', '41', '18 Sep, 2019'),
(27, 'A renowned writer of horror is looking for inspiration when newlyweds come to stay with her and her husband. Things change when she uses them as fodder for her story.', 'https://i.imgur.com/wDNz4Kl.jpg', 'https://in.bmscdn.com/iedb/movies/images/extra/horizontal_no_logo/mobile/listing/xxlarge/shirley-et00132352-28-02-2021-03-49-04.jpg', 'English', '1h 47m', 'Shirley', '46', '05 Jun, 2020'),
(28, 'A documentary, `Woman` is a worldwide project giving voice to 2000 women in 50 different countries.', 'https://i.imgur.com/jnGTeQd.jpg', 'https://in.bmscdn.com/iedb/movies/images/extra/horizontal_no_logo/mobile/listing/xxlarge/woman-et00303975-08-03-2021-08-48-54.jpg', 'English', '1h 48m', 'Woman', '94', '04 Mar, 2020');

-- --------------------------------------------------------

--
-- Table structure for table `theaters`
--

CREATE TABLE `theaters` (
  `cinemaId` int(11) NOT NULL,
  `cinemaName` text NOT NULL,
  `cinemaLocation` text NOT NULL,
  `cinemaDrawable` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `theaters`
--

INSERT INTO `theaters` (`cinemaId`, `cinemaName`, `cinemaLocation`, `cinemaDrawable`) VALUES
(1, 'Aeon Mall CGV', 'Jakarta Garden City', 'https://imgsrv2.voi.id/UlZmSQ_EXq6NmDgMBv2Rbow-57Svxp3hXZ3EhUqd-rk/auto/1200/675/sm/1/bG9jYWw6Ly8vcHVibGlzaGVycy9lOGYyNDE4MS01ZjgwLTQ2NzgtODYyNC0wNmU0YWZiYzgxMGYvMjAyMDAyMjYxMTA4LW1haW4uY3JvcHBlZF8xNTgyNjkwMTE0LmpwZw.jpg'),
(2, 'Arion XXI', 'Arion Plaza Rawamangun', 'https://arionmall.com/wp-content/uploads/2016/06/Arion-Mall-depan-slide-2.jpg'),
(3, 'Artha Gading XXI', 'Mall Artha Gading', 'https://www.jakartashoppingcenter.com/media/images/76963000_1511438231.jpg'),
(4, 'Atrium XXI', 'Atrium Segitiga Senen', 'https://live.staticflickr.com/65535/48657741543_7f8bd8e573_b.jpg'),
(5, 'Bassura XXI', 'Bassura City', 'https://cdn-2.tstatic.net/jakarta/foto/bank/images/apartemen-bassura-city_20180703_072141.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `theater_movies`
--

CREATE TABLE `theater_movies` (
  `id` int(11) NOT NULL,
  `cinemaId` int(11) NOT NULL,
  `movieId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `theater_movies`
--

INSERT INTO `theater_movies` (`id`, `cinemaId`, `movieId`) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 3),
(4, 4, 4),
(5, 5, 5),
(6, 1, 6),
(7, 2, 7),
(8, 3, 8),
(9, 4, 9),
(10, 5, 10),
(11, 1, 11),
(12, 2, 12),
(13, 3, 13),
(14, 4, 14),
(15, 5, 15),
(16, 1, 16),
(17, 2, 17),
(18, 3, 18),
(19, 4, 19),
(20, 5, 20),
(21, 1, 21),
(22, 2, 22),
(23, 3, 23),
(24, 4, 24),
(25, 5, 25),
(26, 1, 25),
(27, 2, 24),
(28, 1, 23),
(29, 4, 22),
(30, 5, 21),
(31, 1, 20),
(32, 2, 19),
(33, 1, 18),
(34, 4, 17),
(35, 5, 16),
(36, 1, 15),
(37, 2, 14),
(38, 4, 13),
(39, 4, 12),
(40, 5, 11),
(41, 1, 10),
(42, 2, 9),
(43, 5, 8),
(44, 4, 7),
(45, 5, 6),
(46, 1, 5),
(47, 2, 4),
(48, 2, 3),
(49, 4, 2),
(50, 5, 1),
(76, 4, 1),
(77, 3, 4),
(78, 5, 7),
(79, 3, 10),
(80, 1, 13),
(81, 4, 16),
(82, 3, 19),
(83, 5, 22),
(84, 3, 25);

-- --------------------------------------------------------

--
-- Table structure for table `tickets`
--

CREATE TABLE `tickets` (
  `id` int(11) NOT NULL,
  `movieId` text NOT NULL,
  `banner_image_url` text NOT NULL,
  `movie_name` text NOT NULL,
  `cinemaName` text NOT NULL,
  `cinemaLocation` text NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `totalPrice` int(11) NOT NULL,
  `date` text NOT NULL,
  `time` text NOT NULL,
  `seat` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tickets`
--

INSERT INTO `tickets` (`id`, `movieId`, `banner_image_url`, `movie_name`, `cinemaName`, `cinemaLocation`, `quantity`, `price`, `totalPrice`, `date`, `time`, `seat`) VALUES
(34, '2', 'https://cdn.cinematerial.com/p/297x/osu2gdkh/tom-and-jerry-movie-poster-md.jpg?v=1614079055', 'Tom & Jerry', 'Arion XXI', 'Arion Plaza Rawamangun', 3, 25000, 75000, '09/05/2022', '10:00 am to 12:00 am', 'A4,B3,B4');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `movies`
--
ALTER TABLE `movies`
  ADD PRIMARY KEY (`movieId`);

--
-- Indexes for table `theaters`
--
ALTER TABLE `theaters`
  ADD PRIMARY KEY (`cinemaId`);

--
-- Indexes for table `theater_movies`
--
ALTER TABLE `theater_movies`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tickets`
--
ALTER TABLE `tickets`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `theaters`
--
ALTER TABLE `theaters`
  MODIFY `cinemaId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `theater_movies`
--
ALTER TABLE `theater_movies`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=85;

--
-- AUTO_INCREMENT for table `tickets`
--
ALTER TABLE `tickets`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
