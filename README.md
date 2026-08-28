# Ejercicio Integrador: Peluqueria Canina

<p>
Una peluqueria canina necesita de <strong>un formulario</strong> para <strong>almacenar los datos de cada una de sus mascotas clientes</strong>. Para ello, solicita el desarrollo de una aplicación que sea capaz de registrar los siguientes datos de cada una de ellas y sus dueños:
</p> 

<ul>
 <li>
    <strong>Mascota</strong>: num_cliente, nombre_perro, raza, color, alergico, atencion_especial, observaciones.
 </li>
 <li>
    <strong>Dueño</strong>: id_duenio, nombre, celular, direccion
 </li>
</ul>

<p>
Para poder registrar de manera sencilla y que sea atrativa para el usuario, la dueña de la peluquerua canina proporciona el diseño <strong>APROXIMADO</strong> de la que tiene para la interfaz gráfica de usuario:
</p>

![foto](src/main/java/com/imagenes/design-preview.png)

<p>
Como los <strong>datos</strong> deben permanecer en el tiempo y a futuro los empleados de la peluqueria van a poder acceder a ellos, se requiere que cada uno de los registros sean almacenados en una <strong>base de datos</strong>.
</p>
<p>A partir de este relevamiento de requerimientos:</p>
<ul>
    <li>
        Realizar el desarrollo de una <strong>aplicación de escritorio</strong> que sea capaz de registrar, en una base de datos, los datos tanto de mascotas como dueños que se ingresen desde una interfaz gráfica de usuario.
    </li>
    <li>
        Para este desarrollo tener en cuenta los conceptos del <strong>MODELOS DE CAPAS</strong>
    </li>
</ul>
        Para este desarrollo tener en cuenta los conceptos del <strong>MODELOS DE CAPAS</strong>
    </li>
</ul>

</br>

# Compilación y Ejecución del programa

<p>Compila el código fuente: <code>mvn compile</code>.</p> 
<p>Eliminar carpeta target y compila el programa: <code>mvn clean compile</code>.</p> 
<p>Compila, ejecuta pruebas y empaqueta el código en un JAR en la carpeta target: <code>mvn package</code>.</p>
<p>Ejecuta el programa: <code>mvn exec:java</code>.</p> 

## Requisitos
- openJDK version 25.0.3
- javac version 25.0.3
- Apache Maven
- XAMPP con MariaDB

## Instalación y Configuración de XAMPP

### 1. Descargar e Instalar XAMPP

**En Linux:**

```bash
# Descargar XAMPP (reemplazar versión según disponibilidad)
wget https://sourceforge.net/projects/xampp/files/XAMPP%20Linux/8.2.12/xampp-linux-8.2.12-0-installer.run

# Dar permisos de ejecución
chmod +x xampp-linux-*.run

# Ejecutar el instalador
sudo ./xampp-linux-*.run
```

XAMPP se instalará en `/opt/lampp/`.

### 2. Iniciar XAMPP

**En Linux:**

```bash
sudo /opt/lampp/lampp start
```

Verifica que Apache y MySQL estén corriendo:
```bash
sudo /opt/lampp/lampp status
```

### 3. Crear la Base de Datos

Accede a phpMyAdmin en tu navegador:
```
http://localhost/phpmyadmin/
```

**O usa la línea de comandos:**

```bash
# Conectar a MySQL
/opt/lampp/bin/mysql -u root -p

crea la base de datos con el nombre jpaPeluCanina
# Salir de MySQL
exit;

### 5. Parar XAMPP (cuando ya no lo necesites)

```bash
sudo /opt/lampp/lampp stop
```

## Compilación y Ejecución del programa

**Importante:** Asegúrate de que XAMPP esté corriendo (`sudo /opt/lampp/lampp start`) antes de ejecutar la aplicación.

<p>Compila el código fuente: <code>mvn compile</code>.</p> 
<p>Eliminar carpeta target y compila el programa: <code>mvn clean compile</code>.</p> 
<p>Compila, ejecuta pruebas y empaqueta el código en un JAR en la carpeta target: <code>mvn package</code>.</p>
<p>Ejecuta el programa: <code>mvn exec:java</code>.</p>

