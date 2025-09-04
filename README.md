<body>
  <h1>🧪 Gestión de Productos Químicos y Ecológicos</h1>
  <p>
    Este proyecto es una aplicación de escritorio desarrollada en <strong>Java</strong> y <strong>JavaFX</strong>, utilizando <strong>Scene Builder</strong>. Su objetivo principal es la gestión eficiente de inventarios de productos químicos y ecológicos, implementando un CRUD robusto y validaciones de datos.
  </p>

  <h2>🚀 Características Principales</h2>
  <ul>
    <li><strong>GUI con JavaFX y Scene Builder:</strong> Interfaz de usuario intuitiva y moderna.</li>
    <li><strong>CRUD Completo:</strong> Funcionalidades para Crear, Leer, Actualizar y Eliminar productos.</li>
    <li><strong>Validaciones y Alertas:</strong> Uso de alertas para notificar al usuario sobre errores de entrada de datos, asegurando la integridad de la información.</li>
    <li><strong>Filtrado por Vencimiento:</strong> La aplicación filtra productos que caducan en los próximos 20 días y guarda la lista en un archivo de texto.</li>
    <li><strong>Persistencia de Datos:</strong> Los datos se guardan en archivos <strong>JSON</strong> y los informes de caducidad en archivos <strong>TXT</strong>.</li>
    <li><strong>Estructura MVC:</strong> El código está organizado en base al patrón Modelo-Vista-Controlador, utilizando <strong>Controllers</strong> y <strong>Views</strong> (archivos .fxml).</li>
  </ul>

  <h2>⚙️ Estructura del Proyecto</h2>
  <ul>
    <li><code>src/main/java/com/tuproyecto/model/</code>: Contiene las clases de modelo (ej. `ProductoQuimico`).</li>
    <li><code>src/main/java/com/tuproyecto/controller/</code>: Contiene las clases que manejan la lógica (`Controller`).</li>
     <li><code>src/main/resources/com/tuproyecto/view/</code>: Contiene los archivos <code>.fxml</code> (las vistas).</li>
  </ul>
  ![Parcial](UML-RecuSegundoParcial.png)

  <h2>💻 ¿Cómo ejecutar el proyecto?</h2>
  <ol>
    <li>Clonar el repositorio.</li>
    <li>Abrir el proyecto en tu IDE (IntelliJ IDEA, Eclipse, etc.).</li>
    <li>Asegurarse de tener el JDK y las librerías de JavaFX configuradas.</li>
    <li>Ejecutar la clase principal de la aplicación.</li>
  </ol>
</body>
