-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 16, 2020 at 05:30 AM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `trail`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id_admin` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id_admin`, `username`, `password`) VALUES
(1, 'admin', 'admin'),
(3, 'bayu ', 'bayu');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id_customer` int(11) NOT NULL,
  `nama_customer` varchar(100) NOT NULL,
  `no_telepon` varchar(15) NOT NULL,
  `alamat` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id_customer`, `nama_customer`, `no_telepon`, `alamat`) VALUES
(1, 'Daffa Attariq', '08263542711', 'Pakis,Malang'),
(3, 'Geordheca M.', '08654372688', 'Jl.Srani Raya'),
(4, 'Alfarizqi Abiyyu', '08121123211', 'Sawojajar 2'),
(5, 'Bagas Saputra', '08543628199', 'Puncak Tidar'),
(7, 'Hadinata ', '08274658311', 'Sukun'),
(12, 'Nay ', '09283746322', 'Limboto');

-- --------------------------------------------------------

--
-- Table structure for table `detail_transaksi`
--

CREATE TABLE `detail_transaksi` (
  `id_detail` int(11) NOT NULL,
  `id_transaksi` int(11) NOT NULL,
  `id_motor` int(11) NOT NULL,
  `id_pemilik` int(11) NOT NULL,
  `harga_motor` int(11) NOT NULL,
  `bagi_pemilik` int(11) NOT NULL,
  `bagi_rental` int(11) NOT NULL,
  `status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `detail_transaksi`
--

INSERT INTO `detail_transaksi` (`id_detail`, `id_transaksi`, `id_motor`, `id_pemilik`, `harga_motor`, `bagi_pemilik`, `bagi_rental`, `status`) VALUES
(16, 8, 5, 4, 45000, 27000, 18000, 'available'),
(28, 13, 5, 4, 175000, 105000, 70000, 'available'),
(29, 13, 5, 4, 175000, 105000, 70000, 'available'),
(30, 14, 5, 4, 175000, 105000, 70000, 'used'),
(32, 15, 2, 2, 200000, 120000, 80000, 'used'),
(33, 16, 3, 4, 250000, 150000, 100000, 'used'),
(35, 17, 5, 4, 175000, 105000, 70000, 'used'),
(48, 28, 2, 2, 200000, 120000, 80000, 'booking'),
(50, 30, 2, 2, 200000, 120000, 80000, 'used');

-- --------------------------------------------------------

--
-- Table structure for table `header_transaksi`
--

CREATE TABLE `header_transaksi` (
  `id_transaksi` int(11) NOT NULL,
  `id_customer` int(11) NOT NULL,
  `tgl_sewa` date NOT NULL,
  `tgl_kembali` date NOT NULL,
  `total_pembayaran` int(12) NOT NULL,
  `jaminan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `header_transaksi`
--

INSERT INTO `header_transaksi` (`id_transaksi`, `id_customer`, `tgl_sewa`, `tgl_kembali`, `total_pembayaran`, `jaminan`) VALUES
(8, 1, '2019-11-29', '2019-11-29', 250000, 'SIM'),
(13, 7, '2019-12-18', '2019-12-19', 200000, 'SIM'),
(14, 7, '2019-12-21', '2019-12-22', 200000, 'ktp'),
(15, 4, '2019-12-20', '2019-12-21', 200000, 'sim'),
(16, 5, '2019-12-28', '2019-12-29', 250000, 'motor'),
(17, 7, '2019-12-19', '2019-12-20', 175000, 'sim'),
(28, 12, '2019-12-23', '2019-12-24', 200000, 'ktp'),
(30, 5, '2019-12-22', '2019-12-23', 200000, 'ktp');

-- --------------------------------------------------------

--
-- Table structure for table `motor`
--

CREATE TABLE `motor` (
  `id_motor` int(11) NOT NULL,
  `id_pemilik` int(11) NOT NULL,
  `no_plat` varchar(50) NOT NULL,
  `no_mesin` varchar(100) NOT NULL,
  `jenis_motor` varchar(50) NOT NULL,
  `tarif_motor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `motor`
--

INSERT INTO `motor` (`id_motor`, `id_pemilik`, `no_plat`, `no_mesin`, `jenis_motor`, `tarif_motor`) VALUES
(1, 1, '0', '0', '0', 0),
(2, 2, 'N1111G ', '2645GH345', 'Kawasaki KLX 150', 200000),
(3, 4, 'N3333F ', '132FG35HD ', 'Kawasaki KLX 250', 250000),
(4, 4, 'N444FG ', '3412GC454', 'CRF 150', 185000),
(5, 4, 'N12345 ', '1254153JJ1 ', 'KLX', 175000);

-- --------------------------------------------------------

--
-- Table structure for table `pemilik_motor`
--

CREATE TABLE `pemilik_motor` (
  `id_pemilik` int(11) NOT NULL,
  `nama_pemilik` varchar(100) NOT NULL,
  `no_telepon` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pemilik_motor`
--

INSERT INTO `pemilik_motor` (`id_pemilik`, `nama_pemilik`, `no_telepon`) VALUES
(1, 'kosong', '0'),
(2, 'Kris Aditya', '08764538295'),
(3, 'Ilham Apriyad', '08978988991'),
(4, 'Ucil', '08215467364'),
(5, 'Victor Bayu', '08124365488'),
(6, 'Bambang Nurdiansyah', '08756434590'),
(7, 'Handika ', '08132123451');

-- --------------------------------------------------------

--
-- Table structure for table `pengembalian`
--

CREATE TABLE `pengembalian` (
  `id_pengembalian` int(11) NOT NULL,
  `id_transaksi` int(11) NOT NULL,
  `id_detail` int(11) NOT NULL,
  `denda` int(11) NOT NULL,
  `tgl_pengembalian` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pengembalian`
--

INSERT INTO `pengembalian` (`id_pengembalian`, `id_transaksi`, `id_detail`, `denda`, `tgl_pengembalian`) VALUES
(11, 13, 29, 350000, '2019-12-20'),
(12, 13, 28, 700000, '2019-12-22'),
(13, 8, 16, 4025000, '2019-12-22');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id_customer`);

--
-- Indexes for table `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  ADD PRIMARY KEY (`id_detail`),
  ADD KEY `id_pemilik` (`id_pemilik`),
  ADD KEY `id_motor` (`id_motor`),
  ADD KEY `id_transaksi` (`id_transaksi`);

--
-- Indexes for table `header_transaksi`
--
ALTER TABLE `header_transaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `id_customer` (`id_customer`);

--
-- Indexes for table `motor`
--
ALTER TABLE `motor`
  ADD PRIMARY KEY (`id_motor`),
  ADD KEY `id_pemilik` (`id_pemilik`);

--
-- Indexes for table `pemilik_motor`
--
ALTER TABLE `pemilik_motor`
  ADD PRIMARY KEY (`id_pemilik`);

--
-- Indexes for table `pengembalian`
--
ALTER TABLE `pengembalian`
  ADD PRIMARY KEY (`id_pengembalian`),
  ADD KEY `id_transaksi` (`id_transaksi`),
  ADD KEY `id_detail` (`id_detail`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id_admin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id_customer` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  MODIFY `id_detail` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- AUTO_INCREMENT for table `header_transaksi`
--
ALTER TABLE `header_transaksi`
  MODIFY `id_transaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `motor`
--
ALTER TABLE `motor`
  MODIFY `id_motor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `pemilik_motor`
--
ALTER TABLE `pemilik_motor`
  MODIFY `id_pemilik` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `pengembalian`
--
ALTER TABLE `pengembalian`
  MODIFY `id_pengembalian` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  ADD CONSTRAINT `detail_transaksi_ibfk_1` FOREIGN KEY (`id_pemilik`) REFERENCES `pemilik_motor` (`id_pemilik`),
  ADD CONSTRAINT `detail_transaksi_ibfk_2` FOREIGN KEY (`id_motor`) REFERENCES `motor` (`id_motor`),
  ADD CONSTRAINT `detail_transaksi_ibfk_3` FOREIGN KEY (`id_transaksi`) REFERENCES `header_transaksi` (`id_transaksi`);

--
-- Constraints for table `header_transaksi`
--
ALTER TABLE `header_transaksi`
  ADD CONSTRAINT `header_transaksi_ibfk_1` FOREIGN KEY (`id_customer`) REFERENCES `customer` (`id_customer`);

--
-- Constraints for table `motor`
--
ALTER TABLE `motor`
  ADD CONSTRAINT `motor_ibfk_1` FOREIGN KEY (`id_pemilik`) REFERENCES `pemilik_motor` (`id_pemilik`);

--
-- Constraints for table `pengembalian`
--
ALTER TABLE `pengembalian`
  ADD CONSTRAINT `pengembalian_ibfk_1` FOREIGN KEY (`id_transaksi`) REFERENCES `header_transaksi` (`id_transaksi`),
  ADD CONSTRAINT `pengembalian_ibfk_2` FOREIGN KEY (`id_detail`) REFERENCES `detail_transaksi` (`id_detail`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
