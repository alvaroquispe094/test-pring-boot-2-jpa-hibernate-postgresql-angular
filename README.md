# Ecommerce-spring-boot--jpa-postgresql-hibernate-angular9
Desarrollando un ecommerce, integrando pagos mediante la api de mercadopago

## Que se ha utilizado?? 
Este proyecto esta basado en [Spring Boot](http://projects.spring.io/spring-boot/) y usa las siguientes tecnologias :
- Maven
- Spring boot
- Spring Data (Hibernate & Postgresql)
- Bootstrap 4
- html5 css3 javascript
- bootstrap
- angular(componentes, servicio, clases, routing)

## Pasos para correr el backend

**1. Clona el repositorio**

```bash
git clone https://github.com/alvaroquispe094/test-pring-boot-2-jpa-hibernate-postgresql-angular.git
```

**2. Crear la base de datos en postgresql**

```bash
DB: 'examen-tecnico'
```

**3. Modifica tu usuario y contraseña de postgresql**

+ abrir `src/main/resources/application.properties`

+ cambiar `spring.datasource.username` y `spring.datasource.password` con tu usuario y contraseña de mysql


## Pasos para correr el frontend con angular
**1. Compilar la carpeta 'frontend-examen' usando npm**

+ abrir en la consola ruta de `frontend-examen`

+ ejecutar el comando `npm install` para bajar todas las dependencias de `node_module`

**2. Levantar el proyecto angular**

+ ejecutar el comando `ng serve`
