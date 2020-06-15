------------------------------- book table ----------------------
CREATE SEQUENCE public.book_id_seq;

CREATE TABLE public.producto (
	id serial NOT NULL,
	nombre varchar(200) NULL,
	descripcion varchar(1000) NULL,
	precio numeric NULL,
	imagen varchar NULL,
	stock int4 NULL,
	activo bool NULL,
	CONSTRAINT pk_producto PRIMARY KEY (id)
);
-- Permissions
ALTER TABLE public.producto OWNER TO postgres;
GRANT ALL ON TABLE public.producto TO postgres;

INSERT INTO public.producto
(nombre, descripcion, precio, imagen, stock, activo)
VALUES('Celular Motorola Moto E5 Dorado XT1944', 'MEGA BATERÍA  Pasá todo el día lejos del cargador con una batería de 4000 mAh para una mayor diversión. ', 4999, 'https://www.necxus.com.ar/products_image/13497/1000x1000_1.jpg', 100, true);

INSERT INTO public.producto
(nombre, descripcion, precio, imagen, stock, activo)
VALUES('Auricular gamer logitech', 'Sin descripcion. ', 1999, 'https://images.bidcom.com.ar/resize?src=https://www.bidcom.com.ar/publicacionesML/productos/ABLUE039/1000x1000-ABLUE039.jpg&w=1000&q=100', 100, true);

INSERT INTO public.producto
(nombre, descripcion, precio, imagen, stock, activo)
VALUES('Funda pata Iphone', 'Sin descripcion. ', 999, 'https://store.storeimages.cdn-apple.com/4668/as-images.apple.com/is/MQH12?wid=1144&hei=1144&fmt=jpeg&qlt=80&op_usm=0.5,0.5&.v=1516399629065', 100, true);

INSERT INTO public.producto
(nombre, descripcion, precio, imagen, stock, activo)
VALUES('Notebook hp 5 series', 'Sin descripcion. ', 27000, 'https://www.necxus.com.ar/products_image/13497/1000x1000_1.jpg', 100, true);

-------------------------------------------------------------------------
CREATE TABLE public.usuario (
	id serial NOT NULL,
	nombre varchar(100) NULL,
	apellido varchar(100) NULL,
	email varchar(100) NULL,
	usuario varchar(100) NULL,
	"password" varchar(10000) NULL,
	direccion varchar(100) NULL,
	documento varchar(100) NULL,
	activo bool NULL,
	vip bool null,
	fecha_vip Date null,
	CONSTRAINT pk_usuario PRIMARY KEY (id)
);

-- Permissions
ALTER TABLE public.usuario OWNER TO postgres;
GRANT ALL ON TABLE public.usuario TO postgres;

INSERT INTO public.usuario(nombre, apellido, email, usuario, "password", direccion, documento,vip, activo)
VALUES('Usuario', 'prueba', 'usuario@gmail.com', 'usuario', '12345', 'belgrano 124', '23523532',false, true);

---------------------------------------------------------------------------------------------------
CREATE TABLE public.especial (
	id serial NOT NULL,
	fecha date NULL,
	activo bool null,
	CONSTRAINT pk_especial PRIMARY KEY (id)
);
-- Permissions
ALTER TABLE public.especial OWNER TO postgres;
GRANT ALL ON TABLE public.especial TO postgres;

INSERT INTO public.especial (fecha, activo) VALUES('2020-06-18', true);
INSERT INTO public.especial (fecha, activo) VALUES('2020-07-01', true);
INSERT INTO public.especial (fecha, activo) VALUES('2020-06-24', true);
----------------------------------------------------------------------
CREATE TABLE public.compra_comercio (
	id serial NOT NULL,
	usuario_id int4 NULL,
	fecha date NULL,
	total numeric NULL,
	activo bool NULL,
	CONSTRAINT pk_compra_comercio PRIMARY KEY (id),
	CONSTRAINT fk_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);
-- Permissions
ALTER TABLE public.compra_comercio OWNER TO postgres;
GRANT ALL ON TABLE public.compra_comercio TO postgres;
---