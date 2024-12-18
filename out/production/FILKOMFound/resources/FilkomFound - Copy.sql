CREATE database FilkomFound;
use FilkomFound;

CREATE TABLE data(
	id_barang INT PRIMARY KEY AUTO_INCREMENT,
    nama_barang VARCHAR(120) NOT NULL,
    deskripsi VARCHAR(225) NOT NULL,
    lokasi VARCHAR(150) NOT NULL,
    waktu_kehilangan DATE NOT NULL,
    status TINYINT,
    image MEDIUMBLOB NOT NULL
);

RENAME TABLE data TO barang;

CREATE TABLE pengguna(
	id_pengguna INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(20) NOT NULL,
    email VARCHAR(30) NOT NULL UNIQUE,
    password VARCHAR(15) NOT NULL
);

INSERT INTO pengguna(username, email, password)
VALUES('admin', 'admin@email.com', '123456');
